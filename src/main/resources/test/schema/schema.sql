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

CREATE TABLE electronic_cards
(
    id                 SERIAL PRIMARY KEY NOT NULL,
    qrCode             VARCHAR(255)       NOT NULL,
    electronicCardUUID VARCHAR(255)       NOT NULL,

    created_at         TIMESTAMP(6)       NOT NULL
);

CREATE TABLE location_table
(
    id                 SERIAL PRIMARY KEY NOT NULL,
    electronic_card_id INTEGER REFERENCES electronic_cards (id),
    latitude           DECIMAL            NOT NULL,
    longitude          DECIMAL            NOT NULL,

    created_at         TIMESTAMP(6)       NOT NULL
);

ALTER TABLE location_table
    ADD FOREIGN KEY (electronic_card_id) references electronic_cards (id);

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

CREATE TABLE electronic_card_users
(
    id         SERIAL PRIMARY KEY NOT NULL,
    name       VARCHAR(50)        NOT NULL,
    uuid       VARCHAR(250)       NOT NULL,
    user_id    INTEGER REFERENCES users (id),

    deleted    BOOLEAN,
    version    NUMERIC(10),
    created_at TIMESTAMP(6)       NOT NULL


);

ALTER TABLE electronic_card_users
    ADD FOREIGN KEY (user_id) references users (id);

