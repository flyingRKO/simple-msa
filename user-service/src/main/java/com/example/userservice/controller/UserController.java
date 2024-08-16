package com.example.userservice.controller;

import com.example.userservice.dto.request.SignupRequest;
import com.example.userservice.dto.response.UserResponse;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final Environment env;

    @GetMapping("/hc")
    public String status() {
        return String.format("It's Working in User Service on Port %s", env.getProperty("local.server.port"));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signUp(@RequestBody SignupRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.signup(request));
    }
}
