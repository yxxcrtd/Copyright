package cn.digitalpublishing.springmvc.form;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.CrmCtpClassify;
import cn.digitalpublishing.po.CrmCtypeProp;
import cn.digitalpublishing.po.CrmPeTypeProp;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class CrmCtypePropForm extends DataTableForm<CrmCtypeProp> {

	private CrmCtypeProp crmCtypeProp;

	private String name;
	private String code;
	private String tid;
	private String order;
	private List<CrmCtpClassify> crmCtpClassifyList;
	private Map<String, String> display;
	private Map<String, String> must;
	

	public CrmCtypeProp getCrmCtypeProp() {
		return crmCtypeProp;
	}

	public void setCrmCtypeProp(CrmCtypeProp crmCtypeProp) {
		this.crmCtypeProp = crmCtypeProp;
	}

	public List<CrmCtpClassify> getCrmCtpClassifyList() {
		return crmCtpClassifyList;
	}

	public void setCrmCtpClassifyList(List<CrmCtpClassify> crmCtpClassifyList) {
		this.crmCtpClassifyList = crmCtpClassifyList;
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
