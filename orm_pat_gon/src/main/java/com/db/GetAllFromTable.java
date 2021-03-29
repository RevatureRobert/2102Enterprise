package com.db;

import com.model.DBColumn;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetAllFromTable {
    ConnectionPool postgresqlDataSource = ConnectionPool.getInstance();

    public void getAll(Class clazz){
        try (Connection conn = postgresqlDataSource.getConnection();){
            String[] fullClassName = clazz.getName().split("\\.");
            String tableName = fullClassName[fullClassName.length - 1];

            String sql = "select * from " + tableName + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<Object> objects = new ArrayList<>();
            Field[] fields = clazz.getDeclaredFields();
            Object success = clazz.newInstance();
            while(rs.next()){
                for(Field field : fields){
                    if(field.isAnnotationPresent(Column.class)){
                        Column col = field.getAnnotation(Column.class);
                        field.setAccessible(true);
                        field.set(success, rs.getObject(col.name()));
                    }
                }
                System.out.println(success);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();

        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
