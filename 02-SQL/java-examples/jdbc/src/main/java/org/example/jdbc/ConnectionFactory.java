package org.example.jdbc;

import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory implements Closeable {

    public static final int MAX_CONNECTIONS = 4;
    private final Connection[] connectionPool = new Connection[MAX_CONNECTIONS];

    private static ConnectionFactory instance;

    private ConnectionFactory() {
        for(int i = 0; i< MAX_CONNECTIONS; i++){
            System.out.println("adding connection number "+i+" to the connection pool");
            connectionPool[i] = createConnection("dev");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }


    private Connection createConnection(String profile) {
        Properties props = new Properties();
        try {
            props.load(new FileReader(new File("src/main/resources/db.properties")));

            String connectionTemplate = "gym.jdbc.connection.profile." + profile;
            System.out.println("creating a connection");
            return DriverManager.getConnection(
                    props.getProperty(connectionTemplate + ".url"),
                    props.getProperty(connectionTemplate + ".username"),
                    props.getProperty(connectionTemplate + ".password"));
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Connection[] getConnectionPool() {
        return connectionPool;
    }

    @Override
    public void close() throws IOException {
        for(Connection con: connectionPool){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
