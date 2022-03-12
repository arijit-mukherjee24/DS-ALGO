package com.java.concurrency.thread.local;

public class InheritableThreadLocalBasicExample {

	public static void main(String[] args) {

		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

		Thread thread1 = new Thread(() -> {
			System.out.println("===== Thread1 =====");
			threadLocal.set("Thread 1 - ThreadLocal");
			inheritableThreadLocal.set("Thread 1 - InheritableThreadLocal");

			System.out.println(threadLocal.get());
			System.out.println(inheritableThreadLocal.get());

			Thread childThread = new Thread(() -> {
				System.out.println("====== ChildThread ======");
				System.out.println(threadLocal.get()); // null
				System.out.println(inheritableThreadLocal.get()); // Thread 1 - InheritableThreadLocal
			});

			childThread.start();
		});

		thread1.start();

		Thread thread2 = new Thread(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			System.out.println("===== Thread2 =====");
			System.out.println(threadLocal.get());
			System.out.println(inheritableThreadLocal.get());
		});
		thread2.start();
	}

}
