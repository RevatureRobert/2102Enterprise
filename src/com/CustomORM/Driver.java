package com.CustomORM;

import com.CustomORM.config.DatabaseConfig;

public class Driver {

    public static void main(String[] args) {

        DatabaseConfig databaseConfig = new DatabaseConfig();
        System.out.println(databaseConfig.getString());


    }

}
