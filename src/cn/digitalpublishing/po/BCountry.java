package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.Date;

/**
 * @name 00_国别
 * @table B_COUNTRY
 */
@SuppressWarnings("serial")
public class BCountry implements Serializable {

    private String id; // 国别ID
    private String cnName; // 国家中文名称
    private String enName; // 国家英文名称
    private String status; // 状态
    private Date createOn; // 创建日期
    private String createBy; // 创建者
    private Date updateOn; // 修改日期
    private String updateBy; // 修改者
    private String internationCode; // 国际化参数
    @JsonIgnore
    private Set<BRegion> regionSet = new HashSet<BRegion>(); // 00_地域信息


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getInternationCode() {
        return internationCode;
    }

    public void setInternationCode(String internationCode) {
        this.internationCode = internationCode;
    }

    public Set<BRegion> getRegionSet() {
        return regionSet;
    }

    public void setRegionSet(Set<BRegion> regionSet) {
        this.regionSet = regionSet;
    }
}
