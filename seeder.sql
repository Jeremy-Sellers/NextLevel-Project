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
('sixth bio','6themail@test.com','SixthName','Last Name');

INSERT INTO shops (fri_close, fri_open, mon_close, mon_open, sat_close, sat_open, shop_description, shop_heading, shop_tele_num, sun_close, sun_open, thu_close, thu_open, tue_close, tue_open, wed_close, wed_open) VALUES ('5:00 p.m.', '10:00 a.m.','5:00 p.m.', '10:00 a.m.','5:00 p.m.', '10:00 a.m.','First shop description','Shop heading','555-555-5555','5:00 p.m.', '10:00 a.m.','5:00 p.m.', '10:00 a.m.','5:00 p.m.', '10:00 a.m.','5:00 p.m.', '10:00 a.m.')