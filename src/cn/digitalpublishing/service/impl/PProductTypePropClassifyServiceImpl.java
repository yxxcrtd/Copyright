package cn.digitalpublishing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.PProductTypePropClassify;
import cn.digitalpublishing.service.PProductTypePropClassifyService;
import cn.digitalpublishing.util.DicCache;

public class PProductTypePropClassifyServiceImpl extends BaseServiceImpl implements PProductTypePropClassifyService{

	@Override
	public void updateClassify(PProductTypePropClassify obj, String id,
			String[] properties) throws Exception {
		try {
			this.daoFacade.getProductTypePropClassifyDao().update(obj,PProductTypePropClassify.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
		
	}

	@Override
	public void insertClassify(PProductTypePropClassify obj) throws Exception {
		try {
			this.daoFacade.getProductTypePropClassifyDao().insert(obj);
	} catch (Exception e) {
		throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.insertCTransaction.error", e);
		}
		
	}

	@Override
	public void deleteClassify(String id) throws Exception {
		try {
			PProductTypePropClassify typePropClassify = this.getClassify(id);
			typePropClassify.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE));
			this.updateClassify(typePropClassify, id, null);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.deletecTransAction.error", e);
		}
		
	}

	@Override
	public List<PProductTypePropClassify> getClassifyPagingList(Map<String, Object> condition, String sort, Integer pageCount,Integer page) throws Exception {
		List<PProductTypePropClassify> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProductTypePropClassifyDao").get("getPagingList");
		try{
			list=this.daoFacade.getProductTypePropClassifyDao().getPProductTypePropClassifyPagingList(condition,sort,pageCount,page,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public Integer getClassifyCount(Map<String, Object> condition)
			throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProductTypePropClassifyDao").get("getCount");
		try {
			num = this.daoFacade.getProductTypePropClassifyDao().getCount(condition,hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}
	
    public PProductTypePropClassify getClassify(String id) throws Exception{
    	PProductTypePropClassify cla = null;
		try {
			cla = (PProductTypePropClassify) this.daoFacade.getProductTypePropClassifyDao().get(PProductTypePropClassify.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransaction.error", e);
		}
		return cla;
    }

	@Override
	public List<PProductTypePropClassify> getClassifyList(
			Map<String, Object> condition) {
		List<PProductTypePropClassify> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProductTypePropClassifyDao").get("getList");
		try{
			list=this.daoFacade.getProductTypePropClassifyDao().getPProductTypePropClassifyList(condition,hqlBean);
		}catch(Exception e){
			e.printStackTrace();
//			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}
	
	
	@Override
	public boolean orderUnique(String id, Integer order,String tid) throws Exception {
		
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("order", order);
		condition.put("tid", tid);
		
		int count = this.getClassifyCount(condition);
		//新增
		if("".equals(id)){
			if(count>0)
			{
				return false;
			}
		}else {//修改
			if(count==1)
			{
				PProductTypePropClassify typeId = this.getClassify(id);
				PProductTypePropClassify typeIndex = this.getClassifyList(condition).get(0);
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
			this.daoFacade.getProductTypePropClassifyDao().delete(PProductTypePropClassify.class.getName(),id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
	}

	@Override
	public PProductTypePropClassify getClassifyByCode(String code) throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("code", code);
		List<PProductTypePropClassify> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProductTypePropClassifyDao").get("getPProductTypePropClassifyByCode");
		try{
			list = this.daoFacade.getProductTypePropClassifyDao().getPProductTypePropClassifyList(condition,hqlBean);
			if (!list.isEmpty()) {
				return list.get(0);
			}
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return null;
	}
}