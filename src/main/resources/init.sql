DROP TABLE IF EXISTS user;

CREATE TABLE user(
                       id int not null primary key auto_increment,
                       first_name VARCHAR(255) NOT NULL,
                       last_name VARCHAR(255) NOT NULL
);

INSERT INTO `user` (`first_name`,`last_name`) VALUES ("Chadwick","Rosales"),("Gil","Wise"),("Kennan","Battle"),("Cedric","Harris"),("Burton","Frederick"),("Ivor","Rowland"),("Hiram","Mccoy"),("Arthur","Cantrell"),("Elvis","Sloan"),("Mark","Warren");
