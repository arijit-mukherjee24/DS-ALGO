package com.java.concurrency.thread.race_condition;

public class Counter {
	private long count = 0;

	public long increment() {
		this.count++;
		return this.count;
	}

	public long getCount() {
		return this.count;
	}
}