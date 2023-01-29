CREATE TABLE client_info
(
    id               SERIAL PRIMARY KEY NOT NULL,
    user_id          INTEGER REFERENCES users (id),
    latitude         DECIMAL      NOT NULL,
    longitude        DECIMAL      NOT NULL,
    phone_name       VARCHAR(255) NOT NULL,
    phone_brand      VARCHAR(255) NOT NULL,
    operating_system VARCHAR(255) NOT NULL,

    created_at       TIMESTAMP(6) NOT NULL
);

ALTER TABLE client_info
    ADD FOREIGN KEY (user_id) references users (id);
