package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 04_人员类型属性
 * @table CRM_PE_TYPE_PROP
 */
@SuppressWarnings("serial")
public class CrmPeTypeProp implements Serializable {

	private String id; // 人员类型属性ID
	private String code; // 人员类型属性编号
	private String name; // 人员类型属性名称
	private String order; // 人员类型属性排序
	private String display; // 人员类型属性显示方式
	private String must; // 人员类型属性是否必须
	private String sourceType; // 人员类型属性来源方式
	private String source; // 人员类型属性来源
	private String status; // 人员类型属性状态
	private String internationCode; // 国际化参数
	private CrmPersonType personType; // 04_人员类型
	private CrmPeTpClassify personTypePropClassify; // 04_人员类型属性分类
	@JsonIgnore
	private Set<CrmPersonProp> personPropSet = new HashSet<CrmPersonProp>(); // 04_人员属性

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

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getMust() {
		return must;
	}

	public void setMust(String must) {
		this.must = must;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public CrmPeTpClassify getPersonTypePropClassify() {
		return personTypePropClassify;
	}

	public void setPersonTypePropClassify(CrmPeTpClassify personTypePropClassify) {
		this.personTypePropClassify = personTypePropClassify;
	}

	public Set<CrmPersonProp> getPersonPropSet() {
		return personPropSet;
	}

	public void setPersonPropSet(Set<CrmPersonProp> personPropSet) {
		this.personPropSet = personPropSet;
	}
}
