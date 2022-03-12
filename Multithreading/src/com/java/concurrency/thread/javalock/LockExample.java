package com.java.concurrency.thread.javalock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

	public static void main(String[] args) {
		lockBasics();
		// lockInterruptibly();
		// tryLock();
		
		/* ReentrantLock reentrantLock = new ReentrantLock();
		int holdCount = reentrantLock.getHoldCount();
		int queueLength = reentrantLock.getQueueLength();
		boolean hasQueueThisThread = reentrantLock.hasQueuedThread(Thread.currentThread());
		boolean hasQueueThisThreads = reentrantLock.hasQueuedThreads();
		
		// isFair() 
		// isLocked()
		// isHeldByCurrentThread() */
		
	}

	private static void lockBasics() {
		Lock lock = new ReentrantLock(false); // passing true means fairness is maintained
		
		Runnable runnable = () -> {
			lockSleepUnlock(lock, 1000);
		};
		
		Thread thread1 = new Thread(runnable, "Thread-1");
		Thread thread2 = new Thread(runnable, "Thread-2");
		Thread thread3 = new Thread(runnable, "Thread-3");
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

	private static void lockSleepUnlock(Lock lock, long timeMillis) {
		try {
			lock.lock();
			printThreadMsg(" holds the lock");
			sleep(timeMillis);
		}
		finally {
			lock.unlock();
		}
	}

	private static void sleep(long timeMillis) {
		try {
			Thread.sleep(timeMillis);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	private static void printThreadMsg(String text) {
			System.out.println(Thread.currentThread().getName() + text);
	}
	
	// lock interruptibly
	private static void lockInterruptibly() {
		Lock lock = new ReentrantLock();
		// Thread.currentThread().interrupt();
		try {
			lock.lockInterruptibly();
			
			lock.unlock();
		}
		catch(InterruptedException ie) {
			System.out.println("Thread Interrupted");
		}
	}
	
	// trylock - 
	private static void tryLock() {
		Lock lock = new ReentrantLock(); // tryLock doesn't respect fairness
		try {
			boolean lockSuccesful = lock.tryLock();
			System.out.println("Lock Successful: "+ lockSuccesful);
		}
		finally {
			lock.unlock();
		}
	}

}
