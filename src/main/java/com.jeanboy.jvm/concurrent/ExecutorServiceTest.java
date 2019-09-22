package com.jeanboy.jvm.concurrent;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class ExecutorServiceTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Asynchronous task");
            }
        });
        service.shutdown();

        Future<?> future = service.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        try {
            Object o = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Set<Callable<String>> callableSet=new HashSet<>();
        callableSet.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });
        try {
            String s = service.invokeAny(callableSet);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
