package com.urise.webapp;

import java.util.ArrayList;
import java.util.List;

public class MainConcurrency {

    private static final Object LOCK = new Object();
    public static final int THREADS_NUMBER = 10000;

    private static int counter;

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName());

        Thread thread0 = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + ", " + getState());
            }
        };
        thread0.start();

        new Thread(() -> System.out.println(Thread.currentThread().getName() + ", " + Thread.currentThread().getState())).start();

        System.out.println("Thread-0 is " + thread0.getState());

        final MainConcurrency mainConcurrency = new MainConcurrency();
        List<Thread> threads = new ArrayList<>(THREADS_NUMBER);
        for (int i = 0; i < THREADS_NUMBER; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                }
            });
            thread.start();
//            thread.join();
            threads.add(thread);
        }
//        Thread.sleep(500);
        threads.forEach((t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        System.out.println(counter);
    }

//    private static synchronized void inc() {
//        double a = Math.sin(13.);
//        counter++;
//    }

//    private static void inc() {
//        double a = Math.sin(13.);
//        synchronized (LOCK) {
//            counter++;
//        }

    private synchronized void inc() {
//        synchronized (this) {
        counter++;
    }

}




