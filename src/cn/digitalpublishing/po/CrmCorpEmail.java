package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 04_公司Email
 * @table CRM_CORP_EMAIL
 */
@SuppressWarnings("serial")
public class CrmCorpEmail implements Serializable {

    private String id; // 邮箱ID
    private String defaultFlg; // 是否主邮箱
    private String address; // 邮箱地址
    private String status; // 邮箱状态
    private CrmCorpTypeRelationship crmCorpTypeRelationship; // 04_公司类型角色关系

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDefaultFlg() {
        return defaultFlg;
    }

    public void setDefaultFlg(String defaultFlg) {
        this.defaultFlg = defaultFlg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
