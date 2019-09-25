package com.jeanboy.jvm.base;

public class Father {

    final static String a = "a";
    static String b = "b";
    int c = 3;

    {
        System.out.println(Father.class.getSimpleName() + "==={}====");
    }

    static {
        int d = 0;
        System.out.println(Father.class.getSimpleName() + "===static====");
    }

    public Father() {
        System.out.println(Father.class.getSimpleName() + "===构造方法====");

        final int e = 5;
    }
}
