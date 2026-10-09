package com.tarea.application.security.usecase;

import com.tarea.application.security.dto.UserResponse;
import com.tarea.domain.security.exception.UserNotFoundException;
import com.tarea.domain.security.port.repository.UserRepository;

import java.util.UUID;

public class GetCurrentUserUseCase {

    private final UserRepository userRepository;

    public GetCurrentUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse execute(UUID userId) {
        return userRepository.findById(userId)
                .map(UserResponse::fromDomain)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));
    }
}