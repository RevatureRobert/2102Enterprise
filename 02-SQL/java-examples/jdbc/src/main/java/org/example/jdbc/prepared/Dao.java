package org.example.jdbc.prepared;

public interface Dao<T, I> {

    int create(T t);
    T findById(I id);
    int update(T t);
    int delete(I id);
}
