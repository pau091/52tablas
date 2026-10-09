package com.tarea.application.security.usecase;

import com.tarea.application.security.command.ChangePasswordCommand;
import com.tarea.domain.security.exception.InvalidCredentialsException;
import com.tarea.domain.security.exception.UserNotFoundException;
import com.tarea.domain.security.model.User;
import com.tarea.domain.security.port.repository.UserRepository;
import com.tarea.domain.security.port.service.PasswordService;

public class ChangePasswordUseCase {

    private final UserRepository userRepository;
    private final PasswordService passwordService;

    public ChangePasswordUseCase(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    public void execute(ChangePasswordCommand command) {
        User user = userRepository.findById(command.userId())
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        if (!passwordService.matches(command.currentPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Contraseña actual incorrecta");
        }

        user.changePassword(passwordService.hash(command.newPassword()));
        userRepository.save(user);
    }
}