package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Date;

import cn.digitalpublishing.util.DateFormatUitl;

/**
 * @name 04_公司联系日志
 * @table CRM_CORP_CONTACT_LOG
 */
@SuppressWarnings("serial")
public class CrmCorpContactLog implements Serializable {

	private String id; // 联系日志ID
	private String name; // 联系日志名称
	private String desc; // 联系日志描述
	private Date date; // 联系日志日期
    private String status; // 联系日志状态
	private CrmCorpTypeRelationship crmCorpTypeRelationship; // 04_公司类型角色关系
	private String dateStr;
	
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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
		return this.dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	
}