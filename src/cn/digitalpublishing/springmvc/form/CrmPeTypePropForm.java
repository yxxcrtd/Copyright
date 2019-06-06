package cn.digitalpublishing.springmvc.form;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.CrmPeTpClassify;
import cn.digitalpublishing.po.CrmPeTypeProp;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class CrmPeTypePropForm extends DataTableForm<CrmPeTypeProp> {

	private CrmPeTypeProp crmPeTypeProp;

	private String name;
	private String code;
	private String tid;
	private String order;
	private List<CrmPeTpClassify> crmPeTpClassifyList;
	private Map<String, String> display;
	private Map<String, String> must;

	public CrmPeTypeProp getCrmPeTypeProp() {
		return crmPeTypeProp;
	}

	public void setCrmPeTypeProp(CrmPeTypeProp crmPeTypeProp) {
		this.crmPeTypeProp = crmPeTypeProp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}


	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public List<CrmPeTpClassify> getCrmPeTpClassifyList() {
		return crmPeTpClassifyList;
	}

	public void setCrmPeTpClassifyList(List<CrmPeTpClassify> crmPeTpClassifyList) {
		this.crmPeTpClassifyList = crmPeTpClassifyList;
	}

	public Map<String, String> getDisplay() {
		return display;
	}

	public void setDisplay(Map<String, String> display) {
		this.display = display;
	}

	public Map<String, String> getMust() {
		return must;
	}

	public void setMust(Map<String, String> must) {
		this.must = must;
	}

}
