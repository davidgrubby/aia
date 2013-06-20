package com.acn.aia.core.utils.threads.c07;

public class Output implements Runnable {
	private Res r;

	Output(Res res) {
		this.r = res;
	}

	@Override
	public void run() {
		while (true) {
			r.out();
		}
	}

}
