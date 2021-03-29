package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DropTable {
    ConnectionPool postgresqlDataSource = ConnectionPool.getInstance();

    public void drop(Class aClass){
        try(Connection conn = postgresqlDataSource.getConnection();){
            String[] fullClassName = aClass.getName().split("\\.");
            String tableName = fullClassName[fullClassName.length-1];
            String sql = "drop table " + tableName + " cascade";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();

            sql = "drop sequence " + tableName + "seq;";
            ps = conn.prepareStatement(sql);
            ps.execute();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
