package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.Date;

/**
 * @name 04_公司组信息
 * @table CRM_CORP_GROUP
 */
@SuppressWarnings("serial")
public class CrmCorpGroup implements Serializable {

    private String id; // 公司组ID
    private String name; // 公司组名称
    private String code; // 公司组编码
    private String introduction; // 公司组简介
    private String status; // 公司组状态
    private String type; // 公司组类型
    private Date createOn; // 公司组创建日期
    private String createBy; // 公司组创建人
    private Date updateOn; // 公司组修改日期
    private String updateBy; // 公司组修改人
    @JsonIgnore
    private Set<CrmCorp> corpSet = new HashSet<CrmCorp>(); // 04_公司信息


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Set<CrmCorp> getCorpSet() {
        return corpSet;
    }

    public void setCorpSet(Set<CrmCorp> corpSet) {
        this.corpSet = corpSet;
    }
}
