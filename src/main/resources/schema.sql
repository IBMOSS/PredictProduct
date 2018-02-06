create table contacts (
	id bigint auto_increment,
	firstName varchar(30) not null,
	lastName varchar(50) not null,
	phoneNumber varchar(13),
	emailAddress varchar(30),
	primary key(id)
);

create table predition_result (
	id bigint auto_increment,
	version varchar(30) not null,
	condition varchar(255) not null,
	result varchar(255),
	score DOUBLE,
	primary key(id)
);

create table param_table (
	id bigint auto_increment,
	param varchar(30) not null,
	primary key(id)
);

