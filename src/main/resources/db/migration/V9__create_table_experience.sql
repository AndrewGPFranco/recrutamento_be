CREATE TABLE experiences (
    id BIGINT NOT NULL AUTO_INCREMENT,
    profile_id BIGINT NOT NULL,
    company_name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    PRIMARY KEY (id),
    CONSTRAINT fk_profile_experience FOREIGN KEY (profile_id) REFERENCES profiles(id) ON DELETE CASCADE
);