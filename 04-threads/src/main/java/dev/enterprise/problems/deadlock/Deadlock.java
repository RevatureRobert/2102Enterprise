package dev.enterprise.problems.deadlock;

import java.time.LocalTime;

public class Deadlock {

    Object keyA = new Object();
    Object keyB = new Object();


    public void a() {
        synchronized (keyA) {
            System.out.println(Thread.currentThread().getName() + ": " + LocalTime.now());
            b();
        }
    }

    public void b() {
        synchronized (keyB) {
            System.out.println(Thread.currentThread().getName() + ": " +  LocalTime.now());
            c();
        }
    }

    public void c() {
        synchronized (keyA){
            System.out.println(Thread.currentThread().getName() + ": " + LocalTime.now());
            System.out.println("in c");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Deadlock d = new Deadlock();

        Runnable r1 = () -> d.a();
        Runnable r2 = () -> d.b();

        Thread t2 = new Thread(r2);
        Thread t1 = new Thread(r1);

        t2.start();
        t1.start();

        t1.join();
        t2.join();

        System.out.println("main completed");


//        ReadAndWriteLockExample r = new ReadAndWriteLockExample();
//        Thread t3 = new Thread(() -> {
//            for (int i = 0; i < 500; i++) System.out.println(r.getX());
//        });
//        Thread t4 = new Thread(() -> {
//            for (int i = 0; i < 500; i++) r.setX(i);
//        });
//
//        t4.start();
//        t3.start();
//
//        t4.join();
//        t3.join();
//
//        System.out.println("main waiting for it");

    }
}
