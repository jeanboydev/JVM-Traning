package com.jeanboy.jvm.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {

    static class Test {
        public void hello() {
            System.out.println("hello...");
        }
    }

    public static void main(String[] args) {
        try {
            Test test = new Test();
            MethodType methodType = MethodType.methodType(void.class);
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MethodHandle methodHandle = lookup.findVirtual(test.getClass(), "hello", methodType);
            methodHandle.invoke(test);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    

}
