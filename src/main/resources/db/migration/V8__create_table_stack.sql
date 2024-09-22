CREATE TABLE IF NOT EXISTS profile_stacks (
    profile_id BIGINT NOT NULL,
    technology_type VARCHAR(255) NOT NULL,
    PRIMARY KEY (profile_id, technology_type),
    CONSTRAINT fk_profile_stacks FOREIGN KEY (profile_id) REFERENCES profiles(id) ON DELETE CASCADE
);