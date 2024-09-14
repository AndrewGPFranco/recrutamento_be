CREATE TABLE IF NOT EXISTS stack (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    technology VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_profile_stack (
    user_profile_id BIGINT,
    stack_id BIGINT,
    FOREIGN KEY (user_profile_id) REFERENCES user_profile(id) ON DELETE CASCADE,
    FOREIGN KEY (stack_id) REFERENCES stack(id) ON DELETE CASCADE
);
