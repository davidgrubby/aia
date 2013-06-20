package com.acn.aia.adapter.tmall.util;

import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acn.aia.biz.service.domain.Product;
import com.acn.aia.biz.service.exception.ProductException;
import com.taobao.api.domain.Item;

public class ProductHelperTest extends CamelSpringTestSupport {
	
	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("classpath:META-INF/spring/tmall-adapter.xml");
	}
	
	private Product product = new Product();
	
	@Before
	public void prepareProduct(){
		// David: product id must be unique.
		// if you saw the error code: {"error_response":{"code":540,"msg":"
		// Remote service error","sub_code":"isp.product-service-error:null-tmall","
		// sub_msg":"本类目此关键属性的产品已存在, 不可重复添加"}}
		// increase the number is must 
		String productId = "50012780";
		String locale="zh_CN";
		String productTitle = "Samsung 联合 Flo Rida 带来超大功率音";
		String categoryId = "1234";
		String categoryTitle = "保暖裤";
		String baseProductId = "123";
		String barCode = "3234541";
		String type = "";
		String status = "onsale";
		String factoryId = "9823";
		String factoryTitle = "上海闸北店";
		String tax = "10";
		String locationOfManufactory = "上海市闸北区中山北路2550号";
		String properties = "品牌:猫人;颜色分类:天蓝色;厚度:加厚;面料材质:真丝";
		String unit = "件";
		String price = "125.05";
		String quantity = "25";
		String mainImageUrl = "C:/Users/fei.zhu/Pictures/1.png";
		String description = "Samsung 和 Flo Rida （是美国著名的嘻哈说唱歌手，" +
				"年轻时曾是当地的嘻哈组合 2 Live Crew 的一员 ）" +
				"一起发布了最新的超大功率音箱产品：MX-FS9000。" +
				"其具备了 2 个超大低音炮，最大功率达到了 2,560W。" +
				"它会在 5 月份上市，价格在 US$1,499，如果你觉得偏" +
				"大了点，还有一个较小的型号 MX-FS9000 供选择，价" +
				"格在 US$999。";
		String createDate = "";
		String modifyDate = "";
		
		product = new Product();
		product.setProductId(productId);
		product.setLocale(locale);
		product.setProductTitle(productTitle);
		product.setCategoryId( categoryId );
		product.setCategoryTitle(categoryTitle);
		product.setBaseproductId(baseProductId);
		product.setType(type);
		product.setStatus(status);
		product.setFactoryId(factoryId);
		product.setFactoryTitle(factoryTitle);
		product.setTax(tax);
		product.setLocationOfManuFactory(locationOfManufactory);
		product.setProperties(properties);
		product.setUnit(unit);
		product.setPrice(price);
		product.setQuantity(quantity);
		product.setMainImageUrl(mainImageUrl);
		product.setDescription(description);
		product.setCreationDate(createDate);
		product.setModifyDate(modifyDate);
		product.setBarCode(barCode);
	}

	@Test
	public void testCreateNewProduct() throws ProductException{
		ProductHelper productHelper = getMandatoryBean(ProductHelper.class, "productHelper");
		assertNotNull(productHelper);
		com.taobao.api.domain.Product createdProduct = productHelper.createNewProduct(product);
		System.out.println("Tmall product id: " +createdProduct.getProductId());
		assertNotNull( createdProduct );
	}
	
	@Test
	public void testCreateNewMerchandise() throws ProductException{
		ProductHelper productHelper = getMandatoryBean(ProductHelper.class, "productHelper");
		assertNotNull(productHelper);
		com.taobao.api.domain.Product tmallProduct = productHelper.createNewProduct(product);
		Item newItem = productHelper.createNewMerchandise(tmallProduct.getProductId(), product);
		System.out.println("Tmall item id: " + newItem.getNumIid() );
		assertNotNull( newItem );
	}

}
