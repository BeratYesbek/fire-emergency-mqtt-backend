CREATE TABLE users
(
    id         SERIAL PRIMARY KEY NOT NULL,
    email      VARCHAR(255) NOT NULL,
    username   VARCHAR(255) NOT NULL,
    full_name  VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    phone_uuid VARCHAR(255) NOT NULL,


    created_at TIMESTAMP(6) NOT NULL

);