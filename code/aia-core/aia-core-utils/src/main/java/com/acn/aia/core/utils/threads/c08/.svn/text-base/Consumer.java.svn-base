package com.acn.aia.core.utils.threads.c08;

public class Consumer implements Runnable {

	private Resource resource;

	Consumer(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		while (true)
			resource.out();
	}

}
