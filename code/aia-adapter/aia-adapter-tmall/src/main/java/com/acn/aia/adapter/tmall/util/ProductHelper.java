package com.acn.aia.adapter.tmall.util;

import java.io.File;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.acn.aia.adapter.tmall.TmallClient;
import com.acn.aia.biz.service.domain.Product;
import com.acn.aia.biz.service.exception.ProductException;
import com.taobao.api.ApiException;
import com.taobao.api.FileItem;
import com.taobao.api.domain.Item;
import com.taobao.api.request.ItemAddRequest;
import com.taobao.api.request.ProductAddRequest;
import com.taobao.api.response.ItemAddResponse;
import com.taobao.api.response.ProductAddResponse;

/**
 * Tmall Product Utility
 * 
 * @author fei.zhu
 * */
public class ProductHelper {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TmallClient tmallClient;
	/**
	 * A particular field as it is required as user input<b> and the value
	 * cannot be duplicated.
	 * */
	// TODO hard code, need to optimize.
	private static String CARGO_NUM = "货号";

	@Autowired
	private CategoryHelper categoryHelper;
	@Autowired
	private PropsHelper propsHelper;

	/**
	 * Create add new product request by given product.
	 * */
	private ProductAddRequest buildNewProductRequest(Product product)
			throws ProductException {
		if (product == null) {
			logger.error(">>>Product is null");
			return null;
		}

		if (product.getCategoryId() == null) {
			logger.error("Tmall product category is null");
			return null;
		}
		ProductAddRequest tbProduct = new ProductAddRequest();

		// Category
		// By mapping category title, return the category id from Tmall.
		String tmallCategoryId = categoryHelper.findCidByTitle(product.getCategoryTitle());
		if (tmallCategoryId == null || "".equals(tmallCategoryId))
			throw new ProductException("Cannot find any category available on Tmall, category title:"+ product.getCategoryTitle());
		tbProduct.setCid(Long.parseLong(tmallCategoryId));

		// Additional description for product i.e. color:red;size:XL
		String productProperties = product.getProperties();
		String props = propsHelper.translateProperties(tmallCategoryId,productProperties);
		//if (props == null || "".equals(props))
			//throw new ProductException(">>>Cannot find any property available on Tmall, category title:"+ product.getCategoryTitle());
		tbProduct.setProps(props);// set properties

		tbProduct.setPrice(product.getPrice());
		tbProduct.setName(product.getProductTitle());
		tbProduct.setDesc(product.getDescription());
		tbProduct.setOuterId(product.getProductId());

		// Handle custom tags which are madatory fields to upload a product per
		// TOP API
		Long cargoPid = propsHelper.getTmallPid(tmallCategoryId, CARGO_NUM);
		
		if( cargoPid != null ) {
			String cargoNumPid = cargoPid== null ? "": cargoPid.toString();
			String customProperties = cargoNumPid + ":" + product.getProductId();
			tbProduct.setCustomerProps(customProperties);
		}
		

		// Handle major image
		String imageUrl = product.getMainImageUrl();
		final FileItem images = new FileItem(imageUrl);
		tbProduct.setImage(images);
		tbProduct.setMarketTime(new Date());

		return tbProduct;
	}

	/**
	 * build tmall request object by given parameters.
	 * */
	private ItemAddRequest buildNewItemRequest( Long tmallProductId, Product product) 
			throws ProductException {
		ItemAddRequest req = new ItemAddRequest();
		try {
			req.setNum(Long.parseLong(product.getQuantity()));
		} catch (Exception e) {
			throw new ProductException("Format error: product quantity:"+ product.getQuantity());
		}
		req.setPrice(product.getPrice());
		req.setType("fixed");
		req.setStuffStatus("new");
		req.setTitle(product.getProductTitle());
		req.setDesc(product.getDescription());

		// TODO Should provide valid State and City information by Taobao
		// database.
		// Hard code for now.
		req.setLocationState("浙江");
		req.setLocationCity("杭州");
		req.setApproveStatus("onsale");
		
		String tmallCategoryId = categoryHelper.findCidByTitle(product.getCategoryTitle());
		if (tmallCategoryId == null || "".equals(tmallCategoryId))
			throw new ProductException(">>>Cannot find any category available on Tmall, category title:"+ product.getCategoryTitle());
		req.setCid(Long.parseLong(tmallCategoryId));
		
		req.setProps( propsHelper.translateProperties(tmallCategoryId.toString() ,product.getProperties() ));
		// Indicator who takes over shipment fee, options: seller, buyer
		req.setFreightPayer("buyer");
		// valid day, default 14 days
		// req.setValidThru(7L);
		req.setHasInvoice(true);
		req.setHasWarranty(true);
		req.setHasShowcase(true);
		
		//TODO should provide valid navigation category id 
		// req.setSellerCids("1101,1102,1103");
		req.setHasDiscount(true);
		req.setPostFee("5.07");
		req.setExpressFee("15.07");
		req.setEmsFee("25.07");
		// schedule specific time to be avalible to buyer.
		/*Date dateTime = SimpleDateFormat.getDateTimeInstance().parse(
				"2000-01-01 00:00:00");
		req.setListTime(dateTime);*/
		// req.setIncrement("2.50");
		FileItem fItem = new FileItem(new File( product.getMainImageUrl() ));
		req.setImage(fItem);
		// TODO To be provided valid delivery expense template
		// req.setPostageId(775752L);
		req.setAuctionPoint(5L);
		//req.setPropertyAlias("pid:vid:别名;pid1:vid1:别名1");
		// TODO To be done, user self input fields under this category
		// Hard code, only Cargo number is must have
		req.setInputPids( propsHelper.getTmallPid( tmallCategoryId.toString(), CARGO_NUM).toString() );
		req.setInputStr( product.getProductId() );
		/*req.setSkuProperties("pid:vid;pid:vid");
		req.setSkuQuantities("2,3,4");
		req.setSkuPrices("200.07");
		req.setSkuOuterIds("1234,1342");*/
		req.setLang( product.getLocale() );
		req.setOuterId( product.getProductId() );
		req.setProductId( tmallProductId );
		//req.setPicPath("i7/T1rfxpXcVhXXXH9QcZ_033150.jpg");
		req.setIsTaobao(true);
		req.setIsEx(true);
		req.setIs3D(true);
		req.setSellPromise(true);
		// TODO, to provide after sales template id.
		//req.setAfterSaleId(47758L);
		// TODO to provide valid COD template.
		//req.setCodPostageId(53899L);
		req.setIsLightningConsignment(true);
		//req.setWeight(100L);
		/*req.setIsXinpin(false);
		req.setSubStock(1L);
		req.setFoodSecurityPrdLicenseNo("QS410006010388");
		req.setFoodSecurityDesignCode("Q/DHL.001-2008");
		req.setFoodSecurityFactory("远东恒天然乳品有限公司");
		req.setFoodSecurityFactorySite("台北市仁爱路4段85号");
		req.setFoodSecurityContact("00800-021216");
		req.setFoodSecurityMix("有机乳糖、有机植物油");
		req.setFoodSecurityPlanStorage("常温");
		req.setFoodSecurityPeriod("2年");
		req.setFoodSecurityFoodAdditive("磷脂 、膨松剂");
		req.setFoodSecuritySupplier("深圳岸通商贸有限公司");
		req.setFoodSecurityProductDateStart("2012-06-01");
		req.setFoodSecurityProductDateEnd("2012-06-10");
		req.setFoodSecurityStockDateStart("2012-06-20");
		req.setFoodSecurityStockDateEnd("2012-06-30");
		req.setGlobalStockType("1");
		req.setScenicTicketPayWay(1L);
		req.setScenicTicketBookCost("5.99");
		req.setItemSize("bulk:8");
		req.setItemWeight("10");
		req.setLocalityLifeChooseLogis("0");
		req.setLocalityLifeExpirydate("2012-08-06,2012-08-16");
		req.setLocalityLifeNetworkId("5645746");
		req.setLocalityLifeMerchant("56879:码商X");
		req.setLocalityLifeVerification("101");
		req.setLocalityLifeRefundRatio(50L);
		req.setLocalityLifeOnsaleAutoRefundRatio(80L);
		req.setPaimaiInfoMode(1L);
		req.setPaimaiInfoDeposit(20L);
		req.setPaimaiInfoInterval(5L);
		req.setPaimaiInfoReserve("11");
		req.setPaimaiInfoValidHour(2L);
		req.setPaimaiInfoValidMinute(22L);*/
		return req;
	}
	
	
	/**
	 * Upload product to Taobao by Open API<br>
	 * */
	public com.taobao.api.domain.Product createNewProduct(Product product) throws ProductException {
		com.taobao.api.domain.Product uploadedProduct = new com.taobao.api.domain.Product();
		try {
			ProductAddRequest tbProduct = buildNewProductRequest(product);
			ProductAddResponse response = tmallClient.execute(tbProduct);
			uploadedProduct = response.getProduct();
			
			// As Tmall merchant, it's MUST to have product created first, <br>
			// and then create merchandise associate with product
			if (uploadedProduct.getProductId() == null || 0 == uploadedProduct.getProductId()) {
				logger.error(">>> Upload product FAILED :"+ uploadedProduct.getName());
				throw new ProductException("Upload product failed:" + product );
			} else  {
				logger.info(">>>Upload product SUCCESS :" + product + "  Tmall product id :" + uploadedProduct.getProductId());
			}
		} catch (ApiException e) {
			logger.error(">>>" + e.getErrCode() + ":" + e.getErrMsg(), e);
			throw new ProductException(e);
		}
		return uploadedProduct;
	}
	
	/**
	 * To save a merchandise on Tmall. 
	 * @param product to be convert to tmall merchandise
	 * @param tmallProductId product id on TMall to be assiociated with this merchandise.
	 * */
	public Item createNewMerchandise(Long tmallProductId,Product  product) throws ProductException {
		ItemAddRequest uploadItem = buildNewItemRequest( tmallProductId, product);
		Item newItem = null;
		try{
			ItemAddResponse response = tmallClient.execute( uploadItem );
			newItem = response.getItem();
			if ( newItem == null ) {
				logger.error(">>> Upload Item FAILED :"+ product );
				throw new ProductException("Upload product failed:" + product );
			} else  {
				logger.info(">>>Upload merchandise SUCCESS, item id: :" + newItem.getNumIid() );
			}
		}catch (ApiException e) {
			throw new ProductException(e);
		}
		return newItem;
	}
}
