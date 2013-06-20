package com.acn.aia.core.utils.threads.c02;

public class Ticket implements Runnable {

	private int tick =100;
	@Override
	public void run() {
		while(true ) {
			if(  tick > 0 ) 
				System.out.println(Thread.currentThread().getName()+" " + tick-- );
			else {
				System.out.println("Available tickets have been sold out " + tick );
				Thread.currentThread().stop();
			}
		}

	}

}
