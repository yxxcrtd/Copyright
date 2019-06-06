package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @name 05_初始销售订单项
 * @table O_INITIAL_SALE_ITEM
 */
@SuppressWarnings("serial")
public class OInitialSaleItem implements Serializable {

	private String initialSaleItemId; // 初始销售订单项ID
	private String initialSaleItemCode; // 初始销售订单项编号
	private Date initialSaleItemCreateOn; // 初始销售订单项创建日期
	private String initialSaleItemCreateBy; // 初始销售订单项创建人
	private Date initialSaleItemUpdateOn; // 初始销售订单项修改日期
	private String initialSaleItemUpdateBy; // 初始销售订单项修改人
	private String initialSaleItemIsbn; // 初始销售订单项ISBN
	private String initialSaleItemTitle; // 初始销售订单项书名
	private String initialSaleItemAuthor; // 初始销售订单项作者
	private String initialSaleItemPublisher; // 初始销售订单项出版社
	private BigDecimal initialSaleItemPrice; // 初始销售订单项报订定价
	private Integer initialSaleItemDiscount; // 初始销售订单项报订折扣
	private Integer initialSaleItemCount; // 初始销售订单项报订数量
	private String initialSaleItemStatus; // 初始销售订单项状态
	private OInitialSaleOrder initialSaleOrder; // 05_初始销售订单
	private CrmCorpTypeRelationship corpTypeRelationship; // 04_公司类型角色关系
	private PProduct product; // 01_产品基础信息
	private OSaleItem saleItem; // 05_销售订单项
	
    private String productId;

	public String getInitialSaleItemId() {
		return initialSaleItemId;
	}

	public void setInitialSaleItemId(String initialSaleItemId) {
		this.initialSaleItemId = initialSaleItemId;
	}

	public String getInitialSaleItemCode() {
		return initialSaleItemCode;
	}

	public void setInitialSaleItemCode(String initialSaleItemCode) {
		this.initialSaleItemCode = initialSaleItemCode;
	}

	public Date getInitialSaleItemCreateOn() {
		return initialSaleItemCreateOn;
	}

	public void setInitialSaleItemCreateOn(Date initialSaleItemCreateOn) {
		this.initialSaleItemCreateOn = initialSaleItemCreateOn;
	}

	public String getInitialSaleItemCreateBy() {
		return initialSaleItemCreateBy;
	}

	public void setInitialSaleItemCreateBy(String initialSaleItemCreateBy) {
		this.initialSaleItemCreateBy = initialSaleItemCreateBy;
	}

	public Date getInitialSaleItemUpdateOn() {
		return initialSaleItemUpdateOn;
	}

	public void setInitialSaleItemUpdateOn(Date initialSaleItemUpdateOn) {
		this.initialSaleItemUpdateOn = initialSaleItemUpdateOn;
	}

	public String getInitialSaleItemUpdateBy() {
		return initialSaleItemUpdateBy;
	}

	public void setInitialSaleItemUpdateBy(String initialSaleItemUpdateBy) {
		this.initialSaleItemUpdateBy = initialSaleItemUpdateBy;
	}

	public String getInitialSaleItemIsbn() {
		return initialSaleItemIsbn;
	}

	public void setInitialSaleItemIsbn(String initialSaleItemIsbn) {
		this.initialSaleItemIsbn = initialSaleItemIsbn;
	}

	public String getInitialSaleItemTitle() {
		return initialSaleItemTitle;
	}

	public void setInitialSaleItemTitle(String initialSaleItemTitle) {
		this.initialSaleItemTitle = initialSaleItemTitle;
	}

	public String getInitialSaleItemAuthor() {
		return initialSaleItemAuthor;
	}

	public void setInitialSaleItemAuthor(String initialSaleItemAuthor) {
		this.initialSaleItemAuthor = initialSaleItemAuthor;
	}

	public String getInitialSaleItemPublisher() {
		return initialSaleItemPublisher;
	}

	public void setInitialSaleItemPublisher(String initialSaleItemPublisher) {
		this.initialSaleItemPublisher = initialSaleItemPublisher;
	}

	public BigDecimal getInitialSaleItemPrice() {
		return initialSaleItemPrice;
	}

	public void setInitialSaleItemPrice(BigDecimal initialSaleItemPrice) {
		this.initialSaleItemPrice = initialSaleItemPrice;
	}

	public Integer getInitialSaleItemDiscount() {
		return initialSaleItemDiscount;
	}

	public void setInitialSaleItemDiscount(Integer initialSaleItemDiscount) {
		this.initialSaleItemDiscount = initialSaleItemDiscount;
	}

	public Integer getInitialSaleItemCount() {
		return initialSaleItemCount;
	}

	public void setInitialSaleItemCount(Integer initialSaleItemCount) {
		this.initialSaleItemCount = initialSaleItemCount;
	}

	public String getInitialSaleItemStatus() {
		return initialSaleItemStatus;
	}

	public void setInitialSaleItemStatus(String initialSaleItemStatus) {
		this.initialSaleItemStatus = initialSaleItemStatus;
	}

	public OInitialSaleOrder getInitialSaleOrder() {
		return initialSaleOrder;
	}

	public void setInitialSaleOrder(OInitialSaleOrder initialSaleOrder) {
		this.initialSaleOrder = initialSaleOrder;
	}

	public CrmCorpTypeRelationship getCorpTypeRelationship() {
		return corpTypeRelationship;
	}

	public void setCorpTypeRelationship(CrmCorpTypeRelationship corpTypeRelationship) {
		this.corpTypeRelationship = corpTypeRelationship;
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}