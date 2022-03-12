package com.java.concurrency.thread.executorservice;
import java.util.concurrent.ArrayBlockingQueue;
// ExecutorService Implementation
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample1_1 {

	public static void main(String[] args) {
		int corePoolSize = 10;
		int maxPoolSize = 20;
		long keepAliveTime = 3000;
		
 		ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
 				corePoolSize, 
 				maxPoolSize, 
 				keepAliveTime, 
 				TimeUnit.MILLISECONDS, 
 				new ArrayBlockingQueue<>(128)
 			);
 		
 		// threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(corePoolSize);
		
 		ScheduledExecutorService scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(
 				corePoolSize
 			);
		
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
