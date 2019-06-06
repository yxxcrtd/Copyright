package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.Date;

/**
 * @name 04_公司信息
 * @table CRM_CORP
 */
@SuppressWarnings("serial")
public class CrmCorp implements Serializable {

    private String id; // 公司信息ID
    private String code; // 公司编码
    private String fullName; // 公司全称
    private String shortName; // 公司简称
    private String introduction; // 公司简介
    private String status; // 公司信息状态
    private String treeCode; // 公司树形编号
    private Integer order; // 公司排序
    private Date createOn; // 公司创建时间
    private String createBy; // 公司创建人
    private Date updateOn; // 公司修改时间
    private String updateBy; // 公司修改人
    private String nameFirstChar; // 公司简称首字母字符串
    private CrmCorpGroup corpGroup; // 04_公司组信息
    private BRegion region; // 00_地域信息
    @JsonIgnore
    private Set<CrmCorpTypeRelationship> corpTypeRelationshipSet = new HashSet<CrmCorpTypeRelationship>(); // 04_公司类型角色关系

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(String treeCode) {
        this.treeCode = treeCode;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getNameFirstChar() {
		return nameFirstChar;
	}

	public void setNameFirstChar(String nameFirstChar) {
		this.nameFirstChar = nameFirstChar;
	}

	public CrmCorpGroup getCorpGroup() {
        return corpGroup;
    }

    public void setCorpGroup(CrmCorpGroup corpGroup) {
        this.corpGroup = corpGroup;
    }

    public BRegion getRegion() {
        return region;
    }

    public void setRegion(BRegion region) {
        this.region = region;
    }

    public Set<CrmCorpTypeRelationship> getCorpTypeRelationshipSet() {
        return corpTypeRelationshipSet;
    }

    public void setCorpTypeRelationshipSet(Set<CrmCorpTypeRelationship> corpTypeRelationshipSet) {
        this.corpTypeRelationshipSet = corpTypeRelationshipSet;
    }
}
