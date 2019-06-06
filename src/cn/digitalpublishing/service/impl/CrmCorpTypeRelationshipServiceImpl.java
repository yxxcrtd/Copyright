package cn.digitalpublishing.service.impl;

import java.util.List;
import java.util.Map;
import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.CrmCorp;
import cn.digitalpublishing.po.CrmCorpTypeRelationship;
import cn.digitalpublishing.service.CrmCorpTypeRelationshipService;

public class CrmCorpTypeRelationshipServiceImpl extends BaseServiceImpl implements CrmCorpTypeRelationshipService {
	
	@Override
	public void insert(CrmCorpTypeRelationship obj) throws Exception {
		daoFacade.getCrmCorpTypeRelationshipDao().insert(obj);
	}

	@Override
	public void update(CrmCorpTypeRelationship obj) throws Exception {

	}

	@Override
	public List<CrmCorp> getCorpTreeNodes(String parentCorpId, String corpTypeId) throws Exception {
		
		
		return null;
	}

    @Override
    public List<CrmCorpTypeRelationship> getAllCrmCorpType(Map<String, Object> condition, String sort) throws Exception {
        List<CrmCorpTypeRelationship> list = null;
        try {

            HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCorpTypeRelationshipDao").get("getPagingList");
            list = this.daoFacade.getCrmCorpTypeRelationshipDao().getList(condition, sort, hqlBean);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionList.error", e);
        }
        return list;
    }

	@Override
	public List<CrmCorpTypeRelationship> getPagingList(
			Map<String, Object> condition, String sort, Integer pageCount,
			Integer page) throws Exception {
		List<CrmCorpTypeRelationship> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCorpTypeRelationshipDao").get("getPagingList");
		try{
			list=this.daoFacade.getCrmCorpTypeRelationshipDao().getPagingList(condition,sort,pageCount,page,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public Integer getCount(Map<String, Object> condition, String sort)
			throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCorpTypeRelationshipDao").get("getCount");
		try {
			num = this.daoFacade.getCrmCorpTypeRelationshipDao().getCount(condition,hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}
	
	@Override
	public List<CrmCorpTypeRelationship> getList(Map<String, Object> condition, String sort) throws Exception {
		List<CrmCorpTypeRelationship> list = null;
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCorpTypeRelationshipDao").get("getList");
			list = this.daoFacade.getCrmCorpTypeRelationshipDao().getList(condition, sort, hqlBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "CrmPerson.getList.error", e);
		}
		return list;
	}
}