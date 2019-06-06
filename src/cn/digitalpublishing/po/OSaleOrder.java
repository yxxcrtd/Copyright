package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.Date;

/**
 * @name 05_销售订单
 * @table O_SALE_ORDER
 */
@SuppressWarnings("serial")
public class OSaleOrder implements Serializable {

	private String saleOrderId; // 销售订单ID
	private String saleOrderCode; // 销售订单编号
	private Date saleOrderCreateOn; // 销售订单创建日期
	private String saleOrderCreateBy; // 销售订单创建人
	private Date saleOrderUpdateOn; // 销售订单修改日期
	private String saleOrderUpdateBy; // 销售订单修改人
	private String saleOrderSendRemark; // 销售订单发货备注
	private Date saleOrderBookingOn; // 销售订单订货日期
	private String saleOrderBookingBy; // 销售订单交单人
	private Integer saleOrderTaxRate; // 销售订单税率
	private String saleOrderRecheckFlg; // 销售订单查重标识
	private String saleOrderStatus; // 销售订单状态
	private CrmCorpTypeRelationship corpTypeRelationship; // 04_公司类型角色关系
	@JsonIgnore
	private Set<OSaleItem> saleItemSet = new HashSet<OSaleItem>(); // 05_销售订单项
	@JsonIgnore
	private Set<IvStockOut> stockOutSet = new HashSet<IvStockOut>(); // 09_出库单
	@JsonIgnore
	private Set<OInitialSaleOrder> initialSaleOrderSet = new HashSet<OInitialSaleOrder>(); // 05_初始销售订单


	public String getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(String saleOrderId) {
		this.saleOrderId = saleOrderId;
	}

	public String getSaleOrderCode() {
		return saleOrderCode;
	}

	public void setSaleOrderCode(String saleOrderCode) {
		this.saleOrderCode = saleOrderCode;
	}

	public Date getSaleOrderCreateOn() {
		return saleOrderCreateOn;
	}

	public void setSaleOrderCreateOn(Date saleOrderCreateOn) {
		this.saleOrderCreateOn = saleOrderCreateOn;
	}

	public String getSaleOrderCreateBy() {
		return saleOrderCreateBy;
	}

	public void setSaleOrderCreateBy(String saleOrderCreateBy) {
		this.saleOrderCreateBy = saleOrderCreateBy;
	}

	public Date getSaleOrderUpdateOn() {
		return saleOrderUpdateOn;
	}

	public void setSaleOrderUpdateOn(Date saleOrderUpdateOn) {
		this.saleOrderUpdateOn = saleOrderUpdateOn;
	}

	public String getSaleOrderUpdateBy() {
		return saleOrderUpdateBy;
	}

	public void setSaleOrderUpdateBy(String saleOrderUpdateBy) {
		this.saleOrderUpdateBy = saleOrderUpdateBy;
	}

	public String getSaleOrderSendRemark() {
		return saleOrderSendRemark;
	}

	public void setSaleOrderSendRemark(String saleOrderSendRemark) {
		this.saleOrderSendRemark = saleOrderSendRemark;
	}

	public Date getSaleOrderBookingOn() {
		return saleOrderBookingOn;
	}

	public void setSaleOrderBookingOn(Date saleOrderBookingOn) {
		this.saleOrderBookingOn = saleOrderBookingOn;
	}

	public String getSaleOrderBookingBy() {
		return saleOrderBookingBy;
	}

	public void setSaleOrderBookingBy(String saleOrderBookingBy) {
		this.saleOrderBookingBy = saleOrderBookingBy;
	}

	public Integer getSaleOrderTaxRate() {
		return saleOrderTaxRate;
	}

	public void setSaleOrderTaxRate(Integer saleOrderTaxRate) {
		this.saleOrderTaxRate = saleOrderTaxRate;
	}

	public String getSaleOrderRecheckFlg() {
		return saleOrderRecheckFlg;
	}

	public void setSaleOrderRecheckFlg(String saleOrderRecheckFlg) {
		this.saleOrderRecheckFlg = saleOrderRecheckFlg;
	}

	public String getSaleOrderStatus() {
		return saleOrderStatus;
	}

	public void setSaleOrderStatus(String saleOrderStatus) {
		this.saleOrderStatus = saleOrderStatus;
	}

	public CrmCorpTypeRelationship getCorpTypeRelationship() {
		return corpTypeRelationship;
	}

	public void setCorpTypeRelationship(CrmCorpTypeRelationship corpTypeRelationship) {
		this.corpTypeRelationship = corpTypeRelationship;
	}

	public Set<OSaleItem> getSaleItemSet() {
		return saleItemSet;
	}

	public void setSaleItemSet(Set<OSaleItem> saleItemSet) {
		this.saleItemSet = saleItemSet;
	}

	public Set<IvStockOut> getStockOutSet() {
		return stockOutSet;
	}

	public void setStockOutSet(Set<IvStockOut> stockOutSet) {
		this.stockOutSet = stockOutSet;
	}

	public Set<OInitialSaleOrder> getInitialSaleOrderSet() {
		return initialSaleOrderSet;
	}

	public void setInitialSaleOrderSet(Set<OInitialSaleOrder> initialSaleOrderSet) {
		this.initialSaleOrderSet = initialSaleOrderSet;
	}
}