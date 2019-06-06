package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;
import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.po.PProductPersonRelationship;

public interface PProductPersonRelationshipService extends BaseService {

	public void update(PProductPersonRelationship obj, String id, String[] properties) throws Exception;

	public void insert(PProductPersonRelationship obj) throws Exception;

	public void delete(String id) throws Exception;

	public List<PProductPersonRelationship> getPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws Exception;
	public List<PProductPersonRelationship> getPagingListForProduct(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws Exception;

	public Integer getCount(Map<String, Object> condition) throws Exception;
	public Integer getCountForProduct(Map<String, Object> condition) throws Exception;

	public PProductPersonRelationship get(String id) throws Exception;

	public List<PProductPersonRelationship> getList(Map<String, Object> condition) throws Exception;

	public void saveAll(String allId, String id) throws CcsException;
}