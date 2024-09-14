CREATE TABLE IF NOT EXISTS experience (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS user_profile_experience (
    user_profile_id BIGINT,
    experience_id BIGINT,
    FOREIGN KEY (user_profile_id) REFERENCES user_profile(id) ON DELETE CASCADE,
    FOREIGN KEY (experience_id) REFERENCES experience(id) ON DELETE CASCADE
);
