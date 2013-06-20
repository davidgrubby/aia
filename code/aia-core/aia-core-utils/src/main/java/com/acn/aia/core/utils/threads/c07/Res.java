package com.acn.aia.core.utils.threads.c07;

/**
 * Optimized version for c06
 * */
public class Res {
	String name;
	String sex;
	boolean flag = false;
	
	public synchronized void set(String name, String sex) {
		if( flag ) 
			try{this.wait();}catch (Exception e) {e.printStackTrace();}
		this.name = name;
		this.sex = sex;
		this.flag = true;
		this.notify();
	}
	
	public synchronized void out(){
		if( !flag ) 
			try{ this.wait();} catch (Exception e) {}
		
		System.err.println(name+ "....." + sex );
		flag = false;
		this.notify();
	}
}
