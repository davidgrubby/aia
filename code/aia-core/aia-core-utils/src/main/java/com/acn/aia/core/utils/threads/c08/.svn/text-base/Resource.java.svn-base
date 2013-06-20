package com.acn.aia.core.utils.threads.c08;

public class Resource {
	private String name;
	private int count = 1;
	private boolean flag = false;

	public synchronized void set(String name) {
		while (flag)
			try {
				this.wait();
			} catch (Exception e) {
			}

		this.name = name + "--" + count++;
		System.out.println(Thread.currentThread().getName() + "...Producer..."+ this.name);
		
		flag = true;
		this.notifyAll();
	}
	
	public synchronized void out(){
		while(!flag ) 
			try {
				this.wait();
			} catch (Exception e) {
			}
		
		System.out.println(Thread.currentThread().getName() + "...Consumer..." + this.name );
		flag = false;
		this.notifyAll();
	}
}
