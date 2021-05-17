DROP TABLE IF EXISTS user;

CREATE TABLE user(
                       id int not null primary key auto_increment,
                       first_name VARCHAR(255) NOT NULL,
                       last_name VARCHAR(255) NOT NULL
);
