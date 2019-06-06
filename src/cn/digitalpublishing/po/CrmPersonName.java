package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 04_人员名称
 * @table CRM_PERSON_NAME
 */
@SuppressWarnings("serial")
public class CrmPersonName implements Serializable {

	private String id; // 人员名称ID
	private String type; // 人员名称类型
	private String name; // 人员名称
	private String status; // 人员状态
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CrmPersonTypeRelationship getCrmPersonTypeRelationship() {
		return crmPersonTypeRelationship;
	}

	public void setCrmPersonTypeRelationship(CrmPersonTypeRelationship crmPersonTypeRelationship) {
		this.crmPersonTypeRelationship = crmPersonTypeRelationship;
	}
}