package cn.digitalpublishing.springmvc.form.product;

import cn.digitalpublishing.po.PProposalPersonRelationship;
import cn.digitalpublishing.springmvc.form.DataTableForm;

/**
 * Created by huangchenxi on 14-7-15.
 */
public class PProposalPersonRelationshipForm extends DataTableForm<PProposalPersonRelationship> {
    private String personId;
    private String proposalId;
    private String ids;
    private String name;
    private String desc;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getProposalId() {
        return proposalId;
    }

    public void setProposalId(String proposalId) {
        this.proposalId = proposalId;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
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
}
