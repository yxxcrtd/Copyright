package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;
import cn.digitalpublishing.po.CrmCorpAccount;

public interface CrmCorpAccountService extends BaseService {

	public Integer getCount(Map<String, Object> condition) throws Exception;

	public List<CrmCorpAccount> getPagingList(Map<String, Object> condition,
			Integer pageSize, Integer startIndex) throws Exception;

	public CrmCorpAccount get(CrmCorpAccount account) throws Exception;

	public void insert(CrmCorpAccount account) throws Exception;

	public void update(CrmCorpAccount account) throws Exception;

	public void delete(CrmCorpAccount account) throws Exception;
}