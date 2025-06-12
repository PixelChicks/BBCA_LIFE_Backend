package com.bbcalife.bbcalife.controller;

import com.bbcalife.bbcalife.model.User;
import com.bbcalife.bbcalife.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        List<User> list = userRepository.findAll();
        return ResponseEntity.ok(list);
    }
}