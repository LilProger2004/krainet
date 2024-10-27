INSERT INTO role (id, role_name)
VALUES (1, 'USER'),
       (2, 'ADMIN');

INSERT INTO employee (employee_id, employee_role_id, employee_login, employee_password, employee_email)
VALUES ('539b93d0-a77a-4107-aa48-de4f6aaac6b0', 2, 'krainet', '$2a$10$Edk6MubxmgvNauGwGPhGKeGIaV3npQoT.DYDHFDIMfYvXNEY.4AUy', 'krainet@gmail.com');

INSERT INTO employee (employee_id, employee_role_id, employee_login, employee_password, employee_email)
VALUES ('7954c292-4621-4108-b196-6d64893d4f9b', 1, 'PDiddy', '$2a$10$ZEJ/CfSzosyxZfNjA4elW..VYX2D1aXGfR5zWdYaJ024CHAnUYyVu', 'white_party@gmail.com');

INSERT INTO project (project_id, project_name, project_start_date, project_end_date)
VALUES
    ('proj-001', 'Website Redesign', '2024-01-15', '2024-06-15'),
    ('proj-002', 'Mobile App Development', '2023-10-01', '2024-04-01');

-- Таблица task
INSERT INTO task (task_id, task_name, task_required_start_date, task_required_end_date, project_id)
VALUES
    ('task-001', 'Design Homepage', '2024-01-01', '2024-01-15', 1),
    ('task-002', 'Backend API Development', '2024-02-01', '2024-04-01', 2);

INSERT INTO employee_tasks (employee_id, tasks_id)
VALUES
    (10, 1),
    (10, 2);

-- Таблица record
INSERT INTO record (record_time, employee_id, task_id)
VALUES
    ('08:30:00', 10, 1),
    ('09:00:00',10, 2),
    ('10:30:00', 10, 2);

