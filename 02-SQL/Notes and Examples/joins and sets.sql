/*

joins
	inner
	outer
		left
		right
		full
	self
	cross
set operators
	union
	union all
	intersect
	minus

*/

select * from "Customer";
select "InvoiceDate" from "Invoice";

-- inner join
select "FirstName", "LastName", "Total" from "Customer" 
	inner join "Invoice" 
		on "Customer"."CustomerId" = "Invoice"."CustomerId";
		
select "FirstName", "LastName", "Total" from "Customer" 
	join "Invoice" 
		on "Customer"."CustomerId" = "Invoice"."CustomerId";
	
select "FirstName", "LastName", "Total" from "Customer" c
	join "Invoice" i 
		on c."CustomerId" = i."CustomerId";

select c."FirstName", c."LastName", "Total", e."FirstName" as support_name
	from "Customer" c, "Invoice" i, "Employee" e
		where c."CustomerId" = i."CustomerId" and c."SupportRepId"= e."EmployeeId";
		
select "FirstName", "LastName", "Total" from "Customer" c
	left join "Invoice" i 
		on c."CustomerId" = i."CustomerId";
		
select "Name", "Title" from "Artist"a left outer join "Album"b on a."ArtistId" = b."ArtistId";


--set operations
--	requirements, sets must have the same number of columns and the same types in the same order

select * from "Customer";
select * from "Employee";

select "FirstName" as first,"LastName" from "Customer";
select "LastName","FirstName" from "Employee";

--unions
select "FirstName" as first,"LastName" from "Customer" 
	union select "FirstName", "LastName" from "Employee" 
		order by "LastName" asc;
		
	--union all, has duplicates
select "State" from "Customer" where "State" is not null 
	union all 
		select "State" from "Employee" where "State" is not null; -- duplicates
select "State" from "Customer" union select "State" from "Employee" order by "State"; --no duplicates


--intersect
select "State" from "Customer" intersect select "State" from "Employee";


create table A (num Integer);
create table B (bnum Integer);
insert into A values (1),(2),(3);
insert into B values (2),(3),(4);
select * from A;
select * from B;

-- minus
select * from A except select * from B;
select * from B except select * from A;

-- find the uncommon entries of two tables
select * from A except select * from B union (select * from B except select * from A);



select count(*) from (select "FirstName" from "Customer" union select "FirstName"from "Employee");

-- count is an aggregate function, others include average, sum, etc. These work on multiple
--		pieces of data
select count(first) from 
	( select "FirstName" as first from "Customer" 
		union select "FirstName" from "Employee") 
			as table_union;

-- scalar function works with one piece of data
select upper('george of the jungle');


-- subquery is a nested query. A query within a query. the query to end them all.
select count(*) from "Artist" where "ArtistId" in (select "ArtistId" from "Album") ;
select count(*) from "Artist" where "ArtistId" not in (select "ArtistId" from "Album");
select "ArtistId" from "Album";

select * from "Customer";

select a."ArtistId", "Name","Title" from "Artist"a join "Album"b on a."ArtistId" = b."ArtistId";

select a."ArtistId", "Name","Title" from "Artist"a join "Album"b on a."ArtistId" = b."ArtistId" where a."ArtistId" = 1;

create view artist_albums as select a."ArtistId", "Name","Title" from "Artist"a join "Album"b on a."ArtistId" = b."ArtistId";

create view acdc_albums as select * from artist_albums where "ArtistId" = 1;
select * from acdc_albums;
select * from artist_albums where "Name" like 'A%';

insert into "Album" values (351, 'something for another war',1);

select * from "Album";

drop view acdc_albums;
drop view artist_albums;