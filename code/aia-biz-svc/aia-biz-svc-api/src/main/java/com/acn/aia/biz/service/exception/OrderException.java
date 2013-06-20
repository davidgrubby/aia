package com.acn.aia.biz.service.exception;

/**
 * Exception for product.
 * */
public class OrderException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OrderException(String msg) {
		super(msg);
	}
	
	public OrderException(Exception exception ){
		super(exception);
	}

	public OrderException(String msg,Exception exception) {
		super(msg,exception);
	}
}
