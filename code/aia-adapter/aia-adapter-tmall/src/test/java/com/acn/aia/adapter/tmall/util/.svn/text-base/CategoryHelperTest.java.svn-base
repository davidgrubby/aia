package com.acn.aia.adapter.tmall.util;

import java.util.List;

import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taobao.api.ApiException;
import com.taobao.api.domain.Brand;
import com.taobao.api.domain.ItemCat;

public class CategoryHelperTest extends CamelSpringTestSupport {
	
	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("classpath:META-INF/spring/tmall-adapter.xml");
	}

	@Test
	public void testFindCategoryIdByTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveAuthorizedCategoriesFromTmall() throws ApiException {
		CategoryHelper categoryHelper = getMandatoryBean(CategoryHelper.class, "categoryHelper");
		assertNotNull(categoryHelper);
		
		List<Brand> brands = categoryHelper.getAuthorizedBrands();
		List<ItemCat> categories = categoryHelper.getAuthorizedCategories();
		
		assertNotNull(brands);
		assertNotNull( categories );
	}
	
	

}
