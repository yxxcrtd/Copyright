package cn.digitalpublishing.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import cn.digitalpublishing.po.CrmCorpType;

public interface CrmCorpTypeService extends BaseService {
	
	public void updateCorpType(CrmCorpType obj, String id, String[] properties) throws Exception;
	
	public void insertCorpType(CrmCorpType obj) throws Exception;
	
	public void deletecCorpType(String id) throws Exception;
	
    public List<CrmCorpType> getCorpTypePagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;
   /**
    * 获取产品类型tree
    * @param condition
    * @param sort
    * @return
    * @throws Exception
    */
    public List<CrmCorpType> getCorpTypeTreeList(Map<String,Object> condition,String sort)throws Exception;
	
	public Integer getCorpTypeCount(Map<String, Object> condition) throws Exception;
	
	public CrmCorpType getCorpType(String id) throws Exception;
	
	public CrmCorpType getCorpTypeByCode(String code) throws Exception;
	
	/**
	 * 验证code是否唯一
	 * @param id
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public boolean codeUnique(String id,String code)throws Exception;	
	
	//假删除
	public void falseDel(String id) throws Exception;
	
	
	
	public void upload(String corpTypeId, InputStream is) throws Exception;
}