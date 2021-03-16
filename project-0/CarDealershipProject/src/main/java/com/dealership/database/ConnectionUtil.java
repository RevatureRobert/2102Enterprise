package com.dealership.database;

import com.dealership.model.DealershipUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
//    private static ConnectionUtil instance;

    public ConnectionUtil() {
    }

//    public static ConnectionUtil getInstance(){
//        if(instance == null){
//            instance = new ConnectionUtil();
//        }
//        return instance;
//    }

    public static void main(String[] args) throws SQLException {


    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://dealership.cnftml2dw6bt.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=public",
                "postgres",
                "password");
    }

}
