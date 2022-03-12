package com.java.concurrency.thread.executorservice;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample8 {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Future<?> future = executorService.submit(newCallable("Task 1.1"));
		System.out.println(future.isDone());
		
		boolean mayInterrupt = true;
		boolean wasCancellled = future.cancel(mayInterrupt);
		System.out.println("Task was Cancelled: "+wasCancellled);
		
		try {
			String result = (String)future.get(); 
			System.out.println(result);
		}
		catch(InterruptedException ie) {
		}
		catch(ExecutionException ee) {
		}
		catch(CancellationException ce) {
			String msg = "Cannot call future.get(), since the task is cancelled";
			System.out.println(msg);
		}
		
		System.out.println(future.isDone());
		System.out.println(future.isCancelled());
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
