package cn.digitalpublishing.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
import cn.digitalpublishing.service.CrmPersonTypeRelationshipService;
import cn.digitalpublishing.springmvc.form.CrmPersonTypeRelationshipForm;
import cn.digitalpublishing.util.DicCache;

import com.google.common.base.Strings;

public class CrmPersonTypeRelationshipServiceImpl extends BaseServiceImpl implements CrmPersonTypeRelationshipService {

	@Override
	public void insertCrmPersonTypeRelationship(CrmPersonTypeRelationshipForm form)
			throws Exception {
		String statusYes = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
		Map<String, Object> condition = form.getCondition();
		CrmPersonType personType = form.getPersonType();
		CrmPerson person = form.getObj();
		if (Strings.isNullOrEmpty(person.getId())) {
			this.daoFacade.getCrmPersonDao().insert(person);
		} else {
			this.daoFacade.getCrmPersonDao().update(person, CrmPerson.class.getName(), person.getId(), null);
		}
		

		CrmPersonTypeRelationship relationship = form.getRelation();
		relationship.setPersonType(personType);
		relationship.setPerson(person);
		relationship.setStatus(statusYes);
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
		this.daoFacade.getCrmPersonPropDao().getHibernateDao().saveOrUpdateAll(personPropList);
		
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
	public void addTab(CrmPersonTypeRelationshipForm form) throws Exception {
		String statusYes = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
		Map<String, Object> condition = form.getCondition();
		
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPeTpClassifyDao").get("getPersonTypeClassifyList");
		condition.put("personType_id", form.getPersonType().getId());
		condition.put("parentClassify_id", form.getPeTpClassify().getId());
		condition.put("status", statusYes);
		
		List<CrmPeTpClassify> personTypeClassifyList = daoFacade.getCrmPeTpClassifyDao().getPersonTypeClassifyList(condition, hqlBean);
		form.setPeTpClassifieList(personTypeClassifyList);
		
		condition.clear();
		condition.put("personTypeRelationship_id", form.getRelation().getId());
		condition.put("personTypePropClassify_id", form.getPeTpClassify().getId());
		hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPersonPropDao").get("getPersonPropList");
		
		List<CrmPersonProp> personPropList = daoFacade.getCrmPersonPropDao().getPersonPropList(condition, hqlBean);
		form.setPersonPropList(personPropList);		
	}

	@Override
	public CrmPersonTypeRelationship getCrmPersonTypeRelationship(String id)
			throws Exception {
		CrmPersonTypeRelationship crmPersonTypeRelationship = null;
		try {
			crmPersonTypeRelationship = this.daoFacade.getCrmPersonTypeRelationshipDao().get(CrmPersonTypeRelationship.class.getName(), id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "CrmPerson.getCrmPerson.error", e);
		}
		return crmPersonTypeRelationship;
	}

	@Override
	public CrmPersonTypeRelationship getByIds(Map<String, Object> condition)
			throws Exception {
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPersonTypeRelationshipDao").get("getByIds");
		try {
			CrmPersonTypeRelationship crmPersonTypeRelationship = this.daoFacade.getCrmPersonTypeRelationshipDao().getByIds(condition, hqlBean);
			return crmPersonTypeRelationship;
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
	}
	
	@Override
	public void upload(String path, String personTypeId,String accountId) throws Exception {
		try {
			InputStream is = new FileInputStream(new File(path));
			XSSFWorkbook xwb = new XSSFWorkbook(is);
			XSSFSheet sheet = xwb.getSheetAt(0);
			
			List<CrmPerson> personList = new ArrayList<CrmPerson>();
			String statusYes = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
			for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow row = sheet.getRow(i);
				if (row != null) {
					// 使用首行来判断是"分类"还是"属性"
					XSSFCell personCode = row.getCell(0);
					XSSFCell name = row.getCell(1);
					XSSFCell telphone = row.getCell(2);
					XSSFCell phone = row.getCell(3);
					XSSFCell address = row.getCell(4);
					XSSFCell postCode = row.getCell(5);
					XSSFCell email = row.getCell(6);
					XSSFCell fax = row.getCell(7);
					
					CrmPerson person = new CrmPerson();
					person.setCode(personCode.toString());
					person.setName(name.toString());
					person.setTelephone(telphone.toString());
					person.setPhone(phone.toString());
					person.setAddress(address.toString());
					person.setPostCode(postCode.toString());
					person.setEmail(email.toString());
					person.setFax(fax.toString());
					person.setCreateOn(new Date());
					person.setStatus(statusYes);
					person.setCreateBy(accountId);
					personList.add(person);
				}
			}
			this.savePerson(personList, personTypeId);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CcsException("解析Excel出错！");
		}
	}

	@Override
	public void delete(CrmPersonTypeRelationship personTypeRelationship)
			throws Exception {
		try {
			this.daoFacade.getCrmPersonTypeRelationshipDao().update(personTypeRelationship,CrmPersonTypeRelationship.class.getName(), personTypeRelationship.getId(),null);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.deletecTransAction.error", e);
		}
	}

	public void savePerson(List<CrmPerson> personList, String personTypeId) {
		String statusYes = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
		
		try {
			for(CrmPerson person: personList){
				Map<String, Object> condition = new HashMap<String, Object>();
				//CrmPersonType personType = form.getPersonType();
				//CrmPerson person = form.getObj();
				this.daoFacade.getCrmPersonDao().insert(person);
		
				CrmPersonTypeRelationship relationship = new CrmPersonTypeRelationship();
				CrmPersonType personType = new CrmPersonType();
				personType.setId(personTypeId);
				relationship.setPersonType(personType);
				relationship.setPerson(person);
				relationship.setStatus(statusYes);
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
				this.daoFacade.getCrmPersonPropDao().getHibernateDao().saveOrUpdateAll(personPropList);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
