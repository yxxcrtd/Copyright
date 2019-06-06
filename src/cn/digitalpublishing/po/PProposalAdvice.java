package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.Date;

/**
 * @name 01_策划意见
 * @table P_PROPOSAL_ADVICE
 */
@SuppressWarnings("serial")
public class PProposalAdvice implements Serializable {

    private String id; // 策划意见ID
    private String desc; // 策划意见描述
    private Date createOn; // 策划意见创建时间
    private String createBy; // 策划意见创建人
	private String roleType; // 策划意见可见范围
    private PProposal proposal; // 01_策划
	@JsonIgnore
	private Set<PProposalAdvicePersonRelationship> proposalAdvicePersonRelationshipSet = new HashSet<PProposalAdvicePersonRelationship>(); // 01_策划意见人员关联表

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public PProposal getProposal() {
        return proposal;
    }

    public void setProposal(PProposal proposal) {
        this.proposal = proposal;
    }

    public Set<PProposalAdvicePersonRelationship> getProposalAdvicePersonRelationshipSet() {
        return proposalAdvicePersonRelationshipSet;
    }

    public void setProposalAdvicePersonRelationshipSet(Set<PProposalAdvicePersonRelationship> proposalAdvicePersonRelationshipSet) {
        this.proposalAdvicePersonRelationshipSet = proposalAdvicePersonRelationshipSet;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
