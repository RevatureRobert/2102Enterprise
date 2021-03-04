create table membership_type(
	id Integer primary key,
	type text unique
);

create table app_user(
	username text primary key,
	password text,
	phonenumber text,
	email text,
	membership Integer references membership_type
);


create table activity (
	id Integer primary key,
	activity text unique
);

create table user_activity (
	user_name text references app_user,
	activity_id Integer references activity,
	primary key (user_name, activity_id)
);


insert into app_user values ('blah')

insert into membership_type values (0, 'NEVER_USER'),(1, 'BASIC_USER'),(2, 'PREMIUM_USER'), (3, 'PREVIOUS_USER');

select * from app_user;

select * from app_user a join membership_type m on a.membership = m.id;