drop table if exists user;
create table if not exists user(
id int not null auto_increment primary key,
first_Name varchar(50),
last_Name varchar(50)
);

drop table if exists customers;
create table customers
(
    id        bigint unsigned auto_increment,
    first_Name varchar(255) null,
    last_Name  varchar(255) null,
    constraint id
        unique (id)
);