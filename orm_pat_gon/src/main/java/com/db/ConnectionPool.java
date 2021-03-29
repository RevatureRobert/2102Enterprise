package com.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool{
    private HikariConfig config = new HikariConfig();
    private HikariDataSource dataSource;
    private String url;
    private String user;
    private String password;
    private Properties db = new Properties();
    private static ConnectionPool instance = null;

    public static ConnectionPool getInstance(){
        if(instance == null){
            instance = new ConnectionPool();
        }
        return instance;
    }

    private ConnectionPool(){
        try {
            FileReader read = new FileReader("src/main/resources/connection.properties");
            db.load(read);
            url = db.getProperty("url");
            user = db.getProperty("user");
            password = db.getProperty("password");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        dataSource = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void startTransaction(){
        config.setAutoCommit(false);
        dataSource = new HikariDataSource(config);
    }

    public void stopTransaction(){
        config.setAutoCommit(true);
        dataSource = new HikariDataSource(config);
    }

}
