package com.java.concurrency.thread.javalock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
// http://tutorials.jenkov.com/java-util-concurrent/lock.html

/*
Lock Reentrance
================
A lock is called reentrant if the thread that holds the lock can lock it again. 
A non-reentrant lock is a lock which cannot be locked again if locked, not even by the thread that holds the lock. 
Non-reentrant locks may result in reentrance lockout which is a situation similar to a deadlock.

The ReentrantLock class is a reentrant lock. 
That means, that even if a thread holds the hold it can lock it again. 
Consequently the thread must unlock it as many times as it has locked it, in order to fully unlock the Reentrant lock for other threads.

A reentrant lock is useful in certain concurrent designs. 
Below is a concurrent implementation of a calculator. 
The calculator can hold the current result internally, and offers a set of methods that can perform calculations on that result.
 */

public class Calculator {

	public static class Calculation {
		public static final int UNSPECIFIED = -1;
		public static final int ADDITION = 0;
		public static final int SUBTRACTION = 1;
		int type = UNSPECIFIED;

		public double value;

		public Calculation(int type, double value) {
			this.type = type;
			this.value = value;
		}
	}

	private double result = 0.0D;
	Lock lock = new ReentrantLock();

	public void add(double value) {
		try {
			lock.lock();
			this.result += value;
		} finally {
			lock.unlock();
		}
	}

	public void subtract(double value) {
		try {
			lock.lock();
			this.result -= value;
		} finally {
			lock.unlock();
		}
	}

	public void calculate(Calculation... calculations) {
		try {
			lock.lock();

			for (Calculation calculation : calculations) {
				switch (calculation.type) {
				case Calculation.ADDITION:
					add(calculation.value);
					break;
				case Calculation.SUBTRACTION:
					subtract(calculation.value);
					break;
				}
			}
		} finally {
			lock.unlock();
		}
	}
}

/*
Notice how the calculate() method both locks the Calculator instance's Lock before performing any calculations, 
and also call the add() and subtract() methods which also locks the lock. 
Because the ReentrantLock is reentrant, this does not cause any problems. 
The thread calling calculate
*/