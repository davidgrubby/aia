package com.acn.aia.core.utils.threads.timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultMergeCallable {

	public static void main(String[] args) throws Exception {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		List<Callable<String>> callables = new ArrayList<Callable<String>>();

		for (int i = 1; i < 5; i++) {
			final int id = i;
			callables.add(new Callable<String>() {
				public String call() throws Exception {
					return "taskID" + id;
				}
			});
		}

		List<Future<String>> futures = threadPool.invokeAll(callables);
		for (Future<String> future : futures) {
			System.out.println(future.get());
		}
		threadPool.shutdown();
	}

}
