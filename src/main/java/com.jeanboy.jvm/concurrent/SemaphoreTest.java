package com.jeanboy.jvm.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);

        for (int i = 0; i < 5; i++) {
            new Thread(new Task(semaphore)).start();
        }
    }

    static class Task implements Runnable {

        private final Semaphore semaphore;

        Task(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                Thread.sleep(1000);
                System.out.println("===获取到锁的线程==" + Thread.currentThread().getName());
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
