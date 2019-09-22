package com.jeanboy.jvm.inner;

public class Test {

    public void run() {

        InnerClass innerClass = new InnerClass();

    }

    class InnerClass {
        public void test1() {
            System.out.println("===test1====");
        }
    }
}
