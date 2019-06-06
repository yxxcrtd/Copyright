package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 01_产品策划编辑关联表
 * @table P_PRODUCT_PROPOSAL_PERSON_RS
 */
@SuppressWarnings("serial")
public class PProductProposalPersonRelationship implements Serializable {

	private String id; // 产品策划编辑关联ID
	private String proportion; // 所占比例
	private String isMainProposal; // 是否是主策划
	private PProduct product; // 01_产品基础信息
	private CrmPerson person; // 04_人员信息

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PProduct getProduct() {
		return product;
	}

	public void setProduct(PProduct product) {
		this.product = product;
	}

	public CrmPerson getPerson() {
		return person;
	}

	public void setPerson(CrmPerson person) {
		this.person = person;
	}

	public String getIsMainProposal() {
		return isMainProposal;
	}

	public void setIsMainProposal(String isMainProposal) {
		this.isMainProposal = isMainProposal;
	}

	public String getProportion() {
		return proportion;
	}

	public void setProportion(String proportion) {
		this.proportion = proportion;
	}
}
