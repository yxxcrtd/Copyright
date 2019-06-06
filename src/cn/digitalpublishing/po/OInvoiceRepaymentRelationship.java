package cn.digitalpublishing.po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @name 05_销售发票和销售来款关系
 * @table O_INVOICE_REPAYMENT_RS
 */
@SuppressWarnings("serial")
public class OInvoiceRepaymentRelationship implements Serializable {

	private String invoiceRepaymentId; // 销售发票和销售来款关系ID
	private String invoiceRepaymentType; // 销售发票和销售来款关系类型
	private BigDecimal invoiceRepaymentAmount; // 销售发票和销售来款关系金额
	private OInvoiceReq invoiceReq; // 05_销售发票申请单
	private ORepaymentReq repaymentReq; // 05_销售来款

	public String getInvoiceRepaymentId() {
		return invoiceRepaymentId;
	}

	public void setInvoiceRepaymentId(String invoiceRepaymentId) {
		this.invoiceRepaymentId = invoiceRepaymentId;
	}

	public String getInvoiceRepaymentType() {
		return invoiceRepaymentType;
	}

	public void setInvoiceRepaymentType(String invoiceRepaymentType) {
		this.invoiceRepaymentType = invoiceRepaymentType;
	}

	public BigDecimal getInvoiceRepaymentAmount() {
		return invoiceRepaymentAmount;
	}

	public void setInvoiceRepaymentAmount(BigDecimal invoiceRepaymentAmount) {
		this.invoiceRepaymentAmount = invoiceRepaymentAmount;
	}

	public OInvoiceReq getInvoiceReq() {
		return invoiceReq;
	}

	public void setInvoiceReq(OInvoiceReq invoiceReq) {
		this.invoiceReq = invoiceReq;
	}

	public ORepaymentReq getRepaymentReq() {
		return repaymentReq;
	}

	public void setRepaymentReq(ORepaymentReq repaymentReq) {
		this.repaymentReq = repaymentReq;
	}
}