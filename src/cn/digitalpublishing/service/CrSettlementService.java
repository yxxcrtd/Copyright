package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.CrSettlement;

public interface CrSettlementService extends BaseService {

	public void edit(CrSettlement obj, Map<String, Object> dic) throws Exception;
	
	public void insert(CrSettlement obj) throws Exception;

	public void update(CrSettlement obj) throws Exception;
	
	public List<CrSettlement> getPagingList(Map<String, Object> condition, String sort, Integer pageCount,Integer countStart) throws Exception;

	public Integer getCount(Map<String, Object> condition) throws Exception;

	public CrSettlement getById(String id) throws Exception;
	
	public List<CrSettlement> getList(Map<String, Object> condition, String sort) throws Exception;

}