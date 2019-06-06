package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 09_仓库层
 * @table IV_WAREHOUSE_FLOOR
 */
@SuppressWarnings("serial")
public class IvWarehouseFloor implements Serializable {

    private String whFloorId; // 仓库层ID
    private String whFloorCode; // 仓库层编号
    private String whFloorDesc; // 仓库层描述
    private String whFloorStatus; // 仓库层状态
    private IvWarehouse warehouse; // 09_仓库
    @JsonIgnore
    private Set<IvWarehouseRoom> warehouseRoomSet = new HashSet<IvWarehouseRoom>(); // 09_仓库房间
    @JsonIgnore
    private Set<IvShelf> shelfSet = new HashSet<IvShelf>(); // 09_货架
    @JsonIgnore
    private Set<IvLocation> locationSet = new HashSet<IvLocation>(); // 09_货位

    public String getWhFloorId() {
        return whFloorId;
    }

    public void setWhFloorId(String whFloorId) {
        this.whFloorId = whFloorId;
    }

    public String getWhFloorCode() {
        return whFloorCode;
    }

    public void setWhFloorCode(String whFloorCode) {
        this.whFloorCode = whFloorCode;
    }

    public String getWhFloorDesc() {
        return whFloorDesc;
    }

    public void setWhFloorDesc(String whFloorDesc) {
        this.whFloorDesc = whFloorDesc;
    }

    public String getWhFloorStatus() {
        return whFloorStatus;
    }

    public void setWhFloorStatus(String whFloorStatus) {
        this.whFloorStatus = whFloorStatus;
    }

    public IvWarehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(IvWarehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Set<IvWarehouseRoom> getWarehouseRoomSet() {
        return warehouseRoomSet;
    }

    public void setWarehouseRoomSet(Set<IvWarehouseRoom> warehouseRoomSet) {
        this.warehouseRoomSet = warehouseRoomSet;
    }

    public Set<IvShelf> getShelfSet() {
        return shelfSet;
    }

    public void setShelfSet(Set<IvShelf> shelfSet) {
        this.shelfSet = shelfSet;
    }

    public Set<IvLocation> getLocationSet() {
        return locationSet;
    }

    public void setLocationSet(Set<IvLocation> locationSet) {
        this.locationSet = locationSet;
    }
}
