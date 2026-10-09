package com.tarea.application.security.usecase;

import com.tarea.application.security.dto.LoginResponse;
import com.tarea.domain.security.exception.InvalidCredentialsException;
import com.tarea.domain.security.exception.UserNotFoundException;
import com.tarea.domain.security.model.RefreshToken;
import com.tarea.domain.security.model.User;
import com.tarea.domain.security.port.repository.RefreshTokenRepository;
import com.tarea.domain.security.port.repository.UserRepository;
import com.tarea.domain.security.port.service.TokenService;

public class RefreshTokenUseCase {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final long accessTokenExpirationMs;

    public RefreshTokenUseCase(RefreshTokenRepository refreshTokenRepository, UserRepository userRepository,
                               TokenService tokenService, long accessTokenExpirationMs) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.accessTokenExpirationMs = accessTokenExpirationMs;
    }

    public LoginResponse execute(String refreshTokenValue) {
        RefreshToken refreshToken = refreshTokenRepository.findByToken(refreshTokenValue)
                .orElseThrow(() -> new InvalidCredentialsException("Refresh token inválido"));

        if (!refreshToken.isValid()) {
            throw new InvalidCredentialsException("Refresh token expirado o revocado");
        }

        User user = userRepository.findById(refreshToken.getUserId())
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        if (!user.isActive()) {
            throw new InvalidCredentialsException("Usuario bloqueado o inactivo");
        }

        String accessToken = tokenService.generateAccessToken(user.getId(), user.getEmail(), user.getRoles());
        return LoginResponse.of(accessToken, refreshTokenValue, accessTokenExpirationMs / 1000);
    }
}