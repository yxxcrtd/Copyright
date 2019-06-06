package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 04_公司联系地址
 * @table CRM_CORP_ADDRESS
 */
@SuppressWarnings("serial")
public class CrmCorpAddress implements Serializable {

    private String id; // 地址ID
    private String type; // 地址分类
    private String country; // 国家
    private String roomNo; // 房间号
    private Integer floor; // 楼层
    private String building; // 建筑名
    private String street; // 街道名
    private String block; // 区
    private String town; // 镇
    private String city; // 城市
    private String post; // 邮编
    private String status; // 状态
    private CrmCorpTypeRelationship crmCorpTypeRelationship; // 04_公司类型角色关系

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CrmCorpTypeRelationship getCrmCorpTypeRelationship() {
        return crmCorpTypeRelationship;
    }

    public void setCrmCorpTypeRelationship(CrmCorpTypeRelationship crmCorpTypeRelationship) {
        this.crmCorpTypeRelationship = crmCorpTypeRelationship;
    }
}
