package com.taobao.api.request;

import java.util.Map;

import com.taobao.api.TaobaoRequest;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.response.FenxiaoLoginUserGetResponse;
import com.taobao.api.ApiRuleException;
/**
 * TOP API: taobao.fenxiao.login.user.get request
 * 
 * @author auto create
 * @since 1.0, 2011-09-09 13:49:10
 */
public class FenxiaoLoginUserGetRequest implements TaobaoRequest<FenxiaoLoginUserGetResponse> {

	private TaobaoHashMap udfParams; // add user-defined text parameters
	private Long timestamp;

	public Long getTimestamp() {
		return this.timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getApiMethodName() {
		return "taobao.fenxiao.login.user.get";
	}

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		if(udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public void putOtherTextParam(String key, String value) {
		if(this.udfParams == null) {
			this.udfParams = new TaobaoHashMap();
		}
		this.udfParams.put(key, value);
	}

	public Class<FenxiaoLoginUserGetResponse> getResponseClass() {
		return FenxiaoLoginUserGetResponse.class;
	}
	
	public void check() throws ApiRuleException {
		
	}
}
