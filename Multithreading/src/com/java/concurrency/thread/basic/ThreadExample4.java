package com.java.concurrency.thread.basic;

// Anonymous Class with Runnable
public class ThreadExample4 {

	public static void main(String[] args) {
		// Implement the runnable interface with an anonymous class
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("MyRunnable Running");
				System.out.println("MyRunnable Finished");
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();
	}

}
