CREATE TABLE IF NOT EXISTS profile_languages (
    profile_id BIGINT NOT NULL,
    language VARCHAR(255) NOT NULL,
    PRIMARY KEY (profile_id, language),
    CONSTRAINT fk_profile_languages FOREIGN KEY (profile_id) REFERENCES profiles(id) ON DELETE CASCADE
);