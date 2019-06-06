package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 04_公司类型
 * @table CRM_CORP_TYPE
 */
@SuppressWarnings("serial")
public class CrmCorpType implements Serializable {

    private String id; // 公司类型ID
    private String code; // 公司类型编号
    private String name; // 公司类型名称
    private Integer order; // 公司类型排序
    private String status; // 公司类型状态
    private String internationCode; // 国际化参数
    @JsonIgnore
    private Set<CrmCorpTypeRelationship> corpTypeRelationshipSet = new HashSet<CrmCorpTypeRelationship>(); // 04_公司类型角色关系
    @JsonIgnore
    private Set<CrmCtpClassify> corpTypePropClassifySet = new HashSet<CrmCtpClassify>(); // 04_公司类型属性分组
    @JsonIgnore
    private Set<CrmCtypeProp> ctypePropSet = new HashSet<CrmCtypeProp>(); // 04_公司类型属性

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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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

    public Set<CrmCorpTypeRelationship> getCorpTypeRelationshipSet() {
        return corpTypeRelationshipSet;
    }

    public void setCorpTypeRelationshipSet(Set<CrmCorpTypeRelationship> corpTypeRelationshipSet) {
        this.corpTypeRelationshipSet = corpTypeRelationshipSet;
    }

    public Set<CrmCtpClassify> getCorpTypePropClassifySet() {
        return corpTypePropClassifySet;
    }

    public void setCorpTypePropClassifySet(Set<CrmCtpClassify> corpTypePropClassifySet) {
        this.corpTypePropClassifySet = corpTypePropClassifySet;
    }

    public Set<CrmCtypeProp> getCtypePropSet() {
        return ctypePropSet;
    }

    public void setCtypePropSet(Set<CrmCtypeProp> ctypePropSet) {
        this.ctypePropSet = ctypePropSet;
    }
}
