package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 02_公司人员流程节点关系
 * @table F_CORP_PERSON_ACTIVITY_RS
 */
@SuppressWarnings("serial")
public class FCorpPersonActivityRelationship implements Serializable {

	private String cpaId; // 公司人员流程节点关系ID
	private CrmPersonTypeRelationship crmPersonTypeRelationship; // 04_人员类型角色关系
	private FActivity activity; // 02_流程节点信息
	private CrmCorpTypeRelationship crmCorpTypeRelationship; // 04_公司类型角色关系

	public String getCpaId() {
		return cpaId;
	}

	public void setCpaId(String cpaId) {
		this.cpaId = cpaId;
	}

	public CrmPersonTypeRelationship getCrmPersonTypeRelationship() {
		return crmPersonTypeRelationship;
	}

	public void setCrmPersonTypeRelationship(CrmPersonTypeRelationship crmPersonTypeRelationship) {
		this.crmPersonTypeRelationship = crmPersonTypeRelationship;
	}

	public FActivity getActivity() {
		return activity;
	}

	public void setActivity(FActivity activity) {
		this.activity = activity;
	}

	public CrmCorpTypeRelationship getCrmCorpTypeRelationship() {
		return crmCorpTypeRelationship;
	}

	public void setCrmCorpTypeRelationship(CrmCorpTypeRelationship crmCorpTypeRelationship) {
		this.crmCorpTypeRelationship = crmCorpTypeRelationship;
	}
}