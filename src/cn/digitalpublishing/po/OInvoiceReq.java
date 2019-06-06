package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @name 05_销售发票申请单
 * @table O_INVOICE_REQ
 */
@SuppressWarnings("serial")
public class OInvoiceReq implements Serializable {

	private String invoiceReqId; // 销售发票申请单ID
	private String invoiceReqCode; // 销售发票申请单号
	private String invoiceReqCreateBy; // 销售发票申请单创建人
	private Date invoiceReqCreateOn; // 销售发票申请单创建日期
	private String invoiceReqCustomer; // 销售发票申请单客户名称
	private String invoiceReqInvoiceType; // 销售发票申请单发票类型
	private String invoiceReqContent; // 销售发票申请单发票内容
	private String invoiceReqRemark; // 销售发票申请单备注
	private Integer invoiceReqCount; // 销售发票申请单总册数
	private BigDecimal invoiceReqFixedPrice; // 销售发票申请单总码洋
	private BigDecimal invoiceReqDiscountedPrice; // 销售发票申请单总实洋
	private Integer invoiceReqTaxRate; // 销售发票申请单税率
	private BigDecimal invoiceReqTax; // 销售发票申请单税额
	private String invoiceReqStatus; // 销售发票申请单状态
	private CrmCorpTypeRelationship corpTypeRelationship; // 04_公司类型角色关系
	@JsonIgnore
	private Set<IvStockOut> stockOutSet = new HashSet<IvStockOut>(); // 09_出库单
	@JsonIgnore
	private Set<OInvoiceRepaymentRelationship> invoiceRepaymentRelationshipSet = new HashSet<OInvoiceRepaymentRelationship>(); // 05_销售发票和销售来款关系


	public String getInvoiceReqId() {
		return invoiceReqId;
	}

	public void setInvoiceReqId(String invoiceReqId) {
		this.invoiceReqId = invoiceReqId;
	}

	public String getInvoiceReqCode() {
		return invoiceReqCode;
	}

	public void setInvoiceReqCode(String invoiceReqCode) {
		this.invoiceReqCode = invoiceReqCode;
	}

	public String getInvoiceReqCreateBy() {
		return invoiceReqCreateBy;
	}

	public void setInvoiceReqCreateBy(String invoiceReqCreateBy) {
		this.invoiceReqCreateBy = invoiceReqCreateBy;
	}

	public Date getInvoiceReqCreateOn() {
		return invoiceReqCreateOn;
	}

	public void setInvoiceReqCreateOn(Date invoiceReqCreateOn) {
		this.invoiceReqCreateOn = invoiceReqCreateOn;
	}

	public String getInvoiceReqCustomer() {
		return invoiceReqCustomer;
	}

	public void setInvoiceReqCustomer(String invoiceReqCustomer) {
		this.invoiceReqCustomer = invoiceReqCustomer;
	}

	public String getInvoiceReqInvoiceType() {
		return invoiceReqInvoiceType;
	}

	public void setInvoiceReqInvoiceType(String invoiceReqInvoiceType) {
		this.invoiceReqInvoiceType = invoiceReqInvoiceType;
	}

	public String getInvoiceReqContent() {
		return invoiceReqContent;
	}

	public void setInvoiceReqContent(String invoiceReqContent) {
		this.invoiceReqContent = invoiceReqContent;
	}

	public String getInvoiceReqRemark() {
		return invoiceReqRemark;
	}

	public void setInvoiceReqRemark(String invoiceReqRemark) {
		this.invoiceReqRemark = invoiceReqRemark;
	}

	public Integer getInvoiceReqCount() {
		return invoiceReqCount;
	}

	public void setInvoiceReqCount(Integer invoiceReqCount) {
		this.invoiceReqCount = invoiceReqCount;
	}

	public BigDecimal getInvoiceReqFixedPrice() {
		return invoiceReqFixedPrice;
	}

	public void setInvoiceReqFixedPrice(BigDecimal invoiceReqFixedPrice) {
		this.invoiceReqFixedPrice = invoiceReqFixedPrice;
	}

	public BigDecimal getInvoiceReqDiscountedPrice() {
		return invoiceReqDiscountedPrice;
	}

	public void setInvoiceReqDiscountedPrice(BigDecimal invoiceReqDiscountedPrice) {
		this.invoiceReqDiscountedPrice = invoiceReqDiscountedPrice;
	}

	public Integer getInvoiceReqTaxRate() {
		return invoiceReqTaxRate;
	}

	public void setInvoiceReqTaxRate(Integer invoiceReqTaxRate) {
		this.invoiceReqTaxRate = invoiceReqTaxRate;
	}

	public BigDecimal getInvoiceReqTax() {
		return invoiceReqTax;
	}

	public void setInvoiceReqTax(BigDecimal invoiceReqTax) {
		this.invoiceReqTax = invoiceReqTax;
	}

	public String getInvoiceReqStatus() {
		return invoiceReqStatus;
	}

	public void setInvoiceReqStatus(String invoiceReqStatus) {
		this.invoiceReqStatus = invoiceReqStatus;
	}

	public CrmCorpTypeRelationship getCorpTypeRelationship() {
		return corpTypeRelationship;
	}

	public void setCorpTypeRelationship(CrmCorpTypeRelationship corpTypeRelationship) {
		this.corpTypeRelationship = corpTypeRelationship;
	}

	public Set<IvStockOut> getStockOutSet() {
		return stockOutSet;
	}

	public void setStockOutSet(Set<IvStockOut> stockOutSet) {
		this.stockOutSet = stockOutSet;
	}

	public Set<OInvoiceRepaymentRelationship> getInvoiceRepaymentRelationshipSet() {
		return invoiceRepaymentRelationshipSet;
	}

	public void setInvoiceRepaymentRelationshipSet(Set<OInvoiceRepaymentRelationship> invoiceRepaymentRelationshipSet) {
		this.invoiceRepaymentRelationshipSet = invoiceRepaymentRelationshipSet;
	}
}