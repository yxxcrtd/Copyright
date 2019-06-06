package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 01_产品类型属性
 * @table P_PRODUCT_TYPE_PROP
 */
@SuppressWarnings("serial")
public class PProductTypeProp implements Serializable {

    private String id; // 产品类型属性ID
    private String code; // 产品类型属性编码
    private String name; // 产品类型属性名称
    private String order; // 产品类型属性排序
    private String display; // 产品类型属性显示方式
    private String must; // 产品类型属性是否必填
    private String sourceType; // 产品类型属性来源类型
    private String source; // 产品类型属性来源
    private String status; // 产品类型属性状态
    private String internationCode; // 国际化参数
	private String defaultValue; // 产品类型属性默认值
    private PProductType productType; // 01_产品类型
    private PProductTypePropClassify typePropClassify; // 01_产品分类
    @JsonIgnore
    private Set<PProductProp> productPropSet = new HashSet<PProductProp>(); // 01_产品扩展属性
    @JsonIgnore
    private Set<FActivityPropRelationship> activityPropRelationshipSet = new HashSet<FActivityPropRelationship>(); // 02_流程节点属性关联表

    // 非持久化字段
    //private String value;

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

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
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
    public PProductType getProductType() {
        return productType;
    }

    public void setProductType(PProductType productType) {
        this.productType = productType;
    }

    public PProductTypePropClassify getTypePropClassify() {
        return typePropClassify;
    }

    public void setTypePropClassify(PProductTypePropClassify typePropClassify) {
        this.typePropClassify = typePropClassify;
    }

    public Set<PProductProp> getProductPropSet() {
        return productPropSet;
    }

    public void setProductPropSet(Set<PProductProp> productPropSet) {
        this.productPropSet = productPropSet;
    }

//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }

    public Set<FActivityPropRelationship> getActivityPropRelationshipSet() {
        return activityPropRelationshipSet;
    }

    public void setActivityPropRelationshipSet(Set<FActivityPropRelationship> activityPropRelationshipSet) {
        this.activityPropRelationshipSet = activityPropRelationshipSet;
    }
}
