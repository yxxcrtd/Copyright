package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 01_结构类型
 * @table P_STRUCT_TYPE
 */
@SuppressWarnings("serial")
public class PStructureType implements Serializable {

	private String id; // 结构类型ID
	private String name; // 结构类型名称
	private String code; // 结构类型编号
	private Integer order; // 结构类型排序
	private String status; // 结构类型状态
	private String treeCode; // 结构类型树形编码
	private String internationCode; // 国际化参数
	@JsonIgnore
	private Set<PStructureTypePropClassify> structureTypePropClassifySet = new HashSet<PStructureTypePropClassify>(); // 01_结构分类
	@JsonIgnore
	private Set<PStructure> structureSet = new HashSet<PStructure>(); // 01_结构
	@JsonIgnore
	private Set<PStructureTypeProp> structureTypePropSet = new HashSet<PStructureTypeProp>(); // 01_结构类型属性

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

	public String getTreeCode() {
		return treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}

	public String getInternationCode() {
		return internationCode;
	}

	public void setInternationCode(String internationCode) {
		this.internationCode = internationCode;
	}

	public Set<PStructureTypePropClassify> getStructureTypePropClassifySet() {
		return structureTypePropClassifySet;
	}

	public void setStructureTypePropClassifySet(Set<PStructureTypePropClassify> structureTypePropClassifySet) {
		this.structureTypePropClassifySet = structureTypePropClassifySet;
	}

	public Set<PStructure> getStructureSet() {
		return structureSet;
	}

	public void setStructureSet(Set<PStructure> structureSet) {
		this.structureSet = structureSet;
	}

	public Set<PStructureTypeProp> getStructureTypePropSet() {
		return structureTypePropSet;
	}

	public void setStructureTypePropSet(Set<PStructureTypeProp> structureTypePropSet) {
		this.structureTypePropSet = structureTypePropSet;
	}
}