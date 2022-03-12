package com.java.concurrency.thread.basic;


public class ThreadExample7 {

	public static void main(String[] args) {
		// Implement the runnable interface with a Java Lambda Expression
		Runnable runnable = () -> {
				String threadName = Thread.currentThread().getName(); 
				System.out.println(threadName + " running");
				try {
					Thread.sleep(2000);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(threadName + " finished");
		};

		Thread thread = new Thread(runnable, "The Thread");
		thread.start();

	}

	// Here the order of execution is not guarnateed
}
