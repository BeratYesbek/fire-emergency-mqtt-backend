CREATE TABLE electronic_card_users (
    id              SERIAL PRIMARY KEY NOT NULL,
    name            VARCHAR(50) NOT NULL,
    uuid            VARCHAR(250) NOT NULL,
    user_id         INTEGER REFERENCES users(id),
    card_id         INTEGER REFERENCES electronic_cards(id),

    deleted         BOOLEAN,
    version         NUMERIC(10),
    created_at      TIMESTAMP(6) NOT NULL


);

ALTER TABLE electronic_card_users
    ADD FOREIGN KEY (user_id) references users (id);

ALTER TABLE electronic_card_users
    ADD FOREIGN KEY (card_id) references electronic_cards(id);