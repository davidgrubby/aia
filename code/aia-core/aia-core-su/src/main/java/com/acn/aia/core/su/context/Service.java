package com.acn.aia.core.su.context;

public interface Service {

	public void registerService(Adapter adapter);
	
	public Context initial();
	
	/**
	 * Provide a JNDI name to look up adapter on adapter registry.
	 * Null will be returned if no valid adapter existing.
	 * */
	public Adapter lookup(String jndiName);
	
}
