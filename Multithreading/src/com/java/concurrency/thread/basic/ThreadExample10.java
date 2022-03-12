package com.java.concurrency.thread.basic;

// Stop a Java Thread
public class ThreadExample10 {

	public static void main(String[] args) {

		Runnable runnable = () -> {
			for(int i=0; i<5; i++){
				sleep(1000);
				System.out.println("Running ...");
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);  // Mark as Daemon Thread.  
		thread.start();
		
		try {
			thread.join();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
