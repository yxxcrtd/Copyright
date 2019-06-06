package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 01_结构分类
 * @table P_STRUCT_TYPE_PROP_CLASSIFY
 */
@SuppressWarnings("serial")
public class PStructureTypePropClassify implements Serializable {

	private String id; // 结构分类ID
	private String name; // 结构分类名称
	private String code; // 结构分类编码
	private Integer order; // 结构分类排序
	private String status; // 结构分类状态
	private String internationCode; // 国际化参数
	private PStructureType structureType; // 01_结构类型
	private PStructureTypePropClassify parentClassify; // 01_结构分类
	@JsonIgnore
	private Set<PStructureTypeProp> structureTypePropSet = new HashSet<PStructureTypeProp>(); // 01_结构类型属性
	@JsonIgnore
	private Set<PStructureTypePropClassify> structureTypePropClassifySet = new HashSet<PStructureTypePropClassify>(); // 01_结构分类

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public PStructureType getStructureType() {
		return structureType;
	}

	public void setStructureType(PStructureType structureType) {
		this.structureType = structureType;
	}

	public PStructureTypePropClassify getParentClassify() {
		return parentClassify;
	}

	public void setParentClassify(PStructureTypePropClassify parentClassify) {
		this.parentClassify = parentClassify;
	}

	public Set<PStructureTypeProp> getStructureTypePropSet() {
		return structureTypePropSet;
	}

	public void setStructureTypePropSet(Set<PStructureTypeProp> structureTypePropSet) {
		this.structureTypePropSet = structureTypePropSet;
	}

	public Set<PStructureTypePropClassify> getStructureTypePropClassifySet() {
		return structureTypePropClassifySet;
	}

	public void setStructureTypePropClassifySet(Set<PStructureTypePropClassify> structureTypePropClassifySet) {
		this.structureTypePropClassifySet = structureTypePropClassifySet;
	}
}