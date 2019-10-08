package com.jeanboy.jvm.concurrent.test;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {

    static class MyThead implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "=====");
        }
    }

    public static void main(String[] args) {
//        Executors.newFixedThreadPool(3);
//        Executors.newCachedThreadPool();
//        Executors.newSingleThreadExecutor();
//        Executors.newScheduledThreadPool(3);

        Runtime.getRuntime().availableProcessors();//CPU核心数

        ExecutorService executorService = new ThreadPoolExecutor(2,
                3,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()) {

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
//                super.afterExecute(r, t);
                System.out.println("============" );
            }
        };

        MyThead myThead = new MyThead();

        for (int i = 0; i < 10; i++) {
//            try {
                executorService.submit(myThead);
//            } catch (Exception e) {
//                System.out.println(Thread.currentThread().getName() + "==catch===");
////                e.printStackTrace();
//            }
        }
        System.out.println(Thread.currentThread().getName() + "=====");
    }
}
