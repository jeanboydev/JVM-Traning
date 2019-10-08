package com.jeanboy.jvm.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicTest {

    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        boolean b = atomicBoolean.get();
        boolean andSet = atomicBoolean.getAndSet(false);
        boolean b1 = atomicBoolean.compareAndSet(true, false);

        AtomicInteger atomicInteger = new AtomicInteger(1);

        String test = "a";
        AtomicReference<String> atomicReference = new AtomicReference<>();
        atomicReference.set(test);
        atomicReference.compareAndSet("a", "b");
        atomicReference.get();

        AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<>("aa", 100);
        atomicStampedReference.compareAndSet("aa", "bb", 100, 101);

        System.out.println("===" + atomicStampedReference.getReference());
    }
}
