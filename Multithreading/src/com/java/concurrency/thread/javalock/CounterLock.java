package com.java.concurrency.thread.javalock;

// http://tutorials.jenkov.com/java-util-concurrent/lock.html
// https://www.youtube.com/watch?v=MWlqrLiscjQ&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=12


/*
 * The Java Lock interface represents a concurrent lock which can make sure only one thread at a time can lock the lock, 
 * perform its critical logic atomically, and unlock the lock again. A Java Lock is similar to a Java Synchronized block,
 * but is more flexible and has more features.
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock {

    private long count = 0;

    private Lock lock = new ReentrantLock();

    public void inc() {
        try {
            lock.lock();
            this.count++;
        } finally {
            lock.unlock();
        }
    }

    public long getCount() {
        try {
            lock.lock();
            return this.count;
        } finally {
            lock.unlock();
        }
    }
}