package com.example.catchjeon_back.service;

import lombok.RequiredArgsConstructor;
import com.example.catchjeon_back.entity.User;
import com.example.catchjeon_back.dto.AddUserRequest;
import com.example.catchjeon_back.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build());
    }

}
