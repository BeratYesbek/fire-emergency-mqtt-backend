CREATE TABLE users
(
    id         SERIAL PRIMARY KEY NOT NULL,
    email      VARCHAR(255)       NOT NULL,
    username   VARCHAR(255)       NOT NULL,
    full_name  VARCHAR(255)       NOT NULL,
    password   VARCHAR(255)       NOT NULL,
    phone_uuid VARCHAR(255)       NOT NULL,


    created_at TIMESTAMP(6)       NOT NULL,
    deleted    BOOLEAN,
    version    NUMERIC(10)

);


CREATE TABLE client_info
(
    id               SERIAL PRIMARY KEY NOT NULL,
    user_id          INTEGER REFERENCES users (id),
    latitude         DECIMAL            NOT NULL,
    longitude        DECIMAL            NOT NULL,
    phone_name       VARCHAR(255)       NOT NULL,
    phone_brand      VARCHAR(255)       NOT NULL,
    operating_system VARCHAR(255)       NOT NULL,
    phone_uuid       VARCHAR(255)       NOT NULL,

    created_at       TIMESTAMP(6)       NOT NULL,
    deleted          BOOLEAN,
    version          NUMERIC(10)
);

ALTER TABLE client_info
    ADD FOREIGN KEY (user_id) references users (id);

CREATE TABLE gas_sensor_logs
(
    id                    SERIAL PRIMARY KEY NOT NULL,
    model_no              VARCHAR(255)       NOT NULL,
    sensor_type           VARCHAR(255)       NOT NULL,
    detection_gas         VARCHAR(255)       NOT NULL,
    concentration         VARCHAR(255)       NOT NULL,
    loop_voltage          VARCHAR(255)       NOT NULL,
    heater_voltage        VARCHAR(255)       NOT NULL,
    load_resistance       VARCHAR(255)       NOT NULL,
    heater_consumption    VARCHAR(255)       NOT NULL,
    sensing_resistance    VARCHAR(255)       NOT NULL,
    sensitivity           VARCHAR(255)       NOT NULL,
    slope                 VARCHAR(255)       NOT NULL,
    tem_humidity          VARCHAR(255)       NOT NULL,
    standard_test_circuit VARCHAR(255)       NOT NULL,
    preheat_time          TIMESTAMP(6)       NOT NULL,

    created_at            TIMESTAMP(6)       NOT NULL,
    deleted               BOOLEAN,
    version               NUMERIC(10)

);


-- User
INSERT INTO users (id, email, username, full_name, password, phone_uuid, created_at, deleted, version)
VALUES (1, 'beratyesbek@gmail.com', 'feanor', 'berat yesbek', '123456', 'f288aeec-aa2c-11ed-afa1-0242ac120002', now(),
        false, 0);


-- Client Info
INSERT INTO client_info (id, user_id, latitude, longitude, phone_name, phone_brand, operating_system, phone_uuid,
                         created_at, deleted, version)
VALUES (1, 1, 41.093474310193805, 29.072522383920028, 'BERAT IPHONE 14 PRO MAX', 'IPHONE 14 PRO MAX', 'IOS',
        '63ef0586-aa3c-11ed-afa1-0242ac120002', now(), false, 0);

INSERT INTO client_info (id, user_id, latitude, longitude, phone_name, phone_brand, operating_system, phone_uuid,
                         created_at, deleted, version)
VALUES (2, 1, 41.093474310193805, 29.072522383920028, 'BERAT IPHONE 14 PRO MAX', 'IPHONE 14 PRO MAX', 'IOS',
        '63ef0586-aa3c-11ed-afa1-0242ac120002', now(), false, 0);