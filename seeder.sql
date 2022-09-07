DROP DATABASE nextLevel_db;

CREATE DATABASE IF NOT EXISTS nextLevel_db;

CREATE USER nextLevel_Owner@localhost IDENTIFIED BY 'NextLevel1';
GRANT ALL ON nextLevel_db.* TO nextLevel_Owner@localhost;

USE nextLevel_db;