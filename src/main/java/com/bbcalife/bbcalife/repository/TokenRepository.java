package com.bbcalife.bbcalife.repository;

import com.bbcalife.bbcalife.model.entity.Token;
import com.bbcalife.bbcalife.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    List<Token> findAllByUser(User user);

    Optional<Token> findByToken(String token);
}
