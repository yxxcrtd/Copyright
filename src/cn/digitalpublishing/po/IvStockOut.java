package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @name 09_出库单
 * @table IV_STOCK_OUT
 */
@SuppressWarnings("serial")
public class IvStockOut implements Serializable {

	private String stockOutId; // 出库单ID
	private String stockOutCode; // 出库单号
	private Date stockOutCreateOn; // 出库单创建日期
	private String stockOutCreateBy; // 出库单创建人
	private Date stockOutUpdateOn; // 出库单修改日期
	private String stockOutUpdateBy; // 出库单修改人
	private Date stockOutSendOn; // 出库单发货日期
	private String stockOutReceiveCorp; // 出库单收货单位
	private String stockOutReceiveAddr; // 出库单收货地址
	private String stockOutReceiveTel; // 出库单联系电话
	private String stockOutReceivePerson; // 出库单联系人
	private Integer stockOutTotalCount; // 出库单总数量
	private BigDecimal stockOutFixedPrice; // 出库单总码洋
	private BigDecimal stockOutDiscountedPrice; // 出库单总实洋
	private Integer stockOutAverageDiscount; // 出库单平均折扣
	private Integer stockOutTaxRate; // 出库单税率
	private BigDecimal stockOutDiscount; // 出库单折扣额
	private BigDecimal stockOutAttach; // 出库单附加费用
	private Integer stockOutTypeCount; // 出库单品种数
	private String stockOutBusinessBy; // 出库单业务人
	private String stockOutStatus; // 出库单状态
	private IvWarehouse warehouse; // 09_仓库
	private OSaleOrder saleOrder; // 05_销售订单
	private CrmCorpTypeRelationship corpTypeRelationship; // 04_公司类型角色关系
	private OInvoiceReq invoiceReq; // 05_销售发票申请单
	private IvTransport transport; // 09_运输登记单
	@JsonIgnore
	private Set<IvStockOutItem> stockOutItemSet = new HashSet<IvStockOutItem>(); // 09_出库单明细
	
	private Integer stockOutItemQuantity; // 出库单明细数量 view
	private Integer stockOutItemPartQuantity; // 部分下架 出库单明细数量 view
	private Integer stockOutItemAllQuantity; // 全部下架 出库单明细数量 view

	public String getStockOutId() {
		return stockOutId;
	}

	public void setStockOutId(String stockOutId) {
		this.stockOutId = stockOutId;
	}

	public String getStockOutCode() {
		return stockOutCode;
	}

	public void setStockOutCode(String stockOutCode) {
		this.stockOutCode = stockOutCode;
	}

	public Date getStockOutCreateOn() {
		return stockOutCreateOn;
	}

	public void setStockOutCreateOn(Date stockOutCreateOn) {
		this.stockOutCreateOn = stockOutCreateOn;
	}

	public String getStockOutCreateBy() {
		return stockOutCreateBy;
	}

	public void setStockOutCreateBy(String stockOutCreateBy) {
		this.stockOutCreateBy = stockOutCreateBy;
	}

	public Date getStockOutUpdateOn() {
		return stockOutUpdateOn;
	}

	public void setStockOutUpdateOn(Date stockOutUpdateOn) {
		this.stockOutUpdateOn = stockOutUpdateOn;
	}

	public String getStockOutUpdateBy() {
		return stockOutUpdateBy;
	}

	public void setStockOutUpdateBy(String stockOutUpdateBy) {
		this.stockOutUpdateBy = stockOutUpdateBy;
	}

	public Date getStockOutSendOn() {
		return stockOutSendOn;
	}

	public void setStockOutSendOn(Date stockOutSendOn) {
		this.stockOutSendOn = stockOutSendOn;
	}

	public String getStockOutReceiveCorp() {
		return stockOutReceiveCorp;
	}

	public void setStockOutReceiveCorp(String stockOutReceiveCorp) {
		this.stockOutReceiveCorp = stockOutReceiveCorp;
	}

	public String getStockOutReceiveAddr() {
		return stockOutReceiveAddr;
	}

	public void setStockOutReceiveAddr(String stockOutReceiveAddr) {
		this.stockOutReceiveAddr = stockOutReceiveAddr;
	}

	public String getStockOutReceiveTel() {
		return stockOutReceiveTel;
	}

	public void setStockOutReceiveTel(String stockOutReceiveTel) {
		this.stockOutReceiveTel = stockOutReceiveTel;
	}

