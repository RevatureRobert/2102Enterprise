package com.crunch.util;

import com.crunch.model.User;

import java.util.Collection;

/**
 * should have
 * No duplicates (implementation detail)
 * Do not care about the order (implementation detail)
 * index should always point to the last valid object
 * No gaps
 * Resizable with conditions
 * View all elements of the collection
 *
 */
public abstract class GymCollection {



    /**
     * Optional size number for non expandable subclasses
     */
    protected int maxSize;

    public abstract User get(Object o);

    public abstract void add(User u) throws Exception;

    public abstract int size();

    public abstract void remove(Object o);

    public abstract User next();

    public abstract User previous();

    public abstract String toString();

    abstract boolean isEmpty();

    protected abstract void clear();

}
