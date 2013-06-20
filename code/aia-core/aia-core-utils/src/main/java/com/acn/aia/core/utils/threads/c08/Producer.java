package com.acn.aia.core.utils.threads.c08;

public class Producer implements Runnable {
	
	private Resource resource;
	
	public Producer(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		while(true) {
			resource.set("+商品+");
		}
	}

}
