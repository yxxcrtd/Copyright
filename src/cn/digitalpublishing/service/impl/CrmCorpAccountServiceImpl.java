package cn.digitalpublishing.service.impl;

import java.util.List;
import java.util.Map;
import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.CrmCorpAccount;
import cn.digitalpublishing.service.CrmCorpAccountService;

public class CrmCorpAccountServiceImpl extends BaseServiceImpl implements CrmCorpAccountService {

	@Override
	public Integer getCount(Map<String, Object> condition) throws Exception {
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache()
				.get("cn.digitalpublishing.dao.CrmCorpAccountDao")
				.get("getCount");
		return daoFacade.getCrmCorpAccountDao().getCount(condition, hqlBean);
	}

	@Override
	public List<CrmCorpAccount> getPagingList(Map<String, Object> condition,
			Integer pageSize, Integer startIndex) throws Exception {
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache()
				.get("cn.digitalpublishing.dao.CrmCorpAccountDao")
				.get("getPagingList");
		return daoFacade.getCrmCorpAccountDao().getPagingList(condition, "", pageSize, startIndex, hqlBean);
	}

	@Override
	public CrmCorpAccount get(CrmCorpAccount account) throws Exception {
		return (CrmCorpAccount) daoFacade.getCrmCorpAccountDao().get(CrmCorpAccount.class.getName(), account.getId());
	}

	@Override
	public void insert(CrmCorpAccount account) throws Exception {
		daoFacade.getCrmCorpAccountDao().insert(account);
	}

	@Override
	public void update(CrmCorpAccount account) throws Exception {
		daoFacade.getCrmCorpAccountDao().update(account, CrmCorpAccount.class.getName(), account.getId(), null);
	}

	@Override
	public void delete(CrmCorpAccount account) throws Exception {
		daoFacade.getCrmCorpAccountDao().delete(CrmCorpAccount.class.getName(), account.getId());
	}

}