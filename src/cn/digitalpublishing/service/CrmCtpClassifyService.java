package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.CrmCtpClassify;

public interface CrmCtpClassifyService extends BaseService {

	public void updateCrmCtpClassify(CrmCtpClassify obj, String id, String[] properties) throws Exception;
	
	public void insertCrmCtpClassify(CrmCtpClassify obj) throws Exception;
	
	public void deleteCrmCtpClassify(String id) throws Exception;
	
    public List<CrmCtpClassify> getPagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;
	
	public Integer getCount(Map<String, Object> condition) throws Exception;
	
	public CrmCtpClassify getCrmCtpClassify(String id) throws Exception;
	
	public CrmCtpClassify getCrmCtpClassifyByCode(String code) throws Exception;
	
	public List<CrmCtpClassify> getList(Map<String,Object> condition)throws Exception;
	 
	public boolean orderUnique(String id,Integer order,String tid)throws Exception;
	
	public void realDelete(String id)throws Exception;
}
