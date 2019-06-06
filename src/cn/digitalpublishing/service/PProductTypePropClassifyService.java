package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;
import cn.digitalpublishing.po.PProductTypePropClassify;

public interface PProductTypePropClassifyService extends BaseService {
	
	public void updateClassify(PProductTypePropClassify obj, String id, String[] properties) throws Exception;
	
	public void insertClassify(PProductTypePropClassify obj) throws Exception;
	
	public void deleteClassify(String id) throws Exception;
	
    public List<PProductTypePropClassify> getClassifyPagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;
	
	public Integer getClassifyCount(Map<String, Object> condition) throws Exception;
	
	public PProductTypePropClassify getClassify(String id) throws Exception;
	
	public PProductTypePropClassify getClassifyByCode(String code) throws Exception;
	
	public List<PProductTypePropClassify> getClassifyList(Map<String,Object> condition)throws Exception;
	 
	public boolean orderUnique(String id,Integer order,String tid)throws Exception;
	
	public void realDelete(String id)throws Exception;
}
