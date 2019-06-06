package cn.digitalpublishing.service.impl;

import java.util.List;
import java.util.Map;
import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.CrmPersonTypeRelationship;
import cn.digitalpublishing.po.PProductPersonRelationship;
import cn.digitalpublishing.po.PProduct;
import cn.digitalpublishing.service.PProductPersonRelationshipService;

public class PProductPersonRelationshipServiceImpl extends BaseServiceImpl implements PProductPersonRelationshipService {
	
	@Override
	public void update(PProductPersonRelationship obj, String id, String[] properties) throws Exception {
		try {
			this.daoFacade.getProductPersonRelationshipDao().update(obj, PProductPersonRelationship.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
	}

	@Override
	public void insert(PProductPersonRelationship obj) throws Exception {
		try {
			this.daoFacade.getProductPersonRelationshipDao().insert(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.insertCTransaction.error", e);
		}

	}

	@Override
	public void delete(String id) throws Exception {
		try {
			this.daoFacade.getProductPersonRelationshipDao().delete(PProductPersonRelationship.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.deletecTransAction.error", e);
		}

	}

	@Override
	public List<PProductPersonRelationship> getPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws Exception {
		List<PProductPersonRelationship> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProductPersonRelationshipDao").get("getPagingList");
		try {
			list = this.daoFacade.getProductPersonRelationshipDao().getPagingList(condition, sort, pageCount, page, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}
	@Override
	public List<PProductPersonRelationship> getPagingListForProduct(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws Exception {
		List<PProductPersonRelationship> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProductPersonRelationshipDao").get("getPagingListForProduct");
		try {
			list = this.daoFacade.getProductPersonRelationshipDao().getPagingList(condition, sort, pageCount, page, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public Integer getCount(Map<String, Object> condition) throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProductPersonRelationshipDao").get("getCount");
		try {
			num = this.daoFacade.getProductPersonRelationshipDao().getCount(condition, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}

    @Override
    public Integer getCountForProduct(Map<String, Object> condition) throws Exception {
        Integer num = 0;
        HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProductPersonRelationshipDao").get("getCountForProduct");
        try {
            num = this.daoFacade.getProductPersonRelationshipDao().getCount(condition, hqlBean);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
        }
        return num;
    }

	public PProductPersonRelationship get(String id) throws Exception {
		PProductPersonRelationship cla = null;
		try {
			cla = (PProductPersonRelationship) this.daoFacade.getProductPersonRelationshipDao().get(PProductPersonRelationship.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransaction.error", e);
		}
		return cla;
	}

	@Override
	public List<PProductPersonRelationship> getList(Map<String, Object> condition) throws Exception {
		List<PProductPersonRelationship> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProductPersonRelationshipDao").get("getList");
		try {
			list = this.daoFacade.getProductPersonRelationshipDao().getList(condition, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public void saveAll(String allId, String id) throws CcsException {
		try {
			for (String pId : allId.split(",")) {
				PProductPersonRelationship obj = new PProductPersonRelationship();
				CrmPersonTypeRelationship personTypeRelationship = new CrmPersonTypeRelationship();
				personTypeRelationship.setId(pId);
				PProduct project = new PProduct();
				project.setId(id);
				obj.setPersonTypeRelationship(personTypeRelationship);
				obj.setProduct(project);
				this.daoFacade.getProductPersonRelationshipDao().insert(obj);
			}
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
	}
}