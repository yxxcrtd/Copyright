package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.Date;

/**
 * @name 05_初始销售订单
 * @table O_INITIAL_SALE_ORDER
 */
@SuppressWarnings("serial")
public class OInitialSaleOrder implements Serializable {

	private String initialSaleOrderId; // 初始销售订单ID
	private String initialSaleOrderCode; // 初始销售订单编号
	private Date initialSaleOrderCreateOn; // 初始销售订单创建日期
	private String initialSaleOrderCreateBy; // 初始销售订单创建人
	private Date initialSaleOrderUpdateOn; // 初始销售订单修改日期
	private String initialSaleOrderUpdateBy; // 初始销售订单修改人
	private String initialSaleOrderSendRemark; // 初始销售订单发货备注
	private Date initialSaleOrderBookingOn; // 初始销售订单订货日期
	private String initialSaleOrderBookingBy; // 初始销售订单交单人
	private Integer initialSaleOrderTaxRate; // 初始销售订单税率
	private String initialSaleOrderRecheckFlg; // 初始销售订单查重标识
	private String initialSaleOrderStatus; // 初始销售订单状态
	private CrmCorpTypeRelationship corpTypeRelationship; // 04_公司类型角色关系
	private OSaleOrder saleOrder; // 05_销售订单
	@JsonIgnore
	private Set<OInitialSaleItem> initialSaleItemSet = new HashSet<OInitialSaleItem>(); // 05_初始销售订单项


	public String getInitialSaleOrderId() {
		return initialSaleOrderId;
	}

	public void setInitialSaleOrderId(String initialSaleOrderId) {
		this.initialSaleOrderId = initialSaleOrderId;
	}

	public String getInitialSaleOrderCode() {
		return initialSaleOrderCode;
	}

	public void setInitialSaleOrderCode(String initialSaleOrderCode) {
		this.initialSaleOrderCode = initialSaleOrderCode;
	}

	public Date getInitialSaleOrderCreateOn() {
		return initialSaleOrderCreateOn;
	}

	public void setInitialSaleOrderCreateOn(Date initialSaleOrderCreateOn) {
		this.initialSaleOrderCreateOn = initialSaleOrderCreateOn;
	}

	public String getInitialSaleOrderCreateBy() {
		return initialSaleOrderCreateBy;
	}

	public void setInitialSaleOrderCreateBy(String initialSaleOrderCreateBy) {
		this.initialSaleOrderCreateBy = initialSaleOrderCreateBy;
	}

	public Date getInitialSaleOrderUpdateOn() {
		return initialSaleOrderUpdateOn;
	}

	public void setInitialSaleOrderUpdateOn(Date initialSaleOrderUpdateOn) {
		this.initialSaleOrderUpdateOn = initialSaleOrderUpdateOn;
	}

	public String getInitialSaleOrderUpdateBy() {
		return initialSaleOrderUpdateBy;
	}

	public void setInitialSaleOrderUpdateBy(String initialSaleOrderUpdateBy) {
		this.initialSaleOrderUpdateBy = initialSaleOrderUpdateBy;
	}

	public String getInitialSaleOrderSendRemark() {
		return initialSaleOrderSendRemark;
	}

	public void setInitialSaleOrderSendRemark(String initialSaleOrderSendRemark) {
		this.initialSaleOrderSendRemark = initialSaleOrderSendRemark;
	}

	public Date getInitialSaleOrderBookingOn() {
		return initialSaleOrderBookingOn;
	}

	public void setInitialSaleOrderBookingOn(Date initialSaleOrderBookingOn) {
		this.initialSaleOrderBookingOn = initialSaleOrderBookingOn;
	}

	public String getInitialSaleOrderBookingBy() {
		return initialSaleOrderBookingBy;
	}

	public void setInitialSaleOrderBookingBy(String initialSaleOrderBookingBy) {
		this.initialSaleOrderBookingBy = initialSaleOrderBookingBy;
	}

	public Integer getInitialSaleOrderTaxRate() {
		return initialSaleOrderTaxRate;
	}

	public void setInitialSaleOrderTaxRate(Integer initialSaleOrderTaxRate) {
		this.initialSaleOrderTaxRate = initialSaleOrderTaxRate;
	}

	public String getInitialSaleOrderRecheckFlg() {
		return initialSaleOrderRecheckFlg;
	}

	public void setInitialSaleOrderRecheckFlg(String initialSaleOrderRecheckFlg) {
		this.initialSaleOrderRecheckFlg = initialSaleOrderRecheckFlg;
	}

	public String getInitialSaleOrderStatus() {
		return initialSaleOrderStatus;
	}

	public void setInitialSaleOrderStatus(String initialSaleOrderStatus) {
		this.initialSaleOrderStatus = initialSaleOrderStatus;
	}

	public CrmCorpTypeRelationship getCorpTypeRelationship() {
		return corpTypeRelationship;
	}

	public void setCorpTypeRelationship(CrmCorpTypeRelationship corpTypeRelationship) {
		this.corpTypeRelationship = corpTypeRelationship;
	}

	public OSaleOrder getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(OSaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	public Set<OInitialSaleItem> getInitialSaleItemSet() {
		return initialSaleItemSet;
	}

	public void setInitialSaleItemSet(Set<OInitialSaleItem> initialSaleItemSet) {
		this.initialSaleItemSet = initialSaleItemSet;
	}

	
}