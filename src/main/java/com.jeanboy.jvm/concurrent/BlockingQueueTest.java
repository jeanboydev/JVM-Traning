package com.jeanboy.jvm.concurrent;


import java.util.concurrent.*;

public class BlockingQueueTest {

    public static void main(String[] args) {
        //阻塞队列
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1024);
        blockingQueue.add("aaa");
        try {
            String take = blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //延迟队列
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();
        delayQueue.put(new DelayedElement(1));
        delayQueue.put(new DelayedElement(100));
        delayQueue.put(new DelayedElement(1000));
        try {
            DelayedElement take = delayQueue.take();
            System.out.println(take.delayTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //双端队列
        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();
        blockingDeque.addFirst("aaa");
        blockingDeque.addLast("bbb");
        try {
            blockingDeque.takeFirst();
            blockingDeque.takeLast();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
