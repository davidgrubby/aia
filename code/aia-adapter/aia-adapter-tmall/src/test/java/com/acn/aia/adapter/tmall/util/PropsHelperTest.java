package com.acn.aia.adapter.tmall.util;

import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taobao.api.ApiException;

public class PropsHelperTest extends CamelSpringTestSupport {

	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/tmall-adapter.xml");
	}

	@Test
	public void testGetTmallVid() throws Exception{
		PropsHelper propsHelper = getMandatoryBean(PropsHelper.class,
				"propsHelper");
		assertNotNull(propsHelper);

		String cid = "50012777";
		String propName = "天蓝色";

		Long propVid = propsHelper.getTmallVid(cid, propName);
		assertEquals("3232484", propVid.toString());
	}

	@Test
	public void testGetTmallPid() throws Exception {
		PropsHelper propsHelper = getMandatoryBean(PropsHelper.class,
				"propsHelper");

		String cid = "50012777";
		String propName = "货号";

		Long propPid = propsHelper.getTmallPid(cid, propName);
		assertEquals("2100010", propPid.toString());
	}

	@Test
	public void testGetTranslatedPropPairFromTmall() throws Exception{
		PropsHelper propsHelper = getMandatoryBean(PropsHelper.class,
				"propsHelper");
		String cid = "50012777";
		String propName = "品牌:安莉芳";

		String translatedProps = propsHelper.getTranslatedPropPairFromTmall(
				cid, propName);
		assertEquals("20000:29974", translatedProps);

	}
	
	@Test
	public void testTranslateProperties() throws Exception{
		PropsHelper propsHelper = getMandatoryBean(PropsHelper.class,
				"propsHelper");
		String cid = "50012777";
		String props = "品牌:猫人;颜色分类:天蓝色;厚度:加厚;面料材质:真丝";
		String customProps = "2100010:1235"; // means 货号:1235
		String translatedProps = propsHelper.translateProperties(cid, props);
		System.out.println("translatedProps=="+translatedProps);
		assertEquals("20000:107436;1627207:3232484;2048128:113060;2048150:28348;", translatedProps);
	}
}
