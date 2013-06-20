package com.acn.aia.core.utils.threads.c07;

public class InputOutputDemo {

	public static void main(String[] args) {
		Res res = new Res();
		Input input = new Input(res);
		
		Output output = new Output(res);
		
		Thread t1 = new Thread( input );
		Thread t2 = new Thread( output );
		
		t1.start();
		t2.start();
	}
}
