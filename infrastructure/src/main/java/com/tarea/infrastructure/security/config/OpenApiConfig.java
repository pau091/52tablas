package com.tarea.infrastructure.security.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static final String SCHEME = "bearerAuth";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tarea 52 Tablas API")
                        .version("1.0.0")
                        .description("""
                                API protegida con JWT.
                                1. POST /auth/login para obtener el access token.
                                2. Botón **Authorize** → pegar el token (sin la palabra Bearer).
                                3. Todos los endpoints /api/** requieren autenticación.
                                """))
                .addSecurityItem(new SecurityRequirement().addList(SCHEME))
                .components(new Components()
                        .addSecuritySchemes(SCHEME, new SecurityScheme()
                                .name(SCHEME)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}