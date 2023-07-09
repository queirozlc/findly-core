CREATE TABLE customers
(
    id         UUID PRIMARY KEY NOT NULL UNIQUE,
    name       VARCHAR(255)     NOT NULL,
    email      VARCHAR(255)     NOT NULL UNIQUE,
    password   VARCHAR(255)     NOT NULL,
    birth_date DATE             NOT NULL,
    created_at TIMESTAMP        NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP        NOT NULL DEFAULT NOW()
);