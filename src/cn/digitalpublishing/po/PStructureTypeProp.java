package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 01_结构类型属性
 * @table P_STRUCT_TYPE_PROP
 */
@SuppressWarnings("serial")
public class PStructureTypeProp implements Serializable {

	private String id; // 结构类型属性ID
	private String code; // 结构类型属性编码
	private String name; // 结构类型属性名称
	private String order; // 结构类型属性排序
	private String display; // 结构类型属性显示方式
	private String must; // 结构类型属性是否必填
	private String sourceType; // 结构类型属性来源类型
	private String source; // 结构类型属性来源
	private String status; // 结构类型属性状态
	private String internationCode; // 国际化参数
	private PStructureTypePropClassify structureTypePropClassify; // 01_结构分类
	private PStructureType structureType; // 01_结构类型
	@JsonIgnore
	private Set<PStructureProp> structurePropSet = new HashSet<PStructureProp>(); // 01_结构属性

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

	public PStructureTypePropClassify getStructureTypePropClassify() {
		return structureTypePropClassify;
	}

	public void setStructureTypePropClassify(PStructureTypePropClassify structureTypePropClassify) {
		this.structureTypePropClassify = structureTypePropClassify;
	}

	public PStructureType getStructureType() {
		return structureType;
	}

	public void setStructureType(PStructureType structureType) {
		this.structureType = structureType;
	}

	public Set<PStructureProp> getStructurePropSet() {
		return structurePropSet;
	}

	public void setStructurePropSet(Set<PStructureProp> structurePropSet) {
		this.structurePropSet = structurePropSet;
	}
}