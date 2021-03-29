package com.db;

public interface GenericDAO<T> {
    public void save();

    public void update();

    public void delete();

    public void get();

    public void getAll();

}
