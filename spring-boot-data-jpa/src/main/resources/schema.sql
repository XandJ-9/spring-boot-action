drop table if exists user;
create table if not exists user(
id int not null auto_increment primary key,
first_Name varchar(50),
last_Name varchar(50)
);