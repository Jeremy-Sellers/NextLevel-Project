DROP DATABASE nextLevel_db;

CREATE DATABASE IF NOT EXISTS nextLevel_db;

CREATE USER nextLevel_Owner@localhost IDENTIFIED BY 'NextLevel1';
GRANT ALL ON nextLevel_db.* TO nextLevel_Owner@localhost;

USE nextLevel_db;

INSERT INTO barbers (bio, email, first_name, last_name,link) VALUES
('','','Ezekiel','','app.thecut.co/barbers/ezekielfades'),
('','','Raul','"Bori"','santiagobvrber.booksy.com/'),
('','','Brian','','booksy.com/en-us/instant-experiences/widget/457850?instant_experiences_enabled=true&id_ix=true&fbclid=PAAaaAI4AlsxARum43i7P_AHN7lACzQsSQQedPLm3aHvj10YfVTfgdwDssoxw'),
('','','Raul','','app.thecut.co/barbers/raulshairszn'),
('','','Esmy','','ladybarberesmy.booksy.com/');

INSERT INTO shops (fri_close, fri_open, mon_close, mon_open, sat_close, sat_open, shop_description, shop_heading, shop_tele_num, sun_close, sun_open, thu_close, thu_open, tue_close, tue_open, wed_close, wed_open,facebook_link,instagram_link,shop_address,shop_appointments_description) VALUES ('5:00 p.m.', '10:00 a.m.','5:00 p.m.', '10:00 a.m.','5:00 p.m.', '10:00 a.m.','Welcome! We are open 7 Days! Providing next level customer service and grooming experience. Specializing in all hairstyles with next level end results! All ages welcomed in this high end family friendly establishment! Se Habla Español! ','A Next Level Experience','210-600-3599','5:00 p.m.', '10:00 a.m.','5:00 p.m.', '10:00 a.m.','5:00 p.m.', '10:00 a.m.','5:00 p.m.', '10:00 a.m.','www.facebook.com/profile.php?id=100039975563464','www.instagram.com/nextlevelbarbershop_/','12255 West Ave Suite 102, San Antonio, TX 78216','Walk-ins always welcomed, expect little to no wait. Appointments are recommended but not needed. We do advise you to make appointments a day in advance. No same day appts.')