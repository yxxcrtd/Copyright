package cn.digitalpublishing.service.impl;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.CrmPersonTypeRelationship;
import cn.digitalpublishing.po.PProposal;
import cn.digitalpublishing.po.PProposalPersonRelationship;
import cn.digitalpublishing.service.PProposalPersonRelationshipService;

import java.util.List;
import java.util.Map;

/**
 * Created by huangchenxi on 14-7-15.
 */
public class PProposalPersonRelationshipServiceImpl extends BaseServiceImpl implements PProposalPersonRelationshipService {
    @Override
    public PProposalPersonRelationship getProposalPersonRela(String id) throws Exception {
        return this.daoFacade.getProposalPersonRelationshipDao().get(PProposalPersonRelationship.class.getName(),id);
    }

    @Override
    public void delProposalPersonRela(String id) throws Exception {
        this.daoFacade.getProposalPersonRelationshipDao().delete(PProposalPersonRelationship.class.getName(),id);
    }

    @Override
    public void savePersons(String proposalId, String ids) throws Exception {
        PProposal proposal = this.daoFacade.getProposalDao().get(PProposal.class.getName(), proposalId);
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            PProposalPersonRelationship proposalPersonRelationship = new PProposalPersonRelationship();
            proposalPersonRelationship.setProposal(proposal);
            proposalPersonRelationship.setPerson(this.daoFacade.getCrmPersonTypeRelationshipDao().get(CrmPersonTypeRelationship.class.getName(), id).getPerson());
            this.daoFacade.getProposalPersonRelationshipDao().insert(proposalPersonRelationship);
        }

    }

    @Override
    public List<PProposalPersonRelationship> getProposalPersonRelaPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws CcsException {
        List<PProposalPersonRelationship> list = null;
        HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProposalPersonRelationshipDao").get("getPagingList");
        try {
            list = this.daoFacade.getProposalPersonRelationshipDao().getPProposalPagingList(condition, sort, pageCount, page, hqlBean);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionList.error", e);
        }
        return list;
    }
   @Override
    public List<PProposalPersonRelationship> getProposalPersonRelaList(Map<String, Object> condition, String sort) throws CcsException {
        List<PProposalPersonRelationship> list = null;
        HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProposalPersonRelationshipDao").get("getPagingList");
        try {
            list = this.daoFacade.getProposalPersonRelationshipDao().getList(condition, sort,hqlBean);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionList.error", e);
        }
        return list;
    }

    @Override
    public Integer getCount(Map<String, Object> condition) throws Exception {
        Integer num = 0;
        HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProposalPersonRelationshipDao").get("getCount");
        try {
            num = this.daoFacade.getProposalPersonRelationshipDao().getCount(condition, hqlBean);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
        }
        return num;
    }
}
