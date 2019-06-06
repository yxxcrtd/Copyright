package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 04_岗位信息
 * @table CRM_POSITION
 */
@SuppressWarnings("serial")
public class CrmPosition implements Serializable {

	private String id; // 岗位ID
	private String code; // 岗位编号
	private String name; // 岗位名称
	private String status; // 岗位状态
	private CrmCorpTypeRelationship crmCorpTypeRelationship; // 04_公司类型角色关系
	@JsonIgnore
	private Set<CrmPersonPositionRelationship> personPositionRelationshipSet = new HashSet<CrmPersonPositionRelationship>(); // 04_人员岗位关系

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

	public CrmCorpTypeRelationship getCrmCorpTypeRelationship() {
		return crmCorpTypeRelationship;
	}

	public void setCrmCorpTypeRelationship(CrmCorpTypeRelationship crmCorpTypeRelationship) {
		this.crmCorpTypeRelationship = crmCorpTypeRelationship;
	}

	public Set<CrmPersonPositionRelationship> getPersonPositionRelationshipSet() {
		return personPositionRelationshipSet;
	}

	public void setPersonPositionRelationshipSet(Set<CrmPersonPositionRelationship> personPositionRelationshipSet) {
		this.personPositionRelationshipSet = personPositionRelationshipSet;
	}
}
