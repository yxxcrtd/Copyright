package cn.digitalpublishing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.CrmPeTpClassify;
import cn.digitalpublishing.service.CrmPeTpClassifyService;
import cn.digitalpublishing.util.DicCache;

public class CrmPeTpClassifyServiceImpl extends BaseServiceImpl implements CrmPeTpClassifyService {

	@Override
	public void updateCrmPeTpClassify(CrmPeTpClassify obj, String id,
			String[] properties) throws Exception {
		try {
			this.daoFacade.getCrmPeTpClassifyDao().update(obj,CrmPeTpClassify.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
	}

	@Override
	public void insertCrmPeTpClassify(CrmPeTpClassify obj) throws Exception {
		try {
			this.daoFacade.getCrmPeTpClassifyDao().insert(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.insertCTransaction.error", e);
		}
	}

	@Override
	public void deleteCrmPeTpClassify(String id) throws Exception {
		try {
			CrmPeTpClassify typePropClassify = this.getCrmPeTpClassify(id);
			typePropClassify.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE));
			this.updateCrmPeTpClassify(typePropClassify, id, null);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.deletecTransAction.error", e);
		}
	}

	@Override
	public List<CrmPeTpClassify> getPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer page) throws Exception {
		List<CrmPeTpClassify> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPeTpClassifyDao").get("getPagingList");
		try{
			list=this.daoFacade.getCrmPeTpClassifyDao().getPagingList(condition,sort,pageCount,page,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public Integer getCount(Map<String, Object> condition) throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPeTpClassifyDao").get("getCount");
		try {
			num = this.daoFacade.getCrmPeTpClassifyDao().getCount(condition,hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}

	@Override
	public CrmPeTpClassify getCrmPeTpClassify(String id) throws Exception {
		CrmPeTpClassify cla = null;
		try {
			cla = (CrmPeTpClassify) this.daoFacade.getCrmPeTpClassifyDao().get(CrmPeTpClassify.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransaction.error", e);
		}
		return cla;
	}

	@Override
	public CrmPeTpClassify getCrmPeTpClassifyByCode(String code)
			throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("code", code);
		List<CrmPeTpClassify> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPeTpClassifyDao").get("getCrmPeTpClassifyByCode");
		try{
			list = this.daoFacade.getCrmPeTpClassifyDao().getList(condition,hqlBean);
			if (!list.isEmpty()) {
				return list.get(0);
			}
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return null;
	}

	@Override
	public List<CrmPeTpClassify> getList(Map<String, Object> condition)
			throws Exception {
		List<CrmPeTpClassify> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPeTpClassifyDao").get("getList");
		try{
			list=this.daoFacade.getCrmPeTpClassifyDao().getList(condition,hqlBean);
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
				CrmPeTpClassify typeId = this.getCrmPeTpClassify(id);
				CrmPeTpClassify typeIndex = this.getList(condition).get(0);
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
			this.daoFacade.getCrmPeTpClassifyDao().delete(CrmPeTpClassify.class.getName(),id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
	}

}
