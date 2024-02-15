package com.example.catchjeon_back.controller;

import com.example.catchjeon_back.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import com.example.catchjeon_back.dto.AddUserRequest;
import com.example.catchjeon_back.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> signup(AddUserRequest request) {
        User register = userService.save(request);
        return (request != null) ?
                ResponseEntity.status(HttpStatus.OK).body(register) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}