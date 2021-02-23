package com.crunch.people;
/*
    Access modifiers
    public
    protected
    default
    private
 */

import com.sun.deploy.panel.IProperty;

public class User {

    // Properties
    // TODO: refactor isMember from boolean to membership type
    private boolean member;
    private String username;
    private String password;

    // TODO: Make a datastructure to define the available and interested activities
    private String[] activities;
    private String phoneNumber;
    private String email;

    // Constructors
    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password, String phoneNumber, String email){
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(boolean member, String username, String password, String[] activities, String phoneNumber, String email) {
        this.member = member;
        this.username = username;
        this.password = password;
        this.activities = activities;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String toString(){
        return "Username = " + username;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
