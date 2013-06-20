package com.acn.aia.biz.service.exception;

public class TimeoutException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TimeoutException(String msg) {
		super(msg);
	}
	
	public TimeoutException(Exception exception ){
		super(exception);
	}

	public TimeoutException(String msg,Exception exception) {
		super(msg,exception);
	}

}
