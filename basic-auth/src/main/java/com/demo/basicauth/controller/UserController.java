package com.demo.basicauth.controller;

import com.demo.basicauth.dto.RegisterRequest;
import com.demo.basicauth.dto.UserInfo;
import com.demo.basicauth.model.Role;
import com.demo.basicauth.model.User;
import com.demo.basicauth.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserInfo registerUser(@RequestBody RegisterRequest registerRequest) {
        User user = new User(null, registerRequest.username(), registerRequest.password(), Role.USER);
        user = customUserDetailsService.register(user);
        return new UserInfo(user.getUsername(), user.getRole());
    }

    @PostMapping("/register-admin")
    @ResponseStatus(HttpStatus.CREATED)
    public UserInfo registerAdmin(@RequestBody RegisterRequest registerRequest) {
        User user = new User(null, registerRequest.username(), registerRequest.password(), Role.ADMIN);
        user = customUserDetailsService.register(user);
        return new UserInfo(user.getUsername(), user.getRole());
    }
}
