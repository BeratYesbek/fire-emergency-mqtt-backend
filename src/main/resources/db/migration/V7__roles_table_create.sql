CREATE TABLE roles
(
    id         SERIAL PRIMARY KEY NOT NULL,
    name       VARCHAR(50)        NOT NULL,

    deleted    BOOLEAN,
    version    NUMERIC(10),
    created_at TIMESTAMP(6)       NOT NULL
);

INSERT INTO roles (name, deleted, version, created_at) VALUES ('SUPER_ADMIN',false, 0,now());
INSERT INTO roles (name, deleted, version, created_at) VALUES ('ADMIN',false, 0,now());
INSERT INTO roles (name, deleted, version, created_at) VALUES ('USER',false, 0,now());

