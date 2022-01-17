drop table if exists account;
create table if not exists account (
	m_id serial,
	fName varchar(50),
	lName varchar(50),
	balance numeric(22, 2),
	available bool,
	pw varchar(50)
);

insert into account values (default, 'Tom', 'Jones', 100000, true, '11223344');