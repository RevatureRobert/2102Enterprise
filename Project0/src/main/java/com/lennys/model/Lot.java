package com.lennys.model;

public class Lot {
    static private Car[] lot = new Car[5];
    private int currentIndex = -1;

    public boolean add(Car car){
        if(currentIndex+1 <= lot.length){
            lot[++currentIndex] = car;
            return true;

        }
        return false;
    }
}
