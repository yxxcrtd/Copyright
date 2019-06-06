package cn.digitalpublishing.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import cn.digitalpublishing.po.CrmPersonType;

public interface CrmPersonTypeService extends BaseService {

	public void updateCrmPersonType(CrmPersonType obj, String id, String[] properties) throws Exception;
	
	public void insertCrmPersonType(CrmPersonType obj) throws Exception;
	
	public void deletetCrmPersonType(CrmPersonType obj) throws Exception;
	
    public List<CrmPersonType> getPagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;
    
	public Integer getCount(Map<String, Object> condition, String sort) throws Exception;
	
	public CrmPersonType getCrmPersonType(String id) throws Exception;
	
	public CrmPersonType getCrmPersonTypeByCode(String code) throws Exception;
	
	/**
	 * 验证code是否唯一
	 * @param id
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public boolean codeUnique(String id,String code)throws Exception;
	

	public void upload(String personTypeId, InputStream is) throws Exception;
	
	public List<CrmPersonType> getList(Map<String,Object> condition, String sort)throws Exception;
}
