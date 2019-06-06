package cn.digitalpublishing.springmvc.form.product;

import java.util.List;

import cn.digitalpublishing.po.CrmPerson;
import cn.digitalpublishing.po.PProductPersonRelationship;
import cn.digitalpublishing.po.PProposalAuthorRelationship;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class PProposalAuthorRelationshipForm extends DataTableForm<PProposalAuthorRelationship> {

	private String name;
	private String ids;
	private String topicId;
	private String proposalId;
	
	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getProposalId() {
		return proposalId;
	}

	public void setProposalId(String proposalId) {
		this.proposalId = proposalId;
	}
	
}
