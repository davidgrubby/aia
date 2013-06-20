package com.acn.aia.core.utils.designpattern.observe;

import java.util.Observer;

public class TestWatch {

	public static void main(String[] args) {
		Watched watched = new Watched();
		Observer watcher = new Watcher();
		watched.addObserver(watcher);
		Observer watcher2 = new Watcher2();
		watched.addObserver(watcher2);
		
		watched.count(10);
	}
}
