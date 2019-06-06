package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Date;

import cn.digitalpublishing.util.DateFormatUitl;

/**
 * @name 04_公司投诉
 * @table CRM_CORP_COMPLAIN
 */
@SuppressWarnings("serial")
public class CrmCorpComplain implements Serializable {

	private String id; // 投诉ID
	private String item; // 投诉事项
	private Date date; // 投诉时间
    private String status; // 投诉状态
	private CrmCorpTypeRelationship crmCorpTypeRelationship; // 04_公司类型角色关系
	private String dateStr;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CrmCorpTypeRelationship getCrmCorpTypeRelationship() {
		return crmCorpTypeRelationship;
	}

	public void setCrmCorpTypeRelationship(CrmCorpTypeRelationship crmCorpTypeRelationship) {
		this.crmCorpTypeRelationship = crmCorpTypeRelationship;
	}

	public String getDateStr() {
		this.dateStr = DateFormatUitl.formatDateTime(this.date);
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
}