package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.Date;

/**
 * @name 00_地域信息
 * @table B_REGION
 */
@SuppressWarnings("serial")
public class BRegion implements Serializable {

	private String id; // 地域ID
	private String name; // 名称
	private String fullName; // 全名称
	private String code; // 区域编码
	private String treeCode; // 树形编号
	private Integer order; // 排序
	private String status; // 状态
	private Date createOn; // 创建日期
	private String createBy; // 创建者
	private Date updateOn; // 修改日期
	private String updateBy; // 修改者
	private String internationCode; // 国际化参数
	private BRegion parentRegion; // 00_地域信息
	private BCountry country; // 00_国别
	@JsonIgnore
	private Set<BRegion> regionSet = new HashSet<BRegion>(); // 00_地域信息
	@JsonIgnore
	private Set<CrmCorp> corpSet = new HashSet<CrmCorp>(); // 04_公司信息
	@JsonIgnore
	private Set<IvSite> siteSet = new HashSet<IvSite>(); // 09_驻地
	
	// 非持久化字段
	private Integer isParent;

	private long childSize;

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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTreeCode() {
		return treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getInternationCode() {
		return internationCode;
	}

	public void setInternationCode(String internationCode) {
		this.internationCode = internationCode;
	}

	public BRegion getParentRegion() {
		return parentRegion;
	}

	public void setParentRegion(BRegion parentRegion) {
		this.parentRegion = parentRegion;
	}

	public BCountry getCountry() {
		return country;
	}

	public void setCountry(BCountry country) {
		this.country = country;
	}

	public Set<BRegion> getRegionSet() {
		return regionSet;
	}

	public void setRegionSet(Set<BRegion> regionSet) {
		this.regionSet = regionSet;
	}

	public Set<CrmCorp> getCorpSet() {
		return corpSet;
	}

	public void setCorpSet(Set<CrmCorp> corpSet) {
		this.corpSet = corpSet;
	}

	public Set<IvSite> getSiteSet() {
		return siteSet;
	}

	public void setSiteSet(Set<IvSite> siteSet) {
		this.siteSet = siteSet;
	}

	public Integer getIsParent() {
		return isParent;
	}

	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}

	public long getChildSize() {
		return childSize;
	}

	public void setChildSize(long childSize) {
		this.childSize = childSize;
	}
	
	
}