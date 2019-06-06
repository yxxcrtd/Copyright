package cn.digitalpublishing.springmvc.form;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.digitalpublishing.po.CrmCorpType;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class CrmCorpTypeForm extends DataTableForm<CrmCorpType> {

	private CrmCorpType crmCorpType;
	private String code; // 公司类型编号
	private String name; // 公司类型名称
	
	private CommonsMultipartFile txtFile = null;
	
	private String txtFormat = "xls,xlsx";

	public CrmCorpType getCrmCorpType() {
		return crmCorpType;
	}

	public void setCrmCorpType(CrmCorpType crmCorpType) {
		this.crmCorpType = crmCorpType;
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