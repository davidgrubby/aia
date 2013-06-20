package com.acn.aia.core.utils.threads.c05;

/**
 * Multi-thread 
 * Using synchronized identifier on static method
 * */
public class Ticket implements Runnable {

	private static int tick = 100;

	@SuppressWarnings("unused")
	private Object obj = new Object();

	public boolean flag = true;

	@SuppressWarnings({ "static-access", "deprecation" })
	@Override
	public void run() {
		if (flag) {
			while (true) {
				synchronized (Ticket.class) {
					if (tick > 0) {
						try{Thread.currentThread().sleep(10);}catch (Exception e) {e.printStackTrace();}
						System.out.println(Thread.currentThread().getName()+ " " + tick--);
					} else {
						System.out.println("Available tickets have been sold out "+ tick);
						Thread.currentThread().stop();
					}
				}
			}
		} else 
			while(true)
				show();

	}
	
	@SuppressWarnings("static-access")
	public static synchronized void show(){
		if( tick>0) {
			try{Thread.currentThread().sleep(10);}catch (Exception e) {e.printStackTrace();}
			System.out.println(Thread.currentThread().getName()+"...show..." + tick--);
		}
	}

}
