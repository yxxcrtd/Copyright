package cn.digitalpublishing.dao;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.util.hql.DaoHelper;
import cn.digitalpublishing.po.PProposalPersonRelationship;

import java.util.List;
import java.util.Map;

/**
 * Created by huangchenxi on 14-7-15.
 */
public class PProposalPersonRelationshipDao extends CommonDao<PProposalPersonRelationship, String> {

    public List<PProposalPersonRelationship> getPProposalPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer countStart, HqlBean hqlBean) throws Exception {
        try {
            DaoHelper helper = new DaoHelper();
            String where = (helper.getWhere(hqlBean.getConditions(), condition) != null && "".equals(helper.getWhere(hqlBean.getConditions(), condition))) ? helper.getWhere(hqlBean.getConditions(), condition) : " where " + helper.getWhere(hqlBean.getConditions(), condition);
            List<PProposalPersonRelationship> list = hibernateDao.getListByHql(hqlBean.getProperties(), hqlBean.getFields(), hqlBean.getHql() + where, helper.getCondition() == null ? null : helper.getCondition().toArray(), hqlBean.getOrder(), hqlBean.getClassName(), pageCount, countStart);
            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    public Integer getCount(Map<String, Object> condition, HqlBean hqlBean) throws Exception {
        try {
            DaoHelper helper = new DaoHelper();
            String where = (helper.getWhere(hqlBean.getConditions(), condition) != null && "".equals(helper.getWhere(hqlBean.getConditions(), condition))) ? helper.getWhere(hqlBean.getConditions(), condition) : " where " + helper.getWhere(hqlBean.getConditions(), condition);
            List<PProposalPersonRelationship> list = hibernateDao.getListByHql(hqlBean.getProperties(), hqlBean.getFields(), hqlBean.getHql() + where, helper.getCondition() == null ? null : helper.getCondition().toArray(), hqlBean.getOrder(), hqlBean.getClassName());
            return list == null ? 0 : Integer.valueOf(list.get(0).getId());
        } catch (Exception e) {
            throw e;
        }
    }

    public List<PProposalPersonRelationship> getPProposalList(Map<String, Object> condition, String sort, HqlBean hqlBean) throws Exception {
        try {
            DaoHelper helper = new DaoHelper();
            String where = (helper.getWhere(hqlBean.getConditions(), condition) != null && "".equals(helper.getWhere(hqlBean.getConditions(), condition))) ? helper.getWhere(hqlBean.getConditions(), condition) : " where " + helper.getWhere(hqlBean.getConditions(), condition);
            List<PProposalPersonRelationship> list = hibernateDao.getListByHql(hqlBean.getProperties(), hqlBean.getFields(), hqlBean.getHql() + where, helper.getCondition() == null ? null : helper.getCondition().toArray(), hqlBean.getOrder(), hqlBean.getClassName());
            return list;
        } catch (Exception e) {
            throw e;
        }
    }
}
