package com.jeanboy.jvm.base;

public class Child extends Father {

    final static String a = "a";
    static String b = "b";
    int c = 3;

    {
        int d = 1;
        System.out.println(Child.class.getSimpleName() + "==={}===d=");
    }

    static {
        int e = 2;
        System.out.println(Child.class.getSimpleName() + "===static==e==");
    }

    public Child() {
        System.out.println(Child.class.getSimpleName() + "===构造方法==f==");

        final int f = 5;
    }
}
