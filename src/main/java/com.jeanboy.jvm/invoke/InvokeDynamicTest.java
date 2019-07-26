package com.jeanboy.jvm.invoke;

import java.util.ArrayList;
import java.util.List;

public class InvokeDynamicTest {

    private void run() {
        List ls = new ArrayList();
        ls.add("aaaaaa");

        ArrayList als = new ArrayList();
        als.add("bbbbbb");
    }

    public static void main(String[] args) {
        InvokeDynamicTest test = new InvokeDynamicTest();
        test.run();
    }
}
