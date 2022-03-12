package com.java.concurrency.thread.executorservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
// execute
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample5 {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		List<Callable<String>> callables = new ArrayList<>();
		callables.add(newCallable("Task 1.1"));
		callables.add(newCallable("Task 1.2"));
		callables.add(newCallable("Task 1.3"));
		
		
		try {
			String result = (String)executorService.invokeAny((Collection<Callable<String>>)callables); // Fastest possible task which gets executed and others are ignored
			System.out.println(result);
		}
		catch(InterruptedException ie) {
		}
		catch(ExecutionException ie) {
		}
		
		executorService.shutdown();
		
	}

	private static Callable<String> newCallable(String msg) {
		return new  Callable<String>() {
			@Override
			public String call() throws Exception{
				String completeMsg = Thread.currentThread().getName() + " : " + msg;
				return completeMsg;
			}
		};
	}

}
