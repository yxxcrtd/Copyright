package cn.digitalpublishing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.CrmCorpProp;
import cn.digitalpublishing.po.CrmCorpType;
import cn.digitalpublishing.po.CrmCtypeProp;
import cn.digitalpublishing.service.CrmCtypePropService;
import cn.digitalpublishing.util.DicCache;

public class CrmCtypePropServiceImpl extends BaseServiceImpl implements CrmCtypePropService{

	@Override
	public void updateCrmCtypeProp(CrmCtypeProp obj, String id,
			String[] properties) throws Exception {
		try {
			this.daoFacade.getCrmCtypePropDao().update(obj,CrmCtypeProp.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
	}

	@Override
	public void insertCrmCtypeProp(CrmCtypeProp obj) throws Exception {
		try {
			this.daoFacade.getCrmCtypePropDao().insert(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.insertCTransaction.error", e);
		}
	}

	@Override
	public void deletetCrmCtypeProp(CrmCtypeProp obj) throws Exception {
		try {
			this.daoFacade.getCrmCtypePropDao().update(obj,CrmCtypeProp.class.getName(), obj.getId(), null);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.deletecTransAction.error", e);
		}
	}

	@Override
	public List<CrmCtypeProp> getPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer page) throws Exception {
		List<CrmCtypeProp> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCtypePropDao").get("getPagingList");
		try{
			list=this.daoFacade.getCrmCtypePropDao().getPagingList(condition,sort,pageCount,page,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public Integer getCount(Map<String, Object> condition) throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCtypePropDao").get("getCount");
		try {
			num = this.daoFacade.getCrmCtypePropDao().getCount(condition,hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}

	@Override
	public CrmCtypeProp getCrmCtypeProp(String id) throws Exception {
		CrmCtypeProp cla = null;
		try {
			cla = (CrmCtypeProp) this.daoFacade.getCrmCtypePropDao().get(CrmCtypeProp.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransaction.error", e);
		}
		return cla;
	}

	@Override
	public List<CrmCtypeProp> getList(Map<String, Object> condition,
			String sort) throws Exception {
		List<CrmCtypeProp> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCtypePropDao").get("getList");
		try{
			list=this.daoFacade.getCrmCtypePropDao().getList(condition,sort,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public boolean orderUnique(String id, String order, String tid)
			throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("order", order);
		condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
		condition.put("tid", tid);
		int count = this.getCount(condition);
		//新增
		if("".equals(id)){
			if(count>0)
			{
				return false;
			}
		}else {//修改
			if(count==1)
			{
				CrmCtypeProp typeId = this.getCrmCtypeProp(id);
				CrmCtypeProp typeIndex = this.getList(condition, "").get(0);
				if(!typeId.getId().equals(typeIndex.getId()))
				{
					return false;
				}
			}else if(count == 0){
				return true;
			}else {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<CrmCtypeProp> getListForInsert(Map<String, Object> condition,
			String sort) throws Exception {
		List<CrmCtypeProp> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCtypePropDao").get("getListForInsert");
		try{
			list=this.daoFacade.getCrmCtypePropDao().getList(condition,sort,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}
	
	@Override
	public void  falseDel(String id) throws Exception {
		try {
			CrmCtypeProp obj = this.getCrmCtypeProp(id);
			obj.setStatus( DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE));
			this.daoFacade.getCrmCorpPropDao().getBaseDao().getHibernateDao().update(obj);
			//删除一个公司类型属性后，相应删除其相关联的 公司属性
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("ptpid", id);
			HqlBean shqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCorpPropDao").get("getList");
			List<CrmCorpProp> corpPropList = this.daoFacade.getCrmCorpPropDao().getList(condition, shqlBean);
			for(CrmCorpProp pp : corpPropList){
					pp.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE));
					this.daoFacade.getCrmCorpPropDao().getBaseDao().getHibernateDao().update(pp);
			}
			
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
	}

	@Override
	public void addCrmCtypeProp(CrmCtypeProp obj, String tid) throws Exception {
		try {
			CrmCtypeProp corpTypeProp = obj;
			CrmCorpType corpType = new CrmCorpType();
			corpType.setId(tid);
			corpTypeProp.setCorpType(corpType);
			corpTypeProp.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			this.insertCrmCtypeProp(corpTypeProp);
			//新增一个公司类型属性后，相应新增产品属性--piid为null
			CrmCorpProp corpProp = new CrmCorpProp(); 
			corpProp.setCorpTypeProp(corpTypeProp);
			corpProp.setCode(corpTypeProp.getCode());
			corpProp.setName(corpTypeProp.getName());
			corpProp.setDisplay(corpTypeProp.getDisplay());
			corpProp.setMust(corpTypeProp.getMust());
			corpProp.setOrder(corpTypeProp.getOrder());
			corpProp.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			this.daoFacade.getCrmCorpDao().insert(corpProp);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.insertCTransaction.error", e);
		}
	}

}
