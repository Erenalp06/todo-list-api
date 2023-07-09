-- CREATE SEQUENCES AND TABLES

DROP SEQUENCE IF EXISTS user_seq CASCADE;
CREATE SEQUENCE user_seq START 1 INCREMENT 1;

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users(
                      id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('user_seq'),
                      name VARCHAR(100) NOT NULL,
                      email VARCHAR(255) NOT NULL
);

DROP SEQUENCE IF EXISTS task_seq CASCADE;
CREATE SEQUENCE task_seq START 1 INCREMENT 1;

DROP TABLE IF EXISTS task CASCADE;
CREATE TABLE task(
                id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('task_seq'),
                title VARCHAR(255) NOT NULL,
                description VARCHAR(500) NOT NULL,
                completed BOOLEAN NOT NULL,
                user_id BIGINT NOT NULL REFERENCES users(id)
);