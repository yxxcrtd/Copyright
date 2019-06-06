package cn.digitalpublishing.springmvc.form;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.digitalpublishing.po.CrmPersonType;
import cn.digitalpublishing.springmvc.form.DataTableForm;
import cn.digitalpublishing.util.TreeNode;

public class CrmPersonTypeForm extends DataTableForm<CrmPersonType> {

	private CrmPersonType crmPersonType;

	private String fatherId;
	private TreeNode node;

	private String name;
	private String code;
	private String tid;// 类型Id
	
	private CommonsMultipartFile txtFile = null;
	
	private String txtFormat = "xls,xlsx";

	public CrmPersonType getCrmPersonType() {
		return crmPersonType;
	}

	public void setCrmPersonType(CrmPersonType crmPersonType) {
		this.crmPersonType = crmPersonType;
	}

	public String getFatherId() {
		return fatherId;
	}

	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	public TreeNode getNode() {
		return node;
	}

	public void setNode(TreeNode node) {
		this.node = node;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public CommonsMultipartFile getTxtFile() {
		return txtFile;
	}

	public void setTxtFile(CommonsMultipartFile txtFile) {
		this.txtFile = txtFile;
	}

	public String getTxtFormat() {
		return txtFormat;
	}

	public void setTxtFormat(String txtFormat) {
		this.txtFormat = txtFormat;
	}

}
