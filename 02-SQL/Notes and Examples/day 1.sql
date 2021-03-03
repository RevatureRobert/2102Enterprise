/*
 * 
 * A Table is a series of columns and rows
 * 		You can think of the tables as your classes
 * 			and the rows as your objects.
 * 
 * sublanguages of sql
 * 		DML
 * 			Data Manipulation Language
 * 				CRUD Operations: create, read, update, and delete
 * 				keywords: insert, select, update, delete			
 */


select * from "Album";

-- selecting the titles of the album table and sorting them in alphabetical order 
select "Title" from "Album"  order by "Title" limit 20;



insert into "Album" ("AlbumId","Title","ArtistId") values (348, 'the great war', 10);

insert into "Album" values (349, 'the great war', 10), (350, 'the great war', 10);



select * from "Album" order by "AlbumId" desc;


delete from "Album" where "AlbumId" = 350;

update "Album" set "Title" = 'the bad war' where "AlbumId" = 349;




/*
 * DDL
 * 		Data Definition Language
 * 			Creating and altering objects in the database management system
 * 				(tables, functions, schemas, databases, users, roles, triggers, etc.)
 * 			keywords: create, alter, truncate, drop
 * 
 */

/*
 * constraints
 * 		unique
 * 		not null
 * 		primary key
 * 			natural keys - have meaning outside the database
 * 			surrogate keys - do not have meaning outside the database
 * 			composite keys - more than one, it is a combination of keys
 * 		default
 * 		check
 */

create table colors (
--	id Integer primary key,
	color varchar(200),
	primary_color boolean not null
);


insert into colors values ('red'), ('green'), ('blue'), ('purple');

select * from colors;

alter table colors add column primary_color boolean;

update colors set primary_color = true where color = 'red' or color = 'blue';

update colors set primary_color = false where primary_color is null;

update colors set primary_color = false where color != 'red' and color != 'blue';

truncate table colors;

drop table colors;



/*
Normalization

	1NF 
		granularizing the table information
		needs a primary key
		
	2NF
		must be in first normal form
		no partial dependencies - no composite key, no partial dependencies
	
	3NF
		must be in second normal form
		no transitive dependencies
		
	BCNF
		Boyce Codd Normal Form
			The key, the whole key, nothing but the key, so help me Codd.
			
	4NF
		must be in BCNF
		no multi valued dependencies
*/


create table address (
	address text,
	location text
);

insert into address values ('1324 fake street', 'hallows eve, pennsylvania 52555');


create table address2(
	id Integer primary key,
	street_number Integer,
	street_name text,
	apartment text,
	city text, 
	state text,
	zip Integer
);

create table table_user (
	id Integer primary key,
	first_name text,
	last_name text,
	address Integer,
	constraint fk_user_addr foreign key (address) references address2(id)
);

alter table table_user add constraint fk_usr_add foreign key (address) references address2(id);
alter table table_user drop column something_not_null;
select * from table_user;
drop table table_user;
drop table address2;
truncate table table_user;

insert into address2 values (1, 1234, 'ksearjfgb','kgn','sjrg','sfdgh',55555);
insert into table_user values (1, 'sadif','sadkfjhg',1);
insert into table_user values (2, 'sadif','sadkfjhg',1);

select * from table_user;
/*
 * Foreign key
 * 		Referential integrity
 * 			one table cannot point to a non existent entry in another table
 * 		Orphaned Records
 * 			When a child table points to a parent table, and you want to delete
 * 				the parent table. The child must either point to a different
 * 				record in the parent table, or be deleted first to avoid 
 * 				orphaned records.
 * 
 * Multiplicity
 * 		relationships between tables
 * 			1-m or m-1
 * 				foreign key goes in the many table
 * 			m-m
 * 				intermediate table, aka junction table, to hold foreign
 * 					keys of the other two tables
 * 			1-1
 * 				make the foreign key unique, no matter the table
 * 
 */

/*
 * TCL
 * 		Transaction Control Language
 * 			keywords: begin, end, savepoint, rollback, commit
 * 		begin will create the transaction block and gather the transaction information
 * 			from the dbms
 * 		end will end the transaction block
 * 		savepoint will create savepoints within the transaction that you can rollback to
 * 			if needed.
 * 		rollback will revert the changes back to the original state of the transaction
 * 			or to a state in a savepoint.
 * 		commit will commit the changes and end the transaction, sending the changes to the 
 * 			db for persistent alterations.
 * 
 */

begin;
	insert into colors values ('orange');
	select * from colors;
	savepoint alpha;
	insert into colors values ('jude');
	select * from colors;
	savepoint beta;
	commit;
	rollback;
end

delete from colors where color = 'blurple';

select * from colors;




