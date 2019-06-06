package cn.digitalpublishing.springmvc.form.base;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.BCurrency;
import cn.digitalpublishing.po.BExchange;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class BExchangeForm extends DataTableForm<BExchange> {

	private String exId; // 汇率ID
	private BigDecimal exRate; // 汇率值
	private Date exDate; // 日期
	// private String exType; // 类型
	private String exStatus; // 状态
	private Map<String, String> froms; // 00_币种
	private Map<String, String> tos; // 00_币种
	private List<BCurrency> blist;

	private List<BExchange> exList;

	private Map<String, String> exchangeType;// 类型

	private BCurrency fromCurrency;
	private BCurrency toCurrency;

	private BExchange obj = new BExchange();

	public List<BCurrency> getBlist() {
		return blist;
	}

	public void setBlist(List<BCurrency> blist) {
		this.blist = blist;
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

	public String getExStatus() {
		return exStatus;
	}

	public void setExStatus(String exStatus) {
		this.exStatus = exStatus;
	}

	public Map<String, String> getFroms() {
		return froms;
	}

	public void setFroms(Map<String, String> froms) {
		this.froms = froms;
	}

	public Map<String, String> getTos() {
		return tos;
	}

	public void setTos(Map<String, String> tos) {
		this.tos = tos;
	}

	public Map<String, String> getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(Map<String, String> exchangeType) {
		this.exchangeType = exchangeType;
	}

	public BExchange getObj() {
		return obj;
	}

	public void setObj(BExchange obj) {
		this.obj = obj;
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

	public List<BExchange> getExList() {
		return exList;
	}

	public void setExList(List<BExchange> exList) {
		this.exList = exList;
	}

}
