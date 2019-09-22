package com.jeanboy.jvm.concurrent;

import java.util.concurrent.Exchanger;

public class ExchangerTest {
    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("============Thread 1 开始执行=========");
                try {
                    Thread.sleep(1000);
                    String data = "线程1中的数据";
                    data = exchanger.exchange(data);
                    System.out.println("============Thread 1 ======data===" + data);
                    System.out.println("============Thread 1 执行结束=========");
                } catch (InterruptedException e) {
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
                    String data = "线程2中的数据";
                    data = exchanger.exchange(data);
                    System.out.println("============Thread 2 ======data===" + data);
                    System.out.println("============Thread 2 执行结束=========");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
