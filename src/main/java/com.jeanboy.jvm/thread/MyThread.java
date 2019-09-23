package com.jeanboy.jvm.thread;

public class MyThread extends Thread {


    @Override
    public void run() {
        super.run();
        System.out.println("===MyThread 开始执行=====");
        try {
            Thread.sleep(1000);
            System.out.println("===MyThread 执行完毕=====");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
