package com.jeanboy.jvm.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicTest {

    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        boolean b = atomicBoolean.get();
        boolean andSet = atomicBoolean.getAndSet(false);
        boolean b1 = atomicBoolean.compareAndSet(true, false);

        AtomicInteger atomicInteger = new AtomicInteger(1);

        AtomicReference<String> atomicReference = new AtomicReference<>();
    }
}
