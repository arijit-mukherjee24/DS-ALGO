package com.java.concurrency.thread.executorservice;

import java.util.concurrent.ExecutionException;
// execute
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample3 {

	public static void main(String[] args) {
		// ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Future future = executorService.submit(newRunnable("Task 1.1"));
		System.out.println(future.isDone());
		
		try {
			future.get(); // It will block until the result is available. Here it will return null, will block until the task is executed.
		}
		catch(InterruptedException ie) {
		}
		catch(ExecutionException ie) {
		}
		
		System.out.println(future.isDone());
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
