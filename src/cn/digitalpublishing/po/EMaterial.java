package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.math.BigDecimal;

/**
 * @name 08_材料
 * @table E_MATERIAL
 */
@SuppressWarnings("serial")
public class EMaterial implements Serializable {

	private String materialId; // 材料ID
	private String materialName; // 材料名称
	private String materialCode; // 材料编号
	private String materialSpec; // 材料规格
	private Integer materialGrams; // 材料克重
	private String materialUnit; // 材料单位
	private BigDecimal materialPrice; // 材料单价
	private String materialStock; // 材料库区
	private BigDecimal materialStockCount; // 材料库存
	private CrmCorpTypeRelationship crmCorpTypeRelationship; // 04_公司类型角色关系
	@JsonIgnore
	private Set<PProductMaterialPrint> productMaterialPrintSet = new HashSet<PProductMaterialPrint>(); // 01_材料及印刷

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public String getMaterialSpec() {
		return materialSpec;
	}

	public void setMaterialSpec(String materialSpec) {
		this.materialSpec = materialSpec;
	}

	public Integer getMaterialGrams() {
		return materialGrams;
	}

	public void setMaterialGrams(Integer materialGrams) {
		this.materialGrams = materialGrams;
	}

	public String getMaterialUnit() {
		return materialUnit;
	}

	public void setMaterialUnit(String materialUnit) {
		this.materialUnit = materialUnit;
	}

	public BigDecimal getMaterialPrice() {
		return materialPrice;
	}

	public void setMaterialPrice(BigDecimal materialPrice) {
		this.materialPrice = materialPrice;
	}

	public String getMaterialStock() {
		return materialStock;
	}

	public void setMaterialStock(String materialStock) {
		this.materialStock = materialStock;
	}

	public BigDecimal getMaterialStockCount() {
		return materialStockCount;
	}

	public void setMaterialStockCount(BigDecimal materialStockCount) {
		this.materialStockCount = materialStockCount;
	}

	public CrmCorpTypeRelationship getCrmCorpTypeRelationship() {
		return crmCorpTypeRelationship;
	}

	public void setCrmCorpTypeRelationship(CrmCorpTypeRelationship crmCorpTypeRelationship) {
		this.crmCorpTypeRelationship = crmCorpTypeRelationship;
	}

	public Set<PProductMaterialPrint> getProductMaterialPrintSet() {
		return productMaterialPrintSet;
	}

	public void setProductMaterialPrintSet(Set<PProductMaterialPrint> productMaterialPrintSet) {
		this.productMaterialPrintSet = productMaterialPrintSet;
	}
}