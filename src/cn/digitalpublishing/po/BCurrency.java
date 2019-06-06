package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 00_币种
 * @table B_CURRENCY
 */
@SuppressWarnings("serial")
public class BCurrency implements Serializable {

	private String currencyId; // 币种信息ID
	private String currencyName; // 币种名称
	private String currencyCode; // 币种编号
	private String currencyStatus; // 币种状态
	private Date currencyCreateOn; // 币种创建日期
	private String currencyCreateBy; // 币种创建人
	private Date currencyUpdateOn; // 币种修改日期
	private String currencyUpdateBy; // 币种创建人
	private String currencyInternationCode; // 国际化参数
	@JsonIgnore
	private Set<BExchange> fromExchangeSet = new HashSet<BExchange>(); // 00_汇率
	@JsonIgnore
	private Set<BExchange> toExchangeSet = new HashSet<BExchange>(); // 00_汇率

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyStatus() {
		return currencyStatus;
	}

	public void setCurrencyStatus(String currencyStatus) {
		this.currencyStatus = currencyStatus;
	}

	public String getCurrencyInternationCode() {
		return currencyInternationCode;
	}

	public void setCurrencyInternationCode(String currencyInternationCode) {
		this.currencyInternationCode = currencyInternationCode;
	}

	public Set<BExchange> getFromExchangeSet() {
		return fromExchangeSet;
	}

	public void setFromExchangeSet(Set<BExchange> fromExchangeSet) {
		this.fromExchangeSet = fromExchangeSet;
	}

	public Set<BExchange> getToExchangeSet() {
		return toExchangeSet;
	}

	public void setToExchangeSet(Set<BExchange> toExchangeSet) {
		this.toExchangeSet = toExchangeSet;
	}

	public Date getCurrencyCreateOn() {
		return currencyCreateOn;
	}

	public void setCurrencyCreateOn(Date currencyCreateOn) {
		this.currencyCreateOn = currencyCreateOn;
	}

	public String getCurrencyCreateBy() {
		return currencyCreateBy;
	}

	public void setCurrencyCreateBy(String currencyCreateBy) {
		this.currencyCreateBy = currencyCreateBy;
	}

	public Date getCurrencyUpdateOn() {
		return currencyUpdateOn;
	}

	public void setCurrencyUpdateOn(Date currencyUpdateOn) {
		this.currencyUpdateOn = currencyUpdateOn;
	}

	public String getCurrencyUpdateBy() {
		return currencyUpdateBy;
	}

	public void setCurrencyUpdateBy(String currencyUpdateBy) {
		this.currencyUpdateBy = currencyUpdateBy;
	}
}
