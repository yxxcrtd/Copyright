package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @name 01_产品扩展属性
 * @table P_PRODUCT_PROP
 */
@SuppressWarnings("serial")
public class PProductProp implements Serializable {

    private String id; // 产品属性ID
    private String code; // 产品属性编码
    private String name; // 产品属性名称
    private String value; // 产品属性取值
    private String order; // 产品属性排序
    private String display; // 产品属性显示方式
    private String must; // 产品属性是否必填
    private String source; // 产品属性来源
    private String status; // 产品属性状态
    private Date createOn; // 产品属性创建日期
    private String createBy; // 产品属性创建者
    private Date updateOn; // 产品属性修改日期
    private String updateBy; // 产品属性修改者
    private String internationCode; // 国际化参数
	private String defaultValue; // 产品属性默认值
    private PProduct product; // 01_产品基础信息
    private PProductTypeProp productTypeProp; // 01_产品类型属性


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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    

    public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getMust() {
        return must;
    }

    public void setMust(String must) {
        this.must = must;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getInternationCode() {
        return internationCode;
    }

    public void setInternationCode(String internationCode) {
        this.internationCode = internationCode;
    }

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
    public PProduct getProduct() {
        return product;
    }

    public void setProduct(PProduct product) {
        this.product = product;
    }

    public PProductTypeProp getProductTypeProp() {
        return productTypeProp;
    }

    public void setProductTypeProp(PProductTypeProp productTypeProp) {
        this.productTypeProp = productTypeProp;
    }

}
