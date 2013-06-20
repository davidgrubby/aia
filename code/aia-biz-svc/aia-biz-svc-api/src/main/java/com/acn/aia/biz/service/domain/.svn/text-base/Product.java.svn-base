package com.acn.aia.biz.service.domain;

import java.io.Serializable;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

/**
 * Standard Product Object
 * @author fei.zhu
 * */
@CsvRecord(separator=",", skipFirstLine=true)
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@DataField(pos=1)
	private String productId;
	@DataField(pos=2)
	private String locale;
	@DataField(pos=3)
	private String productTitle;
	@DataField(pos=4)
	private String categoryId;
	@DataField(pos=5)
	private String categoryTitle;
	@DataField(pos=6)
	private String baseproductId;
	@DataField(pos=7)
	private String barCode;
	@DataField(pos=8)
	private String type;
	@DataField(pos=9)
	private String status;
	@DataField(pos=10)
	private String factoryId;
	@DataField(pos=11)
	private String factoryTitle;
	@DataField(pos=12)
	private String tax;
	@DataField(pos=13)
	private String locationOfManuFactory;
	/**
	 * Additional information for this product and commonly used by classification.
	 * expected data format: color:red;size:XXL
	 * */
	@DataField(pos=14)
	private String properties;
	@DataField(pos=15)
	private String unit;
	@DataField(pos=16)
	private String price;
	@DataField(pos=17)
	private String quantity;
	@DataField(pos=18)
	private String mainImageUrl;
	@DataField(pos=19)
	private String description;
	@DataField(pos=20)
	private String creationDate;
	@DataField(pos=21)
	private String modifyDate;
	@DataField(pos=22)
	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getBaseproductId() {
		return baseproductId;
	}

	public void setBaseproductId(String baseproductId) {
		this.baseproductId = baseproductId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFactoryTitle() {
		return factoryTitle;
	}

	public void setFactoryTitle(String factoryTitle) {
		this.factoryTitle = factoryTitle;
	}

	public String getLocationOfManuFactory() {
		return locationOfManuFactory;
	}

	public void setLocationOfManuFactory(String locationOfManuFactory) {
		this.locationOfManuFactory = locationOfManuFactory;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(final String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(final String quantity) {
		this.quantity = quantity;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(final String barCode) {
		this.barCode = barCode;
	}


	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public String getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(final String factoryId) {
		this.factoryId = factoryId;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(final String tax) {
		this.tax = tax;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(final String creationDate) {
		this.creationDate = creationDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(final String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(final String unit) {
		this.unit = unit;
	}

	public String getMainImageUrl() {
		return mainImageUrl;
	}

	public void setMainImageUrl(final String mainImageUrl) {
		this.mainImageUrl = mainImageUrl;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		final StringBuffer buffer = new StringBuffer();
		buffer.append(",productId:" + productId);
		buffer.append(",productTitle:" + productTitle);
		buffer.append(",locale:" + locale);
		buffer.append(",categoryId:" + categoryId);
		buffer.append(",categoryTitle:" + categoryTitle);
		buffer.append(",barCode:" + barCode);
		buffer.append(",type:" + type);
		buffer.append(",status:" + status);
		buffer.append(",factoryId:" + factoryId);
		buffer.append(",factoryTitle:" + factoryTitle);
		buffer.append(",tax:" + tax);
		buffer.append(",creationDate:" + creationDate);
		buffer.append(",locationOfManufactory:" + locationOfManuFactory);
		buffer.append(",modifyDate:" + modifyDate);
		buffer.append(",unit:" + unit);
		buffer.append(",price:" + price);
		buffer.append(",quantity:" + quantity);
		buffer.append(",mainImageUrl:" + mainImageUrl);
		buffer.append(",description:" + description);
		return buffer.toString();
	}
}
