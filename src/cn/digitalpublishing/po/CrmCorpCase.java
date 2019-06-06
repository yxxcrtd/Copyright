package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 04_公司销售机会
 * @table CRM_CORP_CASE
 */
@SuppressWarnings("serial")
public class CrmCorpCase implements Serializable {

    private String id; // 销售机会ID
    private String type; // 销售机会类别
    private String classify; // 销售机会分类
    private String level; // 销售机会优先级
    private String status; // 销售机会状态
    private String mode; // 销售机会方式
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

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public CrmCorpTypeRelationship getCrmCorpTypeRelationship() {
        return crmCorpTypeRelationship;
    }

    public void setCrmCorpTypeRelationship(CrmCorpTypeRelationship crmCorpTypeRelationship) {
        this.crmCorpTypeRelationship = crmCorpTypeRelationship;
    }
}
