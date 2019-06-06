package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 04_人员联系电话
 * @table CRM_PERSON_PHONE
 */
@SuppressWarnings("serial")
public class CrmPersonPhone implements Serializable {

	private String id; // 联系电话ID
	private String type; // 电话分类
	private String defaultFlg; // 是否主要电话
	private String country; // 国家
	private String no; // 号码
	private String status; // 状态
	private CrmPersonTypeRelationship crmPersonTypeRelationship; // 04_人员类型角色关系

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDefaultFlg() {
		return defaultFlg;
	}

	public void setDefaultFlg(String defaultFlg) {
		this.defaultFlg = defaultFlg;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CrmPersonTypeRelationship getCrmPersonTypeRelationship() {
		return crmPersonTypeRelationship;
	}

	public void setCrmPersonTypeRelationship(CrmPersonTypeRelationship crmPersonTypeRelationship) {
		this.crmPersonTypeRelationship = crmPersonTypeRelationship;
	}
}