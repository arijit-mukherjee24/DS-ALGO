package com.java.concurrency.thread.sync;

// Java synchronized block reentrance rules
// https://www.youtube.com/watch?v=eKWjfZ-TUdo&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=5 

// http://tutorials.jenkov.com/java-concurrency/synchronized.html
public class Reentrance {

	private int count = 0;
	
	public synchronized void inc() {
		this.count++;
	}
	
	public synchronized int incAndGet() {
		inc();
		return this.count;
	}
}
