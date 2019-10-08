package com.jeanboy.jvm.concurrent.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadPool {

    class MyThread implements Runnable {

        @Override
        public void run() {

        }
    }

    static class MyThread2 implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("=============");
            return 1024;
        }
    }

    public static void main(String[] args) {

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());

        Thread thread = new Thread(futureTask);
        thread.start();

        try {
//            while (!futureTask.isDone()) {
//
//            }
            System.out.println("============" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
