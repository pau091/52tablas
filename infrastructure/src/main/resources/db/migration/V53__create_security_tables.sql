CREATE TABLE roles (
    id        UUID PRIMARY KEY,
    name      VARCHAR(50) NOT NULL UNIQUE,
    authority VARCHAR(60) NOT NULL UNIQUE
);

CREATE TABLE users (
    id       UUID PRIMARY KEY,
    email    VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    status   VARCHAR(20)  NOT NULL
);

CREATE TABLE user_roles (
    user_id UUID NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    role_id UUID NOT NULL REFERENCES roles (id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE refresh_tokens (
    id         UUID PRIMARY KEY,
    user_id    UUID         NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    token      VARCHAR(255) NOT NULL UNIQUE,
    expires_at TIMESTAMP    NOT NULL,
    revoked    BOOLEAN      NOT NULL DEFAULT FALSE
);

INSERT INTO roles (id, name, authority) VALUES
    ('550e8400-e29b-41d4-a716-446655440001', 'USER',      'ROLE_USER'),
    ('550e8400-e29b-41d4-a716-446655440002', 'ADMIN',     'ROLE_ADMIN'),
    ('550e8400-e29b-41d4-a716-446655440003', 'MODERATOR', 'ROLE_MODERATOR');