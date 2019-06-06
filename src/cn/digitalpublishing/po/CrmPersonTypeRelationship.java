package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 04_人员类型角色关系
 * @table CRM_PERSON_TYPE_RS
 */
@SuppressWarnings("serial")
public class CrmPersonTypeRelationship implements Serializable {

	private String id; // 人员类型角色ID
    private String status; // 人员类型角色状态
	private CrmPersonType personType; // 04_人员类型
	private CrmPerson person; // 04_人员信息
	@JsonIgnore
	private Set<CrmPersonPositionRelationship> personPositionRelationshipSet = new HashSet<CrmPersonPositionRelationship>(); // 04_人员岗位关系
	@JsonIgnore
	private Set<PProductPersonRelationship> productPersonRelationshipSet = new HashSet<PProductPersonRelationship>(); // 01_产品和贡献者关联
	@JsonIgnore
	private Set<CrmPersonProp> personPropSet = new HashSet<CrmPersonProp>(); // 04_人员属性
	@JsonIgnore
	private Set<CrmPersonName> personNameSet = new HashSet<CrmPersonName>(); // 04_人员名称
	@JsonIgnore
	private Set<CrmPersonEmail> personEmailSet = new HashSet<CrmPersonEmail>(); // 04_人员Email
	@JsonIgnore
	private Set<CrmPersonPhone> personPhoneSet = new HashSet<CrmPersonPhone>(); // 04_人员联系电话
	@JsonIgnore
	private Set<CrmPersonIdentity> personIdentitySet = new HashSet<CrmPersonIdentity>(); // 04_人员标识
	@JsonIgnore
	private Set<PProposalAuthorRelationship> proposalAuthorRelationshipSet = new HashSet<PProposalAuthorRelationship>(); // 01_策划和贡献者关系
	@JsonIgnore
	private Set<FCorpPersonActivityRelationship> corpPersonActivityRelationshipSet = new HashSet<FCorpPersonActivityRelationship>(); // 02_公司人员流程节点关系

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

    public CrmPersonType getPersonType() {
		return personType;
	}

	public void setPersonType(CrmPersonType personType) {
		this.personType = personType;
	}

	public CrmPerson getPerson() {
		return person;
	}

	public void setPerson(CrmPerson person) {
		this.person = person;
	}

	public Set<CrmPersonPositionRelationship> getPersonPositionRelationshipSet() {
		return personPositionRelationshipSet;
	}

	public void setPersonPositionRelationshipSet(Set<CrmPersonPositionRelationship> personPositionRelationshipSet) {
		this.personPositionRelationshipSet = personPositionRelationshipSet;
	}

	public Set<PProductPersonRelationship> getProductPersonRelationshipSet() {
		return productPersonRelationshipSet;
	}

	public void setProductPersonRelationshipSet(Set<PProductPersonRelationship> productPersonRelationshipSet) {
		this.productPersonRelationshipSet = productPersonRelationshipSet;
	}

	public Set<CrmPersonProp> getPersonPropSet() {
		return personPropSet;
	}

	public void setPersonPropSet(Set<CrmPersonProp> personPropSet) {
		this.personPropSet = personPropSet;
	}

	public Set<CrmPersonName> getPersonNameSet() {
		return personNameSet;
	}

	public void setPersonNameSet(Set<CrmPersonName> personNameSet) {
		this.personNameSet = personNameSet;
	}

	public Set<CrmPersonEmail> getPersonEmailSet() {
		return personEmailSet;
	}

	public void setPersonEmailSet(Set<CrmPersonEmail> personEmailSet) {
		this.personEmailSet = personEmailSet;
	}

	public Set<CrmPersonPhone> getPersonPhoneSet() {
		return personPhoneSet;
	}

	public void setPersonPhoneSet(Set<CrmPersonPhone> personPhoneSet) {
		this.personPhoneSet = personPhoneSet;
	}

	public Set<CrmPersonIdentity> getPersonIdentitySet() {
		return personIdentitySet;
	}

	public void setPersonIdentitySet(Set<CrmPersonIdentity> personIdentitySet) {
		this.personIdentitySet = personIdentitySet;
	}

    public Set<PProposalAuthorRelationship> getProposalAuthorRelationshipSet() {
        return proposalAuthorRelationshipSet;
    }

    public void setProposalAuthorRelationshipSet(Set<PProposalAuthorRelationship> proposalAuthorRelationshipSet) {
        this.proposalAuthorRelationshipSet = proposalAuthorRelationshipSet;
    }
	public Set<FCorpPersonActivityRelationship> getCorpPersonActivityRelationshipSet() {
		return corpPersonActivityRelationshipSet;
	}

	public void setCorpPersonActivityRelationshipSet(Set<FCorpPersonActivityRelationship> corpPersonActivityRelationshipSet) {
		this.corpPersonActivityRelationshipSet = corpPersonActivityRelationshipSet;
	}
}
