package com.jeanboy.jvm.thread;

public class TestThread {

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("====开始等待 myThread 执行完毕===");
                    myThread.join();
                    System.out.println("====new Thread 执行完毕===");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.yield();

    }
}
