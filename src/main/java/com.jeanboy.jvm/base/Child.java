package com.jeanboy.jvm.base;

public class Child extends Father {


    final static String a = "a";
    static String b = "b";
    int c = 3;

    {
        System.out.println(Child.class.getSimpleName() + "==={}====");
    }

    static {
        int d = 0;
        System.out.println(Child.class.getSimpleName() + "===static====");
    }

    public Child() {
        System.out.println(Child.class.getSimpleName() + "===构造方法====");
    }
}
