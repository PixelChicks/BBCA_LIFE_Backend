package com.bbcalife.bbcalife.repository;

import com.bbcalife.bbcalife.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findByEnabledFalseAndCreatedAtBeforeAndDeletedAtIsNull(LocalDateTime thresholdDateTime);
}
