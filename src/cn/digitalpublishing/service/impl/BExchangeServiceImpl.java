package cn.digitalpublishing.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.BExchange;
import cn.digitalpublishing.service.BExchangeService;

public class BExchangeServiceImpl extends BaseServiceImpl implements BExchangeService {

	@Override
	public List<BExchange> getPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer page) throws Exception {
		List<BExchange> list = null;
		
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BExchangeDao").get("getPagingList");
			list = this.daoFacade.getExchangeDao().getPagingList(condition, sort, pageCount, page, hqlBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BExchange.getPagingList.error", e);
		}
		return list;
	}

	@Override
	public List<BExchange> getList(Map<String, Object> condition, String sort)
			throws Exception {
		List<BExchange> list = null;
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BExchangeDao").get("getList");
			list = this.daoFacade.getExchangeDao().getList(condition, sort, hqlBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BExchange.getList.error", e);
		}
		return list;
	}

	@Override
	public Integer getCount(Map<String, Object> condition, String sort)
			throws Exception {
		int num = 0;
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BExchangeDao").get("getCount");
			num = this.daoFacade.getExchangeDao().getCount(condition, sort, hqlBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BExchange.getCount.error", e);
		}
		return num;
	}

	@Override
	public void insertBExchange(BExchange obj) throws Exception {
		try {
			this.daoFacade.getExchangeDao().insert(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "BExchange.insert.error", e);
		}
	}

	@Override
	public void updateBExchange(Object obj, String className, Serializable id,
			String[] properties) throws Exception {
		try {
			this.daoFacade.getExchangeDao().update(obj, className, id, properties);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BExchange.update.error", e);
		}
	}

	@Override
	public BExchange getBExchange(String id) throws Exception {
		BExchange bc = null;
		try {
			bc = (BExchange) this.daoFacade.getExchangeDao().get(BExchange.class.getName(), id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BExchange.getBExchange.error", e);
		}
		return bc;
	}

	@Override
	public void deleteBExchange(BExchange obj) throws Exception {
		try {
			this.daoFacade.getExchangeDao().update(obj, BExchange.class.getName(), obj.getExId(), null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BExchange.deleteBExchange.error", e);
		}
	}

}
