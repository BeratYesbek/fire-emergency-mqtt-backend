CREATE TABLE electronic_cards
(
    id                 SERIAL PRIMARY KEY NOT NULL,
    qrCode             VARCHAR(255) NOT NULL,
    electronicCardUUID VARCHAR(255) NOT NULL,

    created_at TIMESTAMP(6) NOT NULL
);