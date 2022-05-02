create database if not exists dogs;

use dogs;

drop table if exists dog;

create table dog (

id int(6) auto_increment not null,
name varchar(15) not null,
breed varchar(20) not null,
age int(2) not null,
primary key(id)
);