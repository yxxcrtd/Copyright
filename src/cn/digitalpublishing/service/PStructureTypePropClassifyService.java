package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;
import cn.digitalpublishing.po.PStructureTypePropClassify;

public interface PStructureTypePropClassifyService extends BaseService {

	public void updatePStructureTypePropClassify(PStructureTypePropClassify obj, String id, String[] properties) throws Exception;
	
	public void insertPStructureTypePropClassify(PStructureTypePropClassify obj) throws Exception;
	
	public void deletePStructureTypePropClassify(PStructureTypePropClassify classify) throws Exception;
	
    public List<PStructureTypePropClassify> getPagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;
	
	public Integer getCount(Map<String, Object> condition) throws Exception;
	
	public PStructureTypePropClassify getPStructureTypePropClassify(String id) throws Exception;
	
	public PStructureTypePropClassify getPStructureTypePropClassifyByCode(String code) throws Exception;
	
	public List<PStructureTypePropClassify> getList(Map<String,Object> condition)throws Exception;
	 
	public boolean orderUnique(String id,Integer order,String tid)throws Exception;
	
	public void realDelete(String id)throws Exception;
}