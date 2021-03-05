--functions and procedures
--	PLSQL => Procedural Language SQL
--	functions can be called from jdbc via prepared statements and callable statements
--	procedures can only be called from jdbc by prepared statements

/*
 * create [or replace] function function_name (parameter_name type) returns data_type as $$
 * function body
 * $$ language [language the body is written in]
 */
create or replace function add (a Integer, b Integer) returns Integer as $add$
	begin
		return $1 + $2;
	end
$add$ language plpgsql;

select add(1,2);


-- returning multiple values
create or replace function get_all_artists () returns table(id Integer, name varchar(120)) as $get_all_artists$
	begin
		return query select * from "Artist" where "Name" = 'Aerosmith';
	end
$get_all_artists$ language plpgsql;

select * from get_all_artists();

drop function get_all_artists;


select * from "Artist" where "Name" = 'Aerosmith';

-- example of another language
create or replace function c_example(num1 Integer, num2 Integer) returns Integer as $$
	int result;
	if(num1 > num2)
		result = num1;
	else
		result = num2;
	return result;
$$ language c;



create or replace procedure insert_into_artist (id Integer, name varchar(120)) as $$

insert into "Artist" values (id, name);

$$ language sql;


call insert_into_artist(277, 'meeeeee');

-- a function that does not return anything
create or replace function no_return (id Integer, name varchar(120)) returns void as $$
begin
	insert into "Artist" values (id, name);
end

$$ language plpgsql;

select no_return(278, 'meeeeeeeee');













---ACID 
-----i is for isolation
--isolation levels
/*
 * isolation levels
					dirty read		Non-Repeatable Read		Phantom Read		Serialization Anomaly
 *  read uncommited		X					X					X						X
 * 	read commited		O					X					X						X
 * 	Repeatable Read		O					O					O not in psql						X
 * 	Serializable		O					O					O						O
 */

