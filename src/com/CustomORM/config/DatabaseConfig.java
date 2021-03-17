package com.CustomORM.config;

public class DatabaseConfig {

    private String randomString = "a string in database config";

    public DatabaseConfig() {
        this.randomString = randomString;
    }

    public String getString() {
        return randomString;
    }



}
