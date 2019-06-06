package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 01_策划
 * @table P_PROPOSAL
 */
@SuppressWarnings("serial")
public class PProposal implements Serializable {

    private String id; // 策划ID
    private String name; // 策划名称
    private String desc; // 策划描述
    private Date createOn; // 策划创建时间
    private String createBy; // 策划创建人
	private String roleType; // 策划可见范围
    @JsonIgnore
    private Set<PProduct> productSet = new HashSet<PProduct>(); // 01_产品基础信息
    @JsonIgnore
    private Set<PProposalAdvice> proposalAdviceSet = new HashSet<PProposalAdvice>(); // 01_策划意见
	@JsonIgnore
	private Set<PProposalPersonRelationship> proposalPersonRelationshipSet = new HashSet<PProposalPersonRelationship>(); // 01_策划人员关联表
	@JsonIgnore
	private Set<PProposalAuthorRelationship> proposalAuthorRelationshipSet = new HashSet<PProposalAuthorRelationship>(); // 01_策划和贡献者关系


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<PProduct> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<PProduct> productSet) {
        this.productSet = productSet;
    }

    public Set<PProposalAdvice> getProposalAdviceSet() {
        return proposalAdviceSet;
    }

    public void setProposalAdviceSet(Set<PProposalAdvice> proposalAdviceSet) {
        this.proposalAdviceSet = proposalAdviceSet;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Set<PProposalPersonRelationship> getProposalPersonRelationshipSet() {
        return proposalPersonRelationshipSet;
    }

    public void setProposalPersonRelationshipSet(Set<PProposalPersonRelationship> proposalPersonRelationshipSet) {
        this.proposalPersonRelationshipSet = proposalPersonRelationshipSet;
    }

    public Set<PProposalAuthorRelationship> getProposalAuthorRelationshipSet() {
        return proposalAuthorRelationshipSet;
    }

    public void setProposalAuthorRelationshipSet(Set<PProposalAuthorRelationship> proposalAuthorRelationshipSet) {
        this.proposalAuthorRelationshipSet = proposalAuthorRelationshipSet;
    }
}
