package com.jeanboy.jvm.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                concurrentHashMap.put("aa", "aaaa");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                concurrentHashMap.put("bb", "bbb");
            }
        }).start();
        //加 synchronized 关键字
        HashMap<String, String> hashMap = new HashMap<>();
        Collections.synchronizedMap(hashMap);
    }
}
