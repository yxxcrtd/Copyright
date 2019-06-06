package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.math.BigDecimal;

/**
 * @name 09_货位
 * @table IV_LOCATION
 */
@SuppressWarnings("serial")
public class IvLocation implements Serializable {

	private String locationId; // 货位ID
	private String locationCode; // 货位编号
	private String locationDesc; // 货位描述
	private String locationStatus; // 货位状态
	private BigDecimal locationLoad; // 货位承重
	private BigDecimal locationCapacity; // 货位容积
	private Integer locationPack; // 最大包数
	private Integer locationLoose; // 最大散数
	private IvRegional regional; // 09_区域
	private IvFloor floor; // 09_层阶
	private IvWarehouse warehouse; // 09_仓库
	private IvShelf shelf; // 09_货架
	private IvWarehouseFloor warehouseFloor; // 09_仓库层
	private IvWarehouseRoom warehouseRoom; // 09_仓库房间
	@JsonIgnore
	private Set<IvStoring> storingSet = new HashSet<IvStoring>(); // 09_存货信息

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationDesc() {
		return locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	public String getLocationStatus() {
		return locationStatus;
	}

	public void setLocationStatus(String locationStatus) {
		this.locationStatus = locationStatus;
	}

	public BigDecimal getLocationLoad() {
		return locationLoad;
	}

	public void setLocationLoad(BigDecimal locationLoad) {
		this.locationLoad = locationLoad;
	}

	public BigDecimal getLocationCapacity() {
		return locationCapacity;
	}

	public void setLocationCapacity(BigDecimal locationCapacity) {
		this.locationCapacity = locationCapacity;
	}

	public Integer getLocationPack() {
		return locationPack;
	}

	public void setLocationPack(Integer locationPack) {
		this.locationPack = locationPack;
	}

	public Integer getLocationLoose() {
		return locationLoose;
	}

	public void setLocationLoose(Integer locationLoose) {
		this.locationLoose = locationLoose;
	}

	public IvRegional getRegional() {
		return regional;
	}

	public void setRegional(IvRegional regional) {
		this.regional = regional;
	}

	public IvFloor getFloor() {
		return floor;
	}

	public void setFloor(IvFloor floor) {
		this.floor = floor;
	}

	public IvWarehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(IvWarehouse warehouse) {
		this.warehouse = warehouse;
	}

	public IvShelf getShelf() {
		return shelf;
	}

	public void setShelf(IvShelf shelf) {
		this.shelf = shelf;
	}

	public Set<IvStoring> getStoringSet() {
		return storingSet;
	}

	public void setStoringSet(Set<IvStoring> storingSet) {
		this.storingSet = storingSet;
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
}
