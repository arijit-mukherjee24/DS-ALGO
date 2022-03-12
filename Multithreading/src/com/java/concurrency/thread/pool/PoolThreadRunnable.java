package com.java.concurrency.thread.pool;

import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable {

	private Thread thread = null;
	private BlockingQueue<Runnable> taskQueue = null;
	private boolean isStopped = false;

	public PoolThreadRunnable(BlockingQueue<Runnable> queue) {
		taskQueue = queue;
	}

	@Override
	public void run() {
		this.thread = Thread.currentThread();
        while(!isStopped()){
            try{
                Runnable runnable = (Runnable) taskQueue.take();
                runnable.run();
            } catch(Exception e){
                //log or otherwise report exception,
                //but keep pool thread alive.
            }
        }
	}

	public synchronized boolean isStopped(){
        return isStopped;
    }

	public synchronized void doStop(){
        isStopped = true;
        //break pool thread out of dequeue() call.
        this.thread.interrupt();
    }

}