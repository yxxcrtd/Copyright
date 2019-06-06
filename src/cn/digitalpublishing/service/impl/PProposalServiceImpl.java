package cn.digitalpublishing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.CrmPersonTypeRelationship;
import cn.digitalpublishing.po.PProposal;
import cn.digitalpublishing.po.PProposalPersonRelationship;
import cn.digitalpublishing.service.PProposalService;
import cn.digitalpublishing.util.DicCache;

public class PProposalServiceImpl extends BaseServiceImpl implements PProposalService {

    @Override
    public void updatePProposal(PProposal obj, String id, String[] properties) throws Exception {
        try {
            Map<String, Object> condition = new HashMap<String, Object>();
            condition.put("proposalId", obj.getId());
            HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProposalPersonRelationshipDao").get("getList");
            List<PProposalPersonRelationship> list = this.daoFacade.getProposalPersonRelationshipDao().getPProposalList(condition, "", hqlBean);
            for (PProposalPersonRelationship pp : list) {
                this.daoFacade.getProposalPersonRelationshipDao().delete(PProposalPersonRelationship.class.getName(), pp.getId());
            }

            CrmPersonTypeRelationship personTypeRelationship = this.daoFacade.getCrmPersonTypeRelationshipDao().get(CrmPersonTypeRelationship.class.getName(), this.daoFacade.getProposalDao().get(PProposal.class.getName(),obj.getId()).getCreateBy());
            PProposalPersonRelationship proposalPersonRelationship = new PProposalPersonRelationship();
            proposalPersonRelationship.setPerson(personTypeRelationship.getPerson());
            proposalPersonRelationship.setProposal(obj);


            if (obj.getRoleType().equals(DicCache.getIdByCode(DicConstants.DIC_PROPOSAL_ROLE_TYPE, DicConstants.PROPOSAL_ROLE_PRIVATE)) || obj.getRoleType().equals(DicCache.getIdByCode(DicConstants.DIC_PROPOSAL_ROLE_TYPE, DicConstants.PROPOSAL_ROLE_PROTECTED))) {
                this.daoFacade.getProposalPersonRelationshipDao().insert(proposalPersonRelationship);
            } else if (obj.getRoleType().equals(DicCache.getIdByCode(DicConstants.DIC_PROPOSAL_ROLE_TYPE, DicConstants.PROPOSAL_ROLE_PUBLIC))) {
                proposalPersonRelationship.setPerson(null);
                this.daoFacade.getProposalPersonRelationshipDao().insert(proposalPersonRelationship);
            }

            if (obj.getRoleType().equals(DicCache.getIdByCode(DicConstants.DIC_PROPOSAL_ROLE_TYPE, DicConstants.PROPOSAL_ROLE_PRIVATE))) {


                this.daoFacade.getProposalPersonRelationshipDao().insert(proposalPersonRelationship);
            }
            this.daoFacade.getProposalDao().update(obj, PProposal.class.getName(), id, properties);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
        }

    }

    @Override
    public void insertPProposal(PProposal obj) throws Exception {
        try {
            this.daoFacade.getProposalDao().insert(obj);
//            CrmPersonTypeRelationship personTypeRelationship = this.daoFacade.getCrmPersonTypeRelationshipDao().get(CrmPersonTypeRelationship.class.getName(), obj.getCreateBy());
//            if (obj.getRoleType().equals(DicCache.getIdByCode(DicConstants.DIC_PROPOSAL_ROLE_TYPE, DicConstants.PROPOSAL_ROLE_PRIVATE)) || obj.getRoleType().equals(DicCache.getIdByCode(DicConstants.DIC_PROPOSAL_ROLE_TYPE, DicConstants.PROPOSAL_ROLE_PROTECTED))) {
//                PProposalPersonRelationship proposalPersonRelationship = new PProposalPersonRelationship();
//                proposalPersonRelationship.setPerson(personTypeRelationship.getPerson());
//                proposalPersonRelationship.setProposal(obj);
//                this.daoFacade.getProposalPersonRelationshipDao().insert(proposalPersonRelationship);
//            } else if (obj.getRoleType().equals(DicCache.getIdByCode(DicConstants.DIC_PROPOSAL_ROLE_TYPE, DicConstants.PROPOSAL_ROLE_PUBLIC))) {
//                PProposalPersonRelationship proposalPersonRelationship = new PProposalPersonRelationship();
//                proposalPersonRelationship.setProposal(obj);
//                proposalPersonRelationship.setPerson(null);
//                this.daoFacade.getProposalPersonRelationshipDao().insert(proposalPersonRelationship);
//            }
//        } catch (NullPointerException e){
//            throw new CcsException("该帐号未正确绑定员工，请联系系统管理员处理");
        }catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.insertCTransaction.error", e);
        }

    }
    
    @Override
    public void deletePProposal(String id) throws Exception {

        try {
            this.daoFacade.getProposalDao().delete(PProposal.class.getName(), id);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.deletecTransAction.error", e);
        }
    }

    @Override
    public List<PProposal> getPProposalPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws Exception {
        List<PProposal> list = null;
        HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProposalDao").get("getPagingList");
        try {
            list = this.daoFacade.getProposalDao().getPProposalPagingList(condition, sort, pageCount, page, hqlBean);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionList.error", e);
        }
        return list;
    }

    @Override
    public Integer getPProposalCount(Map<String, Object> condition)
            throws Exception {
        Integer num = 0;
        HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProposalDao").get("getCount");
        try {
            num = this.daoFacade.getProposalDao().getCount(condition, hqlBean);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
        }
        return num;
    }

    public PProposal getPProposal(String id) throws Exception {
        PProposal cla = null;
        try {
            cla = (PProposal) this.daoFacade.getProposalDao().get(PProposal.class.getName(), id);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransaction.error", e);
        }
        return cla;
    }

    @Override
    public List<PProposal> getPProposalList(
            Map<String, Object> condition, String sort) throws Exception {
        List<PProposal> list = null;
        HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProposalDao").get("getList");
        try {
            list = this.daoFacade.getProposalDao().getPProposalList(condition, sort, hqlBean);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionList.error", e);
        }
        return list;
    }

    @Override
    public boolean nameUnique(String id, String name) throws Exception {

        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("name", name);
       // condition.put("id", id);
        int count = this.getPProposalCount(condition);
        //新增
        if ("".equals(id)) {
            if (count > 0) {
                return false;
            }
        } else {//修改
            if (count == 1) {
                PProposal typeId = this.getPProposal(id);
                PProposal typeIndex = this.getPProposalList(condition, "").get(0);
                if (!typeId.getId().equals(typeIndex.getId())) {
                    return false;
                }
            } else if (count == 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }


}
