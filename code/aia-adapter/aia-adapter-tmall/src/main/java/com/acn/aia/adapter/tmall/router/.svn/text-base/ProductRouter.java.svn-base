package com.acn.aia.adapter.tmall.router;

import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.acn.aia.biz.service.api.ProductService;
import com.acn.aia.biz.service.domain.Product;
import com.acn.aia.core.su.core.Callback;

/**
 * Listening on the specific queue name and post the normalized Product to Tmall store.
 * @author fei.zhu
 * */
public class ProductRouter extends RouteBuilder implements Callback{
	@Autowired
	private ProductService productService;
	private String productQueue;

	@Override
	public void configure() throws Exception {
		from("jms:"+productQueue).process(new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {
				List<Map<String, Object>> productList = exchange.getIn().getBody(List.class);
				for (int i = 0; i < productList.size(); i++) {
					Map<String, Object> productRow = productList.get(i);
					Product product = (Product)productRow.get(Product.class.getName());
					productService.loadProduct(product);
				}
				List<Product> products = productService.sync();
			}
		}).to("direct:end");
	}

	public void setProductQueue(String productQueue) {
		this.productQueue = productQueue;
	}

	@Override
	public void callback() {
		// TODO Auto-generated method stub
		
	}
}
