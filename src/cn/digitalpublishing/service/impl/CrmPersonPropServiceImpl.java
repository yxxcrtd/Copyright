package cn.digitalpublishing.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.CrmPersonProp;
import cn.digitalpublishing.service.CrmPersonPropService;

public class CrmPersonPropServiceImpl extends BaseServiceImpl implements CrmPersonPropService {

	@Override
	public void updatePersonProp(CrmPersonProp obj, String id,
			String[] properties) throws Exception {
		try {
			this.daoFacade.getCrmPersonPropDao().update(obj,CrmPersonProp.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
		
	}

	@Override
	public void insertPersonProp(CrmPersonProp obj) throws Exception {
		try {
			this.daoFacade.getCrmPersonPropDao().insert(obj);
		} catch (Exception e) {
		throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.insertCTransaction.error", e);
		}
	}

	@Override
	public void deletetPersonProp(CrmPersonProp obj) throws Exception {
		try {
			this.daoFacade.getCrmPersonPropDao().update(obj,CrmPersonProp.class.getName(), obj.getId(), null);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.deletecTransAction.error", e);
		}
	}

	@Override
	public List<CrmPersonProp> getPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer page) throws Exception {
		List<CrmPersonProp> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPersonPropDao").get("getPagingList");
		try{
			list=this.daoFacade.getCrmPersonPropDao().getPagingList(condition,sort,pageCount,page,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public Integer getCount(Map<String, Object> condition) throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPersonPropDao").get("getCount");
		try {
			num = this.daoFacade.getCrmPersonPropDao().getCount(condition,hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}

	@Override
	public CrmPersonProp getPersonProp(String id) throws Exception {
		CrmPersonProp cla = null;
		try {
			cla = (CrmPersonProp) this.daoFacade.getCrmPersonPropDao().get(CrmPersonProp.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransaction.error", e);
		}
		return cla;
	}

	@Override
	public List<CrmPersonProp> getList(Map<String, Object> condition,
			String sort) throws Exception {
		List<CrmPersonProp> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPersonPropDao").get("getList");
		try{
			list=this.daoFacade.getCrmPersonPropDao().getList(condition,sort,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

}
