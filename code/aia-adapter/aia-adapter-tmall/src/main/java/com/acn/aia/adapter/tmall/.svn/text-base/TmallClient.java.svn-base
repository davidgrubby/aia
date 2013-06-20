package com.acn.aia.adapter.tmall;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.TaobaoResponse;

/**
 * Tmall client to wrap up the details of TaobaoClient construction and hide the details of refreshing session key.
 * @author fei.zhu
 * */
public class TmallClient extends DefaultTaobaoClient {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//TODO session should be refreshed automatically
	private String session;
	
	public TmallClient(String serverUrl, String appKey, String appSecret, String session){
		super(serverUrl, appKey, appSecret);
		logger.info(">>> Initialized Tmall connection...");
		this.session = session;
	}
	
	public <T extends TaobaoResponse> T execute(TaobaoRequest<T> request) throws ApiException{
		logger.info(">>> Prepare to post request to Tmall...");
		T t = super.execute(request, this.session);
		
		if( t.getErrorCode() != null && !"".equals( t.getErrorCode() )) {
			logger.error(">>> Error occurred during obtain response from Tmall.");
			logger.error(">>> Error code:" + t.getErrorCode()+"    Error msg:" + t.getMsg() );
			logger.info(">>> Tmall connection terminated.");
			throw new ApiException("Invoke TOP API error identified.");
		} else {
			logger.info(">>> Response successfully returned from TOP");
		}
		
		logger.info(">>> Sending request complete..");
		return t;
	}
}
