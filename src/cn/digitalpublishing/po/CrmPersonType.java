package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 04_人员类型
 * @table CRM_PERSON_TYPE
 */
@SuppressWarnings("serial")
public class CrmPersonType implements Serializable {

    private String id; // 人员类型ID
    private String code; // 人员类型编号
    private String name; // 人员类型名称
    private Integer order; // 人员类型排序
    private String status; // 人员类型状态
    private String treeCode; // 人员类型树形编码
    private String internationCode; // 国际化参数

    @JsonIgnore
    private Set<CrmPeTpClassify> personTypePropClassifySet = new HashSet<CrmPeTpClassify>(); // 04_人员类型属性分类
    @JsonIgnore
    private Set<CrmPeTypeProp> personTypePropSet = new HashSet<CrmPeTypeProp>(); // 04_人员类型属性
    @JsonIgnore
    private Set<CrmPersonTypeRelationship> personTypeRelationshipSet = new HashSet<CrmPersonTypeRelationship>(); // 04_人员类型角色关系

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

    public Set<CrmPeTpClassify> getPersonTypePropClassifySet() {
        return personTypePropClassifySet;
    }

    public void setPersonTypePropClassifySet(
            Set<CrmPeTpClassify> personTypePropClassifySet) {
        this.personTypePropClassifySet = personTypePropClassifySet;
    }

    public Set<CrmPeTypeProp> getPersonTypePropSet() {
        return personTypePropSet;
    }

    public void setPersonTypePropSet(Set<CrmPeTypeProp> personTypePropSet) {
        this.personTypePropSet = personTypePropSet;
    }

    public Set<CrmPersonTypeRelationship> getPersonTypeRelationshipSet() {
        return personTypeRelationshipSet;
    }

    public void setPersonTypeRelationshipSet(
            Set<CrmPersonTypeRelationship> personTypeRelationshipSet) {
        this.personTypeRelationshipSet = personTypeRelationshipSet;
    }

    public String getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(String treeCode) {
        this.treeCode = treeCode;
    }

}
