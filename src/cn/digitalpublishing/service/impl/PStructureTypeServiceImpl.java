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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.google.common.base.Strings;
import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.BDic;
import cn.digitalpublishing.po.PStructureType;
import cn.digitalpublishing.po.PStructureTypePropClassify;
import cn.digitalpublishing.po.PStructureTypeProp;
import cn.digitalpublishing.service.PStructureTypeService;
import cn.digitalpublishing.util.DicCache;

public class PStructureTypeServiceImpl extends BaseServiceImpl implements PStructureTypeService {
	
	
	
	@Override
	public void updateCorpType(PStructureType obj, String id, String[] properties) throws Exception {
		try {
			this.daoFacade.getStructureTypeDao().update(obj,
					PStructureType.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "exhibit.info.updateEExhibit.error", e);
		}
	}

	@Override
	public void insertCorpType(PStructureType obj) throws Exception {
		String statusAvailable = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
		
		try {
			obj.setStatus(statusAvailable);
			this.daoFacade.getStructureTypeDao().insert(obj);
			
			
			// 获取 code 值
			// String code = getNextCode(obj);
			// obj.setTreeCode(code);
			// 获取 order 值
			//Integer order = getNextOrder(obj);
			//obj.setOrder(order);
			//obj.setStatus();
			
			// //每新增一个产品类型--就为该类型下新增一个默认的--基本类型属性分类
			// PTypePropClassify ptpc = new PTypePropClassify();
			// ptpc.setCorpType(obj);
			// ptpc.setName("基本分类");
			// ptpc.setCode(obj.getCode());
			// ptpc.setOrder(0);
			// ptpc.setInternalCode(obj.getCode());
			// ptpc.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS,
			// DicConstants.DATA_STATUS_AVAILABLE));
			// this.typePropClassifyService.insertClassify(ptpc);
		} catch (Exception e) {
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "transaction.info.insertCTransaction.error", e);
		}
	}

	@Override
	public void deletecCorpType(String id) throws Exception {
		try {
			this.daoFacade.getStructureTypeDao().delete(
					PStructureType.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "transaction.info.deletecTransAction.error", e);
		}
	}

	@Override
	public List<PStructureType> getCorpTypePagingList(
			Map<String, Object> condition, String sort, Integer pageCount,
			Integer page) throws Exception {
		List<PStructureType> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache()
				.get("cn.digitalpublishing.dao.PStructureTypeDao")
				.get("getPagingList");
		try {
			list = this.daoFacade.getStructureTypeDao().getCorpTypePagingList(
					condition, sort, pageCount, page, hqlBean);
		} catch (Exception e) {
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public Integer getCorpTypeCount(Map<String, Object> condition)
			throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache()
				.get("cn.digitalpublishing.dao.PStructureTypeDao")
				.get("getCount");
		try {
			num = this.daoFacade.getStructureTypeDao().getCount(condition,
					hqlBean);
		} catch (Exception e) {
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}

	public PStructureType getCorpType(String id) throws Exception {
		PStructureType cla = null;
		try {
			cla = (PStructureType) this.daoFacade.getStructureTypeDao().get(
					PStructureType.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "transaction.info.getCTransaction.error", e);
		}
		return cla;
	}

	@Override
	public PStructureType getCorpTypeByCode(String code) throws Exception {
		PStructureType cla = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache()
				.get("cn.digitalpublishing.dao.PStructureTypeDao")
				.get("getList");
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("code", code);
			List<PStructureType> list = this.daoFacade.getStructureTypeDao().getList(condition, "", hqlBean);
			if (!list.isEmpty()) {
				cla = list.get(0);
			}
		} catch (Exception e) {
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "transaction.info.getCTransaction.error", e);
		}
		return cla;
	}

	@Override
	public boolean checkCodeAvailable(PStructureType type) throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("code", type.getCode());
		String statusAvailable = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
		condition.put("status", statusAvailable);
		if (Strings.isNullOrEmpty(type.getId())) {
			type = getCorpByCondition(condition);
			if(type == null) {
				return true;
			}
		} else {
			PStructureType ptype = getCorpType(type.getId());
			if (type.getCode().equals(ptype.getCode())) {
				return true;
			}
			
			type = getCorpByCondition(condition);
			if(type == null) {
				return true;
			}
		}
		return false;
	}
	
	public PStructureType getCorpByCondition(Map<String, Object> condition ) throws Exception{
			PStructureType cla = null;
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache()
				.get("cn.digitalpublishing.dao.PStructureTypeDao")
				.get("getList");
			try {
				List<PStructureType> list = this.daoFacade.getStructureTypeDao().getList(condition, "", hqlBean);
				if (!list.isEmpty()) {
					cla = list.get(0);
				}
			} catch (Exception e) {
				throw new CcsException(
						(e instanceof CcsException) ? ((CcsException) e).getPrompt()
								: "transaction.info.getCTransaction.error", e);
			}
			return cla;
	}

	@Override
	public List<PStructureType> getCorpTypeTreeList(Map<String, Object> condition, String sort) throws Exception {
		List<PStructureType> list = null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache()
				.get("cn.digitalpublishing.dao.PStructureTypeDao")
				.get("getTreeList");
		try {
			list = this.daoFacade.getStructureTypeDao().getCorpTypeTreeList(
					condition, sort, hqlBean);
		} catch (Exception e) {
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "PCorpType.info.getTreeList.error", e);
		}
		return list;
	}

	private String getNextCode(PStructureType obj) throws CcsException {
		String code = "";
		// Map<String, Object> condition = new HashMap<String, Object>();
		// condition.put("parentId", obj.getParentCorpType() == null ? "root" :
		// obj.getParentCorpType().getId());
		// try{
		// String parCode = "";
		// if (obj.getParentCorpType() != null) {
		// PStructureType propType = (PStructureType)
		// this.daoFacade.getStructureTypeDao().get(PStructureType.class.getName(),
		// obj.getParentCorpType().getId());
		// //parCode = propType.getTreeCode();
		// }
		//
		// HqlBean hqlBean =
		// HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PCorpTypeDao").get("getTreeList");
		// List<PStructureType> list =
		// this.daoFacade.getStructureTypeDao().getCorpTypeList(condition,
		// " order by a.treeCode desc ", hqlBean);
		// code = ((list == null || list.isEmpty()) ? "001" : list.get(0) ==
		// null ? "001" : list.get(0).getTreeCode());
		// if (list != null && !list.isEmpty()) {
		// if (parCode.trim().length() > 0) {
		// code = code.substring(parCode.length());
		// }
		// int num = Integer.valueOf(code).intValue();
		// num++;
		// String mid = String.valueOf(num);
		// if (mid.length() == 1) {
		// code = "00" + mid;
		// }
		// if (mid.length() == 2) {
		// code = "0" + mid;
		// }
		// if (mid.length() == 3) {
		// code = mid;
		// }
		// }
		// code = parCode + code;
		// }catch(Exception e){
		// throw new CcsException((e instanceof CcsException) ? ((CcsException)
		// e).getPrompt() : "PCorpType.getNextCode.error", e);
		// }
		return code;
	}

	private Integer getNextOrder(PStructureType obj) throws Exception {
		Integer order = 1;
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			// condition.put("parentSubject", obj.getParentCorpType() == null ?
			// "root" : obj.getParentCorpType().getId());
			HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache()
					.get("cn.digitalpublishing.dao.PStructureTypeDao")
					.get("getTreeList");
			List<PStructureType> list = this.daoFacade.getStructureTypeDao()
					.getList(condition, " order by a.order desc ", hqlBean);
			order = ((list == null || list.isEmpty()) ? 1
					: list.get(0) == null ? 1 : (list.get(0).getOrder() + 1));
		} catch (Exception e) {
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "CorpType.getNextOrder.error", e);
		}
		return order;
	}

	@Override
	public void falseDel(String id) throws Exception {
		try {
			String statusUnAvailable = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE);
			PStructureType obj = new PStructureType();
			obj.setId(id);
			obj.setStatus(statusUnAvailable);
			
			this.daoFacade.getStructureTypeDao().update(obj, PStructureType.class.getName(), id, null);
		} catch (Exception e) {
			throw new CcsException(
					(e instanceof CcsException) ? ((CcsException) e).getPrompt()
							: "exhibit.info.updateEExhibit.error", e);
		}
	}

	private PStructureTypePropClassify getParentCorpTypePropClassify(
			PStructureTypePropClassify parentClassify, int skipLevel) {
		PStructureTypePropClassify parentCorpTypePropClassify = null;
		if (skipLevel > 0) {
			// 继续递归
			parentCorpTypePropClassify = this.getParentCorpTypePropClassify(
					parentClassify.getParentClassify(), skipLevel - 1);
		} else {
			// 递归到之前的层
			parentCorpTypePropClassify = parentClassify.getParentClassify();
		}
		return parentCorpTypePropClassify;
	}

	@Override
	public void upload(PStructureType type, InputStream is) throws Exception {
		try {
			byte[] excelByte = IOUtils.toByteArray(is);
			Workbook xwb = null;
			try {
				xwb = new XSSFWorkbook(new ByteArrayInputStream(excelByte));
			} catch (Exception e) {
				xwb = new HSSFWorkbook(new ByteArrayInputStream(excelByte));
			}
			
			Sheet sheet = xwb.getSheetAt(0);
			
			PStructureType structureType = this.daoFacade.getStructureTypeDao().get(
					PStructureType.class.getName(), type.getId());

			Map<String, String> dataCache = new HashMap<String, String>();
			PStructureTypePropClassify parentClassify = null;
			// int level = 1;
			String statusAvailable = DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE);
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
						PStructureTypePropClassify typePropClassify = new PStructureTypePropClassify();
						typePropClassify.setName(classifyName.toString());
						typePropClassify.setCode(classifyCode.toString());
						typePropClassify.setOrder(Integer.parseInt(classifyOrder.toString()));
						typePropClassify.setStatus(statusAvailable);
						typePropClassify.setStructureType(structureType);
						if (previousClassifyCode == null) {
							typePropClassify.setParentClassify(null);
						} else {
							int previousLength = previousClassifyCode.length();
							int currentLength = classifyCode.toString().length();
							if (previousLength == currentLength) {
								// 与上一个分类是同级
								typePropClassify.setParentClassify(parentClassify.getParentClassify());
							} else if (previousLength < currentLength) {
								// 是上一个分类的下级
								typePropClassify.setParentClassify(parentClassify);
								// level ++;
							} else if (previousLength > currentLength) {
								// 是上一个分类的上级（不一定是上面几级）
								int currentLevel = Math.round((currentLength - 1) / 3);
								int previousLevel = Math.round((previousLength - 1) / 3);
								int skipLevel = previousLevel - currentLevel;
								typePropClassify.setParentClassify(this.getParentCorpTypePropClassify(parentClassify, skipLevel));
							}
						}
						typePropClassify.setInternationCode(classifyOrder.toString());
						this.daoFacade.getStructureTypePropClassifyDao().insert(typePropClassify);
						dataCache.put(classifyCode.toString(),typePropClassify.getId());
						previousClassifyCode = classifyCode.toString();
						parentClassify = typePropClassify;
					} else {
						// 属性是否必填
						Map<String, Object> condition = new HashMap<String, Object>();
						condition.put("dicName", propMust.toString());
						condition.put("dicClassCode", DicConstants.DIC_MUST);
						HqlBean dicHqlBean = HqlBeanCacheUtil.gethqlBeanCache()
								.get("cn.digitalpublishing.dao.BDicDao")
								.get("getDicListForExcel");
						List<BDic> dicList = this.daoFacade.getDicDao().getList(condition, "", dicHqlBean);

						// 属性来源
						String source = null;
						if (propSource != null) {
							source = propSource.toString();
						}

						// 插入属性
						PStructureTypeProp typeProp = new PStructureTypeProp();
						typeProp.setSourceType(null);
						typeProp.setInternationCode(propOrder.toString());
						typeProp.setStructureType(structureType);
						typeProp.setStructureTypePropClassify(parentClassify);
						typeProp.setCode(propCode.toString());
						typeProp.setName(propName.toString());
						typeProp.setOrder(propOrder.toString());
						typeProp.setMust(dicList.get(0).getId());
						typeProp.setDisplay(DicCache.getIdByCode(DicConstants.DIC_DISPLAY, propDisplay.toString()));
						typeProp.setSource(source);
						typeProp.setStatus(statusAvailable);
						this.daoFacade.getStructureTypePropDao().insert(typeProp);
					}
				}
			}
		} catch (Exception ex) {
			throw new CcsException("解析Excel出错！");
		} finally {
			IOUtils.closeQuietly(is);
		}
		
	}

	@Override
	public List<PStructureType> getList(Map<String, Object> condition) throws Exception {
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PStructureTypeDao").get("getList");
		List<PStructureType> list = this.daoFacade.getStructureTypeDao().getList(condition, "", hqlBean);
		return list;
	}


}