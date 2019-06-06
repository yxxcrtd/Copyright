package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 04_公司类型角色关系
 * @table CRM_CORP_TYPE_RS
 */
@SuppressWarnings("serial")
public class CrmCorpTypeRelationship implements Serializable {

    private String id; // 公司类型角色关系ID
	private String status; // 公司类型角色关系状态
    private String treeCode; // 公司类型角色关系树形编号
    private CrmCorpType corpType; // 04_公司类型
    private CrmCorp corp; // 04_公司信息
    private CrmCorpTypeRelationship parentRelationship; // 04_公司类型角色关系
    @JsonIgnore
    private Set<CrmCorpProp> corpPropSet = new HashSet<CrmCorpProp>(); // 04_公司属性
    @JsonIgnore
    private Set<CrmCorpTypeRelationship> childRelationshipSet = new HashSet<CrmCorpTypeRelationship>(); // 04_公司类型角色关系
    @JsonIgnore
    private Set<CrmCorpAddress> corpAddressSet = new HashSet<CrmCorpAddress>(); // 04_公司联系地址
    @JsonIgnore
    private Set<CrmCorpEmail> corpEmailSet = new HashSet<CrmCorpEmail>(); // 04_公司Email
    @JsonIgnore
    private Set<CrmCorpCase> corpCaseSet = new HashSet<CrmCorpCase>(); // 04_公司销售机会
    @JsonIgnore
    private Set<CrmCorpPhone> corpPhoneSet = new HashSet<CrmCorpPhone>(); // 04_公司联系电话
    @JsonIgnore
    private Set<CrmCorpIdentity> corpIdentitySet = new HashSet<CrmCorpIdentity>(); // 04_公司标识
    @JsonIgnore
    private Set<CrmCorpWebsite> corpWebsiteSet = new HashSet<CrmCorpWebsite>(); // 04_公司网站
    @JsonIgnore
    private Set<CrmCorpAccount> corpAccountSet = new HashSet<CrmCorpAccount>(); // 04_公司账户
    @JsonIgnore
    private Set<CrmCorpContactLog> corpContactLogSet = new HashSet<CrmCorpContactLog>(); // 04_公司联系日志
    @JsonIgnore
    private Set<CrmCorpComplain> corpComplainSet = new HashSet<CrmCorpComplain>(); // 04_公司投诉
    @JsonIgnore
    private Set<CrmPosition> crmPositionSet = new HashSet<CrmPosition>(); // 04_岗位信息
    @JsonIgnore
    private Set<CrmPerson> personSet = new HashSet<CrmPerson>(); // 04_人员信息
	@JsonIgnore
	private Set<EMaterial> materialSet = new HashSet<EMaterial>(); // 08_材料
	@JsonIgnore
	private Set<FCorpPersonActivityRelationship> corpPersonActivityRelationshipSet = new HashSet<FCorpPersonActivityRelationship>(); // 02_公司人员流程节点关系
	@JsonIgnore
	private Set<OSaleItem> saleItemSet = new HashSet<OSaleItem>(); // 05_销售订单项
	@JsonIgnore
	private Set<OSaleOrder> saleOrderSet = new HashSet<OSaleOrder>(); // 05_销售订单
	@JsonIgnore
	private Set<OInitialSaleOrder> initialSaleOrderSet = new HashSet<OInitialSaleOrder>(); // 05_初始销售订单
	@JsonIgnore
	private Set<OInitialSaleItem> initialSaleItemSet = new HashSet<OInitialSaleItem>(); // 05_初始销售订单项
	@JsonIgnore
	private Set<IvStockIn> stockInSet = new HashSet<IvStockIn>(); // 09_入库单
	@JsonIgnore
	private Set<IvStockOut> stockOutSet = new HashSet<IvStockOut>(); // 09_出库单
	@JsonIgnore
	private Set<OInvoiceReq> invoiceReqSet = new HashSet<OInvoiceReq>(); // 05_发票申请单
	@JsonIgnore
	private Set<OReverseReq> reverseReqSet = new HashSet<OReverseReq>(); // 05_冲账申请单
	@JsonIgnore
	private Set<ORepaymentReq> repaymentReqSet = new HashSet<ORepaymentReq>(); // 05_销售来款
	@JsonIgnore
	private Set<CrmCorpDelivery> corpDeliverySet = new HashSet<CrmCorpDelivery>(); // 04_公司收货信息
	@JsonIgnore
	private Set<IvTransport> transportSet = new HashSet<IvTransport>(); // 09_运输登记单

	private long childSize = 0; // view
	
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    public String getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(String treeCode) {
        this.treeCode = treeCode;
    }

    public CrmCorpType getCorpType() {
        return corpType;
    }

    public void setCorpType(CrmCorpType corpType) {
        this.corpType = corpType;
    }

    public CrmCorp getCorp() {
        return corp;
    }

    public void setCorp(CrmCorp corp) {
        this.corp = corp;
    }

    public CrmCorpTypeRelationship getParentRelationship() {
        return parentRelationship;
    }

    public void setParentRelationship(CrmCorpTypeRelationship parentRelationship) {
        this.parentRelationship = parentRelationship;
    }

    public Set<CrmCorpProp> getCorpPropSet() {
        return corpPropSet;
    }

    public void setCorpPropSet(Set<CrmCorpProp> corpPropSet) {
        this.corpPropSet = corpPropSet;
    }

    public Set<CrmCorpTypeRelationship> getChildRelationshipSet() {
        return childRelationshipSet;
    }

    public void setChildRelationshipSet(Set<CrmCorpTypeRelationship> childRelationshipSet) {
        this.childRelationshipSet = childRelationshipSet;
    }

    public Set<CrmCorpAddress> getCorpAddressSet() {
        return corpAddressSet;
    }

    public void setCorpAddressSet(Set<CrmCorpAddress> corpAddressSet) {
        this.corpAddressSet = corpAddressSet;
    }

    public Set<CrmCorpEmail> getCorpEmailSet() {
        return corpEmailSet;
    }

    public void setCorpEmailSet(Set<CrmCorpEmail> corpEmailSet) {
        this.corpEmailSet = corpEmailSet;
    }

    public Set<CrmCorpCase> getCorpCaseSet() {
        return corpCaseSet;
    }

    public void setCorpCaseSet(Set<CrmCorpCase> corpCaseSet) {
        this.corpCaseSet = corpCaseSet;
    }

    public Set<CrmCorpPhone> getCorpPhoneSet() {
        return corpPhoneSet;
    }

    public void setCorpPhoneSet(Set<CrmCorpPhone> corpPhoneSet) {
        this.corpPhoneSet = corpPhoneSet;
    }

    public Set<CrmCorpIdentity> getCorpIdentitySet() {
        return corpIdentitySet;
    }

    public void setCorpIdentitySet(Set<CrmCorpIdentity> corpIdentitySet) {
        this.corpIdentitySet = corpIdentitySet;
    }

    public Set<CrmCorpWebsite> getCorpWebsiteSet() {
        return corpWebsiteSet;
    }

    public void setCorpWebsiteSet(Set<CrmCorpWebsite> corpWebsiteSet) {
        this.corpWebsiteSet = corpWebsiteSet;
    }

    public Set<CrmCorpAccount> getCorpAccountSet() {
        return corpAccountSet;
    }

    public void setCorpAccountSet(Set<CrmCorpAccount> corpAccountSet) {
        this.corpAccountSet = corpAccountSet;
    }

    public Set<CrmCorpContactLog> getCorpContactLogSet() {
        return corpContactLogSet;
    }

    public void setCorpContactLogSet(Set<CrmCorpContactLog> corpContactLogSet) {
        this.corpContactLogSet = corpContactLogSet;
    }

    public Set<CrmCorpComplain> getCorpComplainSet() {
        return corpComplainSet;
    }

