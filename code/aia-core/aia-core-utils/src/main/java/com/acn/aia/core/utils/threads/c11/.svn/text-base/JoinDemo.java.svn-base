package com.acn.aia.core.utils.threads.c11;

public class JoinDemo {

	public static void main(String[] args) throws Exception {
		Demo demo = new Demo();
		Thread t1 = new Thread(demo);
		Thread t2 = new Thread(demo);

		t1.start();
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.start();
		t1.join();

		for (int x = 0; x < 80; x++) {
			System.out.println("main....." + x);
		}

		System.out.println("over");

	}
}
