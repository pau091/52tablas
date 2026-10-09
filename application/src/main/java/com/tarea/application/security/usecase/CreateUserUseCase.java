package com.tarea.application.security.usecase;

import com.tarea.application.security.command.RegisterUserCommand;
import com.tarea.application.security.dto.UserResponse;
import com.tarea.domain.security.exception.SecurityDomainException;
import com.tarea.domain.security.model.Role;
import com.tarea.domain.security.model.User;
import com.tarea.domain.security.port.repository.RoleRepository;
import com.tarea.domain.security.port.repository.UserRepository;
import com.tarea.domain.security.port.service.PasswordService;

public class CreateUserUseCase {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordService passwordService;

    public CreateUserUseCase(UserRepository userRepository, RoleRepository roleRepository,
                             PasswordService passwordService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordService = passwordService;
    }

    public UserResponse execute(RegisterUserCommand command) {
        if (userRepository.existsByEmail(command.email())) {
            throw new SecurityDomainException("El usuario con email " + command.email() + " ya existe");
        }
        User user = User.create(command.email(), passwordService.hash(command.password()));

        Role userRole = roleRepository.findByAuthority("ROLE_USER")
                .orElseThrow(() -> new SecurityDomainException("Rol USER no encontrado en la base de datos"));
        user.assignRole(userRole);

        return UserResponse.fromDomain(userRepository.save(user));
    }
}