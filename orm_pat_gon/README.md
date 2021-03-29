This is Patrick Gonzalez's ORM

You can set your database connection properties in the connection.properties file

A few things to note when creating a class that you want to be
persisted to the database you must use the @Entity annotation above the
class.

Also you must use the @Id annotation on a primitive int variable
with the name id such as this: 

@Id @GeneratedValue
private int id 

The ORM is able to create a primary key for the table using
this variable.

Anytime you create a class that is denoted as an entity 
you must create a static boolean variable with the name tableExists
that is initialized to false such as the one given:
private static boolean tableExists = false;

This variable is used to check if the table for the entity has already been created
I did this to avoid extra overhead of going to the database
and checking to see if the table exists there.

All entities must have a no args constructor and every field
that you intend to store into the database for the table of that entity
must have the @Column annotation above it along with a name

Example:
@Column(name="firstname")
private String firstName;

All entities must have a toString method.
