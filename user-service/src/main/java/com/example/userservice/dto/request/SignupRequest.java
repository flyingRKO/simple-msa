package com.example.userservice.dto.request;


import com.example.userservice.domain.UserType;

public record SignupRequest(
        String email,
        String password,
        UserType type
) {
}
