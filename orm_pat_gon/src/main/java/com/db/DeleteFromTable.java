package com.db;

import javax.persistence.Column;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteFromTable {
    ConnectionPool postgresqlDataSource = ConnectionPool.getInstance();
    public void delete(Object o){
        try(Connection conn = postgresqlDataSource.getConnection();){
            String[] fullClassName = o.getClass().getName().split("\\.");
            String tableName = fullClassName[fullClassName.length-1];

            Field[] fields = o.getClass().getDeclaredFields();
            Object primaryValue = null;
            String primary = "";
            for(Field field : fields){
                if(field.isAnnotationPresent(Id.class)){
                    Column col = field.getAnnotation(Column.class);
                    primary = col.name();
                    field.setAccessible(true);
                    primaryValue = field.get(o);
                }
            }

            String sql;
            sql = "delete from " + tableName + " where " + primary + " = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, primaryValue);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
