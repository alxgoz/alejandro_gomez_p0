drop table if exists accounts;
create table if not exists accounts (
	m_id serial,
	fName varchar(50),
	lName varchar(50),
	balance numeric(22, 2),
	available bool,
	pw varchar(50)
);

insert into accounts values (default, 'Terry', 'Fleece', 1, true, '2');
insert into accounts values (default, 'Sly', 'Rashid', 7800, true, '44332211');