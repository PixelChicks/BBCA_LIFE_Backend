package com.bbcalife.bbcalife.services;

import com.bbcalife.bbcalife.enums.TokenType;
import com.bbcalife.bbcalife.model.dto.auth.AuthenticationResponse;
import com.bbcalife.bbcalife.model.entity.Token;
import com.bbcalife.bbcalife.model.User;

import java.util.List;

public interface TokenService {
    Token findByToken(String jwt);

    List<Token> findByUser(User user);

    void saveToken(User user, String jwtToken, TokenType tokenType);

    void revokeToken(Token token);

    void revokeAllUserTokens(User user);

    void logoutToken(String jwt);

    AuthenticationResponse generateAuthResponse(User user);

    void createVerificationToken(User user, String token);

    void clearVerificationTokensByUser(User user);
}
