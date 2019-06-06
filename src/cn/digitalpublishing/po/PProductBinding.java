package cn.digitalpublishing.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @name 01_装订
 * @table P_PRODUCT_BINDING
 */
@SuppressWarnings("serial")
public class PProductBinding implements Serializable {

	private String id; // 装订ID
	private String name; // 装订项目
	private String factory; // 装订承装厂名称
	private BigDecimal price; // 装订单价
	private BigDecimal labour; // 装订工价
	private String unit; // 装订计算单位
	private BigDecimal num; // 装订结算数量
	private Integer count; // 装订承装册数
	private Date endOn; // 装订完成日期
	private String desc; // 装订印法说明
	private PProduct product; // 01_产品基础信息
	private EPrint print; // 07_付印单
	
	private String nameText;
	private String factoryText;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getLabour() {
		return labour;
	}

	public void setLabour(BigDecimal labour) {
		this.labour = labour;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getNum() {
		return num;
	}

	public void setNum(BigDecimal num) {
		this.num = num;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getEndOn() {
		return endOn;
	}

	public void setEndOn(Date endOn) {
		this.endOn = endOn;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public PProduct getProduct() {
		return product;
	}

	public void setProduct(PProduct product) {
		this.product = product;
	}

	public EPrint getPrint() {
		return print;
	}

	public void setPrint(EPrint print) {
		this.print = print;
	}

	public String getNameText() {
		return nameText;
	}

	public void setNameText(String nameText) {
		this.nameText = nameText;
	}

	public String getFactoryText() {
		return factoryText;
	}

	public void setFactoryText(String factoryText) {
		this.factoryText = factoryText;
	}
}