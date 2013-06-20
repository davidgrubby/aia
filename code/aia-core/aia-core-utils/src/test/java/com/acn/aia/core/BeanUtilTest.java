package com.acn.aia.core;

import junit.framework.Assert;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

public class BeanUtilTest {

	@Test
	public void testSetProperty() throws Exception {
		Person p = new Person();
		//p.setAge("15");
		BeanUtils.setProperty(p, "age", "15");
		Assert.assertEquals(p.getAge(), "15");
	}
}

class Person {
	private String name;
	private String age;
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}