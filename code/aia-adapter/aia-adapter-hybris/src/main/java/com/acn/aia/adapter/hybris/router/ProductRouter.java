package com.acn.aia.adapter.hybris.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;

public class ProductRouter extends RouteBuilder {

	private String url;
	private String userName;
	private String password;
	private String queueDestination;

	@Override
	public void configure() throws Exception {
		from(url + "?username=" + userName + "&password=" + password+ "&noop=false&move=./done")
		.unmarshal()
		.bindy(BindyType.Csv, "com.acn.aia.biz.service.domain")
		.to("jms:" + queueDestination);
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setQueueDestination(String queueDestination) {
		this.queueDestination = queueDestination;
	}

}
