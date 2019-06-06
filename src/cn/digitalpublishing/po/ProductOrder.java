package cn.digitalpublishing.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @name 01_订单信息
 * @table P_PRODUCT_ORDER
 */
@SuppressWarnings("serial")
public class ProductOrder implements Serializable {

	/**
     * 主键
     */
    private String id;

    /**
     * 订单号
     */
    private String code;
    
    /**
     * 产品名
     */
    private String name;

    /**
     * ISBN
     */
    private String isbn;

    /**
     * 原价
     */
    private BigDecimal listPrice;

    /**
     * 销售价格
     */
    private BigDecimal salePrice;

    /**
     * 数量
     */
    private BigDecimal quantity;

    /**
     * 折扣
     */
    private BigDecimal discount;
    
    /**
     * 交易日期
     */
    private Date tradeDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

}
