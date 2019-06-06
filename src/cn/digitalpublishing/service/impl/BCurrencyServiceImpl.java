package cn.digitalpublishing.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.BCurrency;
import cn.digitalpublishing.service.BCurrencyService;
import cn.digitalpublishing.util.DicCache;

public class BCurrencyServiceImpl extends BaseServiceImpl implements BCurrencyService {

	@Override
	public List<BCurrency> getPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer page) throws Exception {
		List<BCurrency> list = null;
		
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BCurrencyDao").get("getPagingList");
			list = this.daoFacade.getCurrencyDao().getPagingList(condition, sort, pageCount, page, hqlBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BCurrency.getPagingList.error", e);
		}
		return list;
	}

	@Override
	public List<BCurrency> getList(Map<String, Object> condition, String sort)
			throws Exception {
		List<BCurrency> list = null;
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BCurrencyDao").get("getList");
			list = this.daoFacade.getCurrencyDao().getList(condition, sort, hqlBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BCurrency.getList.error", e);
		}
		return list;
	}

	@Override
	public Integer getCount(Map<String, Object> condition, String sort)
			throws Exception {
		int num = 0;
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BCurrencyDao").get("getCount");
			num = this.daoFacade.getCurrencyDao().getCount(condition, sort, hqlBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BCurrency.getCount.error", e);
		}
		return num;
	}

	@Override
	public void insert(BCurrency obj) throws Exception {
		try {
			this.daoFacade.getCurrencyDao().insert(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BCurrency.insert.error", e);
		}
	}

	@Override
	public void update(Object obj, String className, Serializable id,
			String[] properties) throws Exception {
		try {
			this.daoFacade.getCurrencyDao().update(obj, className, id, properties);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BCurrency.update.error", e);
		}
	}

	@Override
	public BCurrency getBCurrency(String id) throws Exception {
		BCurrency bc = null;
		try {
			bc = (BCurrency) this.daoFacade.getCurrencyDao().get(BCurrency.class.getName(), id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BCurrency.getBCurrency.error", e);
		}
		return bc;
	}

	@Override
	public void update(BCurrency obj) throws Exception {
		try {
			this.daoFacade.getCurrencyDao().update(obj, BCurrency.class.getName(), obj.getCurrencyId(), null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BCurrency.update.error", e);
		}
	}

	@Override
	public boolean currencyNameUnique(String currencyName)
			throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		
		condition.put("currencyName", currencyName);
		condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS,DicConstants.DATA_STATUS_AVAILABLE));
		
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BCurrencyDao").get("getCount");
		Integer count = this.daoFacade.getCurrencyDao().getCount(condition, "", hqlBean);

		if (count == 0) {
			return true;
		}
		return false;
	}

}
