package com.java.concurrency.thread.sync;


//http://tutorials.jenkov.com/java-concurrency/java-memory-model.html#race-conditions
//Race Condition
public class SharedObjects {

	public static void main(String[] args) {
		
		Runnable runnable = new MyRunnable();
		
		Thread thread1 = new Thread(runnable, "Thread 1 ");
		Thread thread2 = new Thread(runnable, "Thread 2 ");
		
		thread1.start();
		thread2.start();
	}

}
