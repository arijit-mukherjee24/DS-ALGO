package com.java.concurrency.thread.basic;

// Stop a Java Thread
public class ThreadExample9 {

	public static void main(String[] args) {

		Runnable runnable = () -> {
			while(true) {
				sleep(1000);
				System.out.println("Running ...");
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);  // Mark as Daemon Thread.  
		// The Thread will run as long as the main thread is running. Main Thread stops, it terminates the JVM, then all Daemon Thread are stooped in an undefined state.
		thread.start();
		sleep(3100);
		
	}
	
	private static void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
