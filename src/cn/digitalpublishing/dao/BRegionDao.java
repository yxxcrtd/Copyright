package cn.digitalpublishing.dao;

import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.util.hql.DaoHelper;
import cn.digitalpublishing.po.BRegion;

public class BRegionDao extends CommonDao<BRegion, String> {



	public List<BRegion> getList(Map<String, Object> condition, String sort, HqlBean hqlBean ) throws Exception {
		List<BRegion> list = null;
		
		try {
			DaoHelper helper = new DaoHelper();
			String where="";
			if (condition.get("ppt")!=null&&condition.get("ppt").equals("55")) {
				where =" where a.fullName is not null ";
			}else{
				where = (helper.getWhere(hqlBean.getConditions(), condition) != null && "".equals(helper.getWhere(hqlBean.getConditions(), condition))) ? helper.getWhere(hqlBean.getConditions(), condition) : " where "+helper.getWhere(hqlBean.getConditions(), condition);
			}
			
			list = hibernateDao.getListByHql(hqlBean.getProperties(), hqlBean.getFields(), hqlBean.getHql()+where,helper.getCondition()==null?null:helper.getCondition().toArray(),sort+hqlBean.getOrder(), hqlBean.getClassName());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	public Integer getRegionCount(Map<String, Object> condition, String sort,HqlBean hqlBean) throws Exception {
		List<BRegion> list = null;
		
		try {
			DaoHelper helper = new DaoHelper();
			String where = (helper.getWhere(hqlBean.getConditions(), condition) != null && "".equals(helper.getWhere(hqlBean.getConditions(), condition))) ? helper.getWhere(hqlBean.getConditions(), condition) : " where "+helper.getWhere(hqlBean.getConditions(), condition);
			list = hibernateDao.getListByHql(hqlBean.getProperties(), hqlBean.getFields(), hqlBean.getHql()+where,helper.getCondition()==null?null:helper.getCondition().toArray(),sort+hqlBean.getOrder(), hqlBean.getClassName());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list == null ? 0 : Integer.valueOf(list.get(0).getId());
	}
}
