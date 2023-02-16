CREATE TABLE location_table
(
    id                  SERIAL PRIMARY KEY NOT NULL ,
    electronic_card_id  INTEGER REFERENCES electronic_cards (id),
    latitude            DECIMAL NOT NULL ,
    longitude           DECIMAL NOT NULL ,

    created_at TIMESTAMP(6) NOT NULL
);
ALTER TABLE location_table
    ADD FOREIGN KEY (electronic_card_id) references electronic_cards (id);