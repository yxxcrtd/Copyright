package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.CrmPeTpClassify;

public interface CrmPeTpClassifyService extends BaseService {

	public void updateCrmPeTpClassify(CrmPeTpClassify obj, String id, String[] properties) throws Exception;
	
	public void insertCrmPeTpClassify(CrmPeTpClassify obj) throws Exception;
	
	public void deleteCrmPeTpClassify(String id) throws Exception;
	
    public List<CrmPeTpClassify> getPagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;
	
	public Integer getCount(Map<String, Object> condition) throws Exception;
	
	public CrmPeTpClassify getCrmPeTpClassify(String id) throws Exception;
	
	public CrmPeTpClassify getCrmPeTpClassifyByCode(String code) throws Exception;
	
	public List<CrmPeTpClassify> getList(Map<String,Object> condition)throws Exception;
	 
	public boolean orderUnique(String id,Integer order,String tid)throws Exception;
	
	public void realDelete(String id)throws Exception;
}
