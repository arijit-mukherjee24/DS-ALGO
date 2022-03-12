package com.java.concurrency.thread.basic;


public class ThreadExample5 {

	public static void main(String[] args) {
		// Implement the runnable interface with a Java Lambda Expression
		Runnable runnable = () -> {
				System.out.println("MyRunnable Running");
				System.out.println("MyRunnable Finished");
		};

		Thread thread = new Thread(runnable);
		thread.start();
	}

}
