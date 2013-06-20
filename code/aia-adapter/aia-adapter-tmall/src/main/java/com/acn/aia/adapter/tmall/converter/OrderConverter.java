package com.acn.aia.adapter.tmall.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acn.aia.biz.service.domain.Order;
import com.acn.aia.core.su.core.Converter;
import com.acn.aia.core.utils.DateUtil;
import com.taobao.api.domain.Trade;

public class OrderConverter implements Converter<Trade, Order> {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Order convert(Trade taobaoTrade) {
		com.acn.aia.biz.service.domain.Order order = new com.acn.aia.biz.service.domain.Order();
		if (taobaoTrade == null) {
			logger.error("taobaoTrade cannot be null");
			return null;
		}
		order.setId(taobaoTrade.getTid().toString());
		// hard code "abrode"
		order.setBuyerNick("abrode"); // for demo, it is hard code "abrode"

		if (taobaoTrade.getCreated() != null)
			order.setCreated(DateUtil.getDate(taobaoTrade.getCreated(),
					"yyyy-MM-dd HH:mm"));

		order.setStatus("COMPLETED"); // possible value are : COMPLETED,// CANCENLLED
		// order.setPaymentStatus(taobaoTrade.getStatus());
		// hard code for payment status
		order.setPaymentStatus("PAID");
		// hard code for payment mode
		order.setPaymentMode("AliPay");// possible value are:AliPay, ChinaPay,// cod
		//order.setReceiverAddress(taobaoTrade.getReceiverAddress());
		// hard code for receiver address
		order.setReceiverAddress("广中西路777弄启迪大厦14楼");
		order.setAdjustFee(taobaoTrade.getAdjustFee());
		// order.setReceiverZip( taobaoTrade.getReceiverZip() );
		// for demo, it is hard code "200072"
		order.setReceiverZip("200072");
		// order.setBuyerNick(taobaoTrade.getBuyerNick()); // for demo, it is

		order.setTotalFee(taobaoTrade.getTotalFee());
		order.setPostFee(taobaoTrade.getPostFee());

		// TODO to be determined
		order.setCodFee(taobaoTrade.getCodFee());
		order.setCodStatus(taobaoTrade.getCodStatus());
		order.setDiscountFee(taobaoTrade.getDiscountFee());
		order.setModified(taobaoTrade.getModified());
		order.setNum(taobaoTrade.getNum());
		order.setReceivedPayment(taobaoTrade.getReceivedPayment());
		order.setReceiverCity(taobaoTrade.getReceiverCity());
		order.setReceiverDistrict(taobaoTrade.getReceiverDistrict());
		order.setReceiverMobile(taobaoTrade.getReceiverMobile());
		order.setReceiverName(taobaoTrade.getReceiverName());
		order.setReceiverPhone(taobaoTrade.getReceiverPhone());
		order.setReceiverState(taobaoTrade.getReceiverState());
		order.setSellerNick(taobaoTrade.getSellerNick());
		order.setShippingType(taobaoTrade.getShippingType());
		order.setTitle(taobaoTrade.getTitle());
		order.setType(taobaoTrade.getType());

		return order;
	}

	@Override
	public Trade parse(Order target) {
		// TODO Auto-generated method stub
		return null;
	}

}
