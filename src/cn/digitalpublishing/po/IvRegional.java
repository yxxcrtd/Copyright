package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 09_区域
 * @table IV_REGIONAL
 */
@SuppressWarnings("serial")
public class IvRegional implements Serializable {

	private String areaId; // 区域ID
	private String areaCode; // 区域编号
	private String areaDesc; // 区域描述
	private String areaStatus; // 区域状态
	private String activityLevel; // 活跃度
	private IvAreaType areaType; // 09_区域类型
	@JsonIgnore
	private Set<IvLocation> locationSet = new HashSet<IvLocation>(); // 09_货位

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaDesc() {
		return areaDesc;
	}

	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
	}

	public String getAreaStatus() {
		return areaStatus;
	}

	public void setAreaStatus(String areaStatus) {
		this.areaStatus = areaStatus;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}

	public IvAreaType getAreaType() {
		return areaType;
	}

	public void setAreaType(IvAreaType areaType) {
		this.areaType = areaType;
	}

	public Set<IvLocation> getLocationSet() {
		return locationSet;
	}

	public void setLocationSet(Set<IvLocation> locationSet) {
		this.locationSet = locationSet;
	}
}
