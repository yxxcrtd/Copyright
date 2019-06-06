package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 01_产品和合同关系
 * @table P_PRODUCT_CONTRACT_RS
 */
@SuppressWarnings("serial")
public class PProductContractRelationship implements Serializable {

	private String id; // 产品和合同关系ID
	private PProduct product; // 01_产品基础信息
	private CrContract contract; // 11_合同

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

	public CrContract getContract() {
		return contract;
	}

	public void setContract(CrContract contract) {
		this.contract = contract;
	}
}