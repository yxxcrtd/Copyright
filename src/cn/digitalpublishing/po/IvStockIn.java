package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import cn.digitalpublishing.util.converter.CustomDateSerializer;
import cn.digitalpublishing.util.converter.CustomDateTimeSerializer;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @name 09_入库单
 * @table IV_STOCK_IN
 */
@SuppressWarnings("serial")
public class IvStockIn implements Serializable {

	private String stockInId; // 入库单ID
	private String stockInCode; // 入库单号
	private Date stockInCreateOn; // 入库单创建日期
	private String stockInCreateBy; // 入库单创建人
	private String stockInSendCode; // 入库单发货单号
	private Date stockInSendOn; // 入库单到货日期
	private String stockInSendRemark; // 入库单进货备注
	private BigDecimal stockInFixedPrice; // 入库单总码洋
	private BigDecimal stockInDiscountedPrice; // 入库单总实洋
	private Integer stockInAverageDiscount; // 入库单平均折扣
	private Integer stockInTaxRate; // 入库单税率
	private BigDecimal stockInTotalPrice; // 入库单总应付款
	private Integer stockInTotalCount; // 入库单总数量
	private String stockInStatus; // 入库单状态
	private IvWarehouse warehouse; // 09_仓库
	private CrmCorpTypeRelationship corpTypeRelationship; // 04_公司类型角色关系
	@JsonIgnore
	private Set<IvStockInItem> stockInItemSet = new HashSet<IvStockInItem>(); // 09_入库单明细
	@JsonIgnore
	private Set<IvCheck> checkSet = new HashSet<IvCheck>(); // 09_入库验更单


	public String getStockInId() {
		return stockInId;
	}

	public void setStockInId(String stockInId) {
		this.stockInId = stockInId;
	}

	public String getStockInCode() {
		return stockInCode;
	}

	public void setStockInCode(String stockInCode) {
		this.stockInCode = stockInCode;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getStockInCreateOn() {
		return stockInCreateOn;
	}

	public void setStockInCreateOn(Date stockInCreateOn) {
		this.stockInCreateOn = stockInCreateOn;
	}

	public String getStockInCreateBy() {
		return stockInCreateBy;
	}

	public void setStockInCreateBy(String stockInCreateBy) {
		this.stockInCreateBy = stockInCreateBy;
	}

	public String getStockInSendCode() {
		return stockInSendCode;
	}

	public void setStockInSendCode(String stockInSendCode) {
		this.stockInSendCode = stockInSendCode;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getStockInSendOn() {
		return stockInSendOn;
	}

	public void setStockInSendOn(Date stockInSendOn) {
		this.stockInSendOn = stockInSendOn;
	}

	public String getStockInSendRemark() {
		return stockInSendRemark;
	}

	public void setStockInSendRemark(String stockInSendRemark) {
		this.stockInSendRemark = stockInSendRemark;
	}

	public BigDecimal getStockInFixedPrice() {
		return stockInFixedPrice;
	}

	public void setStockInFixedPrice(BigDecimal stockInFixedPrice) {
		this.stockInFixedPrice = stockInFixedPrice;
	}

	public BigDecimal getStockInDiscountedPrice() {
		return stockInDiscountedPrice;
	}

	public void setStockInDiscountedPrice(BigDecimal stockInDiscountedPrice) {
		this.stockInDiscountedPrice = stockInDiscountedPrice;
	}

	public Integer getStockInAverageDiscount() {
		return stockInAverageDiscount;
	}

	public void setStockInAverageDiscount(Integer stockInAverageDiscount) {
		this.stockInAverageDiscount = stockInAverageDiscount;
	}

	public Integer getStockInTaxRate() {
		return stockInTaxRate;
	}

	public void setStockInTaxRate(Integer stockInTaxRate) {
		this.stockInTaxRate = stockInTaxRate;
	}

	public BigDecimal getStockInTotalPrice() {
		return stockInTotalPrice;
	}

	public void setStockInTotalPrice(BigDecimal stockInTotalPrice) {
		this.stockInTotalPrice = stockInTotalPrice;
	}

	public Integer getStockInTotalCount() {
		return stockInTotalCount;
	}

	public void setStockInTotalCount(Integer stockInTotalCount) {
		this.stockInTotalCount = stockInTotalCount;
	}

	public String getStockInStatus() {
		return stockInStatus;
	}

	public void setStockInStatus(String stockInStatus) {
		this.stockInStatus = stockInStatus;
	}

	public IvWarehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(IvWarehouse warehouse) {
		this.warehouse = warehouse;
	}

	public CrmCorpTypeRelationship getCorpTypeRelationship() {
		return corpTypeRelationship;
	}

	public void setCorpTypeRelationship(CrmCorpTypeRelationship corpTypeRelationship) {
		this.corpTypeRelationship = corpTypeRelationship;
	}

	public Set<IvStockInItem> getStockInItemSet() {
		return stockInItemSet;
	}

	public void setStockInItemSet(Set<IvStockInItem> stockInItemSet) {
		this.stockInItemSet = stockInItemSet;
	}

	public Set<IvCheck> getCheckSet() {
		return checkSet;
	}

	public void setCheckSet(Set<IvCheck> checkSet) {
		this.checkSet = checkSet;
	}
}