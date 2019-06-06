package cn.digitalpublishing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.CrmCtpClassify;
import cn.digitalpublishing.service.CrmCtpClassifyService;
import cn.digitalpublishing.util.DicCache;

public class CrmCtpClassifyServiceImpl extends BaseServiceImpl implements CrmCtpClassifyService {

	@Override
	public void updateCrmCtpClassify(CrmCtpClassify obj, String id,
			String[] properties) throws Exception {
		try {
			this.daoFacade.getCrmCtpClassifyDao().update(obj,CrmCtpClassify.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
	}

	@Override
	public void insertCrmCtpClassify(CrmCtpClassify obj) throws Exception {
		try {
			this.daoFacade.getCrmCtpClassifyDao().insert(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.insertCTransaction.error", e);
		}
	}

	@Override
	public void deleteCrmCtpClassify(String id) throws Exception {
		try {
			CrmCtpClassify typePropClassify = this.getCrmCtpClassify(id);
			typePropClassify.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE));
			this.updateCrmCtpClassify(typePropClassify, id, null);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.deletecTransAction.error", e);
		}
	}

	@Override
	public List<CrmCtpClassify> getPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer page) throws Exception {
		List<CrmCtpClassify> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCtpClassifyDao").get("getPagingList");
		try{
			list=this.daoFacade.getCrmCtpClassifyDao().getPagingList(condition,sort,pageCount,page,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public Integer getCount(Map<String, Object> condition) throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCtpClassifyDao").get("getCount");
		try {
			num = this.daoFacade.getCrmCtpClassifyDao().getCount(condition,hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}

	@Override
	public CrmCtpClassify getCrmCtpClassify(String id) throws Exception {
		CrmCtpClassify cla = null;
		try {
			cla = (CrmCtpClassify) this.daoFacade.getCrmCtpClassifyDao().get(CrmCtpClassify.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransaction.error", e);
		}
		return cla;
	}

	@Override
	public CrmCtpClassify getCrmCtpClassifyByCode(String code)
			throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("code", code);
		List<CrmCtpClassify> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCtpClassifyDao").get("getCrmCtpClassifyByCode");
		try{
			list = this.daoFacade.getCrmCtpClassifyDao().getList(condition,hqlBean);
			if (!list.isEmpty()) {
				return list.get(0);
			}
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return null;
	}

	@Override
	public List<CrmCtpClassify> getList(Map<String, Object> condition)
			throws Exception {
		List<CrmCtpClassify> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCtpClassifyDao").get("getList");
		try{
			list=this.daoFacade.getCrmCtpClassifyDao().getList(condition,hqlBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean orderUnique(String id, Integer order, String tid)
			throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("order", order);
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
				CrmCtpClassify typeId = this.getCrmCtpClassify(id);
				CrmCtpClassify typeIndex = this.getList(condition).get(0);
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
	public void realDelete(String id) throws Exception {
		try {
			this.daoFacade.getCrmCtpClassifyDao().delete(CrmCtpClassify.class.getName(),id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
	}

}
