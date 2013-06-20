package com.acn.aia.core.utils.threads.c02;

public class TicketDemo {

	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		Thread thread1 = new Thread( ticket , "Window 1 ");
		Thread thread2 = new Thread( ticket , "Window 2 ");
		Thread thread3 = new Thread( ticket , "Window 3 ");
		Thread thread4 = new Thread( ticket , "Window 4 ");
		Thread thread5 = new Thread( ticket , "Window 5 ");
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}
}
