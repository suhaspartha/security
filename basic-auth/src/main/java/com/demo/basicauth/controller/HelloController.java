package com.demo.basicauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/greet")
    public String hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if  (authentication != null) {
            return "Hello " + authentication.getName() + "!</h1>";
        }
        return "<h1>Hello!</h1>";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/numbers")
    public List<Integer> index() {
        return List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
