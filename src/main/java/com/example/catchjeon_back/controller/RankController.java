/*package com.example.catchjeon_back.controller;

import com.example.catchjeon_back.dto.RankRequest;
import com.example.catchjeon_back.entity.User;
import com.example.catchjeon_back.repository.UserRepository;
import com.example.catchjeon_back.service.RankService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class RankController {
    private final UserRepository userRepository;

    @Autowired
    public RankController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @PostMapping("/gameover")
    public ResponseEntity saveRank(UserRepository userRepository) {
        User rankEntity = rankService.saveRank(userRepository);
        return (request != null) ?
                ResponseEntity.status(HttpStatus.OK).body(rankEntity) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}
*/