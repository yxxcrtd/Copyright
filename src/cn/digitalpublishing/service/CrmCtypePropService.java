package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.CrmCtypeProp;

public interface CrmCtypePropService extends BaseService {

	public void updateCrmCtypeProp(CrmCtypeProp obj, String id, String[] properties) throws Exception;
	
	public void insertCrmCtypeProp(CrmCtypeProp obj) throws Exception;
	
	public void deletetCrmCtypeProp(CrmCtypeProp obj) throws Exception;
	
    public List<CrmCtypeProp> getPagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;
	
	public Integer getCount(Map<String, Object> condition) throws Exception;
	
	public CrmCtypeProp getCrmCtypeProp(String id) throws Exception;
	
	 public List<CrmCtypeProp> getList(Map<String,Object> condition,String sort)throws Exception;
	 
	 public boolean orderUnique(String id,String order,String tid)throws Exception;
	 
		public List<CrmCtypeProp> getListForInsert(
				Map<String, Object> condition, String sort) throws Exception;
	
	//假删除
	public void  falseDel(String id) throws Exception; 
	
	/**
	 * 添加公司类型属性和公司属性
	 * 
	 * @param obj 公司类型属性对象
	 * @param tid 公司类型id
	 * @throws Exception
	 */
	public void addCrmCtypeProp(CrmCtypeProp obj, String tid) throws Exception;
}
