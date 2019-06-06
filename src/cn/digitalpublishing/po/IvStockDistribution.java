package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import cn.digitalpublishing.util.converter.CustomDateTimeSerializer;

import java.util.Date;

/**
 * @name 09_配书单
 * @table IV_STOCK_DISTRIBUTION
 */
@SuppressWarnings("serial")
public class IvStockDistribution implements Serializable {

	private String stockDistributionId; // 配书单ID
	private String stockDistributionCode; // 配书单号
	private Date stockDistributionCreateOn; // 配书单创建日期
	private String stockDistributionCreateBy; // 配书单创建人
	private Date stockDistributionUpdateOn; // 配书单修改日期
	private String stockDistributionUpdateBy; // 配书单修改人
	private String stockDistributionPickBy; // 配书单拣货人
	private String stockDistributionStatus; // 配书单状态
	@JsonIgnore
	private Set<IvStockDistributionItem> stockDistributionItemSet = new HashSet<IvStockDistributionItem>(); // 09_配书单明细


	public String getStockDistributionId() {
		return stockDistributionId;
	}

	public void setStockDistributionId(String stockDistributionId) {
		this.stockDistributionId = stockDistributionId;
	}

	public String getStockDistributionCode() {
		return stockDistributionCode;
	}

	public void setStockDistributionCode(String stockDistributionCode) {
		this.stockDistributionCode = stockDistributionCode;
	}
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public Date getStockDistributionCreateOn() {
		return stockDistributionCreateOn;
	}

	public void setStockDistributionCreateOn(Date stockDistributionCreateOn) {
		this.stockDistributionCreateOn = stockDistributionCreateOn;
	}

	public String getStockDistributionCreateBy() {
		return stockDistributionCreateBy;
	}

	public void setStockDistributionCreateBy(String stockDistributionCreateBy) {
		this.stockDistributionCreateBy = stockDistributionCreateBy;
	}
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public Date getStockDistributionUpdateOn() {
		return stockDistributionUpdateOn;
	}

	public void setStockDistributionUpdateOn(Date stockDistributionUpdateOn) {
		this.stockDistributionUpdateOn = stockDistributionUpdateOn;
	}

	public String getStockDistributionUpdateBy() {
		return stockDistributionUpdateBy;
	}

	public void setStockDistributionUpdateBy(String stockDistributionUpdateBy) {
		this.stockDistributionUpdateBy = stockDistributionUpdateBy;
	}

	public String getStockDistributionPickBy() {
		return stockDistributionPickBy;
	}

	public void setStockDistributionPickBy(String stockDistributionPickBy) {
		this.stockDistributionPickBy = stockDistributionPickBy;
	}

	public String getStockDistributionStatus() {
		return stockDistributionStatus;
	}

	public void setStockDistributionStatus(String stockDistributionStatus) {
		this.stockDistributionStatus = stockDistributionStatus;
	}

	public Set<IvStockDistributionItem> getStockDistributionItemSet() {
		return stockDistributionItemSet;
	}

	public void setStockDistributionItemSet(Set<IvStockDistributionItem> stockDistributionItemSet) {
		this.stockDistributionItemSet = stockDistributionItemSet;
	}
}