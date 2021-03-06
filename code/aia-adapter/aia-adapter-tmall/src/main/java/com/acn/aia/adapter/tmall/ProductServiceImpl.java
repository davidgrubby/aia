package com.acn.aia.adapter.tmall;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.acn.aia.adapter.tmall.util.ProductHelper;
import com.acn.aia.biz.service.api.ProductService;
import com.acn.aia.biz.service.domain.Product;
import com.acn.aia.biz.service.exception.ProductException;
import com.taobao.api.domain.Item;

/**
 * Connect to TOP to transfer product data
 * 
 * @author fei.zhu
 * */
public class ProductServiceImpl implements ProductService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private List<Product> products;

	@Autowired
	private ProductHelper productHelper;

	/**
	 * Save or update by the given product to Tmall.
	 * */
	@Override
	public List<Product> sync( ) throws ProductException {
		List<Product> ret = new ArrayList<Product>();
		
		if( products == null || products.isEmpty() ) 
			throw new ProductException("No products to be synchronized.");
		
		for( Product product: products ) {
			if (product == null)
				return null;
			
			try {
				//Create product first
				logger.debug("Prepare create product on Tmall.");
				com.taobao.api.domain.Product tmallProduct = productHelper.createNewProduct(product);
				logger.debug("Product created successfuly.");
				
				//Create Item that can be associated with Product
				logger.debug("Prepare to create merchandise on Tmall.");
				Item tmallMerchandise = productHelper.createNewMerchandise(tmallProduct.getProductId() , product );
				logger.debug("Merchandise created successfully.");
				
				//TODO if item created unsuccessfully, delete product.
				// deleteProduct(tmallProductId);
				if( tmallMerchandise.getNumIid() != null ){
					product.setProductId( tmallMerchandise.getNumIid().toString() );
					ret.add(product);
				}
			} catch (ProductException e) {
				// TODO: handle exception
				continue;
			}
			
			
		}
		return ret;
	}

	@Override
	public List<Product> loadProduct(Product product) throws ProductException{
		if( products == null ) 
			products = new ArrayList<Product>();
		
		//TODO validate product category
		//TODO validate product brand
		
		products.add(product);
		return products;
	}
}
