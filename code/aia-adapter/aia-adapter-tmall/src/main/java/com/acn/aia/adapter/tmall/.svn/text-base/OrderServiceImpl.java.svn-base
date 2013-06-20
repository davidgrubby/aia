package com.acn.aia.adapter.tmall;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.acn.aia.adapter.tmall.util.OrderHelper;
import com.acn.aia.biz.service.api.OrderService;
import com.acn.aia.biz.service.domain.Order;
import com.acn.aia.biz.service.exception.OrderException;

/**
 * To implement order service
 * @author fei.zhu
 * */
public class OrderServiceImpl implements OrderService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private OrderHelper orderHelper;
	
	@Override
	public Order saveOrUpdate(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order delete(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> retrieveOrders1DayAgo( Date currentDate )  throws OrderException {
		// Retrieve incremental orders from 1 day ago
		List<Order> orders = orderHelper.retrieveOrders1DayAgo( currentDate );
		
		if( orders == null || orders.isEmpty() ){
			logger.info("No results from Taobao.");
			return null;
		}
		return orders;
	}

	@Override
	public boolean isExists(String orderId) {
		// TODO Auto-generated method stub
		return false;
	}

}
