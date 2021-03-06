SET foreign_key_checks = 0;

INSERT INTO User(id,email,firstName, lastName, password, userName) VALUES ('1', 'admin@miu.edu', 'admin', 'admin', '$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', 'admin');

INSERT INTO Role(id, name) VALUES ('1','ROLE_CHECKER');
INSERT INTO Role (id, name ) VALUES ('2', 'ROLE_STUDENT');

INSERT INTO User_Role (User_id, roles_id) VALUES ('1', '1');
INSERT INTO User_Role (User_id, roles_id) VALUES ('1', '2');

INSERT INTO User(id,email,firstName, lastName, password, userName) VALUES ('2', 'student@gmail.com', 'student', 'student', '$2a$10$TceOcA4syLlX.CINYeBWXOLCqhwroMN/.Ez2z83XCb8DtYnzdrx9u', 'student');
INSERT INTO User_Role (User_id, roles_id) VALUES ('2', '2');


INSERT INTO User(id,email,firstName, lastName, password, userName) VALUES ('3', 'checker@gmail.com', 'checker', 'checker', '$2a$10$1Kuz39FChcy7zJeaPLs70.ZJ8acy83.tV/5.VMeD2Zj1BDERFLtca', 'checker');
INSERT INTO User_Role (User_id, roles_id) VALUES ('3', '1');


INSERT INTO User (`id`,`email`,`enabled`,`firstName`,`lastName`,`password`,`userName`) VALUES (4,'checker@miu.edu',NULL,'checker1','checker1','$2a$10$mUCD4rY6p641UCeJNqEaSObAqnUn0uiFFgulQRSZwdDUjN58FhuHK','checker1');
INSERT INTO User_Role (User_id, roles_id) VALUES ('4', '1');

--INSERTINTG Dummy appointmnets
INSERT INTO Appointment (`id`,`date`,`room_no`,`user_id`) VALUES (1,'2020-06-19','123',3);
INSERT INTO Appointment (`id`,`date`,`room_no`,`user_id`) VALUES (2,'2020-06-19','11',3);
INSERT INTO Appointment (`id`,`date`,`room_no`,`user_id`) VALUES (3,'2020-06-27','1222',3);
INSERT INTO Appointment (`id`,`date`,`room_no`,`user_id`) VALUES (4,'2020-07-01','123',4);




--INSERTING DUMMY RESERVATIONS
INSERT INTO Reservation (`id`,`is_reminder_sent`,`status`,`appointment_id`,`consumer_id`) VALUES (1,0,'PENDING',1, '2');
INSERT INTO Reservation (`id`,`is_reminder_sent`,`status`,`appointment_id`,`consumer_id`) VALUES (2,0,'PENDING',2, '2');
INSERT INTO Reservation (`id`,`is_reminder_sent`,`status`,`appointment_id`,`consumer_id`) VALUES (3,0,'PENDING',3, '2');
INSERT INTO Reservation (`id`,`is_reminder_sent`,`status`,`appointment_id`,`consumer_id`) VALUES (4,0,'PENDING',4, '2');