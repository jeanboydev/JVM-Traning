package com.jeanboy.jvm.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
//        MyRecursiveAction recursiveAction = new MyRecursiveAction(1024);
//        forkJoinPool.invoke(recursiveAction);
        MyRecursiveTask recursiveTask = new MyRecursiveTask(10, 0, 10);
        forkJoinPool.invoke(recursiveTask);
    }

    static class MyRecursiveAction extends RecursiveAction {

        private long value;

        MyRecursiveAction(long value) {
            this.value = value;
        }

        @Override
        protected void compute() {
            if (value > 2) { //分治
                MyRecursiveAction action = new MyRecursiveAction(value / 2);
                action.fork();
                System.out.println("======fork==" + value);
            } else {
                System.out.println("======value==" + value);
            }
        }
    }

    static class MyRecursiveTask extends RecursiveTask<Long> {

        private long value;
        private long start;
        private long end;

        MyRecursiveTask(long value, long start, long end) {
            this.value = value;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            long length = end - start;
            System.out.println("===============length==" + length);
            if (length > 1) {
                MyRecursiveTask left = new MyRecursiveTask(value, start, start + length / 2);
                MyRecursiveTask right = new MyRecursiveTask(value, start + length / 2, end);
                left.fork();
                right.fork();
                System.out.println("======fork==" + value);
                return left.join() + right.join();
            } else {
                System.out.println("======value==" + value);
                return value;
            }
        }
    }
}
