package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @name 04_人员属性
 * @table CRM_PERSON_PROP
 */
@SuppressWarnings("serial")
public class CrmPersonProp implements Serializable {

	private String id; // 人员属性ID
	private String code; // 人员属性编号
	private String name; // 人员属性名称
	private String val; // 人员属性取值
	private String order; // 人员属性排序
	private String display; // 人员属性显示方式
	private String must; // 人员属性是否必填
	private String source; // 人员属性来源
	private String status; // 人员属性状态
	private Date createOn; // 人员属性创建时间
	private String createBy; // 人员属性创建人
	private Date updateOn; // 人员属性修改时间
	private String updateBy; // 人员属性修改人
	private String internationCode; // 国际化参数
	private CrmPeTypeProp personTypeProp; // 04_人员类型属性
	private CrmPersonTypeRelationship personTypeRelationship; // 04_人员类型角色关系

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }


    public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getMust() {
        return must;
    }

    public void setMust(String must) {
        this.must = must;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public CrmPeTypeProp getPersonTypeProp() {
        return personTypeProp;
    }

    public void setPersonTypeProp(CrmPeTypeProp personTypeProp) {
        this.personTypeProp = personTypeProp;
    }

	public CrmPersonTypeRelationship getPersonTypeRelationship() {
		return personTypeRelationship;
	}

	public void setPersonTypeRelationship(CrmPersonTypeRelationship personTypeRelationship) {
		this.personTypeRelationship = personTypeRelationship;
	}
}
