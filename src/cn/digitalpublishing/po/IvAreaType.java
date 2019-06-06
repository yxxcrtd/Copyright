package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 09_区域类型
 * @table IV_AREA_TYPE
 */
@SuppressWarnings("serial")
public class IvAreaType implements Serializable {

	private String areaTypeId; // 区域类型ID
	private String areaTypeCode; // 区域类型编号
	private String areaTypeDesc; // 区域类型名称
	private String areaTypeStatus; // 区域类型状态
	@JsonIgnore
	private Set<IvRegional> regionalSet = new HashSet<IvRegional>(); // 09_区域

	public String getAreaTypeId() {
		return areaTypeId;
	}

	public void setAreaTypeId(String areaTypeId) {
		this.areaTypeId = areaTypeId;
	}

	public String getAreaTypeCode() {
		return areaTypeCode;
	}

	public void setAreaTypeCode(String areaTypeCode) {
		this.areaTypeCode = areaTypeCode;
	}

	public String getAreaTypeDesc() {
		return areaTypeDesc;
	}

	public void setAreaTypeDesc(String areaTypeDesc) {
		this.areaTypeDesc = areaTypeDesc;
	}

	public String getAreaTypeStatus() {
		return areaTypeStatus;
	}

	public void setAreaTypeStatus(String areaTypeStatus) {
		this.areaTypeStatus = areaTypeStatus;
	}

	public Set<IvRegional> getRegionalSet() {
		return regionalSet;
	}

	public void setRegionalSet(Set<IvRegional> regionalSet) {
		this.regionalSet = regionalSet;
	}
}
