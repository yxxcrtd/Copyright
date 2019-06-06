package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.CrmPerson;
import cn.digitalpublishing.po.CrmPersonType;
import cn.digitalpublishing.po.CrmPersonTypeRelationship;
import cn.digitalpublishing.springmvc.form.CrmPersonInfoForm;

public interface CrmPersonService extends BaseService {

	public CrmPerson getCrmPerson(String id) throws Exception;
	
	public void updateCrmPerson(CrmPerson obj, String id, String[] properties) throws Exception;
	
	public void insertCrmPerson(CrmPersonInfoForm form)throws Exception;
	
	public List<CrmPersonTypeRelationship> getPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws Exception;
	
	public List<CrmPersonTypeRelationship> getList(Map<String,Object> condition,String sort) throws Exception;
	
	public Integer getCount (Map<String,Object> condition, String sort) throws Exception;
	
	public CrmPerson getCrmPersonByName(Map<String,Object> condition) throws Exception;
	
	public CrmPerson getCrmPersonByCode(Map<String,Object> condition) throws Exception;
	
	/**
	 * 获取非当前人员类型可用的人员信息
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public List<CrmPerson> getAvailablePersonCode(CrmPersonType type) throws Exception;
	
	/**
	 * 获取当前人员类型可用的人员信息
	 * 
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public List<CrmPerson> getAvailableEmployeePerson(CrmPersonType type)
			throws Exception;
	
	public boolean checkCodeIsAvailable(CrmPerson person) throws Exception;
	
	public void addTab(CrmPersonInfoForm form) throws Exception;
}
