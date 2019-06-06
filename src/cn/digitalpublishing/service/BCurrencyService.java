package cn.digitalpublishing.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.BCurrency;

public interface BCurrencyService extends BaseService {
	
	/**
	 * 币种信息   分页
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public List<BCurrency> getPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws Exception;
	
	/**
	 * 币种信息
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public List<BCurrency> getList(Map<String,Object> condition,String sort) throws Exception;
	
	
	/**
	 * 获取 币种信息总数
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public Integer getCount (Map<String,Object> condition, String sort) throws Exception;
	
	/**
	 * 新增币种信息
	 * @param obj
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public void insert(BCurrency obj) throws Exception;
	/**
	 * 更新币种信息
	 * @param obj
	 * @param className
	 * @param id
	 * @param properties
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public void update(Object obj,String className,Serializable id,String[] properties) throws Exception;
	
	
	/**
	 * 获取币种信息
	 * @param id
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public BCurrency getBCurrency (String id ) throws Exception;
	
	/**
	 * 更新币种信息
	 * @param obj
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public void update (BCurrency obj) throws Exception;
	
	public boolean currencyNameUnique(String currencyName) throws Exception;
}
