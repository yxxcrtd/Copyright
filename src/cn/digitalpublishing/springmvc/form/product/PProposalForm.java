package cn.digitalpublishing.springmvc.form.product;

import cn.digitalpublishing.po.PProposal;
import cn.digitalpublishing.springmvc.form.DataTableForm;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @name 01_策划
 * @table P_PROPOSAL
 */

public class PProposalForm extends DataTableForm<PProposal> {

    private String id; // 策划ID
    private String name; // 策划名称
    private String desc; // 策划描述
    private Date createOn; // 策划创建时间
    private String createBy; // 策划创建人
    private Map<String, String> roleTypeMap; // 策划创建人
    private PProposal obj = new PProposal();
    private String teamWork;
    private String isEdit;

    @SuppressWarnings("rawtypes")
    private Set productSet = new HashSet(0); // 01_产品基础信息

    @SuppressWarnings("rawtypes")
    private Set proposalAdviceSet = new HashSet(0); // 01_策划意见

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

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public String getCreateBy() {
        return createBy;
    }

    @SuppressWarnings("rawtypes")
    public Set getProductSet() {
        return productSet;
    }

    @SuppressWarnings("rawtypes")
    public void setProductSet(Set productSet) {
        this.productSet = productSet;
    }

    @SuppressWarnings("rawtypes")
    public Set getProposalAdviceSet() {
        return proposalAdviceSet;
    }

    @SuppressWarnings("rawtypes")
    public void setProposalAdviceSet(Set proposalAdviceSet) {
        this.proposalAdviceSet = proposalAdviceSet;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public PProposal getObj() {
        return obj;
    }

    public void setObj(PProposal obj) {
        this.obj = obj;
    }

    public Map<String, String> getRoleTypeMap() {
        return roleTypeMap;
    }

    public void setRoleTypeMap(Map<String, String> roleTypeMap) {
        this.roleTypeMap = roleTypeMap;
    }

    public String getTeamWork() {
        return teamWork;
    }

    public void setTeamWork(String teamWork) {
        this.teamWork = teamWork;
    }

    public String getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(String isEdit) {
        this.isEdit = isEdit;
    }
}