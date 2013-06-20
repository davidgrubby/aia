/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.acn.aia.adapter.hybris;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acn.aia.adapter.hybris.router.ProductRouter;

/**
 * The same as InvokeWithProcessorTest but using Spring XML instead
 *
 * @version $Revision: 55 $
 */
public class ProductRouterTest extends CamelSpringTestSupport {

    @Override
    protected AbstractXmlApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("classpath:META-INF/spring/hybris-adapter.xml");
    }

    @Test
    public void testProductRouter() throws Exception {
    	CamelContext context = new DefaultCamelContext();

		// connect to embedded ActiveMQ JMS broker
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://CDC311113:21212");
		context.addComponent("jms",JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		
		context.addRoutes(new ProductRouter());

		// start the route and let it do its work
		context.start();
		Thread.sleep(10000);

		// stop the CamelContext
		context.stop();
    }

}
