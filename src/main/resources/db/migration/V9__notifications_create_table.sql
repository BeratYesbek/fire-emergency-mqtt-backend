CREATE TABLE notifications
(
    id         SERIAL PRIMARY KEY NOT NULL,
    user_id    INTEGER REFERENCES users(id) NOT NULL ,
    card_id    INTEGER REFERENCES electronic_cards(id) NOT NULL,
    message    VARCHAR(1000) NOT NULL,
    title      VARCHAR(1000) NOT NULL,



    deleted    BOOLEAN,
    version    NUMERIC(10),
    created_at TIMESTAMP(6) NOT NULL
)