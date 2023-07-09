CREATE TABLE service_provider
(
    id         UUID PRIMARY KEY NOT NULL UNIQUE,
    name       VARCHAR(255)     NOT NULL,
    email      VARCHAR(255)     NOT NULL UNIQUE,
    password   VARCHAR(255)     NOT NULL,
    phone      VARCHAR(255)     NOT NULL,
    cpf        VARCHAR(255) UNIQUE,
    cnpj       VARCHAR(255) UNIQUE,
    birth_date DATE             NOT NULL
);