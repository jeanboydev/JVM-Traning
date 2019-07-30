package com.jeanboy.jvm.invoke;

import java.lang.reflect.Method;

public class ReflectionTest2 {

    static class Test {
        public void target(int i) {
            new Exception("#" + i).printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Test.class;
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("target", int.class);
        for (int i = 0; i < 20; i++) {
            method.invoke(obj, 0);
        }
    }
}
