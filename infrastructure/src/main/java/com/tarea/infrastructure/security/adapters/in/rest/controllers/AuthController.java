package com.tarea.infrastructure.security.adapters.in.rest.controllers;

import com.tarea.application.security.command.ChangePasswordCommand;
import com.tarea.application.security.command.LoginCommand;
import com.tarea.application.security.command.RegisterUserCommand;
import com.tarea.application.security.dto.LoginResponse;
import com.tarea.application.security.dto.UserResponse;
import com.tarea.application.security.usecase.ChangePasswordUseCase;
import com.tarea.application.security.usecase.CreateUserUseCase;
import com.tarea.application.security.usecase.GetCurrentUserUseCase;
import com.tarea.application.security.usecase.LoginUseCase;
import com.tarea.application.security.usecase.LogoutUseCase;
import com.tarea.application.security.usecase.RefreshTokenUseCase;
import com.tarea.infrastructure.security.adapters.in.rest.dtos.ChangePasswordRequest;
import com.tarea.infrastructure.security.adapters.in.rest.dtos.LoginRequest;
import com.tarea.infrastructure.security.adapters.in.rest.dtos.RefreshTokenRequest;
import com.tarea.infrastructure.security.adapters.in.rest.dtos.RegisterRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "Autenticación", description = "Registro, login, refresh, logout y sesión")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CreateUserUseCase createUserUseCase;
    private final LoginUseCase loginUseCase;
    private final RefreshTokenUseCase refreshTokenUseCase;
    private final LogoutUseCase logoutUseCase;
    private final ChangePasswordUseCase changePasswordUseCase;
    private final GetCurrentUserUseCase getCurrentUserUseCase;

    public AuthController(CreateUserUseCase createUserUseCase, LoginUseCase loginUseCase,
                          RefreshTokenUseCase refreshTokenUseCase, LogoutUseCase logoutUseCase,
                          ChangePasswordUseCase changePasswordUseCase,
                          GetCurrentUserUseCase getCurrentUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.loginUseCase = loginUseCase;
        this.refreshTokenUseCase = refreshTokenUseCase;
        this.logoutUseCase = logoutUseCase;
        this.changePasswordUseCase = changePasswordUseCase;
        this.getCurrentUserUseCase = getCurrentUserUseCase;
    }

    @Operation(summary = "Registrar usuario (asigna ROLE_USER)")
    @SecurityRequirements
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request) {
        var command = new RegisterUserCommand(request.email(), request.password());
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserUseCase.execute(command));
    }

    @Operation(summary = "Iniciar sesión y obtener tokens")
    @SecurityRequirements
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(loginUseCase.execute(new LoginCommand(request.email(), request.password())));
    }

    @Operation(summary = "Renovar access token con el refresh token")
    @SecurityRequirements
    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refresh(@Valid @RequestBody RefreshTokenRequest request) {
        return ResponseEntity.ok(refreshTokenUseCase.execute(request.refreshToken()));
    }

    @Operation(summary = "Cerrar sesión (revoca el refresh token)")
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@Valid @RequestBody RefreshTokenRequest request,
                                       Authentication authentication) {
        logoutUseCase.execute((UUID) authentication.getPrincipal(), request.refreshToken());
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Obtener usuario autenticado")
    @GetMapping("/me")
    public ResponseEntity<UserResponse> me(Authentication authentication) {
        return ResponseEntity.ok(getCurrentUserUseCase.execute((UUID) authentication.getPrincipal()));
    }

    @Operation(summary = "Cambiar contraseña")
    @PutMapping("/change-password")
    public ResponseEntity<Void> changePassword(@Valid @RequestBody ChangePasswordRequest request,
                                               Authentication authentication) {
        var command = new ChangePasswordCommand(
                (UUID) authentication.getPrincipal(),
                request.currentPassword(),
                request.newPassword());
        changePasswordUseCase.execute(command);
        return ResponseEntity.noContent().build();
    }
}