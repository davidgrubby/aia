package com.acn.aia.biz.service.api;

import java.util.Date;
import java.util.List;

import com.acn.aia.biz.service.domain.Order;
import com.acn.aia.biz.service.exception.OrderException;

public interface OrderService {
	/**
	 * Will perform duplicate checking before saving.
	 * @param order - to be saved or updated
	 * @return 
	 * */
	public Order saveOrUpdate(Order order);
	
	/**
	 * To delete this order, maybe just perform deactive 
	 * */
	public Order delete(Order order);
	
	/**
	 * Retrieve order list from Taobao, the orders will be returned from one day ago and no duplicated orders.
	 * */
	public List<Order> retrieveOrders1DayAgo( Date currentDate ) throws OrderException;
	
	/**
	 * To check if the order is exists
	 * */
	public boolean isExists(String orderId);
}
