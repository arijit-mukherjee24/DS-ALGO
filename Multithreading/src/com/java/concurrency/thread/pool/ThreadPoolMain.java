package com.java.concurrency.thread.pool;
// http://tutorials.jenkov.com/java-concurrency/thread-pools.html

// https://www.youtube.com/watch?v=ZcKt5FYd3bU&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=11
public class ThreadPoolMain {

	public static void main(String[] args) throws Exception {
		ThreadPool threadPool = new ThreadPool(3, 10); // 3 Threads and 10 tasks to run internally

		for (int i = 0; i < 10; i++) {
			int taskNo = i;
			// add tasks in queue of threadPool, it expects a Runnable instance
			threadPool.execute(() -> {
				String message = Thread.currentThread().getName() + " Task: " + taskNo;
				System.out.println(message);
			});
			// threadPool.execute(new CustomTask());
		}

		threadPool.waitUntilAllTasksFinished();
        threadPool.stop();

	}

}
