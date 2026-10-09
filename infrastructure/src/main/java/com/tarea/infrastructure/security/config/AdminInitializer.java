package com.tarea.infrastructure.security.config;

import com.tarea.domain.security.exception.SecurityDomainException;
import com.tarea.domain.security.model.Role;
import com.tarea.domain.security.model.User;
import com.tarea.domain.security.port.repository.RoleRepository;
import com.tarea.domain.security.port.repository.UserRepository;
import com.tarea.domain.security.port.service.PasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

public class AdminInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(AdminInitializer.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordService passwordService;
    private final String adminEmail;
    private final String adminPassword;

    public AdminInitializer(UserRepository userRepository, RoleRepository roleRepository,
                            PasswordService passwordService, String adminEmail, String adminPassword) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordService = passwordService;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }

    @Override
    public void run(String... args) {
        if (userRepository.existsByEmail(adminEmail)) {
            log.info("Usuario administrador ya existe: {}", adminEmail);
            return;
        }

        Role adminRole = roleRepository.findByAuthority("ROLE_ADMIN")
                .orElseThrow(() -> new SecurityDomainException("Rol ADMIN no encontrado (revisa la migración V53)"));
        Role userRole = roleRepository.findByAuthority("ROLE_USER")
                .orElseThrow(() -> new SecurityDomainException("Rol USER no encontrado (revisa la migración V53)"));

        User admin = User.create(adminEmail, passwordService.hash(adminPassword));
        admin.assignRole(userRole);
        admin.assignRole(adminRole);
        userRepository.save(admin);

        log.warn("Usuario administrador creado: {}. Cambia la contraseña por defecto.", adminEmail);
    }
}