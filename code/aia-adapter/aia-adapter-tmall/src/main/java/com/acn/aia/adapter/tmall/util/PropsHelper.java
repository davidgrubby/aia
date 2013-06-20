package com.acn.aia.adapter.tmall.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.acn.aia.adapter.tmall.TmallClient;
import com.acn.aia.biz.service.exception.ProductException;
import com.acn.aia.core.utils.StringUtil;
import com.taobao.api.ApiException;
import com.taobao.api.domain.ItemProp;
import com.taobao.api.domain.PropValue;
import com.taobao.api.request.ItempropsGetRequest;
import com.taobao.api.response.ItempropsGetResponse;

/**
 * TOP Props utility.
 * 
 * @author fei.zhu
 * */
public class PropsHelper {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TmallClient tmallClient;
	
	//Cache the item properties.
	private Map<String,Map<String, ItemProp>> itemPropsCache = new HashMap<String, Map<String,ItemProp>>();
	private Map<String,Map<String, Long>> propValuesCache = new HashMap<String, Map<String,Long>>();
	
	/**
	 * Specify the value and return the corresponding property id from Tmall.
	 * 
	 * @param cid category id provided by Tmall
	 * @param propTitle
	 * */
	public Long getTmallPid( String cid , String propName) throws ProductException {
		if( StringUtil.isEmpty( cid )){
			logger.error(">>> Category id cannot be null.");
			return null;
		}
		
		if( !this.itemPropsCache.containsKey( cid ) ) {
			reloadProps(cid);
		}
		
		Map<String, ItemProp> itemProps = this.itemPropsCache.get( cid );
		if( itemProps == null || itemProps.isEmpty() ) {
			logger.error("Property ID cannot be found on Tmall.");
			return null;
		}
		
		Long propValue = itemProps.get(propName).getPid();
		
		return propValue;
	}
	
	public Long getTmallVid(String cid, String propName) throws ProductException {
		if( StringUtil.isEmpty( cid )){
			logger.error(">>> Category id cannot be null.");
			return null;
		}
		
		if( !this.propValuesCache.containsKey( cid ) ) {
			reloadProps(cid);
		}
		
		
		Map<String, Long> propValues= this.propValuesCache.get( cid );
		if( propValues == null || propValues.isEmpty() ) {
			logger.error(">>> Prop values cannot be found on Tmall.");
			return null;
		}
		
		Long propValue = propValues.get(propName);
		
		return propValue;
	}
	
	private void reloadProps(String cid ) throws ProductException{
		ItempropsGetRequest req = new ItempropsGetRequest();
		req.setFields("pid,name,must,multi,prop_values,is_input_prop,is_key_prop,parent_pid,is_color_prop,is_enum_prop,is_input_prop,is_item_prop,child_path,type");
		req.setCid( Long.parseLong( cid ) );

		try {
			ItempropsGetResponse response = tmallClient.execute(req);
			
			if( response == null || response.getItemProps() == null || response.getItemProps().isEmpty() ) {
				logger.error("No available properties returned from Tmall for category id"+cid);
				//throw new ProductException("No available properties returned from Tmall for category id:"+cid) ;
				return;
			}
			//put the search result to cache.
			add2Cache( cid, response.getItemProps() );
		} catch (ApiException e) {
			logger.error("Retrieve props response error.", e);
			throw new ProductException(  e ) ;
		}
	}

	/**
	 * Get corresponding property values by tags.<br>
	 * Tags could be constructed as xxx:xxx;xxx:xxx. <br>
	 * Error will be returned if format is wrong.
	 * */
	public String translateProperties(String cid, String properties) throws ProductException{
		if (StringUtil.isEmpty(properties)) {
			logger.error(">>>tags is null");
			return null;
		}

		String[] arrayOfTags = StringUtil.stringToArray(properties, ";");
		if (arrayOfTags == null || arrayOfTags.length == 0) {
			logger.error(">>> no available tags or format is incorrect.");
			return null;
		}

		String translatedProps = "";
		// loop the array of tags and map to property value and put into a new
		// array.
		for (String tagPair : arrayOfTags) {
			String translatedPair = getTranslatedPropPairFromTmall(cid, tagPair);
			if (translatedPair == null || "".equals(translatedPair))
				continue;

			translatedProps += translatedPair + ";";
		}

		return translatedProps;
	}
	
	/**
	 * Refresh cache
	 * */
	private void add2Cache( String cid, List<ItemProp> itemProps) {
		if( itemProps == null || itemProps.isEmpty() ) 
			return;
		
		Map<String, ItemProp> ipMap = new HashMap<String,ItemProp>();
		Map<String, Long> valueMap = new HashMap<String, Long>();
		for( ItemProp ip : itemProps ) {
			ipMap.put( ip.getName() ,  ip );
			
			if( ip.getPropValues() != null && !ip.getPropValues().isEmpty() )
				for( PropValue pv : ip.getPropValues() ) {
					valueMap.put( pv.getName() ,  pv.getVid() );
				}
		}
		
		this.itemPropsCache.put( cid ,  ipMap );
		this.propValuesCache.put(cid,  valueMap );
	}

	public String getTranslatedPropPairFromTmall(String cid, String pair) throws ProductException {
		if (StringUtil.isEmpty(pair))
			return null;

		// Pair should contains ':'
		if (!StringUtil.isContains(pair, ":"))
			return null;

		String translatedPair = "";

		String[] kv = StringUtil.stringToArray(pair, ":");

		// pair is definitely has two strings.
		if (kv.length != 2)
			return null;

		
		// Obtain property id 
		String keyPropValue =kv[0];
		Long pid = getTmallPid( cid, keyPropValue);
		
		// Obtain property value id.
		String valuePropValue = kv[1];
		Long vid = getTmallVid( cid, valuePropValue );
		
		if( pid!= null && vid != null ) 
			translatedPair = pid + ":" + vid;

		return translatedPair;
	}
	
	
	/**
	 * 
	 * */
	public String getSynonym(String orginalProp) {
		//TODO
		return "";
	}
}
