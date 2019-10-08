package com.jeanboy.jvm.concurrent.test;

import java.util.concurrent.TimeUnit;

public class DeadLockTest {

    static class HoldLockThread implements Runnable {

        private String lockA;
        private String lockB;

        public HoldLockThread(String lockA, String lockB) {
            this.lockA = lockA;
            this.lockB = lockB;
        }

        @Override
        public void run() {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + "自己持有" + lockA + "锁\t尝试获得" + lockB);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + "自己持有" + lockB + "锁\t尝试获得" + lockA);
                }
            }
        }
    }

    public static void main(String[] args) {

        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA, lockB)).start();
        new Thread(new HoldLockThread(lockB, lockA)).start();

        /**
         * linux > ps -ef|grep xxx
         * windows >
         * jps = java ps
         */
    }
}
