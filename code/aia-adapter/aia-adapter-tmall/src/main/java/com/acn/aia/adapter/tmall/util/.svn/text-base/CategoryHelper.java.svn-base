package com.acn.aia.adapter.tmall.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.acn.aia.adapter.tmall.TmallClient;
import com.taobao.api.ApiException;
import com.taobao.api.domain.Brand;
import com.taobao.api.domain.ItemCat;
import com.taobao.api.request.ItemcatsAuthorizeGetRequest;
import com.taobao.api.request.ItemcatsGetRequest;
import com.taobao.api.response.ItemcatsAuthorizeGetResponse;
import com.taobao.api.response.ItemcatsGetResponse;

/**
 * Tmall category helper utility
 * 
 * @author fei.zhu
 * */
public class CategoryHelper {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TmallClient tmallClient;

	private List<Brand> authorizedBrandsCache = new ArrayList<Brand>();
	private List<ItemCat> authorizedCategoriesCache = new ArrayList<ItemCat>();

	/**
	 * Return the list of authorized brands which belong to this merchant
	 * */
	public List<Brand> getAuthorizedBrands() throws ApiException {
		if (authorizedBrandsCache == null || authorizedBrandsCache.isEmpty()) {
			retrieveAuthorizedCategoriesFromTmall();
		}
		return this.authorizedBrandsCache;
	}

	public List<ItemCat> getAuthorizedCategories() throws ApiException {
		if (authorizedCategoriesCache == null || authorizedCategoriesCache.isEmpty()) {
			retrieveAuthorizedCategoriesFromTmall();
		}

		return this.authorizedCategoriesCache;
	}

	/**
	 * Get Tmall category id by specifying category title.
	 * 
	 * */
	public String findCidByTitle(String title)  {
		if (title == null) {
			logger.error(">>>Title is null");
			return null;
		}

		String categoryId = "";
		List<ItemCat> categories = null;
		try {
			//Read from cache
			categories = this.getAuthorizedCategories();
		} catch (ApiException e) {
			logger.error(">>> Retrieve authorized categories Error.",e);
		}
		
		if( categories == null || categories.isEmpty() ) {
			logger.error(">>> Cannot find any authorized categories available on Tmall.");
			return null;
		}
		
		for( ItemCat ic: categories ) {
			if( ic.getName().equals( title ) ) {
				categoryId = ic.getCid().toString();
				break;
			}
		}
		return categoryId;
	}

	/**
	 * Get all authorized categories/brands from Tmall by given sessionkey.
	 * */
	private void retrieveAuthorizedCategoriesFromTmall() throws ApiException {
		ItemcatsAuthorizeGetRequest req = new ItemcatsAuthorizeGetRequest();
		req.setFields("brand.vid,brand.name,item_cat.cid,item_cat.name,item_cat.status,item_cat.sort_order,item_cat.parent_cid,item_cat.is_parent");
		ItemcatsAuthorizeGetResponse response = tmallClient.execute(req);

		if (response != null) {
			logger.debug("Cache data...");
			authorizedBrandsCache = response.getSellerAuthorize().getBrands();
			
			if( response.getSellerAuthorize().getItemCats() == null || response.getSellerAuthorize().getItemCats().isEmpty() ) {
				logger.error("This merchant has no available authorized category.");
				return;
			}
			this.authorizedCategoriesCache.addAll(recurseChildCategory( response.getSellerAuthorize().getItemCats() ));
		}
	}
	
	/**
	 * retrieve child categories from Tmall.
	 * */
	private List<ItemCat> recurseChildCategory( List<ItemCat>  categories ) throws ApiException {
		List<ItemCat> tempCategories = new ArrayList<ItemCat>();
		for( ItemCat ic : categories ) 
			if( ic.getIsParent() ) {
				ItemcatsGetRequest req=new ItemcatsGetRequest();
				req.setFields("cid,parent_cid,name,is_parent");
				req.setParentCid( ic.getCid() );
				ItemcatsGetResponse response = tmallClient.execute(req);
				tempCategories.addAll( recurseChildCategory( response.getItemCats() ) ); 
			} else 
				tempCategories.add(ic);

		return tempCategories;
	}
	
	/**
	 * Check if the specified category is authorized
	 * */
	public boolean isAuthorziedCategory(String categoryId) {
		return false;
	}
	
	public boolean isAuthorizedBrand(String brand) {
		return false;
	}

}
