package com.example.userservice.dto.response;

import com.example.userservice.domain.UserEntity;

public record UserResponse(
        String email
) {
    public static UserResponse fromEntity(UserEntity user){
        return new UserResponse(
                user.getEmail()
        );
    }
}
