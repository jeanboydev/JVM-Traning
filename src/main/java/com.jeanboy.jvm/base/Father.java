package com.jeanboy.jvm.base;

public class Father {

    final static String a = "a";
    static String b = "b";
    int c = 3;

    {
        int d = 1;
        System.out.println(Father.class.getSimpleName() + "==={}===d=");
    }

    static {
        int e = 2;
        System.out.println(Father.class.getSimpleName() + "===static==e==");
    }

    public Father() {
        System.out.println(Father.class.getSimpleName() + "===构造方法==f==");

        final int f = 5;
    }
}
