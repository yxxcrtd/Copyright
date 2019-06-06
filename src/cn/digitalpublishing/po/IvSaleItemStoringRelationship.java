package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 09_现货扣单冻结关系
 * @table IV_SALE_ITEM_STORING_RS
 */
@SuppressWarnings("serial")
public class IvSaleItemStoringRelationship implements Serializable {

	private String saleItemStoringId; // 现货扣单冻结关系ID
	private Integer saleItemStoringCount; // 现货扣单冻结数量
	private OSaleItem saleItem; // 05_销售订单项
	private IvStoring storing; // 09_存货信息

	public String getSaleItemStoringId() {
		return saleItemStoringId;
	}

	public void setSaleItemStoringId(String saleItemStoringId) {
		this.saleItemStoringId = saleItemStoringId;
	}

	public Integer getSaleItemStoringCount() {
		return saleItemStoringCount;
	}

	public void setSaleItemStoringCount(Integer saleItemStoringCount) {
		this.saleItemStoringCount = saleItemStoringCount;
	}

	public OSaleItem getSaleItem() {
		return saleItem;
	}

	public void setSaleItem(OSaleItem saleItem) {
		this.saleItem = saleItem;
	}

	public IvStoring getStoring() {
		return storing;
	}

	public void setStoring(IvStoring storing) {
		this.storing = storing;
	}
}