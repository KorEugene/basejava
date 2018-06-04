package com.urise.webapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.System.*;

public class MainConcurrency {

    private static final int THREADS_NUMBER = 10000;
    //    private static int counter;
    private static final AtomicInteger atomicInteger = new AtomicInteger();
    private static final Lock lock = new ReentrantLock();
    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static final Lock WRITE_LOCK = reentrantReadWriteLock.writeLock();
    private static final Lock READ_LOCK = reentrantReadWriteLock.readLock();
    private static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat();
        }
    };

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        out.println(Thread.currentThread().getName());

        Thread thread0 = new Thread() {
            @Override
            public void run() {
                out.println(getName() + ", " + getState());
            }
        };
        thread0.start();

        new Thread(() -> out.println(Thread.currentThread().getName() + ", " + Thread.currentThread().getState())).start();

        out.println("Thread-0 is " + thread0.getState());

        final MainConcurrency mainConcurrency = new MainConcurrency();
        CountDownLatch latch = new CountDownLatch(THREADS_NUMBER);

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CompletionService completionService = new ExecutorCompletionService(executorService);
        for (int i = 0; i < THREADS_NUMBER; i++) {

            Future<Integer> future = executorService.submit(() -> {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                    out.println(THREAD_LOCAL.get().format(new Date()));
                }
                latch.countDown();
                return 5;
            });
            completionService.poll();
            out.println(future.isDone());
            out.println(future.get());
        }

        latch.await(10, TimeUnit.SECONDS);
        executorService.shutdown();
//        out.println(counter);
        out.println(MainConcurrency.atomicInteger.get());

        final String lock1 = "lock1";
        final String lock2 = "lock2";
        deadLock(lock1, lock2);
        deadLock(lock2, lock1);


        out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
    }

    private static void deadLock(Object lock1, Object lock2) {
        new Thread(() -> {
            out.println("Waiting " + lock1);
            synchronized (lock1) {
                out.println("Holding " + lock1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                out.println("Waiting " + lock2);
                synchronized (lock2) {
                    out.println("Holding " + lock2);
                }
            }
        }).start();
    }

    private void inc() {
        atomicInteger.incrementAndGet();
//        lock.lock();
//        try {
//            counter++;
//        } finally {
//            lock.unlock();
//        }
    }

}




