CREATE TABLE  gas_sensor_logs (
    id                     SERIAL PRIMARY KEY NOT NULL,
    model_no               VARCHAR(255) NOT NULL,
    sensor_type            VARCHAR(255) NOT NULL,
    detection_gas          VARCHAR(255) NOT NULL,
    concentration          VARCHAR(255) NOT NULL,
    loop_voltage           VARCHAR(255) NOT NULL,
    heater_voltage         VARCHAR(255) NOT NULL,
    load_resistance        VARCHAR(255) NOT NULL,
    heater_consumption     VARCHAR(255) NOT NULL,
    sensing_resistance     VARCHAR(255) NOT NULL,
    sensitivity            VARCHAR(255) NOT NULL,
    slope                  VARCHAR(255) NOT NULL,
    tem_humidity           VARCHAR(255) NOT NULL,
    standard_test_circuit  VARCHAR(255) NOT NULL,
    preheat_time           TIMESTAMP(6) NOT NULL,

    created_at TIMESTAMP(6) NOT NULL,
    deleted         BOOLEAN,
    version         NUMERIC(10)

)