package com.jeanboy.jvm.thread;

import java.util.Hashtable;

public class TestThread {

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();

        myThread.stop();

    }
}
