package com.acn.aia.core.utils.threads.timeout;

import java.util.Date;

public class Worker implements Runnable {

	private boolean isRunning = false;
	private Date startTime;
	
	@Override
	public void run() {
		while (true) {
			if (!isRunning) {
				System.out.println(Thread.currentThread().getName()+" worker is starting...");
				// performing web service invocation
				try {
//					Thread.currentThread().wait();
					Thread.sleep(3*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println(Thread.currentThread().getName()+" Counter is starting...");
				changeState();
				Date currentTime = new Date();
				if ((currentTime.getTime() - startTime.getTime()) / 60 > 10) {
					System.out.println(Thread.currentThread().getName()+" Already spend "+ (currentTime.getTime() - startTime.getTime())/ 60 + " on executing web service invocation.");
					Thread.currentThread().interrupt();
				}
			}
		}
	}
	
	private synchronized void changeState(){
		startTime = new Date();
		System.out.println(Thread.currentThread().getName()+ " invoking web service...." + "   started @"+ startTime.getTime());
		isRunning = true;
	}
}
