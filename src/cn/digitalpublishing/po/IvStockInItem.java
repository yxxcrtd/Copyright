package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.math.BigDecimal;

/**
 * @name 09_入库单明细
 * @table IV_STOCK_IN_ITEM
 */
@SuppressWarnings("serial")
public class IvStockInItem implements Serializable {

	private String stockInItemId; // 入库单明细ID
	private String stockInItemIsbn; // 入库单明细ISBN
	private String stockInItemTitle; // 入库单明细书名
	private BigDecimal stockInItemPrice; // 入库单明细价格
	private Integer stockInItemDiscount; // 入库单明细折扣
	private BigDecimal stockInItemFixedPrice; // 入库单明细码洋
	private BigDecimal stockInItemDiscountedPrice; // 入库单明细实洋
	private Integer stockInItemPackCount; // 入库单明细包数量
	private String stockInItemStatus; // 入库单明细状态
	private Integer stockInItemPlanCount; // 入库单明细计划入库数量
	private Integer stockInItemRealCount; // 入库单明细实际入库数量
	private IvStockIn stockIn; // 09_入库单
	private PProduct product; // 01_产品基础信息
	@JsonIgnore
	private Set<IvRackingItem> rackingItemSet = new HashSet<IvRackingItem>(); // 09_上架指示单明细
	@JsonIgnore
	private Set<IvCheck> checkSet = new HashSet<IvCheck>(); // 09_入库验更单
	private String stockInItemStatusValue; // [view]
	private Integer realPutInStockCount; // 已入库数量[view]
	private Integer realNoPutInStockCount; // 未入库数量[view]
	private Integer realAssignedCount; // 已分配数量[view]
	private Integer realNoAssignedCount; // 未分配数量[view]
	
	public String getStockInItemId() {
		return stockInItemId;
	}

	public void setStockInItemId(String stockInItemId) {
		this.stockInItemId = stockInItemId;
	}

	public String getStockInItemIsbn() {
		return stockInItemIsbn;
	}

	public void setStockInItemIsbn(String stockInItemIsbn) {
		this.stockInItemIsbn = stockInItemIsbn;
	}

	public String getStockInItemTitle() {
		return stockInItemTitle;
	}

	public void setStockInItemTitle(String stockInItemTitle) {
		this.stockInItemTitle = stockInItemTitle;
	}

	public BigDecimal getStockInItemPrice() {
		return stockInItemPrice;
	}

	public void setStockInItemPrice(BigDecimal stockInItemPrice) {
		this.stockInItemPrice = stockInItemPrice;
	}

	public Integer getStockInItemDiscount() {
		return stockInItemDiscount;
	}

	public void setStockInItemDiscount(Integer stockInItemDiscount) {
		this.stockInItemDiscount = stockInItemDiscount;
	}

	public BigDecimal getStockInItemFixedPrice() {
		return stockInItemFixedPrice;
	}

	public void setStockInItemFixedPrice(BigDecimal stockInItemFixedPrice) {
		this.stockInItemFixedPrice = stockInItemFixedPrice;
	}

	public BigDecimal getStockInItemDiscountedPrice() {
		return stockInItemDiscountedPrice;
	}

	public void setStockInItemDiscountedPrice(BigDecimal stockInItemDiscountedPrice) {
		this.stockInItemDiscountedPrice = stockInItemDiscountedPrice;
	}

	public Integer getStockInItemPackCount() {
		return stockInItemPackCount;
	}

	public void setStockInItemPackCount(Integer stockInItemPackCount) {
		this.stockInItemPackCount = stockInItemPackCount;
	}

	public String getStockInItemStatus() {
		return stockInItemStatus;
	}

	public void setStockInItemStatus(String stockInItemStatus) {
		this.stockInItemStatus = stockInItemStatus;
	}

	public Integer getStockInItemPlanCount() {
		return stockInItemPlanCount;
	}

	public void setStockInItemPlanCount(Integer stockInItemPlanCount) {
		this.stockInItemPlanCount = stockInItemPlanCount;
	}

	public Integer getStockInItemRealCount() {
		return stockInItemRealCount;
	}

	public void setStockInItemRealCount(Integer stockInItemRealCount) {
		this.stockInItemRealCount = stockInItemRealCount;
	}

	public IvStockIn getStockIn() {
		return stockIn;
	}

	public void setStockIn(IvStockIn stockIn) {
		this.stockIn = stockIn;
	}

	public PProduct getProduct() {
		return product;
	}

	public void setProduct(PProduct product) {
		this.product = product;
	}

	public Set<IvRackingItem> getRackingItemSet() {
		return rackingItemSet;
	}

	public void setRackingItemSet(Set<IvRackingItem> rackingItemSet) {
		this.rackingItemSet = rackingItemSet;
	}

	public Set<IvCheck> getCheckSet() {
		return checkSet;
	}

	public void setCheckSet(Set<IvCheck> checkSet) {
		this.checkSet = checkSet;
	}

	public String getStockInItemStatusValue() {
		return stockInItemStatusValue;
	}

	public void setStockInItemStatusValue(String stockInItemStatusValue) {
		this.stockInItemStatusValue = stockInItemStatusValue;
	}

	public Integer getRealPutInStockCount() {
		if (this.realPutInStockCount == null) {
			this.realPutInStockCount = 0;
		}
		return realPutInStockCount;
	}

	public void setRealPutInStockCount(Integer realPutInStockCount) {
		this.realPutInStockCount = realPutInStockCount;
	}

	public Integer getRealNoPutInStockCount() {
		if (getStockInItemRealCount() != null && getRealPutInStockCount() != null) {
			this.realNoPutInStockCount = getStockInItemRealCount() - getRealPutInStockCount();
		}
		return realNoPutInStockCount;
	}

	public void setRealNoPutInStockCount(Integer realNoPutInStockCount) {
		this.realNoPutInStockCount = realNoPutInStockCount;
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
		if (getRealNoPutInStockCount() != null && getRealAssignedCount() != null) {
			this.realNoAssignedCount = getRealNoPutInStockCount() - getRealAssignedCount();
		}
		return realNoAssignedCount;
	}

	public void setRealNoAssignedCount(Integer realNoAssignedCount) {
		this.realNoAssignedCount = realNoAssignedCount;
	}
}