package com.acn.aia.core.utils.threads.c10;

public class StopThreadDemo {
	public static void main(String[] args) {
		StopThread stopThread = new StopThread();
		
		Thread t1 = new Thread(stopThread);
		Thread t2 = new Thread(stopThread);
		
		t1.setDaemon(true);
		t2.setDaemon( true );
		
		t1.start();
		t2.start();
		
		int num = 0;
		
		while( true ) {
			if( num++ == 60 ) {
				stopThread.changeFlag();
				t1.interrupt();
				t2.interrupt();
				break;
			}
			
			System.out.println(Thread.currentThread().getName()+"......."+num);
		}
		
		System.out.println("over");
	}
}
