package com.acn.aia.core.su.context;

public interface Context {
	public boolean connect(Adapter adapter);
	
	public void stopConnection();
}
