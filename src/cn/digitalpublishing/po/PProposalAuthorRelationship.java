package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 01_策划和贡献者关系
 * @table P_PROPOSAL_AUTHOR_RS
 */
@SuppressWarnings("serial")
public class PProposalAuthorRelationship implements Serializable {

	private String id; // 策划和贡献者关系ID
	private String defaultFlg; // 默认贡献者
	private CrmPersonTypeRelationship personTypeRelationship; // 04_人员类型角色关系
	private PProposal proposal; // 01_策划

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

	public CrmPersonTypeRelationship getPersonTypeRelationship() {
		return personTypeRelationship;
	}

	public void setPersonTypeRelationship(CrmPersonTypeRelationship personTypeRelationship) {
		this.personTypeRelationship = personTypeRelationship;
	}

	public PProposal getProposal() {
		return proposal;
	}

	public void setProposal(PProposal proposal) {
		this.proposal = proposal;
	}
}