package com.java.concurrency.thread.basic;


public class ThreadExample6 {

	public static void main(String[] args) {
		// Implement the runnable interface with a Java Lambda Expression
		Runnable runnable = () -> {
				String threadName = Thread.currentThread().getName(); 
				System.out.println(threadName + " running");
		};

		Thread thread = new Thread(runnable, "The Thread");
		thread.start();
		
		Thread thread2 = new Thread(runnable, "The Thread 2");
		thread2.start();
		
		System.out.println(Thread.currentThread().getName() + " running");
	}

	// Here the order of execution is not guarnateed
}
