package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @name 04_公司类型属性分组
 * @table CRM_CTP_CLASSIFY
 */
@SuppressWarnings("serial")
public class CrmCtpClassify implements Serializable {

    private String id; // 公司类型属性分类ID
    private String code; // 公司类型属性分类编码
    private String name; // 公司类型属性分类名称
    private Integer order; // 公司类型属性分类排序
    private String status; // 公司类型属性分类状态
    private String internationCode; // 国际化参数
    private CrmCorpType corpType; // 04_公司类型
    private CrmCtpClassify parentClassify; // 04_公司类型属性分组
    @JsonIgnore
    private Set<CrmCtypeProp> ctypePropSet = new HashSet<CrmCtypeProp>(); // 04_公司类型属性
    @JsonIgnore
    private Set<CrmCtpClassify> ctpClassifySet = new HashSet<CrmCtpClassify>(); // 04_公司类型属性分组

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

    public CrmCorpType getCorpType() {
        return corpType;
    }

    public void setCorpType(CrmCorpType corpType) {
        this.corpType = corpType;
    }

    public CrmCtpClassify getParentClassify() {
        return parentClassify;
    }

    public void setParentClassify(CrmCtpClassify parentClassify) {
        this.parentClassify = parentClassify;
    }

    public Set<CrmCtypeProp> getCtypePropSet() {
        return ctypePropSet;
    }

    public void setCtypePropSet(Set<CrmCtypeProp> ctypePropSet) {
        this.ctypePropSet = ctypePropSet;
    }

    public Set<CrmCtpClassify> getCtpClassifySet() {
        return ctpClassifySet;
    }

    public void setCtpClassifySet(Set<CrmCtpClassify> ctpClassifySet) {
        this.ctpClassifySet = ctpClassifySet;
    }
}
