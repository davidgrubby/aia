package com.acn.aia.biz.service.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

/**
 * Nomalized order object 
 * */
@CsvRecord(separator=",")
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@DataField(pos=1)
	private String id;
	@DataField(pos=2)
	private String buyerNick;
	@DataField(pos=3)
	private String created;
	
	/**
	 * AliPay, ChinaPay, cod
	 * */
	@DataField(pos=4)
	private String paymentMode;
	
	/**
	 * Order status
	 * COMPLETED, CANCELED
	 * */
	@DataField(pos=5)
	private String status;
	
	/**
	 * PAID,NOTPAID
	 * */
	@DataField(pos=6)
	private String paymentStatus;
	@DataField(pos=7)
	private String receiverAddress;
	@DataField(pos=8)
	private String receiverZip;
	@DataField(pos=9)
	private String totalFee;
	@DataField(pos=10)	
	private String postFee;
	
	private String adjustFee;
	
	private String codFee;
	private String codStatus;
	
	private String discountFee;
	private Date modified;
	private Long num;
	
	private String receivedPayment;
	private String receiverCity;
	private String receiverDistrict;
	private String receiverMobile;
	private String receiverName;
	private String receiverPhone;
	private String receiverState;
	
	
	private String sellerNick;
	private String shippingType;
	
	private String title;
	
	private String type;
	
	private List<OrderEntry> entries;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdjustFee() {
		return adjustFee;
	}

	public void setAdjustFee(String adjustFee) {
		this.adjustFee = adjustFee;
	}

	public String getBuyerNick() {
		return buyerNick;
	}

	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	public String getCodFee() {
		return codFee;
	}

	public void setCodFee(String codFee) {
		this.codFee = codFee;
	}

	public String getCodStatus() {
		return codStatus;
	}

	public void setCodStatus(String codStatus) {
		this.codStatus = codStatus;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getDiscountFee() {
		return discountFee;
	}

	public void setDiscountFee(String discountFee) {
		this.discountFee = discountFee;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getReceivedPayment() {
		return receivedPayment;
	}

	public void setReceivedPayment(String receivedPayment) {
		this.receivedPayment = receivedPayment;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverCity() {
		return receiverCity;
	}

	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}

	public String getReceiverDistrict() {
		return receiverDistrict;
	}

	public void setReceiverDistrict(String receiverDistrict) {
		this.receiverDistrict = receiverDistrict;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverState() {
		return receiverState;
	}

	public void setReceiverState(String receiverState) {
		this.receiverState = receiverState;
	}

	public String getReceiverZip() {
		return receiverZip;
	}

	public void setReceiverZip(String receiverZip) {
		this.receiverZip = receiverZip;
	}

	public String getSellerNick() {
		return sellerNick;
	}

	public void setSellerNick(String sellerNick) {
		this.sellerNick = sellerNick;
	}

	public String getShippingType() {
		return shippingType;
	}

	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<OrderEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<OrderEntry> entries) {
		this.entries = entries;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPostFee() {
		return postFee;
	}

	public void setPostFee(String postFee) {
		this.postFee = postFee;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("ID:").append(this.getId())
		.append("TITLE:").append(this.getTitle())
		.append("PRICE:").append(this.getAdjustFee())
		.append("AMOUNT:").append(this.getTotalFee())
		.append("NUM:").append(this.getNum())
		.append("DELIVERY ADDRESS:").append(this.getReceiverAddress());
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Order))  
            return false;
		
		Order order = (Order) obj;
		
		boolean equals =this.getId().equals( order.getId());
		equals = equals && ( this.getTotalFee().equals( order.getTotalFee() ));
		
		return equals;
	}
	
}
