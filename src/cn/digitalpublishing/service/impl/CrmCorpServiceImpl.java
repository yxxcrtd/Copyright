package cn.digitalpublishing.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.CrmCorp;
import cn.digitalpublishing.po.CrmCorpProp;
import cn.digitalpublishing.po.CrmCorpType;
import cn.digitalpublishing.po.CrmCorpTypeRelationship;
import cn.digitalpublishing.po.CrmCtpClassify;
import cn.digitalpublishing.po.CrmCtypeProp;
import cn.digitalpublishing.service.CrmCorpService;
import cn.digitalpublishing.springmvc.form.CrmCorpForm;
import cn.digitalpublishing.util.DicCache;
import cn.digitalpublishing.util.PinyinUtils;
import cn.digitalpublishing.util.TreeNode;
import com.google.common.base.Strings;

public class CrmCorpServiceImpl extends BaseServiceImpl implements CrmCorpService {

	@Override
	public void saveCorp(CrmCorpForm form) throws Exception {
		String statusYes = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
		Map<String, Object> condition = new HashMap<String, Object>();
		CrmCorpType corpType = form.getCorpType();
		CrmCorp corp = form.getCorp();
		corp.setNameFirstChar(PinyinUtils.getPinyinFirstChar(corp.getShortName()));
		if (Strings.isNullOrEmpty(corp.getId())) {
			daoFacade.getCrmCorpDao().insert(corp);
		} else {
			daoFacade.getCrmCorpDao().update(corp, CrmCorp.class.getName(), corp.getId(), null);
		}
		
		CrmCorpTypeRelationship relationship = form.getRelation();
		if (relationship.getParentRelationship().getId().equals("root")) {
			relationship.setParentRelationship(null);
		}
		relationship.setCorpType(corpType);
		relationship.setCorp(corp);
		relationship.setStatus(statusYes);
		daoFacade.getCrmCorpTypeRelationshipDao().insert(relationship);
		
		form.setNode(createTreeNode(relationship)); // 创建树节点
		
		condition.clear();
		condition.put("status", statusYes);
		condition.put("corpType_id", corpType.getId());
		String daoClassName = "cn.digitalpublishing.dao.CrmCorpTypePropDao";
		String daoMethodName = "getCorpTypePropList";
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get(daoClassName).get(daoMethodName);
		List<CrmCtypeProp> corpTypePropList = daoFacade.getCrmCorpTypePropDao().getCorpTypePropList(condition, hqlBean);
		List<CrmCorpProp> corpPropList = new ArrayList<CrmCorpProp>();
		CrmCorpProp corpProp = null;
		for (CrmCtypeProp corpTypeProp : corpTypePropList) {
			corpProp = new CrmCorpProp();
			corpProp.setCorpTypeRelationship(relationship);
			corpProp.setCorpTypeProp(corpTypeProp);
			corpProp.setCode(corpTypeProp.getCode());
			corpProp.setName(corpTypeProp.getName());
			corpProp.setOrder(corpTypeProp.getOrder());
			corpProp.setDisplay(corpTypeProp.getDisplay());
			corpProp.setMust(corpTypeProp.getMust());
			corpProp.setSource(corpTypeProp.getSource());
			corpProp.setStatus(statusYes);
			corpPropList.add(corpProp);
		}
		daoFacade.getCrmCorpPropDao().getHibernateDao().saveOrUpdateAll(corpPropList);
	}
	
	@Override
	public void updateCorp(CrmCorpForm form) throws Exception {
		CrmCorp corp = form.getCorp();
		corp.setNameFirstChar(corp.getNameFirstChar().toUpperCase());
		String[] ids = form.getPropsId();
		String[] values = form.getPropsValue();
		daoFacade.getCrmCorpDao().update(corp, CrmCorp.class.getName(), corp.getId(), null);
		if (ids != null && ids.length > 0) {
			CrmCorpProp prop = null;
			for(int i = 0; i < ids.length; i++) {
				prop = new CrmCorpProp();
				prop.setId(ids[i]);
				prop.setValue(values[i]);
				daoFacade.getCrmCorpPropDao().update(prop, CrmCorpProp.class.getName(), prop.getId(), null);
			}
		}
		form.getRelation().setCorp(corp);
	}
	
