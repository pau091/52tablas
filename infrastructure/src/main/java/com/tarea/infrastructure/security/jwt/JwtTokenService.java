package com.tarea.infrastructure.security.jwt;

import com.tarea.domain.security.exception.InvalidCredentialsException;
import com.tarea.domain.security.model.Role;
import com.tarea.domain.security.port.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class JwtTokenService implements TokenService {

    private final SecretKey secretKey;
    private final long accessTokenExpirationMs;

    public JwtTokenService(String secret, long accessTokenExpirationMs) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.accessTokenExpirationMs = accessTokenExpirationMs;
    }

    @Override
    public String generateAccessToken(UUID userId, String email, Set<Role> roles) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + accessTokenExpirationMs);

        List<String> authorities = roles.stream().map(Role::getAuthority).toList();

        return Jwts.builder()
                .subject(userId.toString())
                .claim("email", email)
                .claim("roles", authorities)
                .issuedAt(now)
                .expiration(expiry)
                .signWith(secretKey)
                .compact();
    }

    @Override
    public String generateRefreshToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public UUID validateAccessToken(String token) {
        return UUID.fromString(parse(token).getSubject());
    }

    @Override
    public Set<String> extractAuthorities(String token) {
        Object roles = parse(token).get("roles");
        if (!(roles instanceof List<?> list)) {
            return Set.of();
        }
        return list.stream().map(Object::toString).collect(Collectors.toSet());
    }

    private Claims parse(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (JwtException | IllegalArgumentException ex) {
            throw new InvalidCredentialsException("Token inválido o expirado");
        }
    }
}