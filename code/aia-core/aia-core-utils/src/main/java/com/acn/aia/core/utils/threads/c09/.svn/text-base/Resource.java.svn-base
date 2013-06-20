package com.acn.aia.core.utils.threads.c09;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
	private String name;
	private int count = 1;
	private boolean flag = false;
	
	private Lock lock = new ReentrantLock();
	private Condition condition_pro = lock.newCondition();
	private Condition condition_con = lock.newCondition();
	
	

	public void set(String name) {
		lock.lock();
		try {
			while (flag)
				condition_pro.await();
			this.name = name + "--" + count++;
			System.out.println(Thread.currentThread().getName() + "...producing..."+ this.name);
			
			flag = true;
			condition_con.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void out(){
		lock.lock();
		try {
			while(!flag ) 
				condition_con.await();
			System.out.println(Thread.currentThread().getName() + "...consuming..." + this.name );
			flag = false;
			condition_pro.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
