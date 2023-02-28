CREATE TABLE user_roles
(
    id         SERIAL PRIMARY KEY NOT NULL,
    user_id    INTEGER REFERENCES users (id) NOT NULL,
    role_id   INTEGER REFERENCES roles (id) NOT NULL,

    deleted    BOOLEAN,
    version    NUMERIC(10),
    created_at TIMESTAMP(6)       NOT NULL
);

ALTER TABLE user_roles ADD FOREIGN KEY (user_id) references users(id);
ALTER TABLE user_roles ADD FOREIGN KEY (role_id) references roles(id);

