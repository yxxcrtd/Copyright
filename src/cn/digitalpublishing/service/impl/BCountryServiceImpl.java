package cn.digitalpublishing.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.BCountry;
import cn.digitalpublishing.po.BRegion;
import cn.digitalpublishing.service.BCountryService;
import cn.digitalpublishing.util.DicCache;

public class BCountryServiceImpl extends BaseServiceImpl implements BCountryService {

	@Override
	public List<BCountry> getPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws Exception {
		List<BCountry> list = null;
		
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BCountryDao").get("getPagingList");
			list = this.daoFacade.getCountryDao().getPagingList(condition, sort, pageCount, page, hqlBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BCountry.getPagingList.error", e);
		}
		
		return list;
	}

	@Override
	public Integer getCount(Map<String, Object> condition, String sort) throws Exception {
		
		int num = 0;
		
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BCountryDao").get("getCount");
			num = this.daoFacade.getCountryDao().getCount(condition, sort, hqlBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BCountry.getCount.error", e);
		}
		
		return num;
		
	}

	@Override
	public void insert(BCountry obj) throws Exception {
		
		try {
			this.daoFacade.getCountryDao().insert(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BCountry.insert.error", e);
		}
	}

	@Override
	public void update(Object obj, String className, Serializable id, String[] properties) throws Exception {
		
		try {
			this.daoFacade.getCountryDao().update(obj, className, id, properties);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BCountry.update.error", e);
		}
	}

	@Override
	public List<BCountry> getList(Map<String, Object> condition, String sort) throws Exception {
		
		List<BCountry> list = null;
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BCountryDao").get("getList");
			list = this.daoFacade.getCountryDao().getList(condition, sort, hqlBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BCountry.getList.error", e);
		}
		
		return list;
	}
	

	@Override
	public BCountry getBCountry(String id) throws Exception {
		
		BCountry bc = null;
		
		try {
			bc = (BCountry) this.daoFacade.getCountryDao().get(BCountry.class.getName(), id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BCountry.getBCountry.error", e);
		}
		
		
		return bc;
	}

	@Override
	public void update(BCountry obj) throws Exception {
		try {
			this.daoFacade.getCountryDao().update(obj, BCountry.class.getName(), obj.getId(), null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BCountry.update.error", e);
		}
	}

	@Override
	public boolean cnNameUnique(String cnName) throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("cnName", cnName);
		condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS,DicConstants.DATA_STATUS_AVAILABLE));
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BCountryDao").get("getCount");
		Integer count = this.daoFacade.getCountryDao().getCount(condition, "", hqlBean);
		
		if (count == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean enNameUnique(String enName) throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("enName", enName);
		condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS,DicConstants.DATA_STATUS_AVAILABLE));
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BCountryDao").get("getCount");
		Integer count = this.daoFacade.getCountryDao().getCount(condition, "", hqlBean);
		
		if (count == 0) {
			return true;
		}
		return false;
	}
}