    public void setCorpComplainSet(Set<CrmCorpComplain> corpComplainSet) {
        this.corpComplainSet = corpComplainSet;
    }

    public Set<CrmPosition> getCrmPositionSet() {
        return crmPositionSet;
    }

    public void setCrmPositionSet(Set<CrmPosition> crmPositionSet) {
        this.crmPositionSet = crmPositionSet;
    }

    public Set<CrmPerson> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<CrmPerson> personSet) {
        this.personSet = personSet;
    }
	public Set<EMaterial> getMaterialSet() {
		return materialSet;
	}

	public void setMaterialSet(Set<EMaterial> materialSet) {
		this.materialSet = materialSet;
	}

	public Set<FCorpPersonActivityRelationship> getCorpPersonActivityRelationshipSet() {
		return corpPersonActivityRelationshipSet;
	}

	public void setCorpPersonActivityRelationshipSet(Set<FCorpPersonActivityRelationship> corpPersonActivityRelationshipSet) {
		this.corpPersonActivityRelationshipSet = corpPersonActivityRelationshipSet;
	}

	public Set<OSaleItem> getSaleItemSet() {
		return saleItemSet;
	}

	public void setSaleItemSet(Set<OSaleItem> saleItemSet) {
		this.saleItemSet = saleItemSet;
	}

	public Set<OSaleOrder> getSaleOrderSet() {
		return saleOrderSet;
	}

	public void setSaleOrderSet(Set<OSaleOrder> saleOrderSet) {
		this.saleOrderSet = saleOrderSet;
	}

	public Set<OInitialSaleOrder> getInitialSaleOrderSet() {
		return initialSaleOrderSet;
	}

	public void setInitialSaleOrderSet(Set<OInitialSaleOrder> initialSaleOrderSet) {
		this.initialSaleOrderSet = initialSaleOrderSet;
	}

	public Set<OInitialSaleItem> getInitialSaleItemSet() {
		return initialSaleItemSet;
	}

	public void setInitialSaleItemSet(Set<OInitialSaleItem> initialSaleItemSet) {
		this.initialSaleItemSet = initialSaleItemSet;
	}

	public Set<IvStockIn> getStockInSet() {
		return stockInSet;
	}

	public void setStockInSet(Set<IvStockIn> stockInSet) {
		this.stockInSet = stockInSet;
	}

	public Set<IvStockOut> getStockOutSet() {
		return stockOutSet;
	}

	public void setStockOutSet(Set<IvStockOut> stockOutSet) {
		this.stockOutSet = stockOutSet;
	}

	public Set<OInvoiceReq> getInvoiceReqSet() {
		return invoiceReqSet;
	}

	public void setInvoiceReqSet(Set<OInvoiceReq> invoiceReqSet) {
		this.invoiceReqSet = invoiceReqSet;
	}

	public Set<OReverseReq> getReverseReqSet() {
		return reverseReqSet;
	}

	public void setReverseReqSet(Set<OReverseReq> reverseReqSet) {
		this.reverseReqSet = reverseReqSet;
	}

	public Set<ORepaymentReq> getRepaymentReqSet() {
		return repaymentReqSet;
	}

	public void setRepaymentReqSet(Set<ORepaymentReq> repaymentReqSet) {
		this.repaymentReqSet = repaymentReqSet;
	}

	public Set<CrmCorpDelivery> getCorpDeliverySet() {
		return corpDeliverySet;
	}

	public void setCorpDeliverySet(Set<CrmCorpDelivery> corpDeliverySet) {
		this.corpDeliverySet = corpDeliverySet;
	}

	public Set<IvTransport> getTransportSet() {
		return transportSet;
	}

	public void setTransportSet(Set<IvTransport> transportSet) {
		this.transportSet = transportSet;
	}

	public long getChildSize() {
		return childSize;
	}

	public void setChildSize(long childSize) {
		this.childSize = childSize;
	}
}
