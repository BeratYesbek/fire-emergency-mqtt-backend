CREATE TABLE user_roles
(
    id         SERIAL PRIMARY KEY NOT NULL,
    user_id    INTEGER REFERENCES users (id),
    roles_id   INTEGER REFERENCES roles (id),

    deleted    BOOLEAN,
    version    NUMERIC(10),
    created_at TIMESTAMP(6)       NOT NULL
);

ALTER TABLE user_roles ADD FOREIGN KEY (user_id) references users(id);
ALTER TABLE user_roles ADD FOREIGN KEY (roles_id) references roles(id);