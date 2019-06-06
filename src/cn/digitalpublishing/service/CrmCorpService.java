package cn.digitalpublishing.service;

import java.io.InputStream;
import java.util.List;
import cn.digitalpublishing.po.CrmCorp;
import cn.digitalpublishing.po.CrmCorpType;
import cn.digitalpublishing.po.CrmCorpTypeRelationship;
import cn.digitalpublishing.springmvc.form.CrmCorpForm;
import cn.digitalpublishing.util.TreeNode;

public interface CrmCorpService {

	void saveCorp(CrmCorpForm form) throws Exception;
	
	void updateCorp(CrmCorpForm form) throws Exception;
	
	List<TreeNode> getChildCorpTreeNodes(CrmCorpForm form) throws Exception;
	
	List<CrmCorp> getCorpListNotInCurrentCorpType(CrmCorpForm form) throws Exception; 
	
	void edit(CrmCorpForm form) throws Exception;
	
	/**
	 * 初始化修改树节点信息
	 * @param form
	 * @throws Exception
	 */
	CrmCorpTypeRelationship editTreeNode(CrmCorpTypeRelationship relation) throws Exception;
	
	void addTab(CrmCorpForm form) throws Exception;
	
	void delete(CrmCorpTypeRelationship relationship) throws Exception;
	
	/**
	 * 获取当前公司类型可用的公司信息
	 * @param type
	 * @return
	 * @throws Exception
	 */
	List<CrmCorp> getAvailableCorpCode(CrmCorpType type) throws Exception;
	
	boolean checkCodeIsAvailable(CrmCorp corp) throws Exception;
	
	List<TreeNode> upload(CrmCorpType corpType, InputStream excel) throws Exception;
	

}