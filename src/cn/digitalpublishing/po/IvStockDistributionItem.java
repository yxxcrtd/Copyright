package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 09_配书单明细
 * @table IV_STOCK_DISTRIBUTION_ITEM
 */
@SuppressWarnings("serial")
public class IvStockDistributionItem implements Serializable {

	private String stockDistItemId; // 配书单明细ID
	private String stockDistItemIndicateCode; // 配书单明细指示货位号
	private String stockDistItemActualCode; // 配书单明细实际货位号
	private Integer stockDistItemCount; // 配书单明细数量
	private Integer stockDistItemPackCount; // 配书单明细包数量
	private String stockDistItemStatus; // 配书单明细状态
	private IvStockDistribution stockDistribution; // 09_配书单
	private IvStockOutItem stockOutItem; // 09_出库单明细
	private PProduct product; // 01_产品基础信息
	private IvStoring actualStoring; // 09_存货信息
	private IvStoring indicateStoring; // 09_存货信息

	public String getStockDistItemId() {
		return stockDistItemId;
	}

	public void setStockDistItemId(String stockDistItemId) {
		this.stockDistItemId = stockDistItemId;
	}

	public String getStockDistItemIndicateCode() {
		return stockDistItemIndicateCode;
	}

	public void setStockDistItemIndicateCode(String stockDistItemIndicateCode) {
		this.stockDistItemIndicateCode = stockDistItemIndicateCode;
	}

	public String getStockDistItemActualCode() {
		return stockDistItemActualCode;
	}

	public void setStockDistItemActualCode(String stockDistItemActualCode) {
		this.stockDistItemActualCode = stockDistItemActualCode;
	}

	public Integer getStockDistItemCount() {
		return stockDistItemCount;
	}

	public void setStockDistItemCount(Integer stockDistItemCount) {
		this.stockDistItemCount = stockDistItemCount;
	}

	public Integer getStockDistItemPackCount() {
		return stockDistItemPackCount;
	}

	public void setStockDistItemPackCount(Integer stockDistItemPackCount) {
		this.stockDistItemPackCount = stockDistItemPackCount;
	}

	public String getStockDistItemStatus() {
		return stockDistItemStatus;
	}

	public void setStockDistItemStatus(String stockDistItemStatus) {
		this.stockDistItemStatus = stockDistItemStatus;
	}

	public IvStockDistribution getStockDistribution() {
		return stockDistribution;
	}

	public void setStockDistribution(IvStockDistribution stockDistribution) {
		this.stockDistribution = stockDistribution;
	}

	public IvStockOutItem getStockOutItem() {
		return stockOutItem;
	}

	public void setStockOutItem(IvStockOutItem stockOutItem) {
		this.stockOutItem = stockOutItem;
	}

	public PProduct getProduct() {
		return product;
	}

	public void setProduct(PProduct product) {
		this.product = product;
	}

	public IvStoring getActualStoring() {
		return actualStoring;
	}

	public void setActualStoring(IvStoring actualStoring) {
		this.actualStoring = actualStoring;
	}

	public IvStoring getIndicateStoring() {
		return indicateStoring;
	}

	public void setIndicateStoring(IvStoring indicateStoring) {
		this.indicateStoring = indicateStoring;
	}
}