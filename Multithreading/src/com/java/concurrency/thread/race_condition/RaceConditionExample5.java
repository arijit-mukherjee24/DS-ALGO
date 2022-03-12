package com.java.concurrency.thread.race_condition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RaceConditionExample5 {

	public static void main(String[] args) {
		Map<String, String> sharedMap = new ConcurrentHashMap<>();

		Thread thread1 = new Thread(getRunnable(sharedMap));
		Thread thread2 = new Thread(getRunnable(sharedMap));

		thread1.start();
		thread2.start();
	}

	private static Runnable getRunnable(Map<String, String> sharedMap) {
		return () -> {
			for (int i = 0; i < 100000; i++) {
				synchronized (sharedMap) {
					if (sharedMap.containsKey("Key")) {
						String val = sharedMap.remove("Key");
						if (val == null) {
							System.out.println("Iteration : " + i + " : Value for 'Key' was null");
						}
					} else {
						sharedMap.put("Key", "value");
					}
				}
			}
		};

	}

}
