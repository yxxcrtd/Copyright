package cn.digitalpublishing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.CrmPeTypeProp;
import cn.digitalpublishing.service.CrmPeTypePropService;
import cn.digitalpublishing.util.DicCache;

public class CrmPeTypePropServiceImpl extends BaseServiceImpl implements CrmPeTypePropService{

	@Override
	public void updateCrmPeTypeProp(CrmPeTypeProp obj, String id,
			String[] properties) throws Exception {
		try {
			this.daoFacade.getCrmPeTypePropDao().update(obj,CrmPeTypeProp.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
	}

	@Override
	public void insertCrmPeTypeProp(CrmPeTypeProp obj) throws Exception {
		try {
			this.daoFacade.getCrmPeTypePropDao().insert(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.insertCTransaction.error", e);
		}
	}

	@Override
	public void deletetCrmPeTypeProp(CrmPeTypeProp obj) throws Exception {
		try {
			this.daoFacade.getCrmPeTypePropDao().update(obj,CrmPeTypeProp.class.getName(), obj.getId(), null);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.deletecTransAction.error", e);
		}
	}

	@Override
	public List<CrmPeTypeProp> getPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer page) throws Exception {
		List<CrmPeTypeProp> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPeTypePropDao").get("getPagingList");
		try{
			list=this.daoFacade.getCrmPeTypePropDao().getPagingList(condition,sort,pageCount,page,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public Integer getCount(Map<String, Object> condition) throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPeTypePropDao").get("getCount");
		try {
			num = this.daoFacade.getCrmPeTypePropDao().getCount(condition,hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}

	@Override
	public CrmPeTypeProp getCrmPeTypeProp(String id) throws Exception {
		CrmPeTypeProp cla = null;
		try {
			cla = (CrmPeTypeProp) this.daoFacade.getCrmPeTypePropDao().get(CrmPeTypeProp.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransaction.error", e);
		}
		return cla;
	}

	@Override
	public List<CrmPeTypeProp> getList(Map<String, Object> condition,
			String sort) throws Exception {
		List<CrmPeTypeProp> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPeTypePropDao").get("getList");
		try{
			list=this.daoFacade.getCrmPeTypePropDao().getList(condition,sort,hqlBean);
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
		condition.put("tid", tid);
		condition.put("status",DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
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
				CrmPeTypeProp typeId = this.getCrmPeTypeProp(id);
				CrmPeTypeProp typeIndex = this.getList(condition, "").get(0);
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
	public List<CrmPeTypeProp> getListForInsert(Map<String, Object> condition,
			String sort) throws Exception {
		List<CrmPeTypeProp> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPeTypePropDao").get("getListForInsert");
		try{
			list=this.daoFacade.getCrmPeTypePropDao().getList(condition,sort,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

}
