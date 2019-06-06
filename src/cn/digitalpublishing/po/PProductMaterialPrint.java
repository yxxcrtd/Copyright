package cn.digitalpublishing.po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @name 01_材料及印刷
 * @table P_PRODUCT_MATERIAL_PRINT
 */
@SuppressWarnings("serial")
public class PProductMaterialPrint implements Serializable {

	private String id; // 材料及印刷ID
	private String projectName; // 项目名称
	private String materialName; // 材料名称
	private String materialCode; // 材料编号
	private String materialSpec; // 材料规格
	private String materialType; // 材料类型
	private String materialSource; // 材料来源
	private Integer materialGrams; // 材料克重
	private Integer materialQuotient; // 材料纸张开数
	private BigDecimal materialPaper; // 材料正用纸
	private BigDecimal materialAddRate; // 材料加放率
	private BigDecimal materialAddCount; // 材料加放数
	private BigDecimal materialTotalCount; // 材料合计数
	private BigDecimal materialReam; // 材料包干令/吨
	private BigDecimal materialTon; // 材料吨数
	private BigDecimal materialPrice; // 材料单价
	private BigDecimal materialExpense; // 材料费
	private Integer faceCount; // 面数
	private Integer printFrontChromaticCount; // 印刷正面色数
	private Integer printEndChromaticCount; // 印刷背面色数
	private String printModel; // 印刷机型
	private BigDecimal printMakeupCount; // 印刷拼版数
	private BigDecimal printMakeupExpense; // 印刷拼版费(上版费)
	private String printType; // 印刷方式
	private BigDecimal printPrice; // 印刷单价
	private BigDecimal printExpense; // 印刷费
	private String printColorType; // 印刷色谱
	private Boolean isCtpAloneExpense; // CTP制版费是否单独计算
	private BigDecimal ctpAloneExpense; // CTP制版费
	private String remark; // 项目备注
	private CrmCorpTypeRelationship ctpPrintPlant; // CTP印厂
	private CrmCorpTypeRelationship printPlant; // 印厂
	private PProduct product; // 01_产品基础信息
	private EPrint print; // 07_付印单
	private EMaterial material; // 08_材料
	private String projectNameText;
	private String materialTypeText;
	private String materialSourceText;
	private String printTypeText;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getMaterialSource() {
		return materialSource;
	}

	public void setMaterialSource(String materialSource) {
		this.materialSource = materialSource;
	}

	public Integer getMaterialGrams() {
		return materialGrams;
	}

	public void setMaterialGrams(Integer materialGrams) {
		this.materialGrams = materialGrams;
	}

	public Integer getMaterialQuotient() {
		return materialQuotient;
	}

	public void setMaterialQuotient(Integer materialQuotient) {
		this.materialQuotient = materialQuotient;
	}

	public BigDecimal getMaterialPaper() {
		return materialPaper;
	}

	public void setMaterialPaper(BigDecimal materialPaper) {
		this.materialPaper = materialPaper;
	}

	public BigDecimal getMaterialAddRate() {
		return materialAddRate;
	}

	public void setMaterialAddRate(BigDecimal materialAddRate) {
		this.materialAddRate = materialAddRate;
	}

	public BigDecimal getMaterialAddCount() {
		return materialAddCount;
	}

	public void setMaterialAddCount(BigDecimal materialAddCount) {
		this.materialAddCount = materialAddCount;
	}

	public BigDecimal getMaterialTotalCount() {
		return materialTotalCount;
	}

	public void setMaterialTotalCount(BigDecimal materialTotalCount) {
		this.materialTotalCount = materialTotalCount;
	}

	public BigDecimal getMaterialReam() {
		return materialReam;
	}

	public void setMaterialReam(BigDecimal materialReam) {
		this.materialReam = materialReam;
	}

	public BigDecimal getMaterialTon() {
		return materialTon;
	}

	public void setMaterialTon(BigDecimal materialTon) {
		this.materialTon = materialTon;
	}

	public BigDecimal getMaterialPrice() {
		return materialPrice;
	}

