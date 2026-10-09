package com.tarea.domain.security.port.service;

import com.tarea.domain.security.model.Role;

import java.util.Set;
import java.util.UUID;

public interface TokenService {

    String generateAccessToken(UUID userId, String email, Set<Role> roles);

    String generateRefreshToken();

    UUID validateAccessToken(String token);

    Set<String> extractAuthorities(String token);
}