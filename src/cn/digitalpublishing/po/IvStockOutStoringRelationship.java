package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 09_出库冻结关系
 * @table IV_STOCK_OUT_STORING_RS
 */
@SuppressWarnings("serial")
public class IvStockOutStoringRelationship implements Serializable {

	private String stockOutStoringId; // 出库冻结关系ID
	private Integer stockOutStoringCount; // 出库冻结数量
	private IvStockOutItem stockOutItem; // 09_出库单明细
	private IvStoring storing; // 09_存货信息

	public String getStockOutStoringId() {
		return stockOutStoringId;
	}

	public void setStockOutStoringId(String stockOutStoringId) {
		this.stockOutStoringId = stockOutStoringId;
	}

	public Integer getStockOutStoringCount() {
		return stockOutStoringCount;
	}

	public void setStockOutStoringCount(Integer stockOutStoringCount) {
		this.stockOutStoringCount = stockOutStoringCount;
	}

	public IvStockOutItem getStockOutItem() {
		return stockOutItem;
	}

	public void setStockOutItem(IvStockOutItem stockOutItem) {
		this.stockOutItem = stockOutItem;
	}

	public IvStoring getStoring() {
		return storing;
	}

	public void setStoring(IvStoring storing) {
		this.storing = storing;
	}
}