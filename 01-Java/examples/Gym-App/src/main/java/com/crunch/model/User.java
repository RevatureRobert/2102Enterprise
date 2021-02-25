package com.crunch.model;

import java.util.Arrays;
import java.util.Objects;

/**
 * Access Modifiers
 * Everywhere          Subclasses          Package         Same Class
 * public                  X                   X                   X               X
 * protected               O                   X                   X               X
 * default                 O                   O                  X                 X
 * private                 O                   O                   O               X
 * <p>
 * <p>
 * <p>
 * Constructors
 * Default is a No Arg constructor
 * No-Args
 * All-Args
 * Some-Args
 */

public class User extends Object {

    private MembershipType membership;
    private String username;
    private String password;
    // TODO: make a data structure to define the available and interested activities
    private String[] activities;
    private String phoneNumber;
    private String email;

    public MembershipType getMembership() {
        return membership;
    }

    public void setMembership(MembershipType membership) {
        this.membership = membership;
    }

    public String getUsername() {
        return username;
    }

    // TODO: check for numerical input and properly formatted if necessary

    public void setUsername(String username) {
        System.out.println(username);
        if (username.length() > 0) {
            this.username = username;
        }
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

    public User(MembershipType member, String username, String password, String[] activities, String phoneNumber, String email) {
        this.membership = member;
        this.username = username;
        this.password = password;
        this.activities = activities;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(String username, String password, String phoneNumber, String email) {
        this.username = username;
        this.password= password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User() {
    }

    public User(String username) {
        this.username = username;
    }


    public String toString(){
        return "Username = " + username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return membership == user.membership && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Arrays.equals(activities, user.activities) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(membership, username, password, phoneNumber, email);
        result = 31 * result + Arrays.hashCode(activities);
        return result;
    }
}
