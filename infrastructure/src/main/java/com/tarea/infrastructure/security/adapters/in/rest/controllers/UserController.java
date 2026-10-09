package com.tarea.infrastructure.security.adapters.in.rest.controllers;

import com.tarea.application.security.command.AssignRoleCommand;
import com.tarea.application.security.dto.UserResponse;
import com.tarea.application.security.usecase.AssignRoleUseCase;
import com.tarea.infrastructure.security.adapters.in.rest.dtos.AssignRoleRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "Gestión de Usuarios", description = "Administración de roles (requiere ADMIN)")
@RestController
@RequestMapping("/users")
public class UserController {

    private final AssignRoleUseCase assignRoleUseCase;

    public UserController(AssignRoleUseCase assignRoleUseCase) {
        this.assignRoleUseCase = assignRoleUseCase;
    }

    @Operation(summary = "Asignar rol a un usuario")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{userId}/roles")
    public ResponseEntity<UserResponse> assignRole(@PathVariable UUID userId,
                                                   @Valid @RequestBody AssignRoleRequest request) {
        return ResponseEntity.ok(assignRoleUseCase.execute(new AssignRoleCommand(userId, request.roleName())));
    }
}