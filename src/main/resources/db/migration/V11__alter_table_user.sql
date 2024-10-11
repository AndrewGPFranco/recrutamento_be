SELECT COUNT(*)
INTO @colExists
FROM information_schema.columns
WHERE table_name = 'users'
AND column_name = 'profile_id';

SET @alterStmt = IF(@colExists = 0, 'ALTER TABLE users ADD COLUMN profile_id BIGINT, ADD CONSTRAINT fk_profile FOREIGN KEY (profile_id) REFERENCES profiles(id) ON DELETE CASCADE', 'SELECT "Column already exists"');
PREPARE stmt FROM @alterStmt;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;