package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.math.BigDecimal;

/**
 * @name 09_货架
 * @table IV_SHELF
 */
@SuppressWarnings("serial")
public class IvShelf implements Serializable {

	private String shelfId; // 货架ID
	private String shelfCode; // 货架编号
	private String shelfDesc; // 货架描述
	private String shelfStatus; // 货架状态
	private BigDecimal shelfLoad; // 货架承重
	private BigDecimal shelfCapacity; // 货架容积
	private String shelfType; // 货架类型
	private String shelfUsage; // 货架用途
	private IvWarehouse warehouse; // 09_仓库
	private IvWarehouseFloor warehouseFloor; // 09_仓库层
	private IvWarehouseRoom warehouseRoom; // 09_仓库房间
	@JsonIgnore
	private Set<IvFloor> floorSet = new HashSet<IvFloor>(); // 09_层阶
	@JsonIgnore
	private Set<IvLocation> locationSet = new HashSet<IvLocation>(); // 09_货位

	public String getShelfId() {
		return shelfId;
	}

	public void setShelfId(String shelfId) {
		this.shelfId = shelfId;
	}

	public String getShelfCode() {
		return shelfCode;
	}

	public void setShelfCode(String shelfCode) {
		this.shelfCode = shelfCode;
	}

	public String getShelfDesc() {
		return shelfDesc;
	}

	public void setShelfDesc(String shelfDesc) {
		this.shelfDesc = shelfDesc;
	}

	public String getShelfStatus() {
		return shelfStatus;
	}

	public void setShelfStatus(String shelfStatus) {
		this.shelfStatus = shelfStatus;
	}

	public BigDecimal getShelfLoad() {
		return shelfLoad;
	}

	public void setShelfLoad(BigDecimal shelfLoad) {
		this.shelfLoad = shelfLoad;
	}

	public BigDecimal getShelfCapacity() {
		return shelfCapacity;
	}

	public void setShelfCapacity(BigDecimal shelfCapacity) {
		this.shelfCapacity = shelfCapacity;
	}

	public String getShelfType() {
		return shelfType;
	}

	public void setShelfType(String shelfType) {
		this.shelfType = shelfType;
	}

	public String getShelfUsage() {
		return shelfUsage;
	}

	public void setShelfUsage(String shelfUsage) {
		this.shelfUsage = shelfUsage;
	}

	public IvWarehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(IvWarehouse warehouse) {
		this.warehouse = warehouse;
	}

	public IvWarehouseFloor getWarehouseFloor() {
		return warehouseFloor;
	}

	public void setWarehouseFloor(IvWarehouseFloor warehouseFloor) {
		this.warehouseFloor = warehouseFloor;
	}

	public IvWarehouseRoom getWarehouseRoom() {
		return warehouseRoom;
	}

	public void setWarehouseRoom(IvWarehouseRoom warehouseRoom) {
		this.warehouseRoom = warehouseRoom;
	}

	public Set<IvFloor> getFloorSet() {
		return floorSet;
	}

	public void setFloorSet(Set<IvFloor> floorSet) {
		this.floorSet = floorSet;
	}

	public Set<IvLocation> getLocationSet() {
		return locationSet;
	}

	public void setLocationSet(Set<IvLocation> locationSet) {
		this.locationSet = locationSet;
	}
}
