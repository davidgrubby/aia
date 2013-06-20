package com.acn.aia.biz.service.api;

import java.util.List;

import com.acn.aia.biz.service.domain.Product;
import com.acn.aia.biz.service.exception.ProductException;

/**
 * Product business services
 * @author fei.zhu
 * */
public interface ProductService {
	
	/**
	 * Load product 
	 * */
	public List<Product> loadProduct(Product product) throws ProductException;

	/**
	 * Parse product information to <p>Product</p>
	 * */
	//public Product parse(List<String> columnsPerRow);
	
	/**
	 * Synchronize the products which to be synchronized to target end point
	 * */
	public List<Product> sync() throws ProductException;
}
