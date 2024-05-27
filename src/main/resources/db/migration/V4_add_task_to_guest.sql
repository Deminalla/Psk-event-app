CREATE TABLE tasks (
                       id UUID PRIMARY KEY,
                       description VARCHAR(255) NOT NULL,
                       guest_id UUID NOT NULL,
                       event_id UUID NOT NULL,
                       completed BOOLEAN NOT NULL DEFAULT FALSE,
                       CONSTRAINT fk_event FOREIGN KEY (event_id) REFERENCES event (id)
);
