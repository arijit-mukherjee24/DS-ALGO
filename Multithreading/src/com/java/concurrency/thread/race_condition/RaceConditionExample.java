package com.java.concurrency.thread.race_condition;

public class RaceConditionExample {

	public static void main(String[] args) {
		//Counter counter = new Counter();
	    CounterSynchronized counterSynchronized = new CounterSynchronized();
	    //Thread thread1 = new Thread(getRunnable(counterSynchronized, "Thread 1: final count-"));
		//Thread thread2 = new Thread(getRunnable(counterSynchronized, "Thread 2: final count-"));
		Thread thread1 = new Thread(getRunnable(counterSynchronized, "Thread 1: final count-"));
		Thread thread2 = new Thread(getRunnable(counterSynchronized, "Thread 2: final count-"));
		thread1.start();
		thread2.start();

	}

	// Java 8
	public static Runnable getRunnable(CounterSynchronized counter, String message) {
		return () -> {
			for (int i = 0; i < 100000; i++) {
				counter.increment();
			}
			System.out.println(message + " " + counter.getCount());
		};
	}
	
	// Java 8
	public static Runnable getRunnable(Counter counter, String message) {
		return () -> {
			for (int i = 0; i < 100000; i++) {
				counter.increment();
			}
			System.out.println(message + " " + counter.getCount());
		};
	}
}
