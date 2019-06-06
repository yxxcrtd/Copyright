package cn.digitalpublishing.po;

import java.io.Serializable;

/**
 * @name 02_流程节点属性分类关联表
 * @table F_ACTIVITY_PROP_CLASSIFY_RS
 */
@SuppressWarnings("serial")
public class FActivityClassifyRelationship implements Serializable {

	private String id; // 流程节点属性分类关联ID
	private String productTypeCode; // 产品类型
	private FActivity activity; // 02_流程节点信息
	private PProductTypePropClassify productTypePropClassify; // 01_产品分类

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

	public PProductTypePropClassify getProductTypePropClassify() {
		return productTypePropClassify;
	}

	public void setProductTypePropClassify(PProductTypePropClassify productTypePropClassify) {
		this.productTypePropClassify = productTypePropClassify;
	}

	public FActivity getActivity() {
		return activity;
	}

	public void setActivity(FActivity activity) {
		this.activity = activity;
	}

}
