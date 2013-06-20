package com.acn.aia.adapter.tmall.util;

import java.util.Date;
import java.util.List;

import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acn.aia.biz.service.domain.Order;
import com.acn.aia.biz.service.exception.OrderException;
import com.acn.aia.core.utils.DateUtil;

public class OrderHelperTest extends CamelSpringTestSupport {
	
	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("classpath:META-INF/spring/tmall-adapter.xml");
	}
	
	
	@Test
	public void testQueryOrder() throws OrderException{
		OrderHelper orderHelper = getMandatoryBean(OrderHelper.class, "orderHelper");
		
		Date currentDate = DateUtil.getDate("2013-06-17 20:59:59", "yyyy-MM-dd HH:mm:ss");
		
		List<Order> orders = orderHelper.retrieveOrders1DayAgo( currentDate );
		assertNotNull(orders);
	}
}
