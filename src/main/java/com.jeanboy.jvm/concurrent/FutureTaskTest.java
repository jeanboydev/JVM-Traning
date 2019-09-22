package com.jeanboy.jvm.concurrent;

import java.util.concurrent.*;

public class FutureTaskTest {

    public static void main(String[] args) {
        ConcurrentHashMap<Object, Future<String>> cacheTask = new ConcurrentHashMap<>();

        String taskName = "aa";
        Future<String> future = cacheTask.get(taskName);
        if (future == null) {
            Callable<String> task = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return taskName;
                }
            };
            //创建任务
            FutureTask<String> futureTask = new FutureTask<>(task);
            cacheTask.putIfAbsent(taskName, futureTask);

            future = futureTask;
            futureTask.run(); //执行任务
        }
        try {
            String s = future.get();//线程在此等待任务执行完成
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            cacheTask.remove(taskName, future);
        }
    }
}
