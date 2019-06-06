package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 02_流程节点属性关联表
 * @table F_ACTIVITY_PROP_RS
 */
@SuppressWarnings("serial")
public class FActivityPropRelationship implements Serializable {

	private String id; // 流程属性关联ID
	private String productTypeCode; // 产品类型
	private FActivity activity; // 02_流程节点信息
	private PProductTypeProp productTypeProp; // 01_产品类型属性

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductTypeCode() {
		return productTypeCode;
	}

	public void setProductTypeCode(String productTypeCode) {
		this.productTypeCode = productTypeCode;
	}

	public PProductTypeProp getProductTypeProp() {
		return productTypeProp;
	}

	public void setProductTypeProp(PProductTypeProp productTypeProp) {
		this.productTypeProp = productTypeProp;
	}

	public FActivity getActivity() {
		return activity;
	}

	public void setActivity(FActivity activity) {
		this.activity = activity;
	}

}
