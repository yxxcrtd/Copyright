package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 04_公司类型属性
 * @table CRM_CTYPE_PROP
 */
@SuppressWarnings("serial")
public class CrmCtypeProp implements Serializable {

    private String id; // 公司类型属性ID
    private String code; // 公司类型属性编码
    private String name; // 公司类型属性名称
    private String order; // 公司类型属性排序
    private String display; // 公司类型属性显示方式
    private String must; // 公司类型属性是否必须
    private String sourceType; // 公司类型属性数据来源方式
    private String source; // 公司类型属性数据来源
    private String status; // 公司类型属性状态
    private String internationCode; // 国际化参数
    private CrmCtpClassify corpTypePropClassify; // 04_公司类型属性分组
    private CrmCorpType corpType; // 04_公司类型
    @JsonIgnore
    private Set<CrmCorpProp> corpPropSet = new HashSet<CrmCorpProp>(); // 04_公司属性

    // 非持久化属性
    private String value;//存储用户属性值

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

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
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

    public String getInternationCode() {
        return internationCode;
    }

    public void setInternationCode(String internationCode) {
        this.internationCode = internationCode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CrmCtpClassify getCorpTypePropClassify() {
        return corpTypePropClassify;
    }

    public void setCorpTypePropClassify(CrmCtpClassify corpTypePropClassify) {
        this.corpTypePropClassify = corpTypePropClassify;
    }

    public CrmCorpType getCorpType() {
        return corpType;
    }

    public void setCorpType(CrmCorpType corpType) {
        this.corpType = corpType;
    }

    public Set<CrmCorpProp> getCorpPropSet() {
        return corpPropSet;
    }

    public void setCorpPropSet(Set<CrmCorpProp> corpPropSet) {
        this.corpPropSet = corpPropSet;
    }
}
