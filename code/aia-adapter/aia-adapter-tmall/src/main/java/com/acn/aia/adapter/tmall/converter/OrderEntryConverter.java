package com.acn.aia.adapter.tmall.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acn.aia.biz.service.domain.OrderEntry;
import com.acn.aia.core.su.core.Converter;
import com.taobao.api.domain.Order;

public class OrderEntryConverter implements Converter<Order, OrderEntry> {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public OrderEntry convert(Order taobaoOrder) {
		if (taobaoOrder == null){
			logger.error("Taobao order cannot be null.");
			return null;
		}
		OrderEntry orderEntry = new OrderEntry();
		// hard code for demo usage
		orderEntry.setCatalog("ai");
		orderEntry.setId( taobaoOrder.getOid().toString());
		// hard code demo purpose
		orderEntry.setProductId("100310020");
		orderEntry.setBasePrice( taobaoOrder.getTotalFee());
		orderEntry.setAdjustFee(taobaoOrder.getAdjustFee());

		//TODO to be determined
		orderEntry.setBuyerNick(taobaoOrder.getBuyerNick());
		orderEntry.setDiscountFee( taobaoOrder.getDiscountFee() );
		orderEntry.setModified( taobaoOrder.getModified() );
		orderEntry.setNum( taobaoOrder.getNum() );
		orderEntry.setStatus( taobaoOrder.getStatus() );
		orderEntry.setTitle( taobaoOrder.getTitle() );
		return orderEntry;
	
	}

	@Override
	public Order parse(OrderEntry target) {
		// TODO Auto-generated method stub
		return null;
	}

}
