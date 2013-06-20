package com.acn.aia.core.utils.threads.c11;

public class Demo implements Runnable {

	@Override
	public void run() {
		for( int x=0; x<70;x++) {
			System.out.println(Thread.currentThread().toString()+"...." + x);
			Thread.yield();
		}
	}

}
