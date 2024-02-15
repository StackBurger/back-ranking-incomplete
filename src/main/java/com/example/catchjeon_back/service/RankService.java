package com.example.catchjeon_back.service;

import com.example.catchjeon_back.dto.RankRequest;
import com.example.catchjeon_back.entity.User;
import com.example.catchjeon_back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service

public class RankService {
    private final UserRepository userRepository;


    public User saveRank(RankRequest dto) {
        return userRepository.save(User.builder()
                .time(dto.getTime())
                .build());
    }
}
