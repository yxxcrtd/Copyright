package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.BRegion;

public interface BRegionService extends BaseService{
	
	/**
	 * 获取地域信息列表
	 * @param conditin
	 * @param sort
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public List<BRegion> getList(Map<String,Object> condition ,String sort) throws  Exception;
	public List<BRegion> getListNoParent(Map<String,Object> condition ,String sort) throws  Exception;
	
	/**
	 * 加入新的地域信息
	 * @param condition
	 * @param sort
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public void insert(BRegion obj) throws Exception;

	/**
	 * 加入tree 节点
	 * @param obj
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public void insertRegion(BRegion obj) throws Exception;
	
	/**
	 * 过去 地域  对象
	 * @param id
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public BRegion getBRegion(String id) throws Exception;
	
	/**
	 * 更新地域信息
	 * @param obj
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public void  update(BRegion obj) throws Exception;

	/**
	 * 删除地域信息
	 * @param id
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 地域信息 数量
	 * @param condition
	 * @param sort
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public int getBRegionCount(Map<String,Object> condition,String sort) throws Exception;
	
	/**
	 * 验证地域信息  code  唯一
	 * @param code
	 * @param countryId
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public boolean codeUnique (String id,String code , String countryId) throws Exception;
	
}

