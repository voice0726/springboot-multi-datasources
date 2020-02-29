CREATE DATABASE client1;
CREATE DATABASE client2;

-- auto-generated definition
create table client1.client_user
(
    id   int auto_increment
        primary key,
    name varchar(1024) not null
);

create table client2.client_user
(
    id   int auto_increment
        primary key,
    name varchar(1024) not null
);
