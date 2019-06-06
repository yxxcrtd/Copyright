package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.math.BigDecimal;

/**
 * @name 09_仓库
 * @table IV_WAREHOUSE
 */
@SuppressWarnings("serial")
public class IvWarehouse implements Serializable {

    private String warehouseId; // 仓库ID
    private String warehouseCode; // 仓库编号
    private String warehouseDesc; // 仓库描述
    private String warehouseStatus; // 仓库状态
    private BigDecimal warehouseLoad; // 仓库承重
    private BigDecimal warehouseCapacity; // 货架容积
    private IvSite site; // 09_驻地
    @JsonIgnore
    private Set<IvShelf> shelfSet = new HashSet<IvShelf>(); // 09_货架
    @JsonIgnore
    private Set<IvWarehouseFloor> warehouseFloorSet = new HashSet<IvWarehouseFloor>(); // 09_仓库层
    @JsonIgnore
    private Set<IvLocation> locationSet = new HashSet<IvLocation>(); // 09_货位
	@JsonIgnore
	private Set<IvStockIn> stockInSet = new HashSet<IvStockIn>(); // 09_入库单
	@JsonIgnore
	private Set<IvStockOut> stockOutSet = new HashSet<IvStockOut>(); // 09_出库单

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseDesc() {
        return warehouseDesc;
    }

    public void setWarehouseDesc(String warehouseDesc) {
        this.warehouseDesc = warehouseDesc;
    }

    public String getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(String warehouseStatus) {
        this.warehouseStatus = warehouseStatus;
    }

    public BigDecimal getWarehouseLoad() {
        return warehouseLoad;
    }

    public void setWarehouseLoad(BigDecimal warehouseLoad) {
        this.warehouseLoad = warehouseLoad;
    }

    public BigDecimal getWarehouseCapacity() {
        return warehouseCapacity;
    }

    public void setWarehouseCapacity(BigDecimal warehouseCapacity) {
        this.warehouseCapacity = warehouseCapacity;
    }

    public IvSite getSite() {
        return site;
    }

    public void setSite(IvSite site) {
        this.site = site;
    }

    public Set<IvShelf> getShelfSet() {
        return shelfSet;
    }

    public void setShelfSet(Set<IvShelf> shelfSet) {
        this.shelfSet = shelfSet;
    }

    public Set<IvWarehouseFloor> getWarehouseFloorSet() {
        return warehouseFloorSet;
    }

    public void setWarehouseFloorSet(Set<IvWarehouseFloor> warehouseFloorSet) {
        this.warehouseFloorSet = warehouseFloorSet;
    }

    public Set<IvLocation> getLocationSet() {
        return locationSet;
    }

    public void setLocationSet(Set<IvLocation> locationSet) {
        this.locationSet = locationSet;
    }

	public Set<IvStockIn> getStockInSet() {
		return stockInSet;
	}

	public void setStockInSet(Set<IvStockIn> stockInSet) {
		this.stockInSet = stockInSet;
	}

	public Set<IvStockOut> getStockOutSet() {
		return stockOutSet;
	}

	public void setStockOutSet(Set<IvStockOut> stockOutSet) {
		this.stockOutSet = stockOutSet;
	}
}
