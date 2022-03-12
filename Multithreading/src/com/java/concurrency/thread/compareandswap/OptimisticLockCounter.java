package com.java.concurrency.thread.compareandswap;

// http://tutorials.jenkov.com/java-concurrency/compare-and-swap.html
import java.util.concurrent.atomic.AtomicLong;

public class OptimisticLockCounter implements Counter {

	private AtomicLong count = new AtomicLong();

	@Override
	public void inc() {
		boolean incSuccessful = false;
		while (!incSuccessful) {
			long value = this.count.get(); // value == 11
			long newValue = value + 1;

			incSuccessful = this.count.compareAndSet(value, newValue);
		}

	}

	@Override
	public long getCount() {
		return this.count.get();
	}

}
