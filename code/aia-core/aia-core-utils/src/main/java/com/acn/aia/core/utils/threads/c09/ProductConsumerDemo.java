package com.acn.aia.core.utils.threads.c09;

public class ProductConsumerDemo {

	public static void main(String[] args) {
		Resource resource = new Resource();
		Producer producer = new Producer(resource);
		Consumer consumer = new Consumer(resource);
		
		Thread t1 = new Thread( producer );
		Thread t2 = new Thread( producer );
		Thread t3 = new Thread( consumer );
		Thread t4 = new Thread( consumer );
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
