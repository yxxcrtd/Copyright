package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 04_人员岗位关系
 * @table CRM_PERSON_POSITION_RS
 */
@SuppressWarnings("serial")
public class CrmPersonPositionRelationship implements Serializable {

	private String id; // 人员岗位关系ID
	private String status; // 人员岗位关系状态
	private CrmPosition position; // 04_岗位信息
	private CrmPersonTypeRelationship personTypeRelationship; // 04_人员类型角色关系

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CrmPosition getPosition() {
		return position;
	}

	public void setPosition(CrmPosition position) {
		this.position = position;
	}

	public CrmPersonTypeRelationship getPersonTypeRelationship() {
		return personTypeRelationship;
	}

	public void setPersonTypeRelationship(CrmPersonTypeRelationship personTypeRelationship) {
		this.personTypeRelationship = personTypeRelationship;
	}
}
