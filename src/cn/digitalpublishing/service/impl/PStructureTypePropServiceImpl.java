package cn.digitalpublishing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.PStructureTypeProp;
import cn.digitalpublishing.po.PStructureProp;
import cn.digitalpublishing.service.PStructureTypePropService;
import cn.digitalpublishing.util.DicCache;

public class PStructureTypePropServiceImpl extends BaseServiceImpl implements PStructureTypePropService{

	@Override
	public void updatePStructureTypeProp(PStructureTypeProp obj, String id,
			String[] properties) throws Exception {
		try {
			this.daoFacade.getStructureTypePropDao().update(obj,PStructureTypeProp.class.getName(), obj.getId(), properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
	}

	@Override
	public void insertPStructureTypeProp(PStructureTypeProp obj) throws Exception {
		try {
			this.daoFacade.getStructureTypePropDao().insert(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.insertCTransaction.error", e);
		}
	}

	@Override
	public void deletetPStructureTypeProp(PStructureTypeProp obj) throws Exception {
		try {
			this.daoFacade.getStructureTypePropDao().update(obj,PStructureTypeProp.class.getName(), obj.getId(), null);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.deletecTransAction.error", e);
		}
	}

	@Override
	public List<PStructureTypeProp> getPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer page) throws Exception {
		List<PStructureTypeProp> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PStructureTypePropDao").get("getPagingList");
		try{
			list=this.daoFacade.getStructureTypePropDao().getPagingList(condition,sort,pageCount,page,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public Integer getCount(Map<String, Object> condition) throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PStructureTypePropDao").get("getCount");
		try {
			num = this.daoFacade.getStructureTypePropDao().getCount(condition,hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}

	@Override
	public PStructureTypeProp getPStructureTypeProp(String id) throws Exception {
		PStructureTypeProp cla = null;
		try {
			cla = (PStructureTypeProp) this.daoFacade.getStructureTypePropDao().get(PStructureTypeProp.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransaction.error", e);
		}
		return cla;
	}

	@Override
	public List<PStructureTypeProp> getList(Map<String, Object> condition,
			String sort) throws Exception {
		List<PStructureTypeProp> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PStructureTypePropDao").get("getList");
		try{
			list=this.daoFacade.getStructureTypePropDao().getList(condition,sort,hqlBean);
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
				PStructureTypeProp typeId = this.getPStructureTypeProp(id);
				PStructureTypeProp typeIndex = this.getList(condition, "").get(0);
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
	public List<PStructureTypeProp> getListForInsert(Map<String, Object> condition,
			String sort) throws Exception {
		List<PStructureTypeProp> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PStructureTypePropDao").get("getListForInsert");
		try{
			list=this.daoFacade.getStructureTypePropDao().getList(condition,sort,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}
	
	@Override
	public void  falseDel(PStructureTypeProp obj) throws Exception {
		try {
			String statusUnAvailable = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE);
			obj.setStatus(statusUnAvailable);
			this.daoFacade.getStructureTypePropDao().update(obj, PStructureTypeProp.class.getName(), obj.getId(), null);
			
			//删除一个公司类型属性后，相应删除其相关联的 公司属性
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("structureTypeProp_id", obj.getId());
			HqlBean shqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PStructurePropDao").get("getList");
			List<PStructureProp> structurePropList = this.daoFacade.getStructurePropDao().getList(condition, shqlBean);
			for(PStructureProp pp : structurePropList){
					pp.setStatus(statusUnAvailable);
					this.daoFacade.getStructurePropDao().update(pp, PStructureProp.class.getName(), pp.getId(), null);
			}
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
	}

	@Override
	public void addPStructureTypeProp(PStructureTypeProp obj, String tid) throws Exception {
		try {
			String statusAvailable = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
			obj.setStatus(statusAvailable);
			this.insertPStructureTypeProp(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.insertCTransaction.error", e);
		}
	}

}
