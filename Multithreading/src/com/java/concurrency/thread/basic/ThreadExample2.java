package com.java.concurrency.thread.basic;
// http://tutorials.jenkov.com/java-concurrency/creating-and-starting-threads.html


// Using Thread Class Extends
public class ThreadExample2 {
	
	public static class MyThread extends Thread {
		public void run() {
			System.out.println("MyThread Running");
			System.out.println("MyThread Finished");
		}
	}

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
	}

}
