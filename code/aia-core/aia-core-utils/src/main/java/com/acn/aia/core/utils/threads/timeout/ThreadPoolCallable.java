package com.acn.aia.core.utils.threads.timeout;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolCallable {
	public static void main(String[] args) throws Exception {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<Integer> future = threadPool.submit(new Callable<Integer>() {
			public Integer call() throws Exception {
				System.out.println(Thread.currentThread().getName()+" callable executed.");
				return new Random().nextInt(200);
			}
		});

		System.out.println(Thread.currentThread().getName() +" do your things");
		System.out.println(future.get());
		threadPool.shutdown();
	}
}
