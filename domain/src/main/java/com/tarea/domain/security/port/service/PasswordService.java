package com.tarea.domain.security.port.service;

public interface PasswordService {

    String hash(String plainPassword);

    boolean matches(String plainPassword, String hashedPassword);
}