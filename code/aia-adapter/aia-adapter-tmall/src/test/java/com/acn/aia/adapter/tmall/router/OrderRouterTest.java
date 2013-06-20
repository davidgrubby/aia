package com.acn.aia.adapter.tmall.router;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.test.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderRouterTest extends CamelSpringTestSupport {

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("classpath:META-INF/spring/tmall-adapter.xml");
	}
	
	@Test
    public void testOrderRouter() throws Exception {
    	CamelContext context = new DefaultCamelContext();
    	OrderRouter orderRouter = getMandatoryBean(OrderRouter.class, "orderRouter");
		// connect to embedded ActiveMQ JMS broker
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://CDC311113:21212");
		context.addComponent("jms",JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		context.addRoutes( orderRouter );
		// start the route and let it do its work
		context.start();
		Thread.sleep(1000000);

		// stop the CamelContext
		context.stop();
    }

}
