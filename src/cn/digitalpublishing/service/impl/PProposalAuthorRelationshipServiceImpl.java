package cn.digitalpublishing.service.impl;

import java.util.List;
import java.util.Map;
import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.CrmPersonTypeRelationship;
import cn.digitalpublishing.po.PProposal;
import cn.digitalpublishing.po.PProposalAuthorRelationship;
import cn.digitalpublishing.service.PProposalAuthorRelationshipService;

public class PProposalAuthorRelationshipServiceImpl extends BaseServiceImpl implements PProposalAuthorRelationshipService {
	
	@Override
	public void update(PProposalAuthorRelationship obj, String id, String[] properties) throws Exception {
		try {
			this.daoFacade.getProposalAuthorRelationshipDao().update(obj, PProposalAuthorRelationship.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
	}

	@Override
	public void insert(PProposalAuthorRelationship obj) throws Exception {
		try {
			this.daoFacade.getProposalAuthorRelationshipDao().insert(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.insertCTransaction.error", e);
		}

	}

	@Override
	public void delete(String id) throws Exception {
		try {
			this.daoFacade.getProposalAuthorRelationshipDao().delete(PProposalAuthorRelationship.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.deletecTransAction.error", e);
		}

	}

	@Override
	public List<PProposalAuthorRelationship> getPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws Exception {
		List<PProposalAuthorRelationship> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProposalAuthorRelationshipDao").get("getPagingList");
		try {
			list = this.daoFacade.getProposalAuthorRelationshipDao().getPagingList(condition, sort, pageCount, page, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public Integer getCount(Map<String, Object> condition) throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProposalAuthorRelationshipDao").get("getCount");
		try {
			num = this.daoFacade.getProposalAuthorRelationshipDao().getCount(condition, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}

	public PProposalAuthorRelationship get(String id) throws Exception {
		PProposalAuthorRelationship cla = null;
		try {
			cla = (PProposalAuthorRelationship) this.daoFacade.getProposalAuthorRelationshipDao().get(PProposalAuthorRelationship.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransaction.error", e);
		}
		return cla;
	}

	@Override
	public List<PProposalAuthorRelationship> getList(Map<String, Object> condition) throws Exception {
		List<PProposalAuthorRelationship> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProposalAuthorRelationshipDao").get("getList");
		try {
			list = this.daoFacade.getProposalAuthorRelationshipDao().getList(condition, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public void saveAll(String allId, String id) throws CcsException {
		try {
			for (String pId : allId.split(",")) {
				PProposalAuthorRelationship obj = new PProposalAuthorRelationship();
				CrmPersonTypeRelationship personTypeRelationship = new CrmPersonTypeRelationship();
				personTypeRelationship.setId(pId);
				PProposal proposal= new PProposal();
				proposal.setId(id);
				obj.setPersonTypeRelationship(personTypeRelationship);
				obj.setProposal(proposal);
				this.daoFacade.getProposalAuthorRelationshipDao().insert(obj);
			}
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
	}
}