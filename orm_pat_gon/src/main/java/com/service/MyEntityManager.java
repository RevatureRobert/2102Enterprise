package com.service;

import com.db.*;
import com.model.DBColumn;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyEntityManager implements EntityManager {

    Connection conn;
    boolean transaction = false;

    @Override
    public void persist(Object o) {
        if(o == null){
            return;
        }
        else if(!tableExists(o)){
            System.out.println("You must create the table before persisting");
            return;
        }
        InsertIntoTable insert = new InsertIntoTable();
        insert.insert(o);
//        insert(getColumns(o), )
    }

    public void getAll(Class clazz){
        GetAllFromTable gottem = new GetAllFromTable();
        gottem.getAll(clazz);
    }


    public boolean tableExists(Object o) throws IllegalArgumentException {
        try{
            Field field = o.getClass().getDeclaredField("tableExists");
            field.setAccessible(true);
            return (Boolean) field.get(o);
        }
        catch (NoSuchFieldException e) {
            System.out.println("This class of this object is missing the tableExists variable specified in the README");
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        throw new IllegalArgumentException("This class of this object is missing the tableExists variable specified in the README");
    }

    public void createTable(Object o){
        if(tableExists(o)){
            System.out.println("Table Already Exists");
            return;
        }
        Field[] fields = o.getClass().getDeclaredFields();
        for(Field field : fields){
            if(field.isAnnotationPresent(OneToOne.class)){
                if(field.isAnnotationPresent(JoinColumn.class)){
                    JoinColumn col = field.getAnnotation(JoinColumn.class);
                    try{
                        field.setAccessible(true);
                        if(!tableExists(field.get(o))){
                            System.out.println("You have not created the tables in the right order.");
                            return;
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        CreateTable ct = new CreateTable();
        ct.create(o);
    }

    public void dropTable(Class aClass){
        DropTable dt = new DropTable();
        dt.drop(aClass);
    }

    public ArrayList<DBColumn> getColumns(Object o){
        Field[] fields = o.getClass().getDeclaredFields();
        ArrayList<DBColumn> columns = new ArrayList<>();
        HashMap<String, String> sqlHashMap = new SQLHashMap().getSQLHashMap();
        String dataType;

        for(Field field : fields){
            if(field.isAnnotationPresent(Id.class)){
                Column col = field.getAnnotation(Column.class);
                columns.add(new DBColumn(col.name(), "serial primary key"));
            }
            else if(field.isAnnotationPresent(Column.class)){
                dataType = sqlHashMap.get(field.getType().getTypeName());
                Column col = field.getAnnotation(Column.class);
                columns.add(new DBColumn(col.name(), dataType));
            }
            else if(field.isAnnotationPresent(OneToOne.class)){
                if(field.isAnnotationPresent(JoinColumn.class)){
                    JoinColumn col = field.getAnnotation(JoinColumn.class);
                    columns.add(new DBColumn(col.name(), "integer", col.referencedColumnName()));
                }
            }
        }

        return columns;
    }

    @Override
    public <T> T merge(T t) {
        UpdateTable update = new UpdateTable();
        return (T) update.update(getColumns(t), t);
    }

    @Override
    public void remove(Object o) {
        if(!tableExists(o)){
            return;
        }
        DeleteFromTable del = new DeleteFromTable();
        del.delete(o);
    }

    @Override
    public <T> T find(Class<T> aClass, Object o) {
        try {
            if (!tableExists(aClass.newInstance())) {
                // Must fix this

                return null;
            }
            else
                {
                ReadFromTable read = new ReadFromTable();
                return aClass.cast(read.read(aClass, o));
            }
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T find(Class<T> aClass, Object o, Map<String, Object> map) {
        return null;
    }

    @Override
    public <T> T find(Class<T> aClass, Object o, LockModeType lockModeType) {
        return null;
    }

    @Override
    public <T> T find(Class<T> aClass, Object o, LockModeType lockModeType, Map<String, Object> map) {
        return null;
    }

    @Override
    public <T> T getReference(Class<T> aClass, Object o) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public void setFlushMode(FlushModeType flushModeType) {

    }

    @Override
    public FlushModeType getFlushMode() {
        return null;
    }

    @Override
    public void lock(Object o, LockModeType lockModeType) {

    }

    @Override
    public void lock(Object o, LockModeType lockModeType, Map<String, Object> map) {

    }

    @Override
    public void refresh(Object o) {

    }

    @Override
    public void refresh(Object o, Map<String, Object> map) {

    }

    @Override
    public void refresh(Object o, LockModeType lockModeType) {

    }

    @Override
    public void refresh(Object o, LockModeType lockModeType, Map<String, Object> map) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void detach(Object o) {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public LockModeType getLockMode(Object o) {
        return null;
    }

    @Override
    public void setProperty(String s, Object o) {

    }

    @Override
    public Map<String, Object> getProperties() {
        return null;
    }

    @Override
    public Query createQuery(String s) {
        return null;
    }

    @Override
    public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
        return null;
    }

    @Override
    public Query createQuery(CriteriaUpdate criteriaUpdate) {
        return null;
    }

    @Override
    public Query createQuery(CriteriaDelete criteriaDelete) {
        return null;
    }

    @Override
    public <T> TypedQuery<T> createQuery(String s, Class<T> aClass) {
        return null;
    }

    @Override
    public Query createNamedQuery(String s) {
        return null;
    }

    @Override
    public <T> TypedQuery<T> createNamedQuery(String s, Class<T> aClass) {
        return null;
    }

    @Override
    public Query createNativeQuery(String s) {
        return null;
    }

    @Override
    public Query createNativeQuery(String s, Class aClass) {
        return null;
    }

    @Override
    public Query createNativeQuery(String s, String s1) {
        return null;
    }

    @Override
    public StoredProcedureQuery createNamedStoredProcedureQuery(String s) {
        return null;
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String s) {
        return null;
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String s, Class... classes) {
        return null;
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String s, String... strings) {
        return null;
    }

    @Override
    public void joinTransaction() {

    }

    @Override
    public boolean isJoinedToTransaction() {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }

    @Override
    public Object getDelegate() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public MyEntityTransaction getTransaction() {
        return new MyEntityTransaction();

    }

    @Override
    public EntityManagerFactory getEntityManagerFactory() {
        return null;
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        return null;
    }

    @Override
    public Metamodel getMetamodel() {
        return null;
    }

    @Override
    public <T> EntityGraph<T> createEntityGraph(Class<T> aClass) {
        return null;
    }

    @Override
    public EntityGraph<?> createEntityGraph(String s) {
        return null;
    }

    @Override
    public EntityGraph<?> getEntityGraph(String s) {
        return null;
    }

    @Override
    public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> aClass) {
        return null;
    }
}
