--liquibase formatted sql

--comment: refer to https://docs.liquibase.com/concepts/changelogs/sql-format.html , changeset is registered action in liquibase.

--changeset gurman:1
create table if not exists test1 (  
    id int primary key,
    name varchar(100)  
);  
create sequence if not exists seq_test1 start 1 increment 1;
--rollback drop table test1; 
--rollback drop sequence seq_test1; 

--changeset gurman:2
create table if not exists test2 (  
    id int primary key,
    name varchar(100)  
);  
create sequence if not exists seq_test2 start 1 increment 1;
--rollback drop table test2; 
--rollback drop sequence seq_test2; 
