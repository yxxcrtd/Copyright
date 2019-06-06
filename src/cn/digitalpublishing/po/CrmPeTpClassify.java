package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 04_人员类型属性分类
 * @table CRM_PE_TP_CLASSIFY
 */
@SuppressWarnings("serial")
public class CrmPeTpClassify implements Serializable {

	private String id; // 人员类型属性分类ID
	private String code; // 人员类型属性分类编号
	private String name; // 人员类型属性分类名称
	private String status; // 人员类型属性分类状态
	private Integer order; // 人员类型属性分类序号
	private String internationCode; // 国际化参数
	private CrmPersonType personType; // 04_人员类型
	private CrmPeTpClassify parentClassify; // 04_人员类型属性分类
	@JsonIgnore
	private Set<CrmPeTypeProp> peTypePropSet = new HashSet<CrmPeTypeProp>(); // 04_人员类型属性
	@JsonIgnore
	private Set<CrmPeTpClassify> peTpClassifySet = new HashSet<CrmPeTpClassify>(); // 04_人员类型属性分类

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getInternationCode() {
		return internationCode;
	}

	public void setInternationCode(String internationCode) {
		this.internationCode = internationCode;
	}

	public CrmPersonType getPersonType() {
		return personType;
	}

	public void setPersonType(CrmPersonType personType) {
		this.personType = personType;
	}

	public CrmPeTpClassify getParentClassify() {
		return parentClassify;
	}

	public void setParentClassify(CrmPeTpClassify parentClassify) {
		this.parentClassify = parentClassify;
	}

	public Set<CrmPeTypeProp> getPeTypePropSet() {
		return peTypePropSet;
	}

	public void setPeTypePropSet(Set<CrmPeTypeProp> peTypePropSet) {
		this.peTypePropSet = peTypePropSet;
	}

	public Set<CrmPeTpClassify> getPeTpClassifySet() {
		return peTpClassifySet;
	}

	public void setPeTpClassifySet(Set<CrmPeTpClassify> peTpClassifySet) {
		this.peTpClassifySet = peTpClassifySet;
	}
}
