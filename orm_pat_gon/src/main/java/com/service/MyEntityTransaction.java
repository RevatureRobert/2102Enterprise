package com.service;

import com.db.ConnectionPool;
import javax.persistence.EntityTransaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.HashMap;

public class MyEntityTransaction implements EntityTransaction {
    ConnectionPool postgresqlDataSource = ConnectionPool.getInstance();
    Connection conn;
    HashMap<String, Savepoint> savepoints;

    public MyEntityTransaction(){
        try {
            conn = postgresqlDataSource.getConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        savepoints = new HashMap<>();
    }

    @Override
    public void begin() {
        try {
            postgresqlDataSource.startTransaction();
            conn = postgresqlDataSource.getConnection();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void commit() {
        try {
            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void rollback() {
        try {
            conn.rollback();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void rollbackToSavepoint(String save){
        try {
            conn.rollback(savepoints.get(save));
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void savepoint(String save){
        try {
            savepoints.put(save, conn.setSavepoint(save));
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void end(){
        try {
            postgresqlDataSource.stopTransaction();
            conn.setAutoCommit(true);
            conn.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void setRollbackOnly() {

    }

    @Override
    public boolean getRollbackOnly() {
        return false;
    }

    @Override
    public boolean isActive() {
        return false;
    }
}
