-- INSERT DATA TO "users" TABLE
INSERT INTO users (name, email)
VALUES
    ('John Doe', 'johndoe@example.com'),
    ('Jane Smith', 'janesmith@example.com'),
    ('Michael Johnson', 'michaeljohnson@example.com'),
    ('Emily Davis', 'emilydavis@example.com'),
    ('David Wilson', 'davidwilson@example.com'),
    ('Sarah Brown', 'sarahbrown@example.com'),
    ('Thomas Taylor', 'thomastaylor@example.com'),
    ('Olivia Clark', 'oliviaclark@example.com'),
    ('James Anderson', 'jamesanderson@example.com'),
    ('Emma Turner', 'emmaturner@example.com');

-- INSERT RANDOM TASK BETWEEN 1 AND 5 TO USER
DO $$
DECLARE
user_id INT;
    task_count INT;
    random_count INT;
BEGIN
FOR user_id IN 1..10 LOOP
        random_count := floor(random() * 5) + 1; -- 1 ila 5 arasında rastgele bir sayı üretme
FOR task_count IN 1..random_count LOOP
            INSERT INTO task (title, description, completed, user_id)
            VALUES
                ('Task ' || task_count || ' for User ' || user_id,
                 'Description for Task ' || task_count || ' for User ' || user_id,
                 false, user_id);
        END LOOP;
    END LOOP;
END $$;
