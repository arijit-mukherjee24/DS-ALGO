package com.java.concurrency.thread.local;

public class ThreadLocalInitialValueExample {

	public static void main(String[] args) {
		
		ThreadLocal<Object> threadLocal1 =  new ThreadLocal<Object>() 
		{
			@Override
			protected Object initialValue() {
				return new Object();
			}
		};
		
		ThreadLocal<Object> threadLocal2 = ThreadLocal.withInitial(() -> {
			return new Object();
		});
		
		Thread thread1 = new Thread( () -> {
			System.out.println("threadLocal 1: "+ threadLocal1.get());
			System.out.println("threadLocal 2: "+ threadLocal2.get());
		});
		
		Thread thread2 = new Thread( () -> {
			System.out.println("threadLocal 1: "+ threadLocal1.get());
			System.out.println("threadLocal 2: "+ threadLocal2.get());
		});
		
		thread1.start();
		thread2.start();
		
	}

}
