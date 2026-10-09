package com.tarea.application.security.dto;

public record LoginResponse(String accessToken, String refreshToken, String tokenType, Long expiresIn) {

    public static LoginResponse of(String accessToken, String refreshToken, Long expiresIn) {
        return new LoginResponse(accessToken, refreshToken, "Bearer", expiresIn);
    }
}