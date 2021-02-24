package com.lennys.service;

import com.lennys.model.Car;
import com.lennys.model.Lot;

public class LotService {
    private Lot lot;
    public boolean add(Car car){
       return lot.add(car);
    }
}
