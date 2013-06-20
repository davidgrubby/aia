package com.acn.aia.core.utils.threads.c07;

public class Input implements Runnable {
	private Res r;

	Input(Res res) {
		this.r = res;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			if (i == 0) {
				r.set("Mike", "man");
			} else {
				r.set("丽丽", "女女女女");
			}
			i = (i + 1) % 2;
		}

	}

}
