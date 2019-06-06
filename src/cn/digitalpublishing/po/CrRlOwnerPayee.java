package cn.digitalpublishing.po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @name 付款对象
 * @table CR_RL_OWNER_PAYEE
 */
@SuppressWarnings("serial")
public class CrRlOwnerPayee implements Serializable {

	private String feePayeeId; // 付款对象ID
	private BigDecimal feePayeePercent; // 付款对象比率
	private String feePayeeReason; // 付款对象原因
	private String status; // 状态
	private CrRlOwner rlOwner; // 权利授权者
	private BCurrency currency; // 币种
	private CrmPersonTypeRelationship personTypeRelationship; // 收款人

	public String getFeePayeeId() {
		return feePayeeId;
	}

	public void setFeePayeeId(String feePayeeId) {
		this.feePayeeId = feePayeeId;
	}

	public BigDecimal getFeePayeePercent() {
		return feePayeePercent;
	}

	public void setFeePayeePercent(BigDecimal feePayeePercent) {
		this.feePayeePercent = feePayeePercent;
	}

	public String getFeePayeeReason() {
		return feePayeeReason;
	}

	public void setFeePayeeReason(String feePayeeReason) {
		this.feePayeeReason = feePayeeReason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CrRlOwner getRlOwner() {
		return rlOwner;
	}

	public void setRlOwner(CrRlOwner rlOwner) {
		this.rlOwner = rlOwner;
	}

	public BCurrency getCurrency() {
		return currency;
	}

	public void setCurrency(BCurrency currency) {
		this.currency = currency;
	}

	public CrmPersonTypeRelationship getPersonTypeRelationship() {
		return personTypeRelationship;
	}

	public void setPersonTypeRelationship(CrmPersonTypeRelationship personTypeRelationship) {
		this.personTypeRelationship = personTypeRelationship;
	}
}