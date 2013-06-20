package com.acn.aia.core.utils.annotation.c91;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

public class AnnotationTest {
	@CxyAnnotation(title = "名字", descript = "记录用户姓名")
	public String name = "";

	public static void main(String[] args) throws Exception {
		Date d = new Date();
		d.getYear(); // 这个Date方法被划伤了横线 代买这个方法已经过时
		oldMethod(); // 这个自定义的方法 被打上了过时方法的标记 @Deprecated
		System.out.println("====================");

		Annotation[] aArray = AnnotationTest.class.getField("name").getAnnotations();
		// 为了演示方便这里我知道肯定会有一个CxyAnnotation在数组的第一个 所以直接取，实际工作中请使用遍历去判断
		Annotation na = aArray[0];
		System.out.println("成员变量name的扩展信息:");
		System.out.println("name代表:" + ((CxyAnnotation) na).title());
		System.out.println("name具体描述:" + ((CxyAnnotation) na).descript());

	}

	// 检查父类是否有一个这样的方法让子类重写。
	@Override
	public String toString() {
		return "AnnotationTest [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	// 标记这个方法已经过时
	@Deprecated
	public static void oldMethod() {
		System.out.println("这个方法已经过时了");
	}

}

// 自己定义的一个Annotation
@Retention(RetentionPolicy.RUNTIME)
// 保留注释到程序运行
@Target(ElementType.FIELD)
// 这个annotation是标记在field上的
@interface CxyAnnotation {
	String title();
	String descript();
}
