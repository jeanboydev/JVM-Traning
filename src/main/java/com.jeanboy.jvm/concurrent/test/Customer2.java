package com.jeanboy.jvm.concurrent.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者消费者加强版
 */
public class Customer2 {

    static class ShareData {
        private volatile boolean flag = true;
        private AtomicInteger atomicInteger = new AtomicInteger();

        private BlockingQueue<String> blockingQueue = null;

        public ShareData(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
            System.out.println(blockingQueue.getClass().getSimpleName());
        }

        public void myProduct() throws InterruptedException {
            String data = null;
            boolean value;
            while (flag) {
                data = atomicInteger.incrementAndGet() + "";
                value = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
                if (value) {
                    System.out.println(Thread.currentThread().getName() + "\t插入队列" + data + "成功");
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t插入队列" + data + "失败");
                }
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println(Thread.currentThread().getName() + "\t 插入队列 flag=" + flag);
        }

        public void myConsumer() throws InterruptedException {
            String result = null;
            while (flag) {
                result = blockingQueue.poll(2L, TimeUnit.SECONDS);
                if (null == result || result.equalsIgnoreCase("")) {
                    flag = false;
                    System.out.println(Thread.currentThread().getName() + "\t消费队列超时，退出");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "\t消费队列" + result + "成功");
            }
            System.out.println(Thread.currentThread().getName() + "\t flag=" + flag);
        }

        public void stop() {
            flag = false;
        }
    }

    public static void main(String[] args) {
        ShareData shareData = new ShareData(new ArrayBlockingQueue<>(10));
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    shareData.myProduct();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    shareData.myConsumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    shareData.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
