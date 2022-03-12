package com.java.concurrency.thread.basic;

// Stop a Java Thread
public class ThreadExample8 {

	public static class StoppableRunnable implements Runnable {
		private boolean stopRequested = false;

		public synchronized void requestStop() {
			this.stopRequested = true;
		}

		public synchronized boolean isStopRequested() {
			return this.stopRequested;
		}

		private void sleep(long milis) {
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			System.out.println("StoppableRunnable is running");
			while (!isStopRequested()) {
				sleep(1000);
				System.out.println("...");
			}
			System.out.println("StoppableRunnable is stopped");
		}

	}

	public static void main(String[] args) {

		StoppableRunnable stoppableRunnable = new StoppableRunnable();
		Thread thread = new Thread(stoppableRunnable, "The Thread");

		thread.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Requesting Stop");
		stoppableRunnable.requestStop();
		System.out.println("stop requested");
	}
}
