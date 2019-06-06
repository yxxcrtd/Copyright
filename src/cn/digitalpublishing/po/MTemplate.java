package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 06_推送信息模板
 * @table M_TEMPLATE
 */
@SuppressWarnings("serial")
public class MTemplate implements Serializable {

	private String id; // 模板ID
	private String name; // 模板名称
	@JsonIgnore
	private Set<MPromotion> promotionSet = new HashSet<MPromotion>(); // 06_推送信息

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

	public Set<MPromotion> getPromotionSet() {
		return promotionSet;
	}

	public void setPromotionSet(Set<MPromotion> promotionSet) {
		this.promotionSet = promotionSet;
	}
}
