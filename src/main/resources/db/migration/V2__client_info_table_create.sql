CREATE TABLE client_info
(
    id               INTEGER      NOT NULL PRIMARY KEY,
    latitude         DECIMAL NOT NULL,
    longitude        DECIMAL NOT NULL,
    phone_name       VARCHAR(255) NOT NULL,
    phone_brand      VARCHAR(255) NOT NULL,
    operating_system VARCHAR(255) NOT NULL,

    created_at       TIMESTAMP(6) NOT NULL

)