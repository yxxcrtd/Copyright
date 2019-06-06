package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.Date;

/**
 * @name 09_运输登记单
 * @table IV_TRANSPORT
 */
@SuppressWarnings("serial")
public class IvTransport implements Serializable {

	private String transportId; // 运输登记单ID
	private String transportCode; // 运输登记单号
	private Date transportSendOn; // 运输登记单发货日期
	private Integer transportSendCount; // 运输登记单发货数量
	private String transportSendBy; // 运输登记单交接人
	private CrmCorpTypeRelationship corpTypeRelationship; // 04_公司类型角色关系
	@JsonIgnore
	private Set<IvStockOut> stockOutSet = new HashSet<IvStockOut>(); // 09_出库单


	public String getTransportId() {
		return transportId;
	}

	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}

	public String getTransportCode() {
		return transportCode;
	}

	public void setTransportCode(String transportCode) {
		this.transportCode = transportCode;
	}

	public Date getTransportSendOn() {
		return transportSendOn;
	}

	public void setTransportSendOn(Date transportSendOn) {
		this.transportSendOn = transportSendOn;
	}

	public Integer getTransportSendCount() {
		return transportSendCount;
	}

	public void setTransportSendCount(Integer transportSendCount) {
		this.transportSendCount = transportSendCount;
	}

	public String getTransportSendBy() {
		return transportSendBy;
	}

	public void setTransportSendBy(String transportSendBy) {
		this.transportSendBy = transportSendBy;
	}

	public CrmCorpTypeRelationship getCorpTypeRelationship() {
		return corpTypeRelationship;
	}

	public void setCorpTypeRelationship(CrmCorpTypeRelationship corpTypeRelationship) {
		this.corpTypeRelationship = corpTypeRelationship;
	}

	public Set<IvStockOut> getStockOutSet() {
		return stockOutSet;
	}

	public void setStockOutSet(Set<IvStockOut> stockOutSet) {
		this.stockOutSet = stockOutSet;
	}
}