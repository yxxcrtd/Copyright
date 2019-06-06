package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 04_人员标识
 * @table CRM_PERSON_IDENTITY
 */
@SuppressWarnings("serial")
public class CrmPersonIdentity implements Serializable {

	private String id; // 标识ID
	private String type; // 标识分类
	private String value; // 标识值
	private String defaultFlg; // 是否主标识
	private String status; // 标识状态
	private CrmPersonTypeRelationship crmPersonTypeRelationship; // 04_人员类型角色关系

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

	public String getDefaultFlg() {
		return defaultFlg;
	}

	public void setDefaultFlg(String defaultFlg) {
		this.defaultFlg = defaultFlg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CrmPersonTypeRelationship getCrmPersonTypeRelationship() {
		return crmPersonTypeRelationship;
	}

	public void setCrmPersonTypeRelationship(CrmPersonTypeRelationship crmPersonTypeRelationship) {
		this.crmPersonTypeRelationship = crmPersonTypeRelationship;
	}
}