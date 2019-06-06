package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @name 05_冲账申请单
 * @table O_REVERSE_REQ
 */
@SuppressWarnings("serial")
public class OReverseReq implements Serializable {

	private String reverseReqId; // 冲账申请单ID
	private String reverseReqCode; // 冲账申请单号
	private String reverseReqCreateBy; // 冲账申请单创建人
	private Date reverseReqCreateOn; // 冲账申请单创建日期
	private BigDecimal reverseReqAmount; // 冲账申请单金额
	private String reverseReqStatus; // 冲账申请单状态
	private CrmCorpTypeRelationship corpTypeRelationship; // 04_公司类型角色关系


	public String getReverseReqId() {
		return reverseReqId;
	}

	public void setReverseReqId(String reverseReqId) {
		this.reverseReqId = reverseReqId;
	}

	public String getReverseReqCode() {
		return reverseReqCode;
	}

	public void setReverseReqCode(String reverseReqCode) {
		this.reverseReqCode = reverseReqCode;
	}

	public String getReverseReqCreateBy() {
		return reverseReqCreateBy;
	}

	public void setReverseReqCreateBy(String reverseReqCreateBy) {
		this.reverseReqCreateBy = reverseReqCreateBy;
	}

	public Date getReverseReqCreateOn() {
		return reverseReqCreateOn;
	}

	public void setReverseReqCreateOn(Date reverseReqCreateOn) {
		this.reverseReqCreateOn = reverseReqCreateOn;
	}

	public BigDecimal getReverseReqAmount() {
		return reverseReqAmount;
	}

	public void setReverseReqAmount(BigDecimal reverseReqAmount) {
		this.reverseReqAmount = reverseReqAmount;
	}

	public String getReverseReqStatus() {
		return reverseReqStatus;
	}

	public void setReverseReqStatus(String reverseReqStatus) {
		this.reverseReqStatus = reverseReqStatus;
	}

	public CrmCorpTypeRelationship getCorpTypeRelationship() {
		return corpTypeRelationship;
	}

	public void setCorpTypeRelationship(CrmCorpTypeRelationship corpTypeRelationship) {
		this.corpTypeRelationship = corpTypeRelationship;
	}
}