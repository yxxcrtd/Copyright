package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.math.BigDecimal;

/**
 * @name 09_层阶
 * @table IV_FLOOR
 */
@SuppressWarnings("serial")
public class IvFloor implements Serializable {

	private String shFloorId; // 货架层ID
	private String shFloorCode; // 货架层编号
	private String shFloorDesc; // 货架层描述
	private String shFloorStatus; // 货架层状态
	private BigDecimal shFloorLoad; // 货架层承重
	private BigDecimal shFloorCapacity; // 货架层容积
	private IvShelf shelf; // 09_货架
	@JsonIgnore
	private Set<IvLocation> locationSet = new HashSet<IvLocation>(); // 09_货位

	public String getShFloorId() {
		return shFloorId;
	}

	public void setShFloorId(String shFloorId) {
		this.shFloorId = shFloorId;
	}

	public String getShFloorCode() {
		return shFloorCode;
	}

	public void setShFloorCode(String shFloorCode) {
		this.shFloorCode = shFloorCode;
	}

	public String getShFloorDesc() {
		return shFloorDesc;
	}

	public void setShFloorDesc(String shFloorDesc) {
		this.shFloorDesc = shFloorDesc;
	}

	public String getShFloorStatus() {
		return shFloorStatus;
	}

	public void setShFloorStatus(String shFloorStatus) {
		this.shFloorStatus = shFloorStatus;
	}

	public BigDecimal getShFloorLoad() {
		return shFloorLoad;
	}

	public void setShFloorLoad(BigDecimal shFloorLoad) {
		this.shFloorLoad = shFloorLoad;
	}

	public BigDecimal getShFloorCapacity() {
		return shFloorCapacity;
	}

	public void setShFloorCapacity(BigDecimal shFloorCapacity) {
		this.shFloorCapacity = shFloorCapacity;
	}

	public IvShelf getShelf() {
		return shelf;
	}

	public void setShelf(IvShelf shelf) {
		this.shelf = shelf;
	}

	public Set<IvLocation> getLocationSet() {
		return locationSet;
	}

	public void setLocationSet(Set<IvLocation> locationSet) {
		this.locationSet = locationSet;
	}
}
