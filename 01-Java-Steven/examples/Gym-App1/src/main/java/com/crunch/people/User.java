package com.crunch.people;

public class User {
	
	// TODO: Make an integer to represent different types of members
    boolean isMember;
    String username;
    String password;
    // TODO: Make a data structure to define the available and interested activities
    String[] activities;
    String phoneNumber;
    String email;
    
    public User(String username) {
    	this.username = username;
    	System.out.println("Created user with the given username");
    }

}
