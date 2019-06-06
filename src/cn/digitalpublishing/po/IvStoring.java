package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 09_存货信息
 * @table IV_STORING
 */
@SuppressWarnings("serial")
public class IvStoring implements Serializable {

	private String ivStoringId; // 存货信息ID
	private Integer ivStoringPack; // 包数
	private Integer ivStoringLoose; // 散数
	private IvLocation location; // 09_货位
	private PProduct product; // 01_产品基础信息
	@JsonIgnore
	private Set<IvStockOutStoringRelationship> stockOutStoringRelationshipSet = new HashSet<IvStockOutStoringRelationship>(); // 09_出库冻结关系
	@JsonIgnore
	private Set<IvSaleItemStoringRelationship> saleItemStoringRelationshipSet = new HashSet<IvSaleItemStoringRelationship>(); // 09_现货扣单冻结关系
	@JsonIgnore
	private Set<IvRackingItem> indicateRackingItemSet = new HashSet<IvRackingItem>(); // 09_上架指示单明细
	@JsonIgnore
	private Set<IvRackingItem> actualRackingItemSet = new HashSet<IvRackingItem>(); // 09_上架指示单明细
	@JsonIgnore
	private Set<IvStockDistributionItem> actualDistributionItemSet = new HashSet<IvStockDistributionItem>(); // 09_配书单明细
	@JsonIgnore
	private Set<IvStockDistributionItem> indicateDistributionItemSet = new HashSet<IvStockDistributionItem>(); // 09_配书单明细

	public String getIvStoringId() {
		return ivStoringId;
	}

	public void setIvStoringId(String ivStoringId) {
		this.ivStoringId = ivStoringId;
	}

	public Integer getIvStoringPack() {
		return ivStoringPack;
	}

	public void setIvStoringPack(Integer ivStoringPack) {
		this.ivStoringPack = ivStoringPack;
	}

	public Integer getIvStoringLoose() {
		return ivStoringLoose;
	}

	public void setIvStoringLoose(Integer ivStoringLoose) {
		this.ivStoringLoose = ivStoringLoose;
	}

	public IvLocation getLocation() {
		return location;
	}

	public void setLocation(IvLocation location) {
		this.location = location;
	}

	public PProduct getProduct() {
		return product;
	}

	public void setProduct(PProduct product) {
		this.product = product;
	}

	public Set<IvStockOutStoringRelationship> getStockOutStoringRelationshipSet() {
		return stockOutStoringRelationshipSet;
	}

	public void setStockOutStoringRelationshipSet(Set<IvStockOutStoringRelationship> stockOutStoringRelationshipSet) {
		this.stockOutStoringRelationshipSet = stockOutStoringRelationshipSet;
	}

	public Set<IvSaleItemStoringRelationship> getSaleItemStoringRelationshipSet() {
		return saleItemStoringRelationshipSet;
	}

	public void setSaleItemStoringRelationshipSet(Set<IvSaleItemStoringRelationship> saleItemStoringRelationshipSet) {
		this.saleItemStoringRelationshipSet = saleItemStoringRelationshipSet;
	}

	public Set<IvRackingItem> getIndicateRackingItemSet() {
		return indicateRackingItemSet;
	}

	public void setIndicateRackingItemSet(Set<IvRackingItem> indicateRackingItemSet) {
		this.indicateRackingItemSet = indicateRackingItemSet;
	}

	public Set<IvRackingItem> getActualRackingItemSet() {
		return actualRackingItemSet;
	}

	public void setActualRackingItemSet(Set<IvRackingItem> actualRackingItemSet) {
		this.actualRackingItemSet = actualRackingItemSet;
	}

	public Set<IvStockDistributionItem> getActualDistributionItemSet() {
		return actualDistributionItemSet;
	}

	public void setActualDistributionItemSet(Set<IvStockDistributionItem> actualDistributionItemSet) {
		this.actualDistributionItemSet = actualDistributionItemSet;
	}

	public Set<IvStockDistributionItem> getIndicateDistributionItemSet() {
		return indicateDistributionItemSet;
	}

	public void setIndicateDistributionItemSet(Set<IvStockDistributionItem> indicateDistributionItemSet) {
		this.indicateDistributionItemSet = indicateDistributionItemSet;
	}
}
