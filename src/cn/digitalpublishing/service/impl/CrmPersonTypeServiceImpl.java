package cn.digitalpublishing.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.BDic;
import cn.digitalpublishing.po.CrmPeTpClassify;
import cn.digitalpublishing.po.CrmPeTypeProp;
import cn.digitalpublishing.po.CrmPersonType;
import cn.digitalpublishing.service.CrmPersonTypeService;
import cn.digitalpublishing.util.DicCache;

public class CrmPersonTypeServiceImpl extends BaseServiceImpl implements CrmPersonTypeService{

	@Override
	public void updateCrmPersonType(CrmPersonType obj, String id,
			String[] properties) throws Exception {
		try {
			this.daoFacade.getCrmPersonTypeDao().update(obj,CrmPersonType.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
	}

	@Override
	public void insertCrmPersonType(CrmPersonType obj) throws Exception {
		try {
			this.daoFacade.getCrmPersonTypeDao().insert(obj);
			
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
	}
	@Override
	public void deletetCrmPersonType(CrmPersonType obj) throws Exception {
		try {
			this.daoFacade.getCrmPersonTypeDao().update(obj,CrmPersonType.class.getName(), obj.getId(),null);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.deletecTransAction.error", e);
		}
	}

	@Override
	public List<CrmPersonType> getPagingList(Map<String, Object> condition,
			String sort, Integer pageCount, Integer page) throws Exception {
		List<CrmPersonType> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPersonTypeDao").get("getPagingList");
		try{
			list=this.daoFacade.getCrmPersonTypeDao().getCrmPersonTypePagingList(condition,sort,pageCount,page,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}


	@Override
	public Integer getCount(Map<String, Object> condition, String sort) throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPersonTypeDao").get("getCount");
		try {
			num = this.daoFacade.getCrmPersonTypeDao().getCount(condition,hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}

	@Override
	public CrmPersonType getCrmPersonType(String id) throws Exception {
		CrmPersonType crmPersonType = null;
		try {
			crmPersonType = (CrmPersonType) this.daoFacade.getCrmPersonTypeDao().get(CrmPersonType.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransaction.error", e);
		}
		return crmPersonType;
	}

	@Override
	public CrmPersonType getCrmPersonTypeByCode(String code) throws Exception {
		CrmPersonType crmPersonType = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmPersonTypeDao").get("getList");
		try {
			Map<String, Object> condition = new HashMap<String,Object>();
			condition.put("code", code);
			
			List<CrmPersonType> list = this.daoFacade.getCrmPersonTypeDao().getList(condition,"",hqlBean);
			crmPersonType = list.get(0);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransaction.error", e);
		}
		return crmPersonType;
	}

	@Override
	public boolean codeUnique(String id, String code) throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("code", code);
		condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS,DicConstants.DATA_STATUS_AVAILABLE));
		int count  = this.getCount(condition,"");
		if("".equals(id) ){
			if(count>0){
				return false;
			}
		}else{
			if(count==1){
				CrmPersonType typeById = this.getCrmPersonType(id);
				CrmPersonType typeByCode = this.getCrmPersonTypeByCode(code);
				if(!typeByCode.getId().equals(typeById.getId())){
					return false;
				}
			}else if(count==0){
				return true;
			}else{
				return false;
			}
		}
		return true;
	}
	
	private CrmPeTpClassify getParentPersonTypePropClassify(CrmPeTpClassify parentClassify, int skipLevel) {
		CrmPeTpClassify parentPersonTypePropClassify = null;
		if (skipLevel > 0) {
			// 继续递归   
			parentPersonTypePropClassify = this.getParentPersonTypePropClassify(parentClassify.getParentClassify(), skipLevel - 1);
		} else {
			// 递归到之前的层
			parentPersonTypePropClassify = parentClassify.getParentClassify();
		}
		return parentPersonTypePropClassify;
	}
	
	@Override
	public void upload(String personTypeId, InputStream is) throws Exception {
		try {
			byte[] excelByte = IOUtils.toByteArray(is);
			Workbook xwb = null;
			try {
				xwb = new XSSFWorkbook(new ByteArrayInputStream(excelByte));
			} catch (Exception e) {
				xwb = new HSSFWorkbook(new ByteArrayInputStream(excelByte));
			}
			
			Sheet sheet = xwb.getSheetAt(0);
			CrmPersonType personType = (CrmPersonType)this.daoFacade.getCrmPersonTypeDao().get(CrmPersonType.class.getName(), personTypeId);
			Map<String, String> dataCache = new HashMap<String, String>();
			CrmPeTpClassify parentClassify = null;
			String previousClassifyCode = null;
			for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
				Row row = sheet.getRow(i);
				if (row != null) {
					// 使用首行来判断是"分类"还是"属性"
					Cell classifyName = row.getCell(0);
					Cell classifyCode = row.getCell(1);
					Cell classifyOrder = row.getCell(2);
					Cell propName = row.getCell(3);
					Cell propCode = row.getCell(4);
					Cell propOrder = row.getCell(5);
					Cell propDisplay = row.getCell(6);
					Cell propMust = row.getCell(7);
					Cell propSource = row.getCell(8);

					if (classifyName != null && !"".equals(classifyName.toString().trim())) {
						// 插入分类
						CrmPeTpClassify personTypePropClassify = new CrmPeTpClassify();
						personTypePropClassify.setName(classifyName.toString());
						personTypePropClassify.setCode(classifyCode.toString());
						personTypePropClassify.setOrder(Integer.parseInt(classifyOrder.toString()));
						personTypePropClassify.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
						personTypePropClassify.setPersonType(personType);
						if (previousClassifyCode == null) {
							personTypePropClassify.setParentClassify(null);
						} else {
							int previousLength = previousClassifyCode.length();
							int currentLength = classifyCode.toString().length();
							if (previousLength == currentLength) {
								// 与上一个分类是同级
								personTypePropClassify.setParentClassify(parentClassify.getParentClassify());
							} else if (previousLength < currentLength) {
								// 是上一个分类的下级
								personTypePropClassify.setParentClassify(parentClassify);
								//level ++;
							} else if (previousLength > currentLength) {
								// 是上一个分类的上级（不一定是上面几级）
								int currentLevel = Math.round((currentLength - 1)/3);
								int previousLevel = Math.round((previousLength - 1)/3);
								int skipLevel = previousLevel - currentLevel;
								personTypePropClassify.setParentClassify(this.getParentPersonTypePropClassify(parentClassify, skipLevel));
							}
						}
						personTypePropClassify.setInternationCode(classifyOrder.toString());
						this.daoFacade.getProductTypePropClassifyDao().insert(personTypePropClassify);
						dataCache.put(classifyCode.toString(), personTypePropClassify.getId());
						previousClassifyCode = classifyCode.toString();
						parentClassify = personTypePropClassify;
					} else {
						// 属性是否必填
						Map<String, Object> condition = new HashMap<String, Object>();
						condition.put("dicName", propMust.toString());
						condition.put("dicClassCode", DicConstants.DIC_MUST);
						HqlBean dicHqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.BDicDao").get("getDicListForExcel");
						List<BDic> dicList = this.daoFacade.getDicDao().getList(condition, "", dicHqlBean);

						// 属性来源
						String source = null;
						if (propSource != null) {
							source = propSource.toString();
						}
						
						// 插入属性
						CrmPeTypeProp personTypeProp = new CrmPeTypeProp();
						personTypeProp.setSourceType(null);
						personTypeProp.setInternationCode(propOrder.toString());
						personTypeProp.setPersonType(personType);
						personTypeProp.setPersonTypePropClassify(parentClassify);
						personTypeProp.setCode(propCode.toString());
						personTypeProp.setName(propName.toString());
						personTypeProp.setOrder(propOrder.toString());
						personTypeProp.setMust(dicList.get(0).getId());
						personTypeProp.setDisplay(DicCache.getIdByCode(DicConstants.DIC_DISPLAY, propDisplay.toString()));
						personTypeProp.setSource(source);
						personTypeProp.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
						this.daoFacade.getCrmPeTypePropDao().insert(personTypeProp);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CcsException("解析Excel出错！");
		} finally{
			IOUtils.closeQuietly(is);
		}
	}

	@Override
	public List<CrmPersonType> getList(Map<String, Object> condition, String sort) throws Exception {
		List<CrmPersonType> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache()
				.get("cn.digitalpublishing.dao.CrmPersonTypeDao")
				.get("getList");
		try{
			list = this.daoFacade.getCrmPersonTypeDao().getList(condition, sort, hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "CrmPersonType.info.getList.error", e);
		}
		return list;
	}
}