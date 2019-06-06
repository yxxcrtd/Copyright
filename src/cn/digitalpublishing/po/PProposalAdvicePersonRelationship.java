package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 01_策划意见人员关联表
 * @table P_PROPOSAL_ADVICE_PERSON_RS
 */
@SuppressWarnings("serial")
public class PProposalAdvicePersonRelationship implements Serializable {

	private String id; // 策划意见人员关联ID
	private PProposalAdvice proposalAdvice; // 01_策划意见
	private CrmPerson person; // 04_人员信息

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PProposalAdvice getProposalAdvice() {
		return proposalAdvice;
	}

	public void setProposalAdvice(PProposalAdvice proposalAdvice) {
		this.proposalAdvice = proposalAdvice;
	}

	public CrmPerson getPerson() {
		return person;
	}

	public void setPerson(CrmPerson person) {
		this.person = person;
	}
}