package cn.digitalpublishing.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.BDic;
import cn.digitalpublishing.po.CrmCorpType;
import cn.digitalpublishing.po.CrmCtpClassify;
import cn.digitalpublishing.po.CrmCtypeProp;
import cn.digitalpublishing.service.CrmCorpTypeService;
import cn.digitalpublishing.util.DicCache;

public class CrmCorpTypeServiceImpl extends BaseServiceImpl implements CrmCorpTypeService {

/*	@Autowired
	@Qualifier("crmCorpTypePropClassifyService")
	protected CrmCorpTypePropClassifyService crmCorpTypePropClassifyService;*/
	
	@Override
	public void updateCorpType(CrmCorpType obj, String id, String[] properties) throws Exception {
		try {
			this.daoFacade.getCrmCorpTypeDao().update(obj,CrmCorpType.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
		
	}

	@Override
	public void insertCorpType(CrmCorpType obj) throws Exception {
		try {
			//获取  code 值
			//String code = getNextCode(obj);
			//obj.setTreeCode(code);
			//获取  order 值
			Integer order = getNextOrder(obj);
			obj.setOrder(order);
			obj.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			this.daoFacade.getCrmCorpTypeDao().insert(obj);
//			//每新增一个产品类型--就为该类型下新增一个默认的--基本类型属性分类
//			PTypePropClassify ptpc = new PTypePropClassify();
//			ptpc.setCorpType(obj);
//			ptpc.setName("基本分类");
//			ptpc.setCode(obj.getCode());
//			ptpc.setOrder(0);
//			ptpc.setInternalCode(obj.getCode());
//			ptpc.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
//			this.typePropClassifyService.insertClassify(ptpc);
	} catch (Exception e) {
		throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.insertCTransaction.error", e);
		}
	}

	@Override
	public void deletecCorpType(String id) throws Exception {
		try {
			this.daoFacade.getCrmCorpTypeDao().delete(CrmCorpType.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.deletecTransAction.error", e);
		}
	}

	@Override
	public List<CrmCorpType> getCorpTypePagingList(Map<String, Object> condition, String sort, Integer pageCount,Integer page) throws Exception {
		List<CrmCorpType> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCorpTypeDao").get("getPagingList");
		try{
			list=this.daoFacade.getCrmCorpTypeDao().getCorpTypePagingList(condition,sort,pageCount,page,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public Integer getCorpTypeCount(Map<String, Object> condition)
			throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCorpTypeDao").get("getCount");
		try {
			num = this.daoFacade.getCrmCorpTypeDao().getCount(condition,hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}
	
    public CrmCorpType getCorpType(String id) throws Exception{
    	CrmCorpType cla = null;
		try {
			cla = (CrmCorpType) this.daoFacade.getCrmCorpTypeDao().get(CrmCorpType.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransaction.error", e);
		}
		return cla;
    }

	@Override
	public CrmCorpType getCorpTypeByCode(String code) throws Exception {
		CrmCorpType cla = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCorpTypeDao").get("getList");
		try {
			Map<String, Object> condition = new HashMap<String,Object>();
			condition.put("code", code);
			cla = (CrmCorpType) this.daoFacade.getCrmCorpTypeDao().getCorpTypeList(condition,"",hqlBean).get(0);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransaction.error", e);
		}
		return cla;
	}
	
	@Override
	public boolean codeUnique(String id, String code) throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("code", code);
		int count  = this.getCorpTypeCount(condition);
		if("".equals(id) ){
			if(count>0){
				return false;
			}
		}else{
			if(count==1){
				CrmCorpType typeById = this.getCorpType(id);
				CrmCorpType typeByCode = this.getCorpTypeByCode(code);
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

	@Override
	public List<CrmCorpType> getCorpTypeTreeList(Map<String, Object> condition, String sort) throws Exception {
		List<CrmCorpType> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCorpTypeDao").get("getTreeList");
		try{
			list=this.daoFacade.getCrmCorpTypeDao().getCorpTypeTreeList(condition,sort,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "PCorpType.info.getTreeList.error", e);
		}
		return list;
	}
	
	private String getNextCode(CrmCorpType obj) throws CcsException{
		String code = "";
//		Map<String, Object> condition = new HashMap<String, Object>();
//		condition.put("parentId", obj.getParentCorpType() == null ? "root" : obj.getParentCorpType().getId());
//		try{
//			String parCode = "";
//			if (obj.getParentCorpType() != null) {
//				CrmCorpType propType = (CrmCorpType) this.daoFacade.getCrmCorpTypeDao().get(CrmCorpType.class.getName(), obj.getParentCorpType().getId());
//				//parCode = propType.getTreeCode();
//			}
//			
//			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PCorpTypeDao").get("getTreeList");
//			List<CrmCorpType> list = this.daoFacade.getCrmCorpTypeDao().getCorpTypeList(condition, " order by a.treeCode desc ", hqlBean);
//			code = ((list == null || list.isEmpty()) ? "001" : list.get(0) == null ? "001" : list.get(0).getTreeCode());
//			if (list != null && !list.isEmpty()) {
//				if (parCode.trim().length() > 0) {
//					code = code.substring(parCode.length());
//				}
//				int num = Integer.valueOf(code).intValue();
//				num++;
//				String mid = String.valueOf(num);
//				if (mid.length() == 1) {
//					code = "00" + mid;
//				}
//				if (mid.length() == 2) {
//					code = "0" + mid;
//				}
//				if (mid.length() == 3) {
//					code = mid;
//				}
//			}
//			code = parCode + code;
//		}catch(Exception e){
//			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "PCorpType.getNextCode.error", e);
//		}
		return code;
	}
	
	private Integer getNextOrder(CrmCorpType obj) throws Exception {
		Integer order = 1;
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			// condition.put("parentSubject", obj.getParentCorpType() == null ? "root" : obj.getParentCorpType().getId());
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.CrmCorpTypeDao").get("getTreeList");
			List<CrmCorpType> list = this.daoFacade.getCrmCorpTypeDao().getCorpTypeList(condition, " order by a.order desc ", hqlBean);
			order=((list==null||list.isEmpty())?1:list.get(0)==null?1:(list.get(0).getOrder()+1));
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "CorpType.getNextOrder.error", e);
		}
		return order;
	}

	@Override
	public void  falseDel(String id) throws Exception {
		try {
			CrmCorpType obj = this.getCorpType(id);
			obj.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE));//
			this.daoFacade.getCrmCorpTypeDao().update(obj,CrmCorpType.class.getName(), id, null);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
	}
	
	private CrmCtpClassify getParentCorpTypePropClassify(CrmCtpClassify parentClassify, int skipLevel) {
		CrmCtpClassify parentCorpTypePropClassify = null;
		if (skipLevel > 0) {
			// 继续递归   
			parentCorpTypePropClassify = this.getParentCorpTypePropClassify(parentClassify.getParentClassify(), skipLevel - 1);
		} else {
			// 递归到之前的层
			parentCorpTypePropClassify = parentClassify.getParentClassify();
		}
		return parentCorpTypePropClassify;
	}
	
	@Override
	public void upload(String corpTypeId, InputStream is) throws Exception {
		try {
			byte[] excelByte = IOUtils.toByteArray(is);
			Workbook xwb = null;
			try {
				xwb = new XSSFWorkbook(new ByteArrayInputStream(excelByte));
			} catch (Exception e) {
				xwb = new HSSFWorkbook(new ByteArrayInputStream(excelByte));
			}
			
			Sheet sheet = xwb.getSheetAt(0);

			CrmCorpType corpType = this.daoFacade.getCrmCorpTypeDao().get(CrmCorpType.class.getName(), corpTypeId);

			Map<String, String> dataCache = new HashMap<String, String>();
			CrmCtpClassify parentClassify = null;
			//int level = 1;
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
						CrmCtpClassify corpTypePropClassify = new CrmCtpClassify();
						corpTypePropClassify.setName(classifyName.toString());
						corpTypePropClassify.setCode(classifyCode.toString());
						corpTypePropClassify.setOrder(Integer.parseInt(classifyOrder.toString()));
						corpTypePropClassify.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
						corpTypePropClassify.setCorpType(corpType);
						if (previousClassifyCode == null) {
							corpTypePropClassify.setParentClassify(null);
						} else {
							int previousLength = previousClassifyCode.length();
							int currentLength = classifyCode.toString().length();
							if (previousLength == currentLength) {
								// 与上一个分类是同级
								corpTypePropClassify.setParentClassify(parentClassify.getParentClassify());
							} else if (previousLength < currentLength) {
								// 是上一个分类的下级
								corpTypePropClassify.setParentClassify(parentClassify);
								//level ++;
							} else if (previousLength > currentLength) {
								// 是上一个分类的上级（不一定是上面几级）
								int currentLevel = Math.round((currentLength - 1)/3);
								int previousLevel = Math.round((previousLength - 1)/3);
								int skipLevel = previousLevel - currentLevel;
								corpTypePropClassify.setParentClassify(this.getParentCorpTypePropClassify(parentClassify, skipLevel));
							}
						}
						corpTypePropClassify.setInternationCode(classifyOrder.toString());
						this.daoFacade.getCrmCorpTypePropClassifyDao().insert(corpTypePropClassify);
						dataCache.put(classifyCode.toString(), corpTypePropClassify.getId());
						previousClassifyCode = classifyCode.toString();
						parentClassify = corpTypePropClassify;
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
						CrmCtypeProp corpTypeProp = new CrmCtypeProp();
						corpTypeProp.setSourceType(null);
						corpTypeProp.setInternationCode(propOrder.toString());
						corpTypeProp.setCorpType(corpType);
						corpTypeProp.setCorpTypePropClassify(parentClassify);
						corpTypeProp.setCode(propCode.toString());
						corpTypeProp.setName(propName.toString());
						corpTypeProp.setOrder(propOrder.toString());
						corpTypeProp.setMust(dicList.get(0).getId());
						corpTypeProp.setDisplay(DicCache.getIdByCode(DicConstants.DIC_DISPLAY, propDisplay.toString()));
						corpTypeProp.setSource(source);
						corpTypeProp.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
						this.daoFacade.getCrmCtypePropDao().insert(corpTypeProp);
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
}