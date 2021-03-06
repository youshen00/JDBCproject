drop table person cascade constraint;
drop sequence person_seq;

create sequence person_seq; 
create table person(
	id number(7) primary key,
	name varchar2(15) not null,
	mobile varchar2(11) not null unique check( length(mobile)=11 ),
	telphone varchar2(13) check( telphone like '___%-_______%'),
	email varchar2(30) unique check( email like '_%@%_' ),
	city varchar2(20),
	birthday date
);

select * from person;