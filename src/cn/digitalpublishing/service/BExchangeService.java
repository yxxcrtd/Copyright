package cn.digitalpublishing.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.BExchange;

public interface BExchangeService extends BaseService {

	/**
	 * 汇率信息   分页
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public List<BExchange> getPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws Exception;
	
	/**
	 * 汇率信息
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public List<BExchange> getList(Map<String,Object> condition,String sort) throws Exception;
	
	
	/**
	 * 获取 汇率信息总数
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public Integer getCount (Map<String,Object> condition, String sort) throws Exception;
	
	/**
	 * 新增汇率信息
	 * @param obj
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public void insertBExchange(BExchange obj) throws Exception;
	/**
	 * 更新汇率信息
	 * @param obj
	 * @param className
	 * @param id
	 * @param properties
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public void updateBExchange(Object obj,String className,Serializable id,String[] properties) throws Exception;
	
	
	/**
	 * 获取汇率信息
	 * @param id
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public BExchange getBExchange (String id ) throws Exception;
	
	/**
	 * 更新汇率信息
	 * @param obj
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public void deleteBExchange(BExchange obj) throws Exception;
	
}
