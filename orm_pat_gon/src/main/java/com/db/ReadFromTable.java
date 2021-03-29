package com.db;

import com.model.DBColumn;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;

public class ReadFromTable {
    ConnectionPool postgresqlDataSource = ConnectionPool.getInstance();

    public Object read(Class aClass, Object o){


        try(Connection conn = postgresqlDataSource.getConnection();){
            Field[] fields = aClass.getDeclaredFields();
            String primary = "";
            String[] fullClassName = aClass.getName().split("\\.");
            String tableName = fullClassName[fullClassName.length-1];
            StringBuilder sql = new StringBuilder();
            PreparedStatement ps;

            for(Field field : fields){
                if(field.isAnnotationPresent(Id.class)){
                    Column col = field.getAnnotation(Column.class);
                    primary = col.name();
                    break;
                }
            }

            sql.append("select * from " + tableName + " where " + primary + "= ?;");
            ps = conn.prepareStatement(sql.toString());
            ps.setObject(1, o);
            ResultSet rs = ps.executeQuery();
            Object success = aClass.newInstance();

            while(rs.next()){
                // Need to grab the column names and use them to set the fields of object success
                if(rs == null){
                    return null;
                }
                for(Field field : fields){
                    if(field.isAnnotationPresent(Column.class)){
                        Column col = field.getAnnotation(Column.class);
                        field.setAccessible(true);
                        field.set(success, rs.getObject(col.name()));
                    }
                    else if(field.isAnnotationPresent(OneToOne.class)){
                        if(field.isAnnotationPresent(JoinColumn.class)){
                            JoinColumn col = field.getAnnotation(JoinColumn.class);
                            field.setAccessible(true);
                            String s = "select * from " + col.table() + " id = " + rs.getObject(col.name()) + ";";
                            ps = conn.prepareStatement(s);
                            ResultSet rsRef = ps.executeQuery();
                            field.set(success, rs.getObject(col.name()));
                        }
                    }
                }
            }
            return success;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }


}
