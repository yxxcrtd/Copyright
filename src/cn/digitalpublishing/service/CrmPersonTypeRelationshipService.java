package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.CrmPersonTypeRelationship;
import cn.digitalpublishing.springmvc.form.CrmPersonTypeRelationshipForm;

public interface CrmPersonTypeRelationshipService extends BaseService {
	
	public void insertCrmPersonTypeRelationship(CrmPersonTypeRelationshipForm form)throws Exception;
	
	//public void update(CrmPersonTypeRelationshipForm form)throws Exception;
	
	public CrmPersonTypeRelationship getCrmPersonTypeRelationship(String id) throws Exception;
	
	public CrmPersonTypeRelationship getByIds(Map<String,Object> condition) throws Exception;
	
	public List<CrmPersonTypeRelationship> getPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws Exception;
	
	public List<CrmPersonTypeRelationship> getList(Map<String,Object> condition,String sort) throws Exception;
	
	public Integer getCount (Map<String,Object> condition, String sort) throws Exception;
	
	public void delete(CrmPersonTypeRelationship personTypeRelationship) throws Exception;

	public void addTab(CrmPersonTypeRelationshipForm form) throws Exception;
	
	public void upload( String path, String personTypeId, String accountId) throws Exception;
}
