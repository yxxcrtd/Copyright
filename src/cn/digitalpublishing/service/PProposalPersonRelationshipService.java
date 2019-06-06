package cn.digitalpublishing.service;

import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.po.PProposalPersonRelationship;

import java.util.List;
import java.util.Map;

/**
 * Created by huangchenxi on 14-7-15.
 */
public interface PProposalPersonRelationshipService extends BaseService {
    public List<PProposalPersonRelationship> getProposalPersonRelaPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws CcsException;
    public List<PProposalPersonRelationship> getProposalPersonRelaList(Map<String, Object> condition, String sort) throws CcsException;
    public Integer getCount(Map<String, Object> condition) throws Exception;
    public void savePersons(String proposalId,String ids) throws Exception;
    public void delProposalPersonRela(String id) throws Exception;
    public PProposalPersonRelationship getProposalPersonRela(String id) throws Exception;
}
