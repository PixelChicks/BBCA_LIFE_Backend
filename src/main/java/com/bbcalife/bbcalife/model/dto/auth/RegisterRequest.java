package com.bbcalife.bbcalife.model.dto.auth;


import com.bbcalife.bbcalife.enums.Provider;
import com.bbcalife.bbcalife.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String nationalIdNumber;
    private Long cityId;
    private String gender;
    private String phoneNumber;
    private LocalDate birthDate;
    private Role role = Role.PATIENT;
    private Provider provider = Provider.LOCAL;
}
