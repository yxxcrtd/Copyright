package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @name 05_销售订单项
 * @table O_SALE_ITEM
 */
@SuppressWarnings("serial")
public class OSaleItem implements Serializable {

	private String saleItemId; // 销售订单项ID
	private String saleItemCode; // 销售订单项编号
	private Date saleItemCreateOn; // 销售订单项创建日期
	private String saleItemCreateBy; // 销售订单项创建人
	private Date saleItemUpdateOn; // 销售订单项修改日期
	private String saleItemUpdateBy; // 销售订单项修改人
	private String saleItemIsbn; // 销售订单项ISBN
	private String saleItemTitle; // 销售订单项书名
	private String saleItemAuthor; // 销售订单项作者
	private String saleItemPublisher; // 销售订单项出版社
	private BigDecimal saleItemPrice; // 销售订单项报订定价
	private Integer saleItemDiscount; // 销售订单项报订折扣
	private Integer saleItemCount; // 销售订单项报订数量
	private String saleItemStatus; // 销售订单项状态
	private OSaleOrder saleOrder; // 05_销售订单
	private CrmCorpTypeRelationship corpTypeRelationship; // 04_公司类型角色关系
	private PProduct product; // 01_产品基础信息
	@JsonIgnore
	private Set<IvSaleItemStoringRelationship> saleItemStoringRelationshipSet = new HashSet<IvSaleItemStoringRelationship>(); // 09_现货扣单冻结关系
	@JsonIgnore
	private Set<OInitialSaleItem> initialSaleItemSet = new HashSet<OInitialSaleItem>(); // 05_初始销售订单项
	@JsonIgnore
	private Set<IvStockOutItem> stockOutItemSet = new HashSet<IvStockOutItem>(); // 09_出库单明细

    // 只显示字段
    private Integer saleItemSendCount = 0; // 已发货数量（默认值为0）
    private Integer saleItemNotSendCount; // 未发货数量
    private Integer saleItemCurrentSendCount; // 本次发货数量

    private String productId;
    private String saleItemStatusId;
    
	public String getSaleItemId() {
		return saleItemId;
	}

	public void setSaleItemId(String saleItemId) {
		this.saleItemId = saleItemId;
	}

	public String getSaleItemCode() {
		return saleItemCode;
	}

	public void setSaleItemCode(String saleItemCode) {
		this.saleItemCode = saleItemCode;
	}

	public Date getSaleItemCreateOn() {
		return saleItemCreateOn;
	}

	public void setSaleItemCreateOn(Date saleItemCreateOn) {
		this.saleItemCreateOn = saleItemCreateOn;
	}

	public String getSaleItemCreateBy() {
		return saleItemCreateBy;
	}

	public void setSaleItemCreateBy(String saleItemCreateBy) {
		this.saleItemCreateBy = saleItemCreateBy;
	}

	public Date getSaleItemUpdateOn() {
		return saleItemUpdateOn;
	}

	public void setSaleItemUpdateOn(Date saleItemUpdateOn) {
		this.saleItemUpdateOn = saleItemUpdateOn;
	}

	public String getSaleItemUpdateBy() {
		return saleItemUpdateBy;
	}

	public void setSaleItemUpdateBy(String saleItemUpdateBy) {
		this.saleItemUpdateBy = saleItemUpdateBy;
	}

	public String getSaleItemIsbn() {
		return saleItemIsbn;
	}

	public void setSaleItemIsbn(String saleItemIsbn) {
		this.saleItemIsbn = saleItemIsbn;
	}

	public String getSaleItemTitle() {
		return saleItemTitle;
	}

	public void setSaleItemTitle(String saleItemTitle) {
		this.saleItemTitle = saleItemTitle;
	}

	public String getSaleItemAuthor() {
		return saleItemAuthor;
	}

	public void setSaleItemAuthor(String saleItemAuthor) {
		this.saleItemAuthor = saleItemAuthor;
	}

	public String getSaleItemPublisher() {
		return saleItemPublisher;
	}

	public void setSaleItemPublisher(String saleItemPublisher) {
		this.saleItemPublisher = saleItemPublisher;
	}

	public BigDecimal getSaleItemPrice() {
		return saleItemPrice;
	}

	public void setSaleItemPrice(BigDecimal saleItemPrice) {
		this.saleItemPrice = saleItemPrice;
	}

	public Integer getSaleItemDiscount() {
		return saleItemDiscount;
	}

	public void setSaleItemDiscount(Integer saleItemDiscount) {
		this.saleItemDiscount = saleItemDiscount;
	}

	public Integer getSaleItemCount() {
		return saleItemCount;
	}

	public void setSaleItemCount(Integer saleItemCount) {
		this.saleItemCount = saleItemCount;
	}

	public String getSaleItemStatus() {
		return saleItemStatus;
	}

	public void setSaleItemStatus(String saleItemStatus) {
		this.saleItemStatus = saleItemStatus;
	}

	public OSaleOrder getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(OSaleOrder saleOrder) {
		this.saleOrder = saleOrder;
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

	public Set<IvSaleItemStoringRelationship> getSaleItemStoringRelationshipSet() {
		return saleItemStoringRelationshipSet;
	}

	public void setSaleItemStoringRelationshipSet(Set<IvSaleItemStoringRelationship> saleItemStoringRelationshipSet) {
		this.saleItemStoringRelationshipSet = saleItemStoringRelationshipSet;
	}

	public Set<OInitialSaleItem> getInitialSaleItemSet() {
		return initialSaleItemSet;
	}

	public void setInitialSaleItemSet(Set<OInitialSaleItem> initialSaleItemSet) {
		this.initialSaleItemSet = initialSaleItemSet;
	}

	public Set<IvStockOutItem> getStockOutItemSet() {
		return stockOutItemSet;
	}

	public void setStockOutItemSet(Set<IvStockOutItem> stockOutItemSet) {
		this.stockOutItemSet = stockOutItemSet;
	}

    public Integer getSaleItemSendCount() {
        return saleItemSendCount;
    }

    public void setSaleItemSendCount(Integer saleItemSendCount) {
        this.saleItemSendCount = saleItemSendCount;
    }

    public Integer getSaleItemNotSendCount() {
        if (saleItemCount != null) {
            saleItemNotSendCount = saleItemCount - saleItemSendCount;
        } else {
            saleItemNotSendCount = saleItemCount;
        }
        return saleItemNotSendCount;
    }

    public void setSaleItemNotSendCount(Integer saleItemNotSendCount) {
        this.saleItemNotSendCount = saleItemNotSendCount;
    }

    public Integer getSaleItemCurrentSendCount() {
        return saleItemCurrentSendCount;
    }

    public void setSaleItemCurrentSendCount(Integer saleItemCurrentSendCount) {
        this.saleItemCurrentSendCount = saleItemCurrentSendCount;
    }

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSaleItemStatusId() {
		return saleItemStatusId;
	}

	public void setSaleItemStatusId(String saleItemStatusId) {
		this.saleItemStatusId = saleItemStatusId;
	}

    
}