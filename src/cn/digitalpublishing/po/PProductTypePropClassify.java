package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 01_产品分类
 * @table P_PRODUCT_TYPE_PROP_CLASSIFY
 */
@SuppressWarnings("serial")
public class PProductTypePropClassify implements Serializable {

    private String id; // 产品分类ID
    private String name; // 产品分类名称
    private String code; // 产品分类编码
    private String order; // 产品分类排序
    private String status; // 产品分类状态
    private String internationCode; // 国际化参数
    private PProductType productType; // 01_产品类型
    private PProductTypePropClassify parentClassify; // 01_产品分类
    @JsonIgnore
    private Set<FActivityClassifyRelationship> activityClassifyRelationshipSet = new HashSet<FActivityClassifyRelationship>(); // 02_流程节点属性分类关联表
    @JsonIgnore
    private Set<PProductTypeProp> productTypePropSet = new HashSet<PProductTypeProp>(); // 01_产品类型属性
    @JsonIgnore
    private Set<PProductTypePropClassify> productTypePropClassifySet = new HashSet<PProductTypePropClassify>(); // 01_产品分类

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    

    public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
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

    public PProductType getProductType() {
        return productType;
    }

    public void setProductType(PProductType productType) {
        this.productType = productType;
    }

    public PProductTypePropClassify getParentClassify() {
        return parentClassify;
    }

    public void setParentClassify(PProductTypePropClassify parentClassify) {
        this.parentClassify = parentClassify;
    }

    public Set<FActivityClassifyRelationship> getActivityClassifyRelationshipSet() {
        return activityClassifyRelationshipSet;
    }

    public void setActivityClassifyRelationshipSet(Set<FActivityClassifyRelationship> activityClassifyRelationshipSet) {
        this.activityClassifyRelationshipSet = activityClassifyRelationshipSet;
    }

    public Set<PProductTypeProp> getProductTypePropSet() {
        return productTypePropSet;
    }

    public void setProductTypePropSet(Set<PProductTypeProp> productTypePropSet) {
        this.productTypePropSet = productTypePropSet;
    }

    public Set<PProductTypePropClassify> getProductTypePropClassifySet() {
        return productTypePropClassifySet;
    }

    public void setProductTypePropClassifySet(Set<PProductTypePropClassify> productTypePropClassifySet) {
        this.productTypePropClassifySet = productTypePropClassifySet;
    }
}
