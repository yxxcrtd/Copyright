package cn.digitalpublishing.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.digitalpublishing.po.PStructureType;

public interface PStructureTypeService extends BaseService {
	
	public List<PStructureType> getList(Map<String,Object> condition)throws Exception;
	
	public void updateCorpType(PStructureType obj, String id, String[] properties) throws Exception;
	
	public void insertCorpType(PStructureType obj) throws Exception;
	
	public void deletecCorpType(String id) throws Exception;
	
    public List<PStructureType> getCorpTypePagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;
   /**
    * 获取产品类型tree
    * @param condition
    * @param sort
    * @return
    * @throws Exception
    */
    public List<PStructureType> getCorpTypeTreeList(Map<String,Object> condition,String sort)throws Exception;
	
	public Integer getCorpTypeCount(Map<String, Object> condition) throws Exception;
	
	public PStructureType getCorpType(String id) throws Exception;
	
	public PStructureType getCorpTypeByCode(String code) throws Exception;
	
	/**
	 * 检查编码是否可用
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public boolean checkCodeAvailable(PStructureType type)throws Exception;	
	
	//假删除
	public void falseDel(String id) throws Exception;
	
	/**
	 * @param type
	 * @param excelInputStream
	 * @throws Exception
	 */
	public void upload(PStructureType type, InputStream excelInputStream) throws Exception;
}