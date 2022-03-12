package com.java.concurrency.thread.executorservice;

// execute
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample2 {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		// ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		executorService.execute(newRunnable("Task 1.1"));
		executorService.execute(newRunnable("Task 1.2"));
		executorService.execute(newRunnable("Task 1.3"));
		
		executorService.shutdown();
		
	}

	private static Runnable newRunnable(String msg) {
		
		return new  Runnable() {
			public void run() {
				String completeMsg = Thread.currentThread().getName() + " : " + msg;
				System.out.println(completeMsg);
			}
		};
	}

}
