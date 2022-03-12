package com.java.concurrency.thread.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		executorService.execute(newRunnable("Task 1"));
		executorService.execute(newRunnable("Task 2"));
		executorService.execute(newRunnable("Task 3"));
		
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
