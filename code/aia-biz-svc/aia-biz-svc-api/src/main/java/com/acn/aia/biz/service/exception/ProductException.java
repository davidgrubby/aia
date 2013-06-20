package com.acn.aia.biz.service.exception;

/**
 * Exception for product.
 * */
public class ProductException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProductException(String msg) {
		super(msg);
	}
	
	public ProductException(Exception exception ){
		super(exception);
	}

	public ProductException(String msg,Exception exception) {
		super(msg,exception);
	}
}
