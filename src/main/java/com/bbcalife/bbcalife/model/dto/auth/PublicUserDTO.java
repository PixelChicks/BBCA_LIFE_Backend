package com.bbcalife.bbcalife.model.dto.auth;

import com.bbcalife.bbcalife.enums.Role;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublicUserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String role;
}
