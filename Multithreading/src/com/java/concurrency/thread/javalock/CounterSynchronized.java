package com.java.concurrency.thread.javalock;

public class CounterSynchronized {

    private long count = 0;

    public synchronized void inc() {
        this.count++;
    }

    public synchronized long getCount() {
        return this.count;
    }
}