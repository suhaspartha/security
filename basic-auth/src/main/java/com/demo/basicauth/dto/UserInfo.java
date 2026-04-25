package com.demo.basicauth.dto;

import com.demo.basicauth.model.Role;

public record UserInfo(String username, Role role) {}
