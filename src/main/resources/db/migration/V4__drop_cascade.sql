ALTER TABLE guests DROP CONSTRAINT fk_event;
ALTER TABLE guests ADD CONSTRAINT fk_event FOREIGN KEY (event_id) REFERENCES event (id) ON DELETE CASCADE;


DO $$
DECLARE
constraint_name text;
BEGIN
    -- Fetch the constraint name
SELECT conname INTO constraint_name
FROM pg_constraint
WHERE conrelid = 'tasks'::regclass AND contype = 'f';

-- Drop the constraint
EXECUTE format('ALTER TABLE tasks DROP CONSTRAINT %I', constraint_name);
END $$;

ALTER TABLE tasks ADD CONSTRAINT fk_event FOREIGN KEY (event_id) REFERENCES event (id) ON DELETE CASCADE;
