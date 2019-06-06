package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 09_上架指示单明细
 * @table IV_RACKING_ITEM
 */
@SuppressWarnings("serial")
public class IvRackingItem implements Serializable {

	private String rackingItemId; // 上架指示单明细ID
	private String rackingItemIndicateCode; // 上架指示单明细指示货位号
	private String rackingItemActualCode; // 上架指示单明细实际货位号
	private Integer rackingItemCount; // 上架指示单明细数量
	private Integer rackingItemPackCount; // 上架指示单明细包数量
	private String rackingItemSubjectCode; // 上架指示单明细分类法号
	private String rackingItemStatus; // 上架指示单明细状态
	private IvRacking racking; // 09_上架指示单
	private PProduct product; // 01_产品基础信息
	private IvStockInItem stockInItem; // 09_入库单明细
	private IvStoring indicateStoring; // 09_存货信息
	private IvStoring actualStoring; // 09_存货信息

	public String getRackingItemId() {
		return rackingItemId;
	}

	public void setRackingItemId(String rackingItemId) {
		this.rackingItemId = rackingItemId;
	}

	public String getRackingItemIndicateCode() {
		return rackingItemIndicateCode;
	}

	public void setRackingItemIndicateCode(String rackingItemIndicateCode) {
		this.rackingItemIndicateCode = rackingItemIndicateCode;
	}

	public String getRackingItemActualCode() {
		return rackingItemActualCode;
	}

	public void setRackingItemActualCode(String rackingItemActualCode) {
		this.rackingItemActualCode = rackingItemActualCode;
	}

	public Integer getRackingItemCount() {
		return rackingItemCount;
	}

	public void setRackingItemCount(Integer rackingItemCount) {
		this.rackingItemCount = rackingItemCount;
	}

	public Integer getRackingItemPackCount() {
		return rackingItemPackCount;
	}

	public void setRackingItemPackCount(Integer rackingItemPackCount) {
		this.rackingItemPackCount = rackingItemPackCount;
	}

	public String getRackingItemSubjectCode() {
		return rackingItemSubjectCode;
	}

	public void setRackingItemSubjectCode(String rackingItemSubjectCode) {
		this.rackingItemSubjectCode = rackingItemSubjectCode;
	}

	public String getRackingItemStatus() {
		return rackingItemStatus;
	}

	public void setRackingItemStatus(String rackingItemStatus) {
		this.rackingItemStatus = rackingItemStatus;
	}

	public IvRacking getRacking() {
		return racking;
	}

	public void setRacking(IvRacking racking) {
		this.racking = racking;
	}

	public PProduct getProduct() {
		return product;
	}

	public void setProduct(PProduct product) {
		this.product = product;
	}

	public IvStockInItem getStockInItem() {
		return stockInItem;
	}

	public void setStockInItem(IvStockInItem stockInItem) {
		this.stockInItem = stockInItem;
	}

	public IvStoring getIndicateStoring() {
		return indicateStoring;
	}

	public void setIndicateStoring(IvStoring indicateStoring) {
		this.indicateStoring = indicateStoring;
	}

	public IvStoring getActualStoring() {
		return actualStoring;
	}

	public void setActualStoring(IvStoring actualStoring) {
		this.actualStoring = actualStoring;
	}
}