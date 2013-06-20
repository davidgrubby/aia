package com.acn.aia.core.utils.threads.c06;

public class Output implements Runnable {
	private Res r;

	Output(Res res ) {
		this.r = res;
	}
	
	
	@Override
	public void run() {
		while( true ) {
			synchronized ( r ) {
				if( !r.flag ) 
					try{
						r.wait();
					}catch (Exception e) {
						e.printStackTrace();
					}
				
				System.out.println(r.name+"...." + r.sex );
				r.flag = false;
				r.notify();
			}
		}
	}

}
