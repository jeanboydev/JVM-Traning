package com.jeanboy.jvm;

public class TestInterfaceAbstract {

    interface TestInterface {
        void test();
    }

    public static abstract class TestAbstract {
        public abstract void haha();
    }

    public static class Test extends TestAbstract implements TestInterface {

        @Override
        public void test() {
            System.out.println("test");
        }

        @Override
        public void haha() {
            System.out.println("haha");
        }
    }

    public static void main(String[] args) {

        Test test = new Test();
        test.test();
        test.haha();
    }
}
