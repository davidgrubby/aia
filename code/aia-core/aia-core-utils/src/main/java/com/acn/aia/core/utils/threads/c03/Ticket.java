package com.acn.aia.core.utils.threads.c03;

public class Ticket implements Runnable {

	private int tick =1000;
	
	private Object obj = new Object();
	
	@Override
	public void run() {
		while(true ) {
			synchronized (obj) {
				if(  tick > 0 ) {
					//try{Thread.sleep(1000);}catch (Exception e) {e.printStackTrace();}
					System.out.println(Thread.currentThread().getName()+" " + tick-- );
				} else {
					System.out.println("Available tickets have been sold out " + tick );
					Thread.currentThread().stop();
				}
			}
		}

	}

}
