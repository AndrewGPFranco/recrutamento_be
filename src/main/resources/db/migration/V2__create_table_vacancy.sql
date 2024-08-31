CREATE TABLE IF NOT EXISTS vacancies (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(30) NOT NULL,
    description VARCHAR(500) NOT NULL,
    salary INTEGER NOT NULL,
    company VARCHAR(30) NOT NULL,
    location VARCHAR(50) NOT NULL,
    job JSON NOT NULL,
    technologies JSON NOT NULL,
    level VARCHAR(50) NOT NULL,
    experience BOOLEAN NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    benefits JSON NOT NULL

);