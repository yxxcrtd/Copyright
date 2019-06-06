package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.CrmPeTypeProp;

public interface CrmPeTypePropService extends BaseService {

	public void updateCrmPeTypeProp(CrmPeTypeProp obj, String id, String[] properties) throws Exception;
	
	public void insertCrmPeTypeProp(CrmPeTypeProp obj) throws Exception;
	
	public void deletetCrmPeTypeProp(CrmPeTypeProp obj) throws Exception;
	
    public List<CrmPeTypeProp> getPagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;
	
	public Integer getCount(Map<String, Object> condition) throws Exception;
	
	public CrmPeTypeProp getCrmPeTypeProp(String id) throws Exception;
	
	 public List<CrmPeTypeProp> getList(Map<String,Object> condition,String sort)throws Exception;
	 
	 public boolean orderUnique(String id,String order,String tid)throws Exception;
	 
		public List<CrmPeTypeProp> getListForInsert(
				Map<String, Object> condition, String sort) throws Exception;
	
	
}
