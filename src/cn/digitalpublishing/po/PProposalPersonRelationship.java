package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 01_策划人员关联表
 * @table P_PROPOSAL_PERSON_RS
 */
@SuppressWarnings("serial")
public class PProposalPersonRelationship implements Serializable {

    private String id; // 策划人员关联ID
    private PProposal proposal; // 01_策划
    private CrmPerson person; // 04_人员信息

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PProposal getProposal() {
        return proposal;
    }

    public void setProposal(PProposal proposal) {
        this.proposal = proposal;
    }

    public CrmPerson getPerson() {
        return person;
    }

    public void setPerson(CrmPerson person) {
        this.person = person;
    }
}