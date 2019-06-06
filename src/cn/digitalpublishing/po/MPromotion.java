package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.Date;

/**
 * @name 06_推送信息
 * @table M_PROMOTION
 */
@SuppressWarnings("serial")
public class MPromotion implements Serializable {

	private String id; // 推送信息ID
	private Date date; // 推送信息日期
	private MPlatform platform; // 06_推送平台
	private MTemplate template; // 06_推送信息模板
	@JsonIgnore
	private Set<PProduct> productSet = new HashSet<PProduct>(); // 01_产品基础信息


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MPlatform getPlatform() {
		return platform;
	}

	public void setPlatform(MPlatform platform) {
		this.platform = platform;
	}

	public MTemplate getTemplate() {
		return template;
	}

	public void setTemplate(MTemplate template) {
		this.template = template;
	}

	public Set<PProduct> getProductSet() {
		return productSet;
	}

	public void setProductSet(Set<PProduct> productSet) {
		this.productSet = productSet;
	}
}
