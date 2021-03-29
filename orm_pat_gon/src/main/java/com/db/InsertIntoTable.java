package com.db;

import com.model.DBColumn;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsertIntoTable {
    ConnectionPool postgresqlDataSource = ConnectionPool.getInstance();
    ReadFromTable read = new ReadFromTable();
    /***
     * Objective: Insert into the correct table this object's fields
     *              that are annotated with the @Column annotation
     * First we grab all the values of objects fields and we match
     * them to their corresponding column in order to insert them.
     * @param o
     * @throws IllegalArgumentException
     */
    public void insert(Object o) throws IllegalArgumentException{
        if(o == null){
            throw new IllegalArgumentException("Illegal Argument: Object o is null");
        }

        try(Connection conn = postgresqlDataSource.getConnection();){
            boolean comma = false;
            String[] fullClassName = o.getClass().getName().split("\\.");
            String tableName = fullClassName[fullClassName.length-1];
            StringBuilder sql = new StringBuilder();
            sql.append("insert into " + tableName + "(");
            Field[] fields = o.getClass().getDeclaredFields();
            ArrayList<Object> values = new ArrayList<>();
            PreparedStatement ps;

            String s = "select nextval('" + tableName + "seq');";
            ps = conn.prepareStatement(s);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Integer id = rs.getInt("nextval");


            for(int i=0; i < fields.length; i++){
                if(fields[i].isAnnotationPresent(Id.class)){
                    if(fields[i].isAnnotationPresent(Column.class)) {
                        Column col = fields[i].getAnnotation(Column.class);
                        fields[i].setAccessible(true);
                        if (comma) {
                            sql.append(", " + col.name());
                        } else {
                            sql.append(col.name());
                        }
                        fields[i].set(o, id);
                        comma = true;
                        values.add(id);
                    }
                }
                else if(fields[i].isAnnotationPresent(Column.class)){
                    Column col = fields[i].getAnnotation(Column.class);
                    if(comma){
                        sql.append(", " + col.name());
                    }
                    else{
                        sql.append(col.name());
                    }
                    fields[i].setAccessible(true);
                    values.add(fields[i].get(o));
                    comma = true;
                }
                else if(fields[i].isAnnotationPresent(OneToOne.class)){
                    if(fields[i].isAnnotationPresent(JoinColumn.class)){
                        JoinColumn col = fields[i].getAnnotation(JoinColumn.class);
                        fields[i].setAccessible(true);
                        insert(fields[i].get(o));
                        if(comma){
                            sql.append(", " + col.name());
                        }
                        else{
                            sql.append(col.name());
                        }
                        Object ref = fields[i].get(o);
                        Class refClass = ref.getClass();
                        Method m = refClass.getDeclaredMethod("getId");
                        Object refId = m.invoke(ref);
                        values.add(refId);
                        comma = true;
                    }
                }
            }

            sql.append(") values(");
            for(int i = 0; i < values.size();i++){
                if(i == values.size()-1){
                    sql.append("?);");
                }
                else{
                    sql.append("?, ");
                }
            }

            ps = conn.prepareStatement(sql.toString());
            for(int i = 0; i < values.size(); i++){
                ps.setObject(i+1, values.get(i));
            }
            ps.execute();
        }
        catch(IllegalAccessException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Failed to create the table");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