	public String getStockOutReceivePerson() {
		return stockOutReceivePerson;
	}

	public void setStockOutReceivePerson(String stockOutReceivePerson) {
		this.stockOutReceivePerson = stockOutReceivePerson;
	}

	public Integer getStockOutTotalCount() {
		return stockOutTotalCount;
	}

	public void setStockOutTotalCount(Integer stockOutTotalCount) {
		this.stockOutTotalCount = stockOutTotalCount;
	}

	public BigDecimal getStockOutFixedPrice() {
		return stockOutFixedPrice;
	}

	public void setStockOutFixedPrice(BigDecimal stockOutFixedPrice) {
		this.stockOutFixedPrice = stockOutFixedPrice;
	}

	public BigDecimal getStockOutDiscountedPrice() {
		return stockOutDiscountedPrice;
	}

	public void setStockOutDiscountedPrice(BigDecimal stockOutDiscountedPrice) {
		this.stockOutDiscountedPrice = stockOutDiscountedPrice;
	}

	public Integer getStockOutAverageDiscount() {
		return stockOutAverageDiscount;
	}

	public void setStockOutAverageDiscount(Integer stockOutAverageDiscount) {
		this.stockOutAverageDiscount = stockOutAverageDiscount;
	}

	public Integer getStockOutTaxRate() {
		return stockOutTaxRate;
	}

	public void setStockOutTaxRate(Integer stockOutTaxRate) {
		this.stockOutTaxRate = stockOutTaxRate;
	}

	public BigDecimal getStockOutDiscount() {
		return stockOutDiscount;
	}

	public void setStockOutDiscount(BigDecimal stockOutDiscount) {
		this.stockOutDiscount = stockOutDiscount;
	}

	public BigDecimal getStockOutAttach() {
		return stockOutAttach;
	}

	public void setStockOutAttach(BigDecimal stockOutAttach) {
		this.stockOutAttach = stockOutAttach;
	}

	public Integer getStockOutTypeCount() {
		return stockOutTypeCount;
	}

	public void setStockOutTypeCount(Integer stockOutTypeCount) {
		this.stockOutTypeCount = stockOutTypeCount;
	}

	public String getStockOutBusinessBy() {
		return stockOutBusinessBy;
	}

	public void setStockOutBusinessBy(String stockOutBusinessBy) {
		this.stockOutBusinessBy = stockOutBusinessBy;
	}

	public String getStockOutStatus() {
		return stockOutStatus;
	}

	public void setStockOutStatus(String stockOutStatus) {
		this.stockOutStatus = stockOutStatus;
	}

	public IvWarehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(IvWarehouse warehouse) {
		this.warehouse = warehouse;
	}

	public OSaleOrder getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(OSaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	public CrmCorpTypeRelationship getCorpTypeRelationship() {
		return corpTypeRelationship;
	}

	public void setCorpTypeRelationship(CrmCorpTypeRelationship corpTypeRelationship) {
		this.corpTypeRelationship = corpTypeRelationship;
	}

	public OInvoiceReq getInvoiceReq() {
		return invoiceReq;
	}

	public void setInvoiceReq(OInvoiceReq invoiceReq) {
		this.invoiceReq = invoiceReq;
	}

	public IvTransport getTransport() {
		return transport;
	}

	public void setTransport(IvTransport transport) {
		this.transport = transport;
	}

	public Set<IvStockOutItem> getStockOutItemSet() {
		return stockOutItemSet;
	}

	public void setStockOutItemSet(Set<IvStockOutItem> stockOutItemSet) {
		this.stockOutItemSet = stockOutItemSet;
	}

	public Integer getStockOutItemQuantity() {
		return stockOutItemQuantity;
	}

	public void setStockOutItemQuantity(Integer stockOutItemQuantity) {
		this.stockOutItemQuantity = stockOutItemQuantity;
	}

	public Integer getStockOutItemPartQuantity() {
		return stockOutItemPartQuantity;
	}

	public void setStockOutItemPartQuantity(Integer stockOutItemPartQuantity) {
		this.stockOutItemPartQuantity = stockOutItemPartQuantity;
	}

	public Integer getStockOutItemAllQuantity() {
		return stockOutItemAllQuantity;
	}

	public void setStockOutItemAllQuantity(Integer stockOutItemAllQuantity) {
		this.stockOutItemAllQuantity = stockOutItemAllQuantity;
	}
}