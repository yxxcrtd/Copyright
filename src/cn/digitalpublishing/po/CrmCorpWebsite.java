package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 04_公司网站
 * @table CRM_CORP_WEBSITE
 */
@SuppressWarnings("serial")
public class CrmCorpWebsite implements Serializable {

    private String id; // 网站ID
    private String type; // 网站分类
    private String url; // 网站地址
    private String status; // 网站状态
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
