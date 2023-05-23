CREATE TABLE electronic_cards
(
    id                 SERIAL PRIMARY KEY NOT NULL,
    qr_code             VARCHAR(255) NOT NULL,
    electronic_card_uuid VARCHAR(255) NOT NULL,

    created_at TIMESTAMP(6) NOT NULL
);