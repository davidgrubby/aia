package com.acn.aia.core.utils.threads.c05;

public class TicketStaticDemo {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		Ticket ticket = new Ticket();
		Thread thread1 = new Thread( ticket , "Window 1 ");
		Thread thread2 = new Thread( ticket , "Window 2 ");
		
		thread1.start();
		thread1.sleep(100);
		
		ticket.flag = false;
		
		thread2.start();
		thread2.sleep(100);
		ticket.flag = true;

	}
}
