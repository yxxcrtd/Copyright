package cn.digitalpublishing.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.BCountry;

public interface BCountryService  extends BaseService{

	/**
	 * 国别信息   分页
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public List<BCountry> getPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws Exception;
	
	/**
	 * 国别信息
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public List<BCountry> getList(Map<String,Object> condition,String sort) throws Exception;
	
	
	/**
	 * 获取 国别信息总数
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public Integer getCount (Map<String,Object> condition, String sort) throws Exception;
	
	/**
	 * 新增国别信息
	 * @param obj
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public void insert(BCountry obj) throws Exception;
	/**
	 * 更新国别信息
	 * @param obj
	 * @param className
	 * @param id
	 * @param properties
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public void update(Object obj,String className,Serializable id,String[] properties) throws Exception;
	
	
	/**
	 * 获取国家信息
	 * @param id
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public BCountry getBCountry (String id ) throws Exception;
	
	/**
	 * 更新国家信息
	 * @param obj
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public void update (BCountry obj) throws Exception;
	
	public boolean cnNameUnique (String cnName) throws Exception;
	public boolean enNameUnique (String enName) throws Exception;
}
