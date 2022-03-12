package com.java.concurrency.thread.sync;

import java.util.function.Consumer;

public class SynchronizedLambda {
	
	private static Object object =  null;
	
	// Monitor Object for Synchronization = SynchronizedLambda.class
	public static synchronized void setObject(Object o) {
		object = o;
	}
	
	public static void consumeObject(Consumer consumer) {
		consumer.accept(object);
		
	}

	public static void main(String[] args) {
		
		consumeObject( (obj) -> {
			// Monitor Object for Synchronization = SynchronizedLambda.class
			synchronized(SynchronizedLambda.class) {
				System.out.println(obj);
			}
		});
		
		consumeObject( (obj) -> {
			// Monitor Object for Synchronization = String.class
			synchronized(String.class) {
				System.out.println(obj);
			}
		});
	}

}
