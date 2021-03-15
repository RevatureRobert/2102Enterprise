package dev.enterprise.threads;

import dev.enterprise.problems.RaceCondition;

public class CustomThread extends Thread{

    RaceCondition r;

    public CustomThread(RaceCondition r){
        this.r = r;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++){
            r.incr();
        }
    }
}
