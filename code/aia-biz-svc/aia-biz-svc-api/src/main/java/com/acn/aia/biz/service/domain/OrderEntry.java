package com.acn.aia.biz.service.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
@CsvRecord(separator=",")
public class OrderEntry implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@DataField(pos=1)
	private String catalog;
	@DataField(pos=2)
	private String id;
	
	/**
	 * Product ID
	 * Associated product id, need to be translated per different target system
	 * */
	@DataField(pos=3)
	private String productId;
	@DataField(pos=4)
	private Long num;
	@DataField(pos=5)
	private String basePrice;
	@DataField(pos=6)
	private String adjustFee;
	
	
	private String buyerNick;
	private String codFee;
	private String codStatus;
	private Date created;
	private String discountFee;
	private Date modified;
	private String shippingType;
	private String status;
	private String title;
	private String type;
	
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
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
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public String getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("ID:").append(this.getId())
		.append("TITLE:").append(this.getTitle())
		.append("PRICE:").append(this.getAdjustFee());
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof OrderEntry))  
            return false;
		
		OrderEntry orderEntry = (OrderEntry) obj;
		return this.getId().equals( orderEntry.getId());
	}
}
