package com.jeanboy.jvm.concurrent.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者模式
 * <p>
 * 1. 线程 操作 资源类
 * 2. 判断 干活 通知
 * 3. 防止虚假唤醒机制
 */
public class Customer {

    /**
     * 资源类
     */
    static class ShareData {
        private int number = 0;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void increment() {
            lock.lock();
            try {
                // 判断
                while (number != 0) {
                    // 等待不能生产
                    condition.await();
                }
                // 干活
                number++;
                System.out.println(Thread.currentThread().getName() + "\t" + number);
                // 通知唤醒
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void decrement() {
            lock.lock();
            try {
                // 判断
                while (number == 0) {
                    // 等待不能生产
                    condition.await();
                }
                // 干活
                number--;
                System.out.println(Thread.currentThread().getName() + "\t" + number);
                // 通知唤醒
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 5; i++) {
                    shareData.increment();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 5; i++) {
                    shareData.decrement();
                }
            }
        }).start();
    }
}
