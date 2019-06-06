package cn.digitalpublishing.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @name 00_汇率
 * @table B_EXCHANGE
 */
@SuppressWarnings("serial")
public class BExchange implements Serializable {

	private String exId; // 汇率ID
	private BigDecimal exRate; // 汇率值
	private Date exDate; // 日期
	private String exType; // 类型
	private String exStatus; // 状态
	private BCurrency fromCurrency; // 00_币种
	private BCurrency toCurrency; // 00_币种

	private String currencyCode; // 币种编号


	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getExId() {
		return exId;
	}

	public void setExId(String exId) {
		this.exId = exId;
	}

	public BigDecimal getExRate() {
		return exRate;
	}

	public void setExRate(BigDecimal exRate) {
		this.exRate = exRate;
	}

	public Date getExDate() {
		return exDate;
	}

	public void setExDate(Date exDate) {
		this.exDate = exDate;
	}

	public String getExType() {
		return exType;
	}

	public void setExType(String exType) {
		this.exType = exType;
	}

	public String getExStatus() {
		return exStatus;
	}

	public void setExStatus(String exStatus) {
		this.exStatus = exStatus;
	}

	public BCurrency getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(BCurrency fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public BCurrency getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(BCurrency toCurrency) {
		this.toCurrency = toCurrency;
	}
}
