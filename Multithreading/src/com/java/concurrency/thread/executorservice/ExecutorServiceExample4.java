package com.java.concurrency.thread.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
// execute
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample4 {

	public static void main(String[] args) {
		// ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Future future = executorService.submit(newCallable("Task 1.1"));
		System.out.println(future.isDone());
		
		try {
			String result = (String)future.get(); // It will block until the task is fully executed. Here it will return value, will block until the task is completed.
			System.out.println(result);
		}
		catch(InterruptedException ie) {
		}
		catch(ExecutionException ie) {
		}
		
		System.out.println(future.isDone());
		executorService.shutdown();
		
	}

	private static Callable newCallable(String msg) {
		return new  Callable() {
			@Override
			public Object call() throws Exception{
				String completeMsg = Thread.currentThread().getName() + " : " + msg;
				return completeMsg;
			}
		};
	}

}