	public void setMaterialPrice(BigDecimal materialPrice) {
		this.materialPrice = materialPrice;
	}

	public BigDecimal getMaterialExpense() {
		return materialExpense;
	}

	public void setMaterialExpense(BigDecimal materialExpense) {
		this.materialExpense = materialExpense;
	}

	public Integer getFaceCount() {
		return faceCount;
	}

	public void setFaceCount(Integer faceCount) {
		this.faceCount = faceCount;
	}

	public Integer getPrintFrontChromaticCount() {
		return printFrontChromaticCount;
	}

	public void setPrintFrontChromaticCount(Integer printFrontChromaticCount) {
		this.printFrontChromaticCount = printFrontChromaticCount;
	}

	public Integer getPrintEndChromaticCount() {
		return printEndChromaticCount;
	}

	public void setPrintEndChromaticCount(Integer printEndChromaticCount) {
		this.printEndChromaticCount = printEndChromaticCount;
	}

	public String getPrintModel() {
		return printModel;
	}

	public void setPrintModel(String printModel) {
		this.printModel = printModel;
	}

	public BigDecimal getPrintMakeupCount() {
		return printMakeupCount;
	}

	public void setPrintMakeupCount(BigDecimal printMakeupCount) {
		this.printMakeupCount = printMakeupCount;
	}

	public BigDecimal getPrintMakeupExpense() {
		return printMakeupExpense;
	}

	public void setPrintMakeupExpense(BigDecimal printMakeupExpense) {
		this.printMakeupExpense = printMakeupExpense;
	}

	public String getPrintType() {
		return printType;
	}

	public void setPrintType(String printType) {
		this.printType = printType;
	}

	public BigDecimal getPrintPrice() {
		return printPrice;
	}

	public void setPrintPrice(BigDecimal printPrice) {
		this.printPrice = printPrice;
	}

	public BigDecimal getPrintExpense() {
		return printExpense;
	}

	public void setPrintExpense(BigDecimal printExpense) {
		this.printExpense = printExpense;
	}

	public String getPrintColorType() {
		return printColorType;
	}

	public void setPrintColorType(String printColorType) {
		this.printColorType = printColorType;
	}

	public Boolean getIsCtpAloneExpense() {
		return isCtpAloneExpense;
	}

	public void setIsCtpAloneExpense(Boolean isCtpAloneExpense) {
		this.isCtpAloneExpense = isCtpAloneExpense;
	}

	public BigDecimal getCtpAloneExpense() {
		return ctpAloneExpense;
	}

	public void setCtpAloneExpense(BigDecimal ctpAloneExpense) {
		this.ctpAloneExpense = ctpAloneExpense;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public CrmCorpTypeRelationship getCtpPrintPlant() {
		return ctpPrintPlant;
	}

	public void setCtpPrintPlant(CrmCorpTypeRelationship ctpPrintPlant) {
		this.ctpPrintPlant = ctpPrintPlant;
	}

	public CrmCorpTypeRelationship getPrintPlant() {
		return printPlant;
	}

	public void setPrintPlant(CrmCorpTypeRelationship printPlant) {
		this.printPlant = printPlant;
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

	public EMaterial getMaterial() {
		return material;
	}

	public void setMaterial(EMaterial material) {
		this.material = material;
	}

	public String getProjectNameText() {
		return projectNameText;
	}

	public void setProjectNameText(String projectNameText) {
		this.projectNameText = projectNameText;
	}

	public String getMaterialTypeText() {
		return materialTypeText;
	}

	public void setMaterialTypeText(String materialTypeText) {
		this.materialTypeText = materialTypeText;
	}

	public String getMaterialSourceText() {
		return materialSourceText;
	}

	public void setMaterialSourceText(String materialSourceText) {
		this.materialSourceText = materialSourceText;
	}

	public String getPrintTypeText() {
		return printTypeText;
	}

	public void setPrintTypeText(String printTypeText) {
		this.printTypeText = printTypeText;
	}
}