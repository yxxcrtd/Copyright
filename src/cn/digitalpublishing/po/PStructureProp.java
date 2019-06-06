package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @name 01_结构属性
 * @table P_STRUCT_PROP
 */
@SuppressWarnings("serial")
public class PStructureProp implements Serializable {

	private String id; // 结构材属性ID
	private String code; // 结构属性编码
	private String name; // 结构属性名称
	private String value; // 结构属性取值
	private String order; // 结构属性排序
	private String display; // 结构属性显示方式
	private String must; // 结构属性是否必填
	private String source; // 结构属性来源
	private String status; // 结构属性状态
	private Date createOn; // 结构属性创建日期
	private String createBy; // 结构属性创建者
	private Date updateOn; // 结构属性修改日期
	private String updateBy; // 结构属性修改者
	private String internationCode; // 国际化参数
	private PStructureTypeProp structureTypeProp; // 01_结构类型属性
	private PStructure structure; // 01_结构


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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getInternationCode() {
		return internationCode;
	}

	public void setInternationCode(String internationCode) {
		this.internationCode = internationCode;
	}

	public PStructureTypeProp getStructureTypeProp() {
		return structureTypeProp;
	}

	public void setStructureTypeProp(PStructureTypeProp structureTypeProp) {
		this.structureTypeProp = structureTypeProp;
	}

	public PStructure getStructure() {
		return structure;
	}

	public void setStructure(PStructure structure) {
		this.structure = structure;
	}
}