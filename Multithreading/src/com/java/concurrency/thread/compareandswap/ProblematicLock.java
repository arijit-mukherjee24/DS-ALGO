package com.java.concurrency.thread.compareandswap;

public class ProblematicLock implements MyLock {

    private volatile boolean locked = false;

    public void unlock() {
        this.locked = false;
    }


    public void lock() {

        while(this.locked) {
            // busy wait - until this.locked == false
        }

        this.locked = true;
    }
}