package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 09_仓库房间
 * @table IV_WAREHOUSE_ROOM
 */
@SuppressWarnings("serial")
public class IvWarehouseRoom implements Serializable {

    private String whRoomId; // 仓库房间ID
    private String whRoomCode; // 仓库房间编号
    private String whRoomDesc; // 仓库房间描述
    private String whRoomStatus; // 仓库房间状态
    private IvWarehouseFloor warehouseFloor; // 09_仓库层
    @JsonIgnore
    private Set<IvShelf> shelfSet = new HashSet<IvShelf>(); // 09_货架
    @JsonIgnore
    private Set<IvLocation> locationSet = new HashSet<IvLocation>(); // 09_货位

    public String getWhRoomId() {
        return whRoomId;
    }

    public void setWhRoomId(String whRoomId) {
        this.whRoomId = whRoomId;
    }

    public String getWhRoomCode() {
        return whRoomCode;
    }

    public void setWhRoomCode(String whRoomCode) {
        this.whRoomCode = whRoomCode;
    }

    public String getWhRoomDesc() {
        return whRoomDesc;
    }

    public void setWhRoomDesc(String whRoomDesc) {
        this.whRoomDesc = whRoomDesc;
    }

    public String getWhRoomStatus() {
        return whRoomStatus;
    }

    public void setWhRoomStatus(String whRoomStatus) {
        this.whRoomStatus = whRoomStatus;
    }

    public IvWarehouseFloor getWarehouseFloor() {
        return warehouseFloor;
    }

    public void setWarehouseFloor(IvWarehouseFloor warehouseFloor) {
        this.warehouseFloor = warehouseFloor;
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
