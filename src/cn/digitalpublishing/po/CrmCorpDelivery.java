package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 04_公司收货信息
 * @table CRM_CORP_DELIVERY
 */
@SuppressWarnings("serial")
public class CrmCorpDelivery implements Serializable {

	private String id; // 收货ID
	private String corpName; // 收货单位
	private String corpAddress; // 收货地址
	private String receiverName; // 收货联系人
	private String tel; // 收货联系电话
	private String fax; // 收货联系传真
	private String postcode; // 收货邮编
	private String status; // 收货状态
	private CrmCorpTypeRelationship crmCorpTypeRelationship; // 04_公司类型角色关系

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCorpAddress() {
		return corpAddress;
	}

	public void setCorpAddress(String corpAddress) {
		this.corpAddress = corpAddress;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
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
}