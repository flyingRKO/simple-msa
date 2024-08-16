package com.example.userservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType type;
    private LocalDateTime createdAt;


    private UserEntity(String email, String password, UserType type){
        this.email = email;
        this.password = password;
        this.type = type;
        this.createdAt = LocalDateTime.now();
    }
    public static UserEntity of(String email, String password, UserType type){
        return new UserEntity(email, password, type);
    }
}
