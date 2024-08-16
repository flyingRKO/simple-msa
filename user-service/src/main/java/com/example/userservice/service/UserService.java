package com.example.userservice.service;

import com.example.userservice.domain.UserEntity;
import com.example.userservice.dto.request.SignupRequest;
import com.example.userservice.dto.response.UserResponse;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public UserResponse signup(SignupRequest request) {
        userRepository.findByEmail(request.email()).ifPresent(it -> {
            throw new RuntimeException("email is duplicated");
        });
        UserEntity savedUser = userRepository.save(UserEntity.of(
                request.email(),
                encoder.encode(request.password()),
                request.type()
        ));
        return UserResponse.fromEntity(savedUser);
    }
}
