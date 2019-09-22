package com.jeanboy.jvm.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock(); //加锁
        lock.unlock();//解锁
    }
}
