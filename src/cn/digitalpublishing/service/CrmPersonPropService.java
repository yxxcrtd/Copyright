package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.CrmPersonProp;

public interface CrmPersonPropService extends BaseService {

	public void updatePersonProp(CrmPersonProp obj, String id, String[] properties) throws Exception;
	
	public void insertPersonProp(CrmPersonProp obj) throws Exception;
	
	public void deletetPersonProp(CrmPersonProp obj) throws Exception;
	
    public List<CrmPersonProp> getPagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;
	
	public Integer getCount(Map<String, Object> condition) throws Exception;
	
	public CrmPersonProp getPersonProp(String id) throws Exception;
	
	 public List<CrmPersonProp> getList(Map<String,Object> condition,String sort)throws Exception;
	
}
