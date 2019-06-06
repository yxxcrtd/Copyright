package cn.digitalpublishing.springmvc.form.product;

import java.io.Serializable;
import java.util.Date;

import cn.digitalpublishing.po.PProductType;
import cn.digitalpublishing.po.PProposal;
import cn.digitalpublishing.po.PProposalAdvice;
import cn.digitalpublishing.springmvc.form.DataTableForm;

/**
 * @name 01_策划意见
 * @table P_PROPOSAL_ADVICE
 */
public class PProposalAdviceForm extends DataTableForm<PProposalAdvice> {

	private String id; // 策划意见ID
	private String desc; // 策划意见描述
	private Date createOn; // 策划意见创建时间
	private String createBy; // 策划意见创建人
	private PProposal proposal; // 01_策划
	
	private String tid;//策划id
	
	private PProposalAdvice obj = new PProposalAdvice();
	
	

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public PProposalAdvice getObj() {
		return obj;
	}

	public void setObj(PProposalAdvice obj) {
		this.obj = obj;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public PProposal getProposal() {
		return proposal;
	}

	public void setProposal(PProposal proposal) {
		this.proposal = proposal;
	}
	
	
}