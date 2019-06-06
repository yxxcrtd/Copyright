package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.math.BigDecimal;

/**
 * @name 09_出库单明细
 * @table IV_STOCK_OUT_ITEM
 */
@SuppressWarnings("serial")
public class IvStockOutItem implements Serializable {

	private String stockOutItemId; // 出库单明细ID
	private String stockOutItemIsbn; // 出库单明细ISBN
	private String stockOutItemTitle; // 出库单明细书名
	private BigDecimal stockOutItemPrice; // 出库单明细价格
	private Integer stockOutItemDiscount; // 出库单明细折扣
	private Integer stockOutItemCount; // 出库单明细数量
	private BigDecimal stockOutItemFixedPrice; // 出库单明细码洋
	private BigDecimal stockOutItemDiscountedPrice; // 出库单明细实洋
	private Integer stockOutItemPackCount; // 出库单明细包数量
	private String stockOutItemLocationCode; // 出库单明细货位号
	private String stockOutItemStatus; // 出库单明细状态
	private IvStockOut stockOut; // 09_出库单
	private PProduct product; // 01_产品基础信息
	private OSaleItem saleItem; // 05_销售订单项
	@JsonIgnore
	private Set<IvStockOutStoringRelationship> stockOutStoringRelationshipSet = new HashSet<IvStockOutStoringRelationship>(); // 09_出库冻结关系
	@JsonIgnore
	private Set<IvStockDistributionItem> stockDistributionItemSet = new HashSet<IvStockDistributionItem>(); // 09_配书单明细
	
	private String stockOutItemStatusValue; // [view]
	private Integer realOutStockCount; // 已出库数量[view]
	private Integer realNoOutStockCount; // 未出库数量[view]
	private Integer realAssignedCount; // 已分配数量[view]
	private Integer realNoAssignedCount; // 未分配数量[view]

	public String getStockOutItemId() {
		return stockOutItemId;
	}

	public void setStockOutItemId(String stockOutItemId) {
		this.stockOutItemId = stockOutItemId;
	}

	public String getStockOutItemIsbn() {
		return stockOutItemIsbn;
	}

	public void setStockOutItemIsbn(String stockOutItemIsbn) {
		this.stockOutItemIsbn = stockOutItemIsbn;
	}

	public String getStockOutItemTitle() {
		return stockOutItemTitle;
	}

	public void setStockOutItemTitle(String stockOutItemTitle) {
		this.stockOutItemTitle = stockOutItemTitle;
	}

	public BigDecimal getStockOutItemPrice() {
		return stockOutItemPrice;
	}

	public void setStockOutItemPrice(BigDecimal stockOutItemPrice) {
		this.stockOutItemPrice = stockOutItemPrice;
	}

	public Integer getStockOutItemDiscount() {
		return stockOutItemDiscount;
	}

	public void setStockOutItemDiscount(Integer stockOutItemDiscount) {
		this.stockOutItemDiscount = stockOutItemDiscount;
	}

	public Integer getStockOutItemCount() {
		return stockOutItemCount;
	}

	public void setStockOutItemCount(Integer stockOutItemCount) {
		this.stockOutItemCount = stockOutItemCount;
	}

	public BigDecimal getStockOutItemFixedPrice() {
		return stockOutItemFixedPrice;
	}

	public void setStockOutItemFixedPrice(BigDecimal stockOutItemFixedPrice) {
		this.stockOutItemFixedPrice = stockOutItemFixedPrice;
	}

	public BigDecimal getStockOutItemDiscountedPrice() {
		return stockOutItemDiscountedPrice;
	}

	public void setStockOutItemDiscountedPrice(BigDecimal stockOutItemDiscountedPrice) {
		this.stockOutItemDiscountedPrice = stockOutItemDiscountedPrice;
	}

	public Integer getStockOutItemPackCount() {
		return stockOutItemPackCount;
	}

	public void setStockOutItemPackCount(Integer stockOutItemPackCount) {
		this.stockOutItemPackCount = stockOutItemPackCount;
	}

	public String getStockOutItemLocationCode() {
		return stockOutItemLocationCode;
	}

	public void setStockOutItemLocationCode(String stockOutItemLocationCode) {
		this.stockOutItemLocationCode = stockOutItemLocationCode;
	}

	public String getStockOutItemStatus() {
		return stockOutItemStatus;
	}

	public void setStockOutItemStatus(String stockOutItemStatus) {
		this.stockOutItemStatus = stockOutItemStatus;
	}

	public IvStockOut getStockOut() {
		return stockOut;
	}

	public void setStockOut(IvStockOut stockOut) {
		this.stockOut = stockOut;
	}

	public PProduct getProduct() {
		return product;
	}

	public void setProduct(PProduct product) {
		this.product = product;
	}

	public OSaleItem getSaleItem() {
		return saleItem;
	}

	public void setSaleItem(OSaleItem saleItem) {
		this.saleItem = saleItem;
	}

	public Set<IvStockOutStoringRelationship> getStockOutStoringRelationshipSet() {
		return stockOutStoringRelationshipSet;
	}

	public void setStockOutStoringRelationshipSet(Set<IvStockOutStoringRelationship> stockOutStoringRelationshipSet) {
		this.stockOutStoringRelationshipSet = stockOutStoringRelationshipSet;
	}

	public Set<IvStockDistributionItem> getStockDistributionItemSet() {
		return stockDistributionItemSet;
	}

	public void setStockDistributionItemSet(Set<IvStockDistributionItem> stockDistributionItemSet) {
		this.stockDistributionItemSet = stockDistributionItemSet;
	}
	
	public String getStockOutItemStatusValue() {
		return stockOutItemStatusValue;
	}

	public void setStockOutItemStatusValue(String stockOutItemStatusValue) {
		this.stockOutItemStatusValue = stockOutItemStatusValue;
	}

	public Integer getRealOutStockCount() {
		if (this.realOutStockCount == null) {
			this.realOutStockCount = 0;
		}
		return realOutStockCount;
	}

	public void setRealOutStockCount(Integer realOutStockCount) {
		this.realOutStockCount = realOutStockCount;
	}

	public Integer getRealNoOutStockCount() {
		if (getStockOutItemCount() != null && getRealOutStockCount() != null) {
			this.realNoOutStockCount = getStockOutItemCount() - getRealOutStockCount();
		}
		return realNoOutStockCount;
	}

	public void setRealNoOutStockCount(Integer realNoOutStockCount) {
		this.realNoOutStockCount = realNoOutStockCount;
	}

	public Integer getRealAssignedCount() {
		if (this.realAssignedCount == null) {
			this.realAssignedCount = 0;
		}
		return realAssignedCount;
	}

	public void setRealAssignedCount(Integer realAssignedCount) {
		this.realAssignedCount = realAssignedCount;
	}

	public Integer getRealNoAssignedCount() {
		if (getRealNoOutStockCount() != null && getRealAssignedCount() != null) {
			this.realNoAssignedCount = getRealNoOutStockCount() - getRealAssignedCount();
		}
		return realNoAssignedCount;
	}

	public void setRealNoAssignedCount(Integer realNoAssignedCount) {
		this.realNoAssignedCount = realNoAssignedCount;
	}
}