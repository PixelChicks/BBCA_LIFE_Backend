package com.bbcalife.bbcalife.model.dto.auth;


import com.bbcalife.bbcalife.enums.Provider;
import com.bbcalife.bbcalife.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String email;
    private String password;
    private String name;
    private String surName;
    private Role role = Role.PATIENT;
    private Provider provider = Provider.LOCAL;
}
