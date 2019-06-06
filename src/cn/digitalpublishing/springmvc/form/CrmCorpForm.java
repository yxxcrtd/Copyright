package cn.digitalpublishing.springmvc.form;

import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import cn.digitalpublishing.po.CrmCorp;
import cn.digitalpublishing.po.CrmCorpProp;
import cn.digitalpublishing.po.CrmCorpType;
import cn.digitalpublishing.po.CrmCorpTypeRelationship;
import cn.digitalpublishing.po.CrmCtpClassify;
import cn.digitalpublishing.springmvc.form.DataTableForm;
import cn.digitalpublishing.util.TreeNode;

public class CrmCorpForm extends DataTableForm<CrmCorp> {

	private CrmCorp corp;
	private CrmCorpType corpType;
	private CrmCorpTypeRelationship relation;
	private CrmCtpClassify corpTypePropClassify;
	private String action; // 操作类型
	private TreeNode node; // 当前操作的树节点对象
	private List<CrmCtpClassify> typePropClassifyList;
	private List<CrmCorpProp> corpPropList;
	private String[] propsId;
	private String[] propsValue;
	private Map<String, Map<String, String>> dicMap;
	private Boolean corpCodeIsAvailable;
	private CommonsMultipartFile excelFile;
	private List<TreeNode> nodeList;

	public CrmCorp getCorp() {
		return corp;
	}

	public void setCorp(CrmCorp corp) {
		this.corp = corp;
	}

	public CrmCorpType getCorpType() {
		return corpType;
	}

	public void setCorpType(CrmCorpType corpType) {
		this.corpType = corpType;
	}

	public CrmCorpTypeRelationship getRelation() {
		return relation;
	}

	public void setRelation(CrmCorpTypeRelationship relation) {
		this.relation = relation;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	public CrmCtpClassify getCorpTypePropClassify() {
		return corpTypePropClassify;
	}

	public void setCorpTypePropClassify(CrmCtpClassify corpTypePropClassify) {
		this.corpTypePropClassify = corpTypePropClassify;
	}

	public TreeNode getNode() {
		return node;
	}

	public void setNode(TreeNode node) {
		this.node = node;
	}

	public List<CrmCtpClassify> getTypePropClassifyList() {
		return typePropClassifyList;
	}

	public void setTypePropClassifyList(List<CrmCtpClassify> typePropClassifyList) {
		this.typePropClassifyList = typePropClassifyList;
	}
	
	public List<CrmCorpProp> getCorpPropList() {
		return corpPropList;
	}

	public void setCorpPropList(List<CrmCorpProp> corpPropList) {
		this.corpPropList = corpPropList;
	}

	public String[] getPropsId() {
		return propsId;
	}

	public void setPropsId(String[] propsId) {
		this.propsId = propsId;
	}

	public String[] getPropsValue() {
		return propsValue;
	}

	public void setPropsValue(String[] propsValue) {
		this.propsValue = propsValue;
	}

	public Map<String, Map<String, String>> getDicMap() {
		return dicMap;
	}

	public void setDicMap(Map<String, Map<String, String>> dicMap) {
		this.dicMap = dicMap;
	}

	public Boolean getCorpCodeIsAvailable() {
		return corpCodeIsAvailable;
	}

	public void setCorpCodeIsAvailable(Boolean corpCodeIsAvailable) {
		this.corpCodeIsAvailable = corpCodeIsAvailable;
	}
	
	public CommonsMultipartFile getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(CommonsMultipartFile excelFile) {
		this.excelFile = excelFile;
	}

	public List<TreeNode> getNodeList() {
		return nodeList;
	}

	public void setNodeList(List<TreeNode> nodeList) {
		this.nodeList = nodeList;
	}
	
}