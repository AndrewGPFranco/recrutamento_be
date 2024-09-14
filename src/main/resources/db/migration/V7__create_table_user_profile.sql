CREATE TABLE IF NOT EXISTS user_profile (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL UNIQUE,
    nickname VARCHAR(30),
    full_name VARCHAR(355) NOT NULL,
    description VARCHAR(355),
    date_birth DATE NOT NULL,
    country VARCHAR(30) NOT NULL,
    city VARCHAR(30) NOT NULL,
    gender ENUM('MASCULINO', 'FEMININO', 'OUTRO') NOT NULL,
    phone_number VARCHAR(30),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);