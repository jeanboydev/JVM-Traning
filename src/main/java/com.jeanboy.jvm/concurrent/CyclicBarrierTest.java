package com.jeanboy.jvm.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2, new WaitTask());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("============Thread 1 开始执行=========");
                try {
                    Thread.sleep(1000);
                    barrier.await();
                    System.out.println("============Thread 1 执行结束=========");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("============Thread 2 开始执行=========");
                try {
                    Thread.sleep(2000);
                    barrier.await();
                    System.out.println("============Thread 2 执行结束=========");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static class WaitTask implements Runnable {

        @Override
        public void run() {
            System.out.println("============等待结束=========");
        }
    }
}
