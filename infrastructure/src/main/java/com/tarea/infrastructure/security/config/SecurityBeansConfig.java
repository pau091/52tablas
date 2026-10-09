package com.tarea.infrastructure.security.config;

import com.tarea.application.security.usecase.AssignRoleUseCase;
import com.tarea.application.security.usecase.ChangePasswordUseCase;
import com.tarea.application.security.usecase.CreateUserUseCase;
import com.tarea.application.security.usecase.GetCurrentUserUseCase;
import com.tarea.application.security.usecase.LoginUseCase;
import com.tarea.application.security.usecase.LogoutUseCase;
import com.tarea.application.security.usecase.RefreshTokenUseCase;
import com.tarea.domain.security.port.repository.RefreshTokenRepository;
import com.tarea.domain.security.port.repository.RoleRepository;
import com.tarea.domain.security.port.repository.UserRepository;
import com.tarea.domain.security.port.service.PasswordService;
import com.tarea.domain.security.port.service.TokenService;
import com.tarea.infrastructure.security.adapters.out.persistence.mappers.SecurityPersistenceMapper;
import com.tarea.infrastructure.security.adapters.out.persistence.repositories.RefreshTokenJpaRepository;
import com.tarea.infrastructure.security.adapters.out.persistence.repositories.RefreshTokenRepositoryAdapter;
import com.tarea.infrastructure.security.adapters.out.persistence.repositories.RoleJpaRepository;
import com.tarea.infrastructure.security.adapters.out.persistence.repositories.RoleRepositoryAdapter;
import com.tarea.infrastructure.security.adapters.out.persistence.repositories.UserJpaRepository;
import com.tarea.infrastructure.security.adapters.out.persistence.repositories.UserRepositoryAdapter;
import com.tarea.infrastructure.security.jwt.JwtTokenService;
import com.tarea.infrastructure.security.jwt.PasswordServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityBeansConfig {

    // ---------- Persistencia ----------

    @Bean
    public SecurityPersistenceMapper securityPersistenceMapper() {
        return new SecurityPersistenceMapper();
    }

    @Bean
    public UserRepository userRepository(UserJpaRepository jpa, SecurityPersistenceMapper mapper) {
        return new UserRepositoryAdapter(jpa, mapper);
    }

    @Bean
    public RoleRepository roleRepository(RoleJpaRepository jpa, SecurityPersistenceMapper mapper) {
        return new RoleRepositoryAdapter(jpa, mapper);
    }

    @Bean
    public RefreshTokenRepository refreshTokenRepository(RefreshTokenJpaRepository jpa,
                                                         SecurityPersistenceMapper mapper) {
        return new RefreshTokenRepositoryAdapter(jpa, mapper);
    }

    // ---------- Servicios ----------

    @Bean
    public TokenService tokenService(@Value("${jwt.secret}") String secret,
                                     @Value("${jwt.access-token-expiration}") long accessExpiration) {
        return new JwtTokenService(secret, accessExpiration);
    }

    @Bean
    public PasswordService passwordService(PasswordEncoder passwordEncoder) {
        return new PasswordServiceImpl(passwordEncoder);
    }

    // ---------- Casos de uso ----------

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository users, RoleRepository roles,
                                               PasswordService passwordService) {
        return new CreateUserUseCase(users, roles, passwordService);
    }

    @Bean
    public LoginUseCase loginUseCase(UserRepository users, PasswordService passwordService,
                                     TokenService tokenService, RefreshTokenRepository refreshTokens,
                                     @Value("${jwt.access-token-expiration}") long accessExpiration,
                                     @Value("${jwt.refresh-token-expiration}") long refreshExpiration) {
        return new LoginUseCase(users, passwordService, tokenService, refreshTokens,
                accessExpiration, refreshExpiration);
    }

    @Bean
    public RefreshTokenUseCase refreshTokenUseCase(RefreshTokenRepository refreshTokens, UserRepository users,
                                                   TokenService tokenService,
                                                   @Value("${jwt.access-token-expiration}") long accessExpiration) {
        return new RefreshTokenUseCase(refreshTokens, users, tokenService, accessExpiration);
    }

    @Bean
    public LogoutUseCase logoutUseCase(RefreshTokenRepository refreshTokens) {
        return new LogoutUseCase(refreshTokens);
    }

    @Bean
    public ChangePasswordUseCase changePasswordUseCase(UserRepository users, PasswordService passwordService) {
        return new ChangePasswordUseCase(users, passwordService);
    }

    @Bean
    public GetCurrentUserUseCase getCurrentUserUseCase(UserRepository users) {
        return new GetCurrentUserUseCase(users);
    }

    @Bean
    public AssignRoleUseCase assignRoleUseCase(UserRepository users, RoleRepository roles) {
        return new AssignRoleUseCase(users, roles);
    }

    // ---------- Admin inicial ----------

    @Bean
    public AdminInitializer adminInitializer(UserRepository users, RoleRepository roles,
                                             PasswordService passwordService,
                                             @Value("${app.security.admin.email}") String adminEmail,
                                             @Value("${app.security.admin.password}") String adminPassword) {
        return new AdminInitializer(users, roles, passwordService, adminEmail, adminPassword);
    }
}