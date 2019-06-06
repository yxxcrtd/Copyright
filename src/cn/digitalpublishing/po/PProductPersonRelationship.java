package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 01_产品和贡献者关联
 * @table P_PRODUCT_PERSON_RS
 */
@SuppressWarnings("serial")
public class PProductPersonRelationship implements Serializable {

	private String id; // 贡献者ID
	private String defaultFlg; // 默认贡献者
	private PProduct product; // 01_产品基础信息
	private CrmPersonTypeRelationship personTypeRelationship; // 04_人员类型角色关系

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

	public PProduct getProduct() {
		return product;
	}

	public void setProduct(PProduct product) {
		this.product = product;
	}

	public CrmPersonTypeRelationship getPersonTypeRelationship() {
		return personTypeRelationship;
	}

	public void setPersonTypeRelationship(CrmPersonTypeRelationship personTypeRelationship) {
		this.personTypeRelationship = personTypeRelationship;
	}
}
