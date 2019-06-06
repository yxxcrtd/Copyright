package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @name 07_付印单
 * @table E_PRINT
 */
@SuppressWarnings("serial")
public class EPrint implements Serializable {

	private String printId; // 付印单ID
	private BigDecimal printPrice; // 定价
	private Integer printCount; // 印数
	private String printOpenFlg; // 开本
	private String printSize; // 成品尺寸
	private String printBinding; // 装帧方式
	private Integer printPageCount; // 页数
	private BigDecimal printSheet; // 印张
	private BigDecimal printPaperTotalCount; // 总印张
	private Integer printEdition; // 版次
	private String printCoverTechnology; // 封面工艺
	private String printBindingMethod; // 订法
	private String printBindingType; // 订式
	private Integer printLeEdge; // 勒口
	private String printSellType; // 发行方式
	private Integer printHeadMargin; // 天头
	private Integer printFootMargin; // 地脚
	private Integer printBindingEdge; // 订口
	private Integer printCutEdge; // 切口
	private BigDecimal printThousandWords; // 千字数
	private Integer printSampleCount; // 样书册书
	private String printOrderDesc; // 装订顺序
	private String printStatus; // 状态
	private Boolean printIsLeEdge; // 是否有勒口
	private Boolean printIsCover; // 是否有封面
	private Boolean printIsJacket; // 是否有护封
	private Boolean printIsGirdle; // 是否有腰封
	private Date printCreateOn; // 创建日期
	private PProduct product; // 01_产品基础信息
	@JsonIgnore
	private Set<PProductMaterialPrint> productMaterialPrintSet = new HashSet<PProductMaterialPrint>(); // 01_材料及印刷
	@JsonIgnore
	private Set<PProductBinding> productBindingSet = new HashSet<PProductBinding>(); // 01_装订

	public String getPrintId() {
		return printId;
	}

	public void setPrintId(String printId) {
		this.printId = printId;
	}

	public BigDecimal getPrintPrice() {
		return printPrice;
	}

	public void setPrintPrice(BigDecimal printPrice) {
		this.printPrice = printPrice;
	}

	public Integer getPrintCount() {
		return printCount;
	}

	public void setPrintCount(Integer printCount) {
		this.printCount = printCount;
	}

	public String getPrintOpenFlg() {
		return printOpenFlg;
	}

	public void setPrintOpenFlg(String printOpenFlg) {
		this.printOpenFlg = printOpenFlg;
	}

	public String getPrintSize() {
		return printSize;
	}

	public void setPrintSize(String printSize) {
		this.printSize = printSize;
	}

	public String getPrintBinding() {
		return printBinding;
	}

	public void setPrintBinding(String printBinding) {
		this.printBinding = printBinding;
	}

	public Integer getPrintPageCount() {
		return printPageCount;
	}

	public void setPrintPageCount(Integer printPageCount) {
		this.printPageCount = printPageCount;
	}

	public BigDecimal getPrintSheet() {
		return printSheet;
	}

	public void setPrintSheet(BigDecimal printSheet) {
		this.printSheet = printSheet;
	}

	public BigDecimal getPrintPaperTotalCount() {
		return printPaperTotalCount;
	}

	public void setPrintPaperTotalCount(BigDecimal printPaperTotalCount) {
		this.printPaperTotalCount = printPaperTotalCount;
	}

	public Integer getPrintEdition() {
		return printEdition;
	}

	public void setPrintEdition(Integer printEdition) {
		this.printEdition = printEdition;
	}

	public String getPrintCoverTechnology() {
		return printCoverTechnology;
	}

	public void setPrintCoverTechnology(String printCoverTechnology) {
		this.printCoverTechnology = printCoverTechnology;
	}

	public String getPrintBindingMethod() {
		return printBindingMethod;
	}

	public void setPrintBindingMethod(String printBindingMethod) {
		this.printBindingMethod = printBindingMethod;
	}

	public String getPrintBindingType() {
		return printBindingType;
	}

	public void setPrintBindingType(String printBindingType) {
		this.printBindingType = printBindingType;
	}

	public Integer getPrintLeEdge() {
		return printLeEdge;
	}

	public void setPrintLeEdge(Integer printLeEdge) {
		this.printLeEdge = printLeEdge;
	}

	public String getPrintSellType() {
		return printSellType;
	}

	public void setPrintSellType(String printSellType) {
		this.printSellType = printSellType;
	}

	public Integer getPrintHeadMargin() {
		return printHeadMargin;
	}

	public void setPrintHeadMargin(Integer printHeadMargin) {
		this.printHeadMargin = printHeadMargin;
	}

	public Integer getPrintFootMargin() {
		return printFootMargin;
	}

	public void setPrintFootMargin(Integer printFootMargin) {
		this.printFootMargin = printFootMargin;
	}

	public Integer getPrintBindingEdge() {
		return printBindingEdge;
	}

	public void setPrintBindingEdge(Integer printBindingEdge) {
		this.printBindingEdge = printBindingEdge;
	}

	public Integer getPrintCutEdge() {
		return printCutEdge;
	}

	public void setPrintCutEdge(Integer printCutEdge) {
		this.printCutEdge = printCutEdge;
	}

	public BigDecimal getPrintThousandWords() {
		return printThousandWords;
	}

	public void setPrintThousandWords(BigDecimal printThousandWords) {
		this.printThousandWords = printThousandWords;
	}

	public Integer getPrintSampleCount() {
		return printSampleCount;
	}

	public void setPrintSampleCount(Integer printSampleCount) {
		this.printSampleCount = printSampleCount;
	}

	public String getPrintOrderDesc() {
		return printOrderDesc;
	}

	public void setPrintOrderDesc(String printOrderDesc) {
		this.printOrderDesc = printOrderDesc;
	}

	public String getPrintStatus() {
		return printStatus;
	}

	public void setPrintStatus(String printStatus) {
		this.printStatus = printStatus;
	}

	public Boolean getPrintIsLeEdge() {
		return printIsLeEdge;
	}

	public void setPrintIsLeEdge(Boolean printIsLeEdge) {
		this.printIsLeEdge = printIsLeEdge;
	}

	public Boolean getPrintIsCover() {
		return printIsCover;
	}

	public void setPrintIsCover(Boolean printIsCover) {
		this.printIsCover = printIsCover;
	}

	public Boolean getPrintIsJacket() {
		return printIsJacket;
	}

	public void setPrintIsJacket(Boolean printIsJacket) {
		this.printIsJacket = printIsJacket;
	}

	public Boolean getPrintIsGirdle() {
		return printIsGirdle;
	}

	public void setPrintIsGirdle(Boolean printIsGirdle) {
		this.printIsGirdle = printIsGirdle;
	}

	public Date getPrintCreateOn() {
		return printCreateOn;
	}

	public void setPrintCreateOn(Date printCreateOn) {
		this.printCreateOn = printCreateOn;
	}

	public PProduct getProduct() {
		return product;
	}

	public void setProduct(PProduct product) {
		this.product = product;
	}

	public Set<PProductMaterialPrint> getProductMaterialPrintSet() {
		return productMaterialPrintSet;
	}

	public void setProductMaterialPrintSet(Set<PProductMaterialPrint> productMaterialPrintSet) {
		this.productMaterialPrintSet = productMaterialPrintSet;
	}

	public Set<PProductBinding> getProductBindingSet() {
		return productBindingSet;
	}

	public void setProductBindingSet(Set<PProductBinding> productBindingSet) {
		this.productBindingSet = productBindingSet;
	}
}