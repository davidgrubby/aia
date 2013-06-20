package com.acn.aia.core.utils.threads.c10;

public class StopThread implements Runnable {

	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			System.out.println(Thread.currentThread().getName() + "....run");
		}
	}
	
	public void changeFlag(){
		flag = false;
	}

}
