create database quiz;
use quiz;
create table questions(
	id int auto_increment,
    topic varchar(400),
    difficulty int,
    content varchar(400),
    responses varchar(400),
    primary key (id)
);