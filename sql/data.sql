SET foreign_key_checks = 0;

INSERT INTO User(id,email,firstName, lastName, password, userName) VALUES ('1', 'eerdene@miu.edu', 'admin', 'admin', '123', 'admin');

INSERT INTO Role(id, name) VALUES ('1','ROLE_CHECKER');
INSERT INTO Role (id, name ) VALUES ('2', 'ROLE_STUDENT');

INSERT INTO User_Role (User_id, roles_id) VALUES ('1', '1');
INSERT INTO User_Role (User_id, roles_id) VALUES ('1', '2');