package cn.digitalpublishing.springmvc.form;

import java.util.List;

import cn.digitalpublishing.po.CrmCtpClassify;
import cn.digitalpublishing.po.CrmPeTpClassify;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class CrmCtpClassifyForm extends DataTableForm<CrmCtpClassify> {

	private CrmCtpClassify classify;

	private String tid;
	private String name;
	private String code;
	private Integer order;

	private List<CrmCtpClassify> classList;

	private String parentClass;

	public CrmCtpClassify getClassify() {
		return classify;
	}

	public void setClassify(CrmCtpClassify classify) {
		this.classify = classify;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
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

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	

	public List<CrmCtpClassify> getClassList() {
		return classList;
	}

	public void setClassList(List<CrmCtpClassify> classList) {
		this.classList = classList;
	}

	public String getParentClass() {
		return parentClass;
	}

	public void setParentClass(String parentClass) {
		this.parentClass = parentClass;
	}

}
