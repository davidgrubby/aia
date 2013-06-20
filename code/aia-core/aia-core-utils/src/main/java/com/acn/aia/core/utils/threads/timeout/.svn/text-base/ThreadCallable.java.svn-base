package com.acn.aia.core.utils.threads.timeout;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadCallable {
	
	public static void main(String[] args) throws Exception{
		
		Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                System.out.println("callable executed.");
                Thread.currentThread().sleep(3*1000);
                return new Random().nextInt(100);
            }
        };
         
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        Thread t = new Thread(future);
        t.start();
        System.out.println(future.get());
		
	}

}
