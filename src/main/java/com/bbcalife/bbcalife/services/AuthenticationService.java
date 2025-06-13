package com.bbcalife.bbcalife.services;

import com.bbcalife.bbcalife.model.dto.auth.AuthenticationRequest;
import com.bbcalife.bbcalife.model.dto.auth.AuthenticationResponse;
import com.bbcalife.bbcalife.model.dto.auth.RegisterRequest;
import com.bbcalife.bbcalife.model.User;

import java.io.IOException;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse refreshToken(String refreshToken) throws IOException;

    AuthenticationResponse me(
            String jwtToken
    );

    void resetPassword(String token, String newPassword);

    void confirmRegistration(String verificationToken);

    User forgotPassword(String email);
}
