package com.jeanboy.jvm.concurrent;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedElement implements Delayed {

    long delayTime;
    long endTime;

    public DelayedElement(long delayTime) {
        this.delayTime = delayTime;
        this.endTime = delayTime + System.currentTimeMillis();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return endTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        return endTime - ((DelayedElement) o).endTime > 0 ? 1 : -1;
    }
}
