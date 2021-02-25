package com.crunch.people;

/*
    Access modifiers

        public
        protected
        default
        private
 */

public class User {

    // TODO: Make an integer to represent types of members
    boolean member;
    String username;
    String password;
    // TODO: Make a data structure to define available and interested activities
    String[] activities;
    String phoneNumber;
    String email;


    public User(String username, String password, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(String username){
        this.username = username;
        System.out.println("Created a user with the given username");

    }

    public User() {
    }

    public User(boolean member, String username, String password, String[] activities, String phoneNumber, String email) {
        this.member = member;
        this.username = username;
        this.password = password;
        this.activities = activities;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        member = member;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getActivities() {
        return activities;
    }

    public void setActivities(String[] activities) {
        this.activities = activities;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{}";
    }
}
