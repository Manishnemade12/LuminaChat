CREATE TABLE conversations
(
    id              BIGSERIAL PRIMARY KEY,
    prompt          TEXT      NOT NULL,
    response        TEXT      NOT NULL,
    created_at      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    conversation_id BIGINT,
    FOREIGN KEY (conversation_id) REFERENCES conversations (id)
);