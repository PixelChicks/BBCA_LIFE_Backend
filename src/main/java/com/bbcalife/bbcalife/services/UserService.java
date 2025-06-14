package com.bbcalife.bbcalife.services;

import com.bbcalife.bbcalife.model.dto.auth.AdminUserDTO;
import com.bbcalife.bbcalife.model.dto.auth.OAuth2UserInfoDTO;
import com.bbcalife.bbcalife.model.dto.auth.PublicUserDTO;
import com.bbcalife.bbcalife.model.dto.auth.RegisterRequest;
import com.bbcalife.bbcalife.model.entity.User;

import java.util.List;

public interface UserService {
    User createUser(RegisterRequest request);

    User findByEmail(String email);

    List<User> getAllUsers();

    AdminUserDTO getByIdAdmin(Long id);

    AdminUserDTO updateUser(Long id, AdminUserDTO userDTO, PublicUserDTO currentUser);

    void deleteUserById(Long id, PublicUserDTO currentUser);

    User processOAuthUser(OAuth2UserInfoDTO oAuth2User);

    User findById(Long id);
}