	@Override
	public void edit(CrmCorpForm form) throws Exception {
		
		
	}

	@Override
	public List<TreeNode> getChildCorpTreeNodes(CrmCorpForm form) throws Exception {
		String statusYes = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
		String daoClassName = "cn.digitalpublishing.dao.CrmCorpTypeRelationshipDao";
		String daoMethodName = "getTreeChildNodes";
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		Map<String, Object> condition = form.getCondition();
		try {
			condition.put("parentId", form.getId());
			condition.put("corpTypeId", form.getCorpType().getId());
			condition.put("corpTypeCode", form.getCorpType().getCode());
			condition.put("status", statusYes);
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get(daoClassName).get(daoMethodName);
			List<CrmCorpTypeRelationship> list = this.daoFacade.getCrmCorpTypeRelationshipDao().getTreeChildNodes(form.getCondition(), hqlBean);
			for (CrmCorpTypeRelationship item : list) {
				nodes.add(createTreeNode(item));
			}
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "corp.getCorpPagingList.error", e);
		}
		return nodes;
	}

	/**
	 * 构建树节点对象
	 * @param relationship
	 * @param
	 * @return
	 */
	private TreeNode createTreeNode(CrmCorpTypeRelationship relationship) {
		TreeNode node = new TreeNode();
		if (relationship.getParentRelationship() == null) {
			node.setPid("root");
		} else {
			node.setPid(relationship.getParentRelationship().getId());
		}
		node.setId(relationship.getId());
		node.setName(relationship.getCorp().getShortName());
//		node.setName(CssUtil.addTreeNodeCss(relationship.getCorp().getShortName()));
		if (relationship.getChildSize() > 0) {
			node.setIsParent(true);
		} else {
			node.setIsParent(false);
		}
		return node;
	}

	@Override
	public List<CrmCorp> getCorpListNotInCurrentCorpType(CrmCorpForm form) throws Exception {
		
		return null;
	}

	@Override
	public CrmCorpTypeRelationship editTreeNode(CrmCorpTypeRelationship relation) throws Exception {
		return daoFacade.getCrmCorpTypeRelationshipDao().get(CrmCorpTypeRelationship.class.getName(), relation.getId());
	}

	@Override
	public void addTab(CrmCorpForm form) throws Exception {
		String statusYes = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
		Map<String, Object> condition = form.getCondition();
		
		String daoClassName = "cn.digitalpublishing.dao.CrmCorpTypePropClassifyDao";
		String daoMethodName = "getCorpTypeClassifyList";
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get(daoClassName).get(daoMethodName);
		condition.put("corpType_id", form.getCorpType().getId());
		condition.put("parentClassify_id", form.getCorpTypePropClassify().getId());
		condition.put("status", statusYes);
		List<CrmCtpClassify> corpTypePropClassifyList = daoFacade.getCrmCorpTypePropClassifyDao().getCorpTypeClassifyList(condition, hqlBean);
		form.setTypePropClassifyList(corpTypePropClassifyList);
		
		if (corpTypePropClassifyList.isEmpty()) {
			daoClassName = "cn.digitalpublishing.dao.CrmCorpPropDao";
			daoMethodName = "getList";
			condition.clear();
			condition.put("corpTypeRelationship_id", form.getRelation().getId());
			condition.put("corpTypePropClassify_id", form.getCorpTypePropClassify().getId());
			hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get(daoClassName).get(daoMethodName);
			List<CrmCorpProp> corpPropList = daoFacade.getCrmCorpPropDao().getList(condition, hqlBean);
			form.setCorpPropList(corpPropList);

		}
	}

	@Override
	public void delete(CrmCorpTypeRelationship relationship) throws Exception {
		String statusNo = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE);
		relationship.setStatus(statusNo);
		daoFacade.getCrmCorpTypeRelationshipDao().update(relationship, CrmCorpTypeRelationship.class.getName(), relationship.getId(), null);
	}

	@Override
	public List<CrmCorp> getAvailableCorpCode(CrmCorpType type) throws Exception {
		String statusNo = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("corpType_id", type.getId());
		condition.put("status", statusNo);
		
		String daoClassName = "cn.digitalpublishing.dao.CrmCorpDao";
		String daoMethodName = "getList";
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get(daoClassName).get(daoMethodName);
		List<CrmCorp> list = daoFacade.getCrmCorpDao().getList(condition, hqlBean);
		
		
		return list;
	}

	@Override
	public boolean checkCodeIsAvailable(CrmCorp corp) throws Exception {
		String statusNo = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("corp_code", corp.getCode());
		condition.put("status", statusNo);
		String daoClassName = "cn.digitalpublishing.dao.CrmCorpTypeRelationshipDao";
		String daoMethodName = "getByCorpCode";
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get(daoClassName).get(daoMethodName);
		List<CrmCorpTypeRelationship> list = daoFacade.getCrmCorpTypeRelationshipDao().getTreeChildNodes(condition, hqlBean);
		if (list.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public List<TreeNode> upload(CrmCorpType corpType, InputStream excel) throws Exception {
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		try {
			Map<String, CrmCorpTypeRelationship> persistentRelation = new HashMap<String, CrmCorpTypeRelationship>();
			String statusAvailable = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
			
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("status", statusAvailable);
			condition.put("corpType_id", corpType.getId());
			String daoClassName = "cn.digitalpublishing.dao.CrmCorpTypePropDao";
			String daoMethodName = "getCorpTypePropList";
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get(daoClassName).get(daoMethodName);
			List<CrmCtypeProp> corpTypePropList = daoFacade.getCrmCorpTypePropDao().getCorpTypePropList(condition, hqlBean);
			
			XSSFWorkbook xwb = new XSSFWorkbook(excel);
			XSSFSheet sheet = xwb.getSheetAt(0);
			for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow row = sheet.getRow(i);
				if (row != null) {
					XSSFCell cell0 = row.getCell(0);
					XSSFCell cell1 = row.getCell(1);
					XSSFCell cell2 = row.getCell(2);
					if (cell0 != null && cell1 != null && cell2 != null) {
						String name = cell0.toString();
						String code = cell1.toString();
						String treeCode = cell2.toString();
						
						if (!Strings.isNullOrEmpty(name) && !Strings.isNullOrEmpty(code) && !Strings.isNullOrEmpty(treeCode)) {
							CrmCorpTypeRelationship relationship = new CrmCorpTypeRelationship();
							
							CrmCorp corp = new CrmCorp();
							corp.setShortName(name);
							corp.setFullName(name);
							corp.setCode(code);
							daoFacade.getCrmCorpDao().insert(corp);
							
							if (treeCode.length() == 3) {
								relationship.setParentRelationship(null);
							} else if(treeCode.length() > 3) {
								String parentCode = treeCode.substring(0, treeCode.length() - 3);
								relationship.setParentRelationship(persistentRelation.get(parentCode));
							}
							
							relationship.setTreeCode(treeCode);
							relationship.setCorpType(corpType);
							relationship.setCorp(corp);
							relationship.setStatus(statusAvailable);
							
							daoFacade.getCrmCorpTypeRelationshipDao().insert(relationship);
							persistentRelation.put(treeCode, relationship);
							nodeList.add(createTreeNode(relationship));
							
							List<CrmCorpProp> corpPropList = new ArrayList<CrmCorpProp>();
							CrmCorpProp corpProp = null;
							for (CrmCtypeProp corpTypeProp : corpTypePropList) {
								corpProp = new CrmCorpProp();
								corpProp.setCorpTypeRelationship(relationship);
								corpProp.setCorpTypeProp(corpTypeProp);
								corpProp.setCode(corpTypeProp.getCode());
								corpProp.setName(corpTypeProp.getName());
								corpProp.setOrder(corpTypeProp.getOrder());
								corpProp.setDisplay(corpTypeProp.getDisplay());
								corpProp.setMust(corpTypeProp.getMust());
								corpProp.setSource(corpTypeProp.getSource());
								corpProp.setStatus(statusAvailable);
								corpPropList.add(corpProp);
							}
							daoFacade.getCrmCorpPropDao().getHibernateDao().saveOrUpdateAll(corpPropList);
						}
					}
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(excel);
		}
		return nodeList;
	}
}