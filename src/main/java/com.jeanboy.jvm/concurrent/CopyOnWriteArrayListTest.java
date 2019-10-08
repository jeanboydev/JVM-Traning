package com.jeanboy.jvm.concurrent;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("aaaa");
        copyOnWriteArrayList.get(0);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    list.add("==" + UUID.randomUUID());
                }
            }).start();
        }
        List<String> list2 = new Vector<>();
        List<String> list3 = Collections.synchronizedList(list2);
    }
}
