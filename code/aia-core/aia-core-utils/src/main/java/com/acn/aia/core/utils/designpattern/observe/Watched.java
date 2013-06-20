package com.acn.aia.core.utils.designpattern.observe;

import java.util.Observable;

public class Watched extends Observable {

	public void count(int num) {

		for (; num >= 0; num--) {
			// 通知之前一定要设定setChanged
			this.setChanged();

			// this.notifyObservers();

			// 如果需要为观察者传递信息,调用此方法,observer 的update第二个参数就能接受
			this.notifyObservers(num);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
