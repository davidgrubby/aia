package com.acn.aia.core.utils.threads.c06;

public class Input implements Runnable {
	private Res r;
	
	Input( Res res ) {
		this.r = res;
	}
	
	@Override
	public void run() {
		int i=0;
		
		while(true ) {
			synchronized ( r ) {
				if( r.flag ) 
					try{
						r.wait();
					}catch (Exception e) {
						e.printStackTrace();
					}
				
				if( i == 0 ) {
					r.name = "Mike";
					r.sex = "man";
				} else{
					r.name = "丽丽";
					r.sex = "女女女女";
				}
				
				i = (i+1)%2;
				r.flag = true;
				r.notify();
			}
		}

	}

}
