package cn.digitalpublishing.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.CrSettlement;
import cn.digitalpublishing.service.CrSettlementService;
import cn.digitalpublishing.util.DicCache;

public class CrSettlementServiceImpl extends BaseServiceImpl implements CrSettlementService {
	
	@Override
	public void edit(CrSettlement obj, Map<String, Object> dic) throws Exception {
		dic.put("CrSettlementType", DicCache.getDicData(DicConstants.CR_SETTLEMENT_TYPE)); // 版税结算状态
	}
	
	@Override
	public void insert(CrSettlement obj) throws Exception {
		try {
			daoFacade.getSettlementDao().insert(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "crOwnerService.info.insertCrOwner.error", e);
		}
	}

	@Override
	public void update(CrSettlement obj) throws Exception {
		try {
			daoFacade.getSettlementDao().update(obj, CrSettlement.class.getName(), obj.getId(), null);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "crOwnerService.info.deleteCrOwner.error", e);
		}
	}

	@Override
	public List<CrSettlement> getPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer countStart) throws Exception {
		List<CrSettlement> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrSettlementDao").get("getPagingList");
		try {
			list = daoFacade.getSettlementDao().getPagingList(condition, sort, pageCount, countStart, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "crOwnerService.info.getCrOwnerPagingList.error", e);
		}
		return list;
	}

	@Override
	public Integer getCount(Map<String, Object> condition) throws Exception {
		Integer num = 0;
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrSettlementDao").get("getCount");
			num = daoFacade.getSettlementDao().getCount(condition, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "crOwnerService.info.getCrOwnerCount.error", e);
		}
		return num;
	}

	@Override
	public CrSettlement getById(String id) throws Exception {
		CrSettlement cla = null;
        try {
            cla = (CrSettlement) this.daoFacade.getSettlementDao().get(CrSettlement.class.getName(), id);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransaction.error", e);
        }
        return cla;
    }
	
	@Override
	public List<CrSettlement> getList(Map<String, Object> condition, String sort) throws Exception {
		List<CrSettlement> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrSettlementDao").get("getList");
		try {
			list = daoFacade.getSettlementDao().getList(condition, "", hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "crOwnerService.info.getCrOwnerList.error", e);
		}
		return list;
	}

}