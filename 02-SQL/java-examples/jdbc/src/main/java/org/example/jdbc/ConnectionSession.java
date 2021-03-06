package org.example.jdbc;

import java.sql.Connection;

public class ConnectionSession implements AutoCloseable {

    private Connection activeConnection;
    private int locationIndex = -1;

    public Connection getActiveConnection(){
        for(int i =0; i<ConnectionFactory.MAX_CONNECTIONS; i++){
            Connection conn = ConnectionFactory.getInstance().getConnectionPool()[i];
            if(conn != null){
                System.out.println("gathering connection id: " + i + " to give to the object");
                activeConnection = conn;
                ConnectionFactory.getInstance().getConnectionPool()[i] = null;
                locationIndex = i;
                return activeConnection;
            }
        }
        throw new RuntimeException("No active connections available");
    }

    @Override
    public void close() throws Exception {
        System.out.println("closing the session and giving the connection back to the connection pool");
        ConnectionFactory.getInstance().getConnectionPool()[locationIndex]=activeConnection;
        activeConnection = null;
        locationIndex = -1;
    }
}
