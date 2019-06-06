package cn.digitalpublishing.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import cn.digitalpublishing.po.ProductOrder;;

public interface ProductOrderService extends BaseService {

    public void upload(InputStream inputStream) throws Exception;
	 
	public void delete(String id) throws Exception;

	public List<ProductOrder> getPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws Exception;

	public Integer getCount(Map<String, Object> condition) throws Exception;

	public ProductOrder getOrderId(String id) throws Exception;

	public List<ProductOrder> getList(Map<String, Object> condition, String sort) throws Exception;
	
}