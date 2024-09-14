CREATE TABLE IF NOT EXISTS language (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    language_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_profile_language (
    user_profile_id BIGINT,
    language_id BIGINT,
    FOREIGN KEY (user_profile_id) REFERENCES user_profile(id) ON DELETE CASCADE,
    FOREIGN KEY (language_id) REFERENCES language(id) ON DELETE CASCADE
);
