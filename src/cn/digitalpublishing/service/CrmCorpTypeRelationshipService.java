package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;
import cn.digitalpublishing.po.CrmCorp;
import cn.digitalpublishing.po.CrmCorpTypeRelationship;

public interface CrmCorpTypeRelationshipService {

	void insert(CrmCorpTypeRelationship obj) throws Exception;

	void update(CrmCorpTypeRelationship obj) throws Exception;

	List<CrmCorp> getCorpTreeNodes(String parentCorpId, String corpTypeId) throws Exception;
	
	public List<CrmCorpTypeRelationship> getPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws Exception;
	
	public Integer getCount (Map<String,Object> condition, String sort) throws Exception;

    public List<CrmCorpTypeRelationship> getAllCrmCorpType(Map<String,Object> condition, String sort) throws Exception;
    
    public List<CrmCorpTypeRelationship> getList(Map<String, Object> condition, String sort) throws Exception;
}