Create Database SrpingTest
Create Database SrpingDemo
Create Database SrpingJPA
Create Database SrpingProject
Create Database MobileStore
Create Database SpringSecurity

Use SrpingTest
CREATE TABLE LoginSpring (
    username varchar(20),
    password varchar(30),
    fullname nvarchar(50),
	isAdmin bit
);

Use SrpingTest
CREATE TABLE Users (
    username varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    fullname nvarchar(50),
	age int,
	gender bit,
);

Use SrpingTest
CREATE TABLE ProductSpring (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name varchar(30) NOT NULL,
    price float NOT NULL,
);


Use SrpingTest
INSERT INTO LoginSpring (username, password, fullname, isAdmin)
VALUES ('minh', 88, 'Le Dang Gia Minh', 1);
INSERT INTO LoginSpring (username, password, fullname, isAdmin)
VALUES ('mikey', 88, 'Le Dang Gia Minh', 1);
INSERT INTO LoginSpring (username, password, fullname, isAdmin)
VALUES ('spring', 123, 'Fpt Academy', 0);
INSERT INTO LoginSpring (username, password, fullname, isAdmin)
VALUES ('java', 123, 'Fpt Academy', 0);
INSERT INTO LoginSpring (username, password, fullname, isAdmin)
VALUES ('fpt', 123, 'Fpt Academy', 0);
INSERT INTO LoginSpring (username, password, fullname, isAdmin)
VALUES ('flex', 88, 'Le Dang Gia Minh', 1);
INSERT INTO LoginSpring (username, password, fullname, isAdmin)
VALUES ('Test1', 88, 'Delete this one a', 0);
INSERT INTO LoginSpring (username, password, fullname, isAdmin)
VALUES ('Test2', 88, 'Delete this one a', 0);
INSERT INTO LoginSpring (username, password, fullname, isAdmin)
VALUES ('Test3', 88, 'Delete this one a', 0);



Use SrpingTest
INSERT INTO ProductSpring(name, price)
VALUES ('HTML', 5580);
INSERT INTO ProductSpring(name, price)
VALUES ('CSS', 3875);
INSERT INTO ProductSpring(name, price)
VALUES ('JavaScript', 9734);
INSERT INTO ProductSpring(name, price)
VALUES ('React', 8375);
INSERT INTO ProductSpring(name, price)
VALUES ('Java', 8734);
INSERT INTO ProductSpring(name, price)
VALUES ('Spring', 3543);
INSERT INTO ProductSpring(name, price)
VALUES ('C/C++', 5348);
INSERT INTO ProductSpring(name, price)
VALUES ('Python', 1111);



Use SrpingProject
INSERT INTO roles (id, name) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

INSERT INTO users (id, email, password, first_name, last_name) VALUES
(1, 'admin@gmail.com', '$2a$10$moTjfAVBJzNS32q7NPPVh.iAGDbZSkjZJBkdxT5ZLKQ3R1Vh/y9Fi', 'Admin', '');

insert into user_role(user_id, role_id) values
(1,1),
(1,2);


Use SrpingTest
DROP TABLE LoginSpring;
Use SrpingTest
DROP TABLE ProductSpring;
Use SrpingTest
DROP TABLE Users;
Use SrpingJPA
DROP TABLE accounts, categories, orders, oder_details, products;
Use MobileStore
DROP TABLE roles, users, user_role
Use SrpingProject
DROP TABLE roles, users, user_role

DROP DATABASE SrpingJPA

Use SrpingProject
ALTER TABLE user_role DROP CONSTRAINT FKj345gk1bovqvfame88rcx7yyx;