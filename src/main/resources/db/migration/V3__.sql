ALTER TABLE project
    ADD project_name VARCHAR(255);

ALTER TABLE project
    ALTER COLUMN project_name SET NOT NULL;