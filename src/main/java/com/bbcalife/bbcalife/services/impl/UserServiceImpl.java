package com.bbcalife.bbcalife.services.impl;

import com.bbcalife.bbcalife.enums.Provider;
import com.bbcalife.bbcalife.enums.Role;
import com.bbcalife.bbcalife.exceptions.common.AccessDeniedException;
import com.bbcalife.bbcalife.exceptions.user.UserCreateException;
import com.bbcalife.bbcalife.exceptions.user.UserNotFoundException;
import com.bbcalife.bbcalife.exceptions.user.UserValidationException;
import com.bbcalife.bbcalife.model.dto.auth.AdminUserDTO;
import com.bbcalife.bbcalife.model.dto.auth.OAuth2UserInfoDTO;
import com.bbcalife.bbcalife.model.dto.auth.PublicUserDTO;
import com.bbcalife.bbcalife.model.dto.auth.RegisterRequest;
import com.bbcalife.bbcalife.model.entity.Patient;
import com.bbcalife.bbcalife.model.entity.User;
import com.bbcalife.bbcalife.repository.*;
import com.bbcalife.bbcalife.services.UserService;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final AssistantRepository assistantRepository;
    private final ModelMapper modelMapper;

    /**
     * Creates a new user based on the provided registration request.
     *
     * @param request The registration request containing user details.
     * @return The created user.
     * @throws UserCreateException             If there is an issue creating the user.
     * @throws DataIntegrityViolationException If there is a data integrity violation while creating the user.
     * @throws ConstraintViolationException    If there is a constraint violation while creating the user.
     */
    @Override
    public User createUser(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserCreateException(true);
        }

        try {
            User user = buildUser(request);
            user.setRole("patient");
            User savedUser = userRepository.save(user);

            Patient patient = buildPatient(request, savedUser);
            patientRepository.save(patient);

            return savedUser;
        } catch (DataIntegrityViolationException exception) {
            throw new UserCreateException(true);
        } catch (ConstraintViolationException exception) {
            throw new UserValidationException(exception.getConstraintViolations());
        }
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository
                .findAll();
    }

    @Override
    public AdminUserDTO updateUser(Long id, AdminUserDTO userDTO, PublicUserDTO currentUser) {
        User userToUpdate = findById(id);

        if (!(userToUpdate.getId().equals(currentUser.getId())) && !currentUser.getRole().equals(Role.ADMIN)) {
            throw new AccessDeniedException();
        }

        if (currentUser.getRole().equals(Role.PATIENT)) {
            userToUpdate.setFirstName(userDTO.getFirstname());
            userToUpdate.setLastName(userDTO.getLastname());
        } else if (currentUser.getRole().equals(Role.ADMIN)) {
            // It is not null it is "" so don't change it
            if (userDTO.getPassword() == "") {
                userDTO.setPassword(userToUpdate.getPassword());
            } else {
                userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            }

            modelMapper.map(userDTO, userToUpdate);
        }

        userToUpdate.setId(id);

        User updatedUser = userRepository.save(userToUpdate);
        return modelMapper.map(updatedUser, AdminUserDTO.class);
    }


    @Override
    public void deleteUserById(Long id, PublicUserDTO currentUser) {
        User user = findById(id);

        if (user.getId().equals(currentUser.getId())) {
            throw new AccessDeniedException();
        }

        if (user.getDeletedAt() == null) {
            user.setDeletedAt(LocalDateTime.now());
        } else {
            user.setDeletedAt(null);
        }

        userRepository.save(user);
    }

    /**
     * Processes the OAuth user obtained from the OAuth2 provider.
     * If the user does not exist in the database, a new user is created based on the OAuth user details.
     *
     * @param oAuth2User The OAuth2 user obtained from the OAuth provider.
     * @return The processed user.
     */
    @Override
    public User processOAuthUser(OAuth2UserInfoDTO oAuth2User) {
        User user = userRepository.findByEmail(oAuth2User.getEmail()).orElse(null);

        if (user == null) {
            RegisterRequest registerRequest = new RegisterRequest();

            registerRequest.setEmail(oAuth2User.getEmail());
            registerRequest.setProvider(oAuth2User.getProvider());

            if (oAuth2User.getProvider().equals(Provider.GOOGLE)) {
                registerRequest.setFirstName(oAuth2User.getGiven_name());
                registerRequest.setLastName(oAuth2User.getFamily_name());
            }

            user = userRepository.save(buildUser(registerRequest));
        }

        return user;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public AdminUserDTO getByIdAdmin(Long id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return modelMapper.map(user, AdminUserDTO.class);
    }

    private User buildUser(RegisterRequest request) {
        User.UserBuilder userBuilder = User
                .builder()
                .uuid(UUID.randomUUID().toString())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .nationalIdNumber(request.getNationalIdNumber())
                .city(cityRepository.findById(request.getCityId()).orElseThrow())
                .email(request.getEmail())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .encrypted(false) // public data
                .role("patient");

        if (request.getPassword() != null) {
            userBuilder.password(passwordEncoder.encode(request.getPassword()));
        }

        return userBuilder.build();
    }

    private Patient buildPatient(RegisterRequest request, User savedUser) {
        return Patient
                .builder()
                .user(savedUser)
                .country(countryRepository.findById(1L).orElseThrow())
                .gender(request.getGender())
                .phoneNumber(request.getPhoneNumber())
                .birthDate(request.getBirthDate())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .assistant(assistantRepository.findById(19L).orElseThrow())
                .build();
    }
}