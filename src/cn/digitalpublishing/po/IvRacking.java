package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import cn.digitalpublishing.util.converter.CustomDateTimeSerializer;

import java.util.Date;

/**
 * @name 09_上架指示单
 * @table IV_RACKING
 */
@SuppressWarnings("serial")
public class IvRacking implements Serializable {

	private String rackingId; // 上架指示单ID
	private String rackingCode; // 上架指示单号
	private Date rackingCreateOn; // 上架指示单创建日期
	private String rackingCreateBy; // 上架指示单创建人
	private Date rackingUpdateOn; // 上架指示单修改日期
	private String rackingUpdateBy; // 上架指示单修改人
	private String rackingPickBy; // 上架指示单拣货人
	private String rackingStatus; // 上架指示单状态
	@JsonIgnore
	private Set<IvRackingItem> rackingItemSet = new HashSet<IvRackingItem>(); // 09_上架指示单明细


	public String getRackingId() {
		return rackingId;
	}

	public void setRackingId(String rackingId) {
		this.rackingId = rackingId;
	}

	public String getRackingCode() {
		return rackingCode;
	}

	public void setRackingCode(String rackingCode) {
		this.rackingCode = rackingCode;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public Date getRackingCreateOn() {
		return rackingCreateOn;
	}

	public void setRackingCreateOn(Date rackingCreateOn) {
		this.rackingCreateOn = rackingCreateOn;
	}

	public String getRackingCreateBy() {
		return rackingCreateBy;
	}

	public void setRackingCreateBy(String rackingCreateBy) {
		this.rackingCreateBy = rackingCreateBy;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public Date getRackingUpdateOn() {
		return rackingUpdateOn;
	}

	public void setRackingUpdateOn(Date rackingUpdateOn) {
		this.rackingUpdateOn = rackingUpdateOn;
	}

	public String getRackingUpdateBy() {
		return rackingUpdateBy;
	}

	public void setRackingUpdateBy(String rackingUpdateBy) {
		this.rackingUpdateBy = rackingUpdateBy;
	}

	public String getRackingPickBy() {
		return rackingPickBy;
	}

	public void setRackingPickBy(String rackingPickBy) {
		this.rackingPickBy = rackingPickBy;
	}

	public String getRackingStatus() {
		return rackingStatus;
	}

	public void setRackingStatus(String rackingStatus) {
		this.rackingStatus = rackingStatus;
	}

	public Set<IvRackingItem> getRackingItemSet() {
		return rackingItemSet;
	}

	public void setRackingItemSet(Set<IvRackingItem> rackingItemSet) {
		this.rackingItemSet = rackingItemSet;
	}
}