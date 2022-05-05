--liquibase formatted sql

--comment: refer to https://docs.liquibase.com/concepts/changelogs/sql-format.html , changeset is registered action in liquibase.

--changeset gurman:1
create table User (  
    user_Id int AUTO_INCREMENT primary key,
    email varchar(100),
    phone varchar(25),
    username varchar(100),
    password varchar(40)
);  
--rollback drop table User;  