drop table if exists account;
create table account
(
    id       int not null auto_increment,
    username varchar(20) default null,
    password varchar(20) default null,
    perms    varchar(20) default null,
    role     varchar(20) default null,
    primary key (id)
) ENGINE=InnoDB
  default charset = utf8;


lock tables account write;
insert into account
values (1, 'zs', '123456', '', ''), (2, 'ls', '123123', 'manage', ''), (3, 'ww', '123123', 'manage', 'administrator');
unlock tables;