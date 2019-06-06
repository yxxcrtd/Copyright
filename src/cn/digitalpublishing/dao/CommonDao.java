package cn.digitalpublishing.dao;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.util.hql.DaoHelper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CommonDao<T, ID extends Serializable> extends BaseDao<T, Serializable> {

    private BaseDao<Object, Serializable> baseDao;

    public void insert(Object obj) throws Exception {
        try {
            baseDao.hibernateDao.save(obj);
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(Object obj, String className, Serializable id, String[] properties) throws Exception {
        try {
            baseDao.hibernateDao.update(obj, className, id, properties);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void saveOrUpdate(T t, String className, Serializable id, String[] properties) throws Exception {
        try {
            if (id == null || id == "") {
                baseDao.hibernateDao.save(t);
            } else {
                baseDao.hibernateDao.update(t, className, id, properties);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void saveOrUpdateAll(List list) throws Exception {
        try {
            baseDao.hibernateDao.saveOrUpdateAll(list);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public T get(String className, Serializable id) throws Exception {
        return (T) baseDao.hibernateDao.getById(className, id);
    }

    public void delete(String className, Serializable id) throws Exception {
        try {
            baseDao.hibernateDao.delete(className, id);
        } catch (Exception e) {
            throw e;
        }
    }

    public BaseDao<Object, Serializable> getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao<Object, Serializable> baseDao) {
        this.baseDao = baseDao;
    }


    public List<T> getCountList(Map<String, Object> condition, HqlBean hqlBean) throws Exception {
        try {
            DaoHelper helper = new DaoHelper();
            String where = (helper.getWhere(hqlBean.getConditions(), condition) != null && "".equals(helper.getWhere(hqlBean.getConditions(), condition))) ? helper.getWhere(hqlBean.getConditions(), condition) : " where " + helper.getWhere(hqlBean.getConditions(), condition);
            List<T> list = hibernateDao.getListByHql(hqlBean.getProperties(), hqlBean.getFields(), hqlBean.getHql() + where, helper.getCondition() == null ? null : helper.getCondition().toArray(), hqlBean.getOrder(), hqlBean.getClassName());
            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<T> getPagingList(Map<String, Object> condition, String sort, Integer pageSize, Integer startIndex, HqlBean hqlBean) throws Exception {
        DaoHelper helper = new DaoHelper();
        String where = (helper.getWhere(hqlBean.getConditions(), condition) != null && "".equals(helper.getWhere(hqlBean.getConditions(), condition))) ? helper.getWhere(hqlBean.getConditions(), condition) : " where " + helper.getWhere(hqlBean.getConditions(), condition);
        List<T> list = hibernateDao.getListByHql(hqlBean.getProperties(), hqlBean.getFields(), hqlBean.getHql() + where, helper.getCondition() == null ? null : helper.getCondition().toArray(), hqlBean.getOrder(), hqlBean.getClassName(), pageSize, startIndex);
        return list;
    }

    public List<T> getList(Map<String, Object> condition, String sort, HqlBean hqlBean) throws Exception {
        DaoHelper helper = new DaoHelper();
        String where = (helper.getWhere(hqlBean.getConditions(), condition) != null && "".equals(helper.getWhere(hqlBean.getConditions(), condition))) ? helper.getWhere(hqlBean.getConditions(), condition) : " where " + helper.getWhere(hqlBean.getConditions(), condition);
        List<T> list = hibernateDao.getListByHql(hqlBean.getProperties(), hqlBean.getFields(), hqlBean.getHql() + where, helper.getCondition() == null ? null : helper.getCondition().toArray(), sort, hqlBean.getClassName());
        return list;
    }

}