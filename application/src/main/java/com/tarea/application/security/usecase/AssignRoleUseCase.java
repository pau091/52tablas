package com.tarea.application.security.usecase;

import com.tarea.application.security.command.AssignRoleCommand;
import com.tarea.application.security.dto.UserResponse;
import com.tarea.domain.security.exception.SecurityDomainException;
import com.tarea.domain.security.exception.UserNotFoundException;
import com.tarea.domain.security.model.Role;
import com.tarea.domain.security.model.User;
import com.tarea.domain.security.port.repository.RoleRepository;
import com.tarea.domain.security.port.repository.UserRepository;

public class AssignRoleUseCase {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public AssignRoleUseCase(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserResponse execute(AssignRoleCommand command) {
        User user = userRepository.findById(command.userId())
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        String roleName = command.roleName().toUpperCase().trim();
        Role role = roleRepository.findByName(roleName)
                .or(() -> roleRepository.findByAuthority(roleName))
                .orElseThrow(() -> new SecurityDomainException("Rol " + roleName + " no encontrado"));

        user.assignRole(role);
        return UserResponse.fromDomain(userRepository.save(user));
    }
}