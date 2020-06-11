insert into category values (1,'Chirurgical', 'Le masque anti-projections');
insert into category values (2,'FFP2', 'Le masque de protection respiratoire individuelle');
insert into category values (3,'Grand publique', 'Le masque en tissu');

insert into mask values (1,200, 1);
insert into mask values (2,200, 2);
insert into mask values (3,200, 3);

insert into collaborater values (10,null,null,'ff@gmail.com','ll','kk','jj');

--insert into delivery values (1,null,true,20,1,1);
--12345
INSERT INTO users VALUES('user',TRUE,'$2a$10$HoZDak2keBkIFy8dtJN.S.Z1Jfricp3sLSsYsRi.eRcQMEoZL5syq');
INSERT INTO users VALUES('admin',TRUE,'$2a$10$HoZDak2keBkIFy8dtJN.S.Z1Jfricp3sLSsYsRi.eRcQMEoZL5syq');


INSERT INTO roles VALUES('USER');
INSERT INTO roles VALUES('ADMIN');

INSERT INTO roles_users VALUES('user','USER');
INSERT INTO roles_users VALUES('admin','ADMIN');
INSERT INTO roles_users VALUES('admin','USER');

