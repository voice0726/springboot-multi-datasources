-- auto-generated definition
create table client1.client_user
(
    id   serial        not null
        constraint user_pk
        primary key,
    name varchar(1024) not null
);

alter table client1.client_user
    owner to admin;

