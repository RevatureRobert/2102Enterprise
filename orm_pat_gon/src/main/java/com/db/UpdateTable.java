package com.db;

import com.model.DBColumn;

import javax.persistence.Column;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UpdateTable {
    ConnectionPool postgresqlDataSource = ConnectionPool.getInstance();

    public Object update(ArrayList<DBColumn> columns, Object o){
        try(Connection conn = postgresqlDataSource.getConnection();){
            String[] fullClassName = o.getClass().getName().split("\\.");
            String tableName = fullClassName[fullClassName.length-1];

            Field[] fields = o.getClass().getDeclaredFields();
            String primary = "";
            Object primaryValue = null;
            for(Field field : fields){
                if(field.isAnnotationPresent(Id.class)){
                    Column col = field.getAnnotation(Column.class);
                    primary = col.name();
                    field.setAccessible(true);
                    primaryValue = field.get(o);
                    break;
                }
            }

            StringBuilder sql = new StringBuilder();
            sql.append("update " + tableName + " set ");

            for(int i = 0; i < columns.size()-1; i++){
                sql.append(columns.get(i).getName() + " = ?, ");
            }
            sql.append(columns.get(columns.size()-1).getName() + " = ? where " + primary  + " = ?;");

            PreparedStatement ps = conn.prepareStatement(sql.toString());
            for(int i = 0; i < columns.size(); i++){
                DBColumn col = columns.get(i);
                for(Field field : fields){
                    if(field.isAnnotationPresent(Column.class)){
                        if(col.getName().equals(field.getAnnotation(Column.class).name())){
                            field.setAccessible(true);
                            ps.setObject(i+1, field.get(o));
                            break;
                        }
                    }
                }
            }
            ps.setObject(columns.size()+1, primaryValue);
            ps.execute();
            ReadFromTable read = new ReadFromTable();
            return read.read(o.getClass(), primaryValue);
        }
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
        catch(IllegalAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}
