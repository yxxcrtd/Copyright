package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @name 05_销售来款
 * @table O_REPAYMENT_REQ
 */
@SuppressWarnings("serial")
public class ORepaymentReq implements Serializable {

	private String repaymentReqId; // 销售来款ID
	private String repaymentReqPayName; // 销售来款付款人名称
	private Date repaymentReqPayOn; // 销售来款付款日期
	private String repaymentReqPayType; // 销售来款付款方式
	private BigDecimal repaymentReqAmount; // 销售来款金额
	private String repaymentReqRemark; // 销售来款备注
	private String repaymentReqClaimBy; // 销售来款认领人
	private Date repaymentReqClaimOn; // 销售来款认领日期
	private String repaymentReqStatus; // 销售来款状态
	private CrmCorpTypeRelationship corpTypeRelationship; // 04_公司类型角色关系
	@JsonIgnore
	private Set<OInvoiceRepaymentRelationship> invoiceRepaymentRelationshipSet = new HashSet<OInvoiceRepaymentRelationship>(); // 05_销售发票和销售来款关系

	public String getRepaymentReqId() {
		return repaymentReqId;
	}

	public void setRepaymentReqId(String repaymentReqId) {
		this.repaymentReqId = repaymentReqId;
	}

	public String getRepaymentReqPayName() {
		return repaymentReqPayName;
	}

	public void setRepaymentReqPayName(String repaymentReqPayName) {
		this.repaymentReqPayName = repaymentReqPayName;
	}

	public Date getRepaymentReqPayOn() {
		return repaymentReqPayOn;
	}

	public void setRepaymentReqPayOn(Date repaymentReqPayOn) {
		this.repaymentReqPayOn = repaymentReqPayOn;
	}

	public String getRepaymentReqPayType() {
		return repaymentReqPayType;
	}

	public void setRepaymentReqPayType(String repaymentReqPayType) {
		this.repaymentReqPayType = repaymentReqPayType;
	}

	public BigDecimal getRepaymentReqAmount() {
		return repaymentReqAmount;
	}

	public void setRepaymentReqAmount(BigDecimal repaymentReqAmount) {
		this.repaymentReqAmount = repaymentReqAmount;
	}

	public String getRepaymentReqRemark() {
		return repaymentReqRemark;
	}

	public void setRepaymentReqRemark(String repaymentReqRemark) {
		this.repaymentReqRemark = repaymentReqRemark;
	}

	public String getRepaymentReqClaimBy() {
		return repaymentReqClaimBy;
	}

	public void setRepaymentReqClaimBy(String repaymentReqClaimBy) {
		this.repaymentReqClaimBy = repaymentReqClaimBy;
	}

	public Date getRepaymentReqClaimOn() {
		return repaymentReqClaimOn;
	}

	public void setRepaymentReqClaimOn(Date repaymentReqClaimOn) {
		this.repaymentReqClaimOn = repaymentReqClaimOn;
	}

	public String getRepaymentReqStatus() {
		return repaymentReqStatus;
	}

	public void setRepaymentReqStatus(String repaymentReqStatus) {
		this.repaymentReqStatus = repaymentReqStatus;
	}

	public CrmCorpTypeRelationship getCorpTypeRelationship() {
		return corpTypeRelationship;
	}

	public void setCorpTypeRelationship(CrmCorpTypeRelationship corpTypeRelationship) {
		this.corpTypeRelationship = corpTypeRelationship;
	}

	public Set<OInvoiceRepaymentRelationship> getInvoiceRepaymentRelationshipSet() {
		return invoiceRepaymentRelationshipSet;
	}

	public void setInvoiceRepaymentRelationshipSet(Set<OInvoiceRepaymentRelationship> invoiceRepaymentRelationshipSet) {
		this.invoiceRepaymentRelationshipSet = invoiceRepaymentRelationshipSet;
	}
}