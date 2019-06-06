package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.Date;

/**
 * @name 04_人员信息
 * @table CRM_PERSON
 */
@SuppressWarnings("serial")
public class CrmPerson implements Serializable {

	private String id; // 人员ID
	private String code; // 人员编码
	private String name; // 人员名称
	private String telephone; // 座机
	private String phone; // 手机
	private String address; // 联系地址
	private String postCode; // 邮编
	private String email; // 电子邮箱
	private String fax; // 传真
	private Date createOn; // 创建时间
	private String createBy; // 创建人
	private Date updateOn; // 修改时间
	private String updateBy; // 修改人
	private String status; // 状态
	private String pinyin; // 拼音
	private String lowerPinyin; // 拼音小写
    private String about; // 作者简介
    private CrmCorpTypeRelationship crmCorpTypeRelationship; // 04_公司类型角色关系
	@JsonIgnore
	private Set<CrmPersonTypeRelationship> personTypeRelationshipSet = new HashSet<CrmPersonTypeRelationship>(); // 04_人员类型角色关系
    @JsonIgnore
    private Set<PProposalPersonRelationship> proposalPersonRelationshipSet = new HashSet<PProposalPersonRelationship>(); // 01_策划人员关联表
	@JsonIgnore
	private Set<PProductProposalPersonRelationship> productProposalPersonRelationshipSet = new HashSet<PProductProposalPersonRelationship>(); // 01_产品策划编辑关联表
	@JsonIgnore
	private Set<PProposalAdvicePersonRelationship> proposalAdvicePersonRelationshipSet = new HashSet<PProposalAdvicePersonRelationship>(); // 01_策划意见人员关联表

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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

	public Date getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
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

	public Set<CrmPersonTypeRelationship> getPersonTypeRelationshipSet() {
		return personTypeRelationshipSet;
	}

	public void setPersonTypeRelationshipSet(Set<CrmPersonTypeRelationship> personTypeRelationshipSet) {
		this.personTypeRelationshipSet = personTypeRelationshipSet;
	}

    public Set<PProposalPersonRelationship> getProposalPersonRelationshipSet() {
        return proposalPersonRelationshipSet;
    }

    public void setProposalPersonRelationshipSet(
            Set<PProposalPersonRelationship> proposalPersonRelationshipSet) {
        this.proposalPersonRelationshipSet = proposalPersonRelationshipSet;
    }

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getLowerPinyin() {
		return lowerPinyin;
	}

	public void setLowerPinyin(String lowerPinyin) {
		this.lowerPinyin = lowerPinyin;
	}

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Set<PProductProposalPersonRelationship> getProductProposalPersonRelationshipSet() {
        return productProposalPersonRelationshipSet;
    }

    public void setProductProposalPersonRelationshipSet(Set<PProductProposalPersonRelationship> productProposalPersonRelationshipSet) {
        this.productProposalPersonRelationshipSet = productProposalPersonRelationshipSet;
    }

    public Set<PProposalAdvicePersonRelationship> getProposalAdvicePersonRelationshipSet() {
        return proposalAdvicePersonRelationshipSet;
    }

    public void setProposalAdvicePersonRelationshipSet(Set<PProposalAdvicePersonRelationship> proposalAdvicePersonRelationshipSet) {
        this.proposalAdvicePersonRelationshipSet = proposalAdvicePersonRelationshipSet;
    }
}
