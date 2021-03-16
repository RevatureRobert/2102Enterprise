package com.dealership.model;

import java.util.Objects;
import java.util.Scanner;

public class DealershipUser {


    private Integer userId;
    private String username;
    private String userPassword;
    private String firstName;
    private String lastName;
    private Integer userType;

    public DealershipUser(Integer userId, String username, String userPassword, String firstName, String lastName, Integer userType) {
        this.userId = userId;
        this.username = username;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
    }

    public DealershipUser(String username, String userPassword, String firstName, String lastName, Integer userType) {
        this.username = username.toLowerCase();
        this.userPassword = userPassword;
        this.firstName = firstName.toLowerCase();
        this.lastName = lastName.toLowerCase();
        this.userType = userType;
    }

    public DealershipUser() {
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DealershipUser)) return false;
        DealershipUser that = (DealershipUser) o;
        return Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getUserPassword(), that.getUserPassword()) && Objects.equals(getUserType(), that.getUserType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getUserPassword(), getFirstName(), getLastName(), getUserType());
    }

    @Override
    public String toString() {
        return "DealershipUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + userPassword + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }

}
