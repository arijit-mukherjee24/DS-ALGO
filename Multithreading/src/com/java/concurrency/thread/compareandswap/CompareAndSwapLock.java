package com.java.concurrency.thread.compareandswap;

import java.util.concurrent.atomic.AtomicBoolean;

public class CompareAndSwapLock implements MyLock{

    private AtomicBoolean atomicLocked = new AtomicBoolean(false);


    public void unlock() {
        this.atomicLocked.set(false);
    }

    public void lock() {
    	// compareAndSet - atomic : only one thread can execute at a time
        while(!this.atomicLocked.compareAndSet(false, true)) {
            // busy wait - until compareAndSet() succeeds
        }


    }

}