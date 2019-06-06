package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @name 04_公司属性
 * @table CRM_CORP_PROP
 */
@SuppressWarnings("serial")
public class CrmCorpProp implements Serializable {

    private String id; // 公司属性ID
    private String code; // 公司属性编号
    private String name; // 公司属性名称
    private String value; // 公司属性取值
    private String order; // 公司属性排序
    private String display; // 公司属性显示方式
    private String must; // 公司属性是否必填
    private String source; // 公司属性来源
    private String status; // 公司属性状态
    private Date createOn; // 公司属性创建时间
    private String createBy; // 公司属性创建人
    private Date updateOn; // 公司属性修改时间
    private String updateBy; // 公司属性修改人
    private String internationCode; // 国际化参数
    private CrmCtypeProp corpTypeProp; // 04_公司类型属性
    private CrmCorpTypeRelationship corpTypeRelationship; // 04_公司类型角色关系


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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public CrmCtypeProp getCorpTypeProp() {
        return corpTypeProp;
    }

    public void setCorpTypeProp(CrmCtypeProp corpTypeProp) {
        this.corpTypeProp = corpTypeProp;
    }

    public CrmCorpTypeRelationship getCorpTypeRelationship() {
        return corpTypeRelationship;
    }

    public void setCorpTypeRelationship(CrmCorpTypeRelationship corpTypeRelationship) {
        this.corpTypeRelationship = corpTypeRelationship;
    }
}
