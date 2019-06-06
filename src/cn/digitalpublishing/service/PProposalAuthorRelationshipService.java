package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;
import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.po.PProposalAuthorRelationship;

public interface PProposalAuthorRelationshipService extends BaseService {

	public void update(PProposalAuthorRelationship obj, String id, String[] properties) throws Exception;

	public void insert(PProposalAuthorRelationship obj) throws Exception;

	public void delete(String id) throws Exception;

	public List<PProposalAuthorRelationship> getPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws Exception;

	public Integer getCount(Map<String, Object> condition) throws Exception;

	public PProposalAuthorRelationship get(String id) throws Exception;

	public List<PProposalAuthorRelationship> getList(Map<String, Object> condition) throws Exception;

	public void saveAll(String allId, String id) throws CcsException;
}