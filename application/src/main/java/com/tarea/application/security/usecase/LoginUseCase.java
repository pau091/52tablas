package com.tarea.application.security.usecase;

import com.tarea.application.security.command.LoginCommand;
import com.tarea.application.security.dto.LoginResponse;
import com.tarea.domain.security.exception.InvalidCredentialsException;
import com.tarea.domain.security.model.RefreshToken;
import com.tarea.domain.security.model.User;
import com.tarea.domain.security.port.repository.RefreshTokenRepository;
import com.tarea.domain.security.port.repository.UserRepository;
import com.tarea.domain.security.port.service.PasswordService;
import com.tarea.domain.security.port.service.TokenService;

import java.time.LocalDateTime;

public class LoginUseCase {

    private final UserRepository userRepository;
    private final PasswordService passwordService;
    private final TokenService tokenService;
    private final RefreshTokenRepository refreshTokenRepository;
    private final long accessTokenExpirationMs;
    private final long refreshTokenExpirationMs;

    public LoginUseCase(UserRepository userRepository, PasswordService passwordService,
                        TokenService tokenService, RefreshTokenRepository refreshTokenRepository,
                        long accessTokenExpirationMs, long refreshTokenExpirationMs) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
        this.tokenService = tokenService;
        this.refreshTokenRepository = refreshTokenRepository;
        this.accessTokenExpirationMs = accessTokenExpirationMs;
        this.refreshTokenExpirationMs = refreshTokenExpirationMs;
    }

    public LoginResponse execute(LoginCommand command) {
        // Mensaje genérico: no revela si el email existe o no
        User user = userRepository.findByEmail(command.email())
                .orElseThrow(InvalidCredentialsException::new);

        if (!passwordService.matches(command.password(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }
        if (!user.isActive()) {
            throw new InvalidCredentialsException("Usuario bloqueado o inactivo");
        }

        String accessToken = tokenService.generateAccessToken(user.getId(), user.getEmail(), user.getRoles());
        String refreshTokenValue = tokenService.generateRefreshToken();

        LocalDateTime expiresAt = LocalDateTime.now().plusNanos(refreshTokenExpirationMs * 1_000_000L);
        refreshTokenRepository.save(RefreshToken.create(user.getId(), refreshTokenValue, expiresAt));

        return LoginResponse.of(accessToken, refreshTokenValue, accessTokenExpirationMs / 1000);
    }
}