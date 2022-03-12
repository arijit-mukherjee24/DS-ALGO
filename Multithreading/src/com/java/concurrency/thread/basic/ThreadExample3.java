package com.java.concurrency.thread.basic;

// Implementing Runnable Interface
public class ThreadExample3{
	
	public static class MyRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("MyThread Running");
			System.out.println("MyThread Finished");
		}
	}

	public static void main(String[] args) {
		//MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(new MyRunnable());
		thread.start();
	}

}
