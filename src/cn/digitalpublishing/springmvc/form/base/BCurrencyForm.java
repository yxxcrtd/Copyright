package cn.digitalpublishing.springmvc.form.base;

import java.util.Date;

import cn.digitalpublishing.po.BCurrency;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class BCurrencyForm extends DataTableForm<BCurrency> {


	private String currencyId; // 币种信息ID
	private String currencyName; // 币种名称
	private String currencyCode; // 币种编号
	private String currencyStatus; // 币种状态
	private Date currencyCreateOn; // 币种创建日期
	private Date currencyUpdateOn; // 币种修改日期
	private String currencyInternationCode; // 国际化参数

	private BCurrency obj = new BCurrency();

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

	public Date getCurrencyCreateOn() {
		return currencyCreateOn;
	}

	public void setCurrencyCreateOn(Date currencyCreateOn) {
		this.currencyCreateOn = currencyCreateOn;
	}

	public Date getCurrencyUpdateOn() {
		return currencyUpdateOn;
	}

	public void setCurrencyUpdateOn(Date currencyUpdateOn) {
		this.currencyUpdateOn = currencyUpdateOn;
	}

	public BCurrency getObj() {
		return obj;
	}

	public void setObj(BCurrency obj) {
		this.obj = obj;
	}

}
