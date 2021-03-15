package dev.enterprise.problems.race;

import dev.enterprise.threads.CustomThread;

public class RaceCondition {

    int x = 5;


    //The synchronized keyword makes a method only allow
    //      one thread at a time into the execution.
    //      This solves race conditions, but causes some others.
    public synchronized void incr(){
        x = x+1;
    }

    public synchronized int getX(){
        return x;
    }

    public static void main(String[] args) throws InterruptedException {
        RaceCondition r = new RaceCondition();

//        System.out.println(Thread.currentThread().getName());
//        r.incr();
//        r.incr();

        CustomThread T1 = new CustomThread(r);
        CustomThread T2 = new CustomThread(r);

        //Why not call run here?
        //      run will not call a new thread, but instead run on the main thread
        T1.start();
        T2.start();

        //Wait for threads to complete and then continue on the current thread
        T2.join();
        T1.join();



        System.out.println(r.getX());

    }
}
