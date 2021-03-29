package com.db;

import com.model.DBColumn;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class CreateTable {
    ConnectionPool postgresqlDataSource =  ConnectionPool.getInstance();
    HashMap<String, String> sqlHashMap = new SQLHashMap().getSQLHashMap();

    public void create(Object o) throws IllegalArgumentException{
        if(o == null){
            throw new IllegalArgumentException("Illegal Argument: Object o is null");
        }

        try(Connection conn = postgresqlDataSource.getConnection()){

            boolean comma = false;
            Field tableExists = o.getClass().getDeclaredField("tableExists");
            tableExists.setAccessible(true);
            tableExists.setBoolean(o, true);
            String[] fullClassName = o.getClass().getName().split("\\.");
            String tableName = fullClassName[fullClassName.length-1];
            StringBuilder sql = new StringBuilder();
            sql.append("create table " + tableName + "(\n");
            String dataType;
            Field[] fields = o.getClass().getDeclaredFields();
            PreparedStatement ps;

            // Create Sequence first
            String s = "create sequence " + tableName + "seq";
            ps = conn.prepareStatement(s);
            ps.execute();


            for(int i = 0; i <  fields.length; i++){
                if(fields[i].isAnnotationPresent(Id.class)){
                    if(fields[i].isAnnotationPresent(Column.class)){
                        if(comma){
                            sql.append(",\n");
                        }
                        Column col = fields[i].getAnnotation(Column.class);
                        sql.append(col.name() + " integer primary key");
                        comma = true;
                    }
                }
                else if(fields[i].isAnnotationPresent(Column.class)){
                    if(comma){
                        sql.append(",\n");
                    }
                    Column col = fields[i].getAnnotation(Column.class);
                    dataType = sqlHashMap.get(fields[i].getType().getTypeName());
                    sql.append(col.name() + " " + dataType);
                    comma = true;
                }
                else if(fields[i].isAnnotationPresent(OneToOne.class)){
                    if(fields[i].isAnnotationPresent(JoinColumn.class)){
                        if(comma){
                            sql.append(",\n");
                        }
                        JoinColumn col = fields[i].getAnnotation(JoinColumn.class);
                        fields[i].setAccessible(true);
                        String[] fieldClassName = fields[i].get(o).getClass().getName().split("\\.");
                        String fieldTableName = fieldClassName[fieldClassName.length-1];
                        sql.append(col.name() + " integer references " + fieldTableName + " on delete cascade");
                        comma = true;
                    }
                }
            }
            sql.append("\n);");
            ps = conn.prepareStatement(sql.toString());
            ps.execute();
        }
        catch(NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
            System.out.println("You did not include the variable tableExists in your class");
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Failed to create the table");

            // Just set the tableExists variable back to false
            try{
                Field field = o.getClass().getDeclaredField("tableExists");
                field.setAccessible(true);
                field.setBoolean(o, false);
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
            catch (NoSuchFieldException noSuchFieldException) {
                noSuchFieldException.printStackTrace();
            }


        }

    }

}
