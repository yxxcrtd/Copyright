
package cn.digitalpublishing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.BRegion;
import cn.digitalpublishing.service.BRegionService;
import cn.digitalpublishing.util.DicCache;

public class BRegionServiceImpl extends BaseServiceImpl implements BRegionService {

	@Override
	public List<BRegion> getList(Map<String, Object> condition, String sort) throws Exception {
		List<BRegion> list = null;
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BRegionDao").get("getList");
			list = this.daoFacade.getRegionDao().getList(condition, sort, hqlBean);
			// list = this.daoFacade.getRegionDao().getList(condition, sort);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "BRegion.getList.error", e);
		}
		return list;
	}

	@Override
	public int getBRegionCount(Map<String,Object> condition,String sort) throws Exception
	{
		int num = 0;
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BRegionDao").get("getCount");
			num = this.daoFacade.getRegionDao().getRegionCount(condition, sort, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt()	: "BCountry.getBRegionCount.error", e);
		}
		return num;
	}
	
	@Override
	public void insert(BRegion obj) throws Exception {

		try {
			this.daoFacade.getRegionDao().insert(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "BRegion.insert.error", e);
		}

	}

	@Override
	public void insertRegion(BRegion obj) throws Exception {

		try {
			String code = getNextCode(obj);
			obj.setTreeCode(code);
			Integer order = getNextOrder(obj);
			obj.setOrder(order);
			this.daoFacade.getRegionDao().insert(obj);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "BRegion.insertRegion.error", e);
		}

	}

	@Override
	public BRegion getBRegion(String id) throws Exception {

		BRegion b = null;
		try {
			b = (BRegion) this.daoFacade.getRegionDao().get(BRegion.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "BRegion.getBRegion.error", e);
		}
		return b;
	}

	@Override
	public void update(BRegion obj) throws Exception {

		try {
			this.daoFacade.getRegionDao().update(obj, BRegion.class.getName(), obj.getId(), null);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "BRegion.update.error", e);
		}
	}

	@Override
	public void delete(String id) throws Exception {

		try {
			BRegion br = new BRegion();
			br.setId(id);
			br.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE));
			this.daoFacade.getRegionDao().update(br, BRegion.class.getName(), id, null);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "BRegion.delete.error", e);
		}
	}

	public String getNextCode(BRegion obj) throws Exception {

		String code = "";
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("parentId", obj.getParentRegion() == null ? "1" : obj.getParentRegion().getId());
			String parCode = "";
			if (obj.getParentRegion() != null) {
				BRegion bs = (BRegion) this.daoFacade.getRegionDao().get(BRegion.class.getName(), obj.getParentRegion().getId());
				parCode = bs.getTreeCode();
			}
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BRegionDao").get("getList");
			List<BRegion> list = this.daoFacade.getRegionDao().getList(condition, " order by a.code desc ", hqlBean);
			code = ((list == null || list.isEmpty()) ? "001" : list.get(0) == null ? "001" : list.get(0).getTreeCode());
			if (list != null && !list.isEmpty()) {
				if (parCode.trim().length() > 0) {
					code = code.substring(parCode.length());
				}
				int num = Integer.valueOf(code).intValue();
				num++;
				String mid = String.valueOf(num);
				if (mid.length() == 1) {
					code = "00" + mid;
				}
				if (mid.length() == 2) {
					code = "0" + mid;
				}
				if (mid.length() == 3) {
					code = mid;
				}
			}
			code = parCode + code;
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "BRegion.getNextCode.error", e);
		}
		return code;
	}

	public Integer getNextOrder(BRegion obj) throws Exception {

		Integer order = 1;
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("parentId", obj.getParentRegion() == null ? "1" : obj.getParentRegion().getId());
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BRegionDao").get("getList");
			List<BRegion> list = this.daoFacade.getRegionDao().getList(condition, " order by a.code desc ", hqlBean);

			order = ((list == null || list.isEmpty()) ? 1 : list.get(0) == null ? 1 : (list.get(0).getOrder()==null?1:list.get(0).getOrder() + 1));
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "BRegion.getNextOrder.error", e);
		}

		return order;
	}

	@Override
	public List<BRegion> getListNoParent(Map<String, Object> condition,
			String sort) throws Exception {
		List<BRegion> list = null;
		try {
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BRegionDao").get("getListNoParent");
			list = this.daoFacade.getRegionDao().getList(condition, sort, hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "BRegion.getList.error", e);
		}
		return list;
	}
	
	@Override
	public boolean codeUnique(String id,String code, String countryId) throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("code", code);
		condition.put("coId", countryId);
		condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS,DicConstants.DATA_STATUS_AVAILABLE));
		int count = this.getBRegionCount(condition, "");
		// 新增时，id为空
		if ("".equals(id)) {
			if (count > 0) {
				return false;
			}
		} else {
			if (count == 1) {
				BRegion regionId = this.getBRegion(id);
				BRegion regionCode = this.getList(condition, "").get(0);
				if (!regionId.getId().equals(regionCode.getId())) {
					return false;
				}
			} else if (count == 0) {
				return true;
			}
		}
		return true;
	}

}
