package cn.digitalpublishing.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.CrmPeTpClassify;
import cn.digitalpublishing.po.CrmPeTypeProp;
import cn.digitalpublishing.po.CrmPerson;
import cn.digitalpublishing.po.CrmPersonProp;
import cn.digitalpublishing.po.CrmPersonType;
import cn.digitalpublishing.po.CrmPersonTypeRelationship;
import cn.digitalpublishing.service.CrmPersonService;
import cn.digitalpublishing.springmvc.form.CrmPersonInfoForm;
import cn.digitalpublishing.util.DicCache;

public class CrmPersonServiceImpl extends BaseServiceImpl implements CrmPersonService {

	@Override
	public CrmPerson getCrmPerson(String id) throws Exception {
		CrmPerson crmPerson = null;
		try {
			crmPerson = (CrmPerson) this.daoFacade.getCrmPersonDao().get(CrmPerson.class.getName(), id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "CrmPerson.getCrmPerson.error", e);
		}
		return crmPerson;
	}

	@Override
	public void updateCrmPerson(CrmPerson obj, String id, String[] properties)
			throws Exception {
		try {
			this.daoFacade.getCrmPersonDao().update(obj,CrmPerson.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
	}

	@Override
	public void insertCrmPerson(CrmPersonInfoForm form) throws Exception {
		String statusYes = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
		Map<String, Object> condition = form.getCondition();
		CrmPersonType personType = form.getPersonType();
		CrmPerson person = form.getObj();
		this.daoFacade.getCrmPersonDao().insert(person);

		CrmPersonTypeRelationship relationship = new CrmPersonTypeRelationship();
		relationship.setPersonType(personType);
		relationship.setPerson(person);
		this.daoFacade.getCrmPersonTypeRelationshipDao().insert(relationship);
		
		condition.clear();
		condition.put("status", statusYes);
		condition.put("personType_id", personType.getId());
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPeTypePropDao").get("getPersonTypePropList");
		
		List<CrmPeTypeProp> personTypePropList = this.daoFacade.getCrmPeTypePropDao().getPersonTypePropList(condition, hqlBean);
		List<CrmPersonProp> personPropList = new ArrayList<CrmPersonProp>();
		CrmPersonProp personProp = null;
		for (CrmPeTypeProp personTypeProp : personTypePropList) {
			personProp = new CrmPersonProp();
			personProp.setPersonTypeRelationship(relationship);
			personProp.setPersonTypeProp(personTypeProp);
			personProp.setCode(personTypeProp.getCode());
			personProp.setName(personTypeProp.getName());
			personProp.setOrder(personTypeProp.getOrder());
			personProp.setDisplay(personTypeProp.getDisplay());
			personProp.setMust(personTypeProp.getMust());
			personProp.setSource(personTypeProp.getSource());
			personProp.setStatus(statusYes);
			personPropList.add(personProp);
		}
		this.daoFacade.	getCrmPersonPropDao().getHibernateDao().saveOrUpdateAll(personPropList);
	}

	@Override
	public Integer getCount(Map<String, Object> condition, String sort)
			throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPersonTypeRelationshipDao").get("getCount");
		try {
			num = this.daoFacade.getCrmPersonTypeRelationshipDao().getCount(condition,hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}

	@Override
	public CrmPerson getCrmPersonByName(Map<String, Object> condition)
			throws Exception {
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PPersonDao").get("getByName");
		try {
			CrmPerson admin = this.daoFacade.getCrmPersonDao().getByName(condition, hqlBean);
			return admin;
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
	}
	
	@Override
	public CrmPerson getCrmPersonByCode(Map<String, Object> condition)
			throws Exception {
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPersonTypeRelationshipDao").get("getByCode");
		try {
			CrmPerson crmPerson = this.daoFacade.getCrmPersonTypeRelationshipDao().getByCode(condition, hqlBean);
			return crmPerson;
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
	}

	@Override
	public List<CrmPersonTypeRelationship> getPagingList(
			Map<String, Object> condition, String sort, Integer pageCount,
			Integer page) throws Exception {
		List<CrmPersonTypeRelationship> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPersonTypeRelationshipDao").get("getPagingList");
		try{
			list=this.daoFacade.getCrmPersonTypeRelationshipDao().getPagingList(condition,sort,pageCount,page,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public List<CrmPersonTypeRelationship> getList(
			Map<String, Object> condition, String sort) throws Exception {
		List<CrmPersonTypeRelationship> list = null;
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPersonTypeRelationshipDao").get("getList");
			list = this.daoFacade.getCrmPersonTypeRelationshipDao().getList(condition, sort, hqlBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "CrmPerson.getList.error", e);
		}
		return list;
	}

	@Override
	public void addTab(CrmPersonInfoForm form) throws Exception {
		String statusYes = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
		Map<String, Object> condition = form.getCondition();
		
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPeTpClassifyDao").get("getPersonTypeClassifyList");
		condition.put("personType_id", form.getPersonType().getId());
		condition.put("parentClassify_id", form.getPeTpClassify().getId());
		condition.put("status", statusYes);
		
		List<CrmPeTpClassify> personTypeClassifyList = daoFacade.getCrmPeTpClassifyDao().getPersonTypeClassifyList(condition, hqlBean);
		form.setPeTpClassifieList(personTypeClassifyList);
		
		condition.clear();
		condition.put("personTypeRelationship_id", form.getPeTypeProp().getId());
		condition.put("personTypePropClassify_id", form.getPeTpClassify().getId());
		hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPersonPropDao").get("getList");
		
		List<CrmPersonProp> personPropList = daoFacade.getCrmPersonPropDao().getList(condition, null, hqlBean);
		form.setPersonPropList(personPropList);
		
	}

	@Override
	public List<CrmPerson> getAvailablePersonCode(CrmPersonType type)
			throws Exception {
		String statusYes = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("personType_id", type.getId());
		condition.put("status", statusYes);
		
		String daoClassName = "cn.digitalpublishing.dao.CrmPersonDao";
		String daoMethodName = "getList";
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get(daoClassName).get(daoMethodName);
		List<CrmPerson> list = daoFacade.getCrmPersonDao().getPersonList(condition,null,hqlBean);
		return list;
	}

	@Override
	public List<CrmPerson> getAvailableEmployeePerson(CrmPersonType type)
			throws Exception {
		String statusYes = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("personType_id", type.getId());
		condition.put("status", statusYes);
		
		String daoClassName = "cn.digitalpublishing.dao.CrmPersonDao";
		String daoMethodName = "getPersonList";
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get(daoClassName).get(daoMethodName);
		List<CrmPerson> list = daoFacade.getCrmPersonDao().getPersonList(condition,null,hqlBean);
		return list;
	}

	
	@Override
	public boolean checkCodeIsAvailable(CrmPerson person) throws Exception {
		String statusYes = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("person_code", person.getCode());
		condition.put("status", statusYes);
		String daoClassName = "cn.digitalpublishing.dao.CrmPersonTypeRelationshipDao";
		String daoMethodName = "getByCode";
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get(daoClassName).get(daoMethodName);
		List<CrmPersonTypeRelationship> list = daoFacade.getCrmPersonTypeRelationshipDao().getList(condition, null, hqlBean);
		if (list.isEmpty()) {
			return true;
		}
		return false;
	}


}
