package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;
import cn.digitalpublishing.po.PStructureTypeProp;

public interface PStructureTypePropService extends BaseService {

	public void updatePStructureTypeProp(PStructureTypeProp obj, String id, String[] properties) throws Exception;
	
	public void insertPStructureTypeProp(PStructureTypeProp obj) throws Exception;
	
	public void deletetPStructureTypeProp(PStructureTypeProp obj) throws Exception;
	
    public List<PStructureTypeProp> getPagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;
	
	public Integer getCount(Map<String, Object> condition) throws Exception;
	
	public PStructureTypeProp getPStructureTypeProp(String id) throws Exception;
	
	 public List<PStructureTypeProp> getList(Map<String,Object> condition,String sort)throws Exception;
	 
	 public boolean orderUnique(String id,String order,String tid)throws Exception;
	 
		public List<PStructureTypeProp> getListForInsert(
				Map<String, Object> condition, String sort) throws Exception;
	
	//假删除
	public void  falseDel(PStructureTypeProp obj) throws Exception; 
	
	/**
	 * 添加公司类型属性和公司属性
	 * 
	 * @param obj 公司类型属性对象
	 * @param tid 公司类型id
	 * @throws Exception
	 */
	public void addPStructureTypeProp(PStructureTypeProp obj, String tid) throws Exception;
}