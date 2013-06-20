package com.acn.aia.core.utils.threads.c01;

public class ThreadDemo extends Thread {

	@Override
	public void run() {
		System.out.println("Thread name:" + Thread.currentThread().getName());
		for (int x = 0; x < 5; x++) {
			System.out.println("Demo run................");
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello world!");
			ThreadDemo td = new ThreadDemo();
			td.start();
//			td.run();
//			for (int x = 0; x < 60; x++) {
//				System.out.println("Hello World!--" + x);
//			}
		}
	}
}
