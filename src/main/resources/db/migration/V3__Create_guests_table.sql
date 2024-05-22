CREATE TABLE guests (
                        id UUID PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL,
                        event_id UUID NOT NULL,
                        CONSTRAINT fk_event FOREIGN KEY (event_id) REFERENCES event (id)
);
