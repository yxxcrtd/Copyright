package cn.digitalpublishing.springmvc.form;

import java.util.List;

import cn.digitalpublishing.po.CrmPeTpClassify;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class CrmPeTpClassifyForm extends DataTableForm<CrmPeTpClassify> {

	private CrmPeTpClassify classify;

	private String tid;
	private String name;
	private String code;
	private Integer order;

	private List<CrmPeTpClassify> classList;

	private String parentClass;

	public CrmPeTpClassify getClassify() {
		return classify;
	}

	public void setClassify(CrmPeTpClassify classify) {
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

	public List<CrmPeTpClassify> getClassList() {
		return classList;
	}

	public void setClassList(List<CrmPeTpClassify> classList) {
		this.classList = classList;
	}

	public String getParentClass() {
		return parentClass;
	}

	public void setParentClass(String parentClass) {
		this.parentClass = parentClass;
	}

}
