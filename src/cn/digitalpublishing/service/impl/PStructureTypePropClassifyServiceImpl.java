package cn.digitalpublishing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.PStructureTypePropClassify;
import cn.digitalpublishing.service.PStructureTypePropClassifyService;
import cn.digitalpublishing.util.DicCache;

public class PStructureTypePropClassifyServiceImpl extends BaseServiceImpl implements PStructureTypePropClassifyService {

	@Override
	public void updatePStructureTypePropClassify(PStructureTypePropClassify obj, String id, String[] properties) throws Exception {
		try {
			this.daoFacade.getStructureTypePropClassifyDao().update(obj,PStructureTypePropClassify.class.getName(), obj.getId(), properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
	}

	@Override
	public void insertPStructureTypePropClassify(PStructureTypePropClassify obj) throws Exception {
		try {
			String statusAvailable = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
			obj.setStatus(statusAvailable);
			this.daoFacade.getStructureTypePropClassifyDao().insert(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.insertCTransaction.error", e);
		}
	}

	@Override
	public void deletePStructureTypePropClassify(PStructureTypePropClassify classify) throws Exception {
		try {
			classify.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE));
			this.updatePStructureTypePropClassify(classify, null, null);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.deletecTransAction.error", e);
		}
	}

	@Override
	public List<PStructureTypePropClassify> getPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer page) throws Exception {
		List<PStructureTypePropClassify> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PStructureTypePropClassifyDao").get("getPagingList");
		try{
			list=this.daoFacade.getStructureTypePropClassifyDao().getPagingList(condition,sort,pageCount,page,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public Integer getCount(Map<String, Object> condition) throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PStructureTypePropClassifyDao").get("getCount");
		try {
			num = this.daoFacade.getStructureTypePropClassifyDao().getCount(condition,hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}

	@Override
	public PStructureTypePropClassify getPStructureTypePropClassify(String id) throws Exception {
		PStructureTypePropClassify cla = null;
		try {
			cla = this.daoFacade.getStructureTypePropClassifyDao().get(PStructureTypePropClassify.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransaction.error", e);
		}
		return cla;
	}

	@Override
	public PStructureTypePropClassify getPStructureTypePropClassifyByCode(String code)
			throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("code", code);
		List<PStructureTypePropClassify> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PStructureTypePropClassifyDao").get("getPStructureTypePropClassifyByCode");
		try{
			list = this.daoFacade.getStructureTypePropClassifyDao().getList(condition,hqlBean);
			if (!list.isEmpty()) {
				return list.get(0);
			}
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return null;
	}

	@Override
	public List<PStructureTypePropClassify> getList(Map<String, Object> condition) throws Exception {
		List<PStructureTypePropClassify> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PStructureTypePropClassifyDao").get("getList");
		try{
			list=this.daoFacade.getStructureTypePropClassifyDao().getList(condition,hqlBean);
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
				PStructureTypePropClassify typeId = this.getPStructureTypePropClassify(id);
				PStructureTypePropClassify typeIndex = this.getList(condition).get(0);
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
			this.daoFacade.getStructureTypePropClassifyDao().delete(PStructureTypePropClassify.class.getName(),id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
	}

}
