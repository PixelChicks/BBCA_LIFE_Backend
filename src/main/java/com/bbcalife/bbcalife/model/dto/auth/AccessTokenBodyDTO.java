package com.bbcalife.bbcalife.model.dto.auth;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessTokenBodyDTO {
    private String accessToken;
}
