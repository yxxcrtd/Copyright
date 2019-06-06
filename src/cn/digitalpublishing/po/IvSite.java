package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 09_驻地
 * @table IV_SITE
 */
@SuppressWarnings("serial")
public class IvSite implements Serializable {

	private String siteId; // 驻地ID
	private String siteCode; // 驻地编号
	private String siteDescription; // 驻地描述
	private String siteStatus; // 驻地状态
	private BRegion region; // 00_地域信息
	@JsonIgnore
	private Set<IvWarehouse> warehouseSet = new HashSet<IvWarehouse>(); // 09_仓库

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getSiteDescription() {
		return siteDescription;
	}

	public void setSiteDescription(String siteDescription) {
		this.siteDescription = siteDescription;
	}

	public String getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}

	public BRegion getRegion() {
		return region;
	}

	public void setRegion(BRegion region) {
		this.region = region;
	}

	public Set<IvWarehouse> getWarehouseSet() {
		return warehouseSet;
	}

	public void setWarehouseSet(Set<IvWarehouse> warehouseSet) {
		this.warehouseSet = warehouseSet;
	}
}
