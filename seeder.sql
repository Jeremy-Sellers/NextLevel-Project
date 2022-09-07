DROP DATABASE nextLevel_db;

CREATE DATABASE IF NOT EXISTS nextLevel_db;

CREATE USER nextLevel_Owner@localhost IDENTIFIED BY 'NextLevel1';
GRANT ALL ON nextLevel_db.* TO nextLevel_Owner@localhost;

USE nextLevel_db;

INSERT INTO barbers (bio, email, first_name, last_name) VALUES
('first bio','1stemail@test.com','FirstName','LastName'),
('second bio','2ndemail@test.com','SecondName','LastName'),
('third bio','3rdemail@test.com','ThirdName','LastName'),
('fourth bio','4themail@test.com','FourthName','LastName'),
('fifth bio','5themail@test.com','FifthName','Last Name'),
('sixth bio','6themail@test.com','SixthName','Last Name')