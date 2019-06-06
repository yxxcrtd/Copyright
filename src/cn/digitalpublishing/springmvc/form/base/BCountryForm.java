package cn.digitalpublishing.springmvc.form.base;

import java.util.Date;

import cn.digitalpublishing.po.BCountry;
import cn.digitalpublishing.po.BRegion;
import cn.digitalpublishing.springmvc.form.DataTableForm;
import cn.digitalpublishing.util.TreeNode;

public class BCountryForm extends DataTableForm<BCountry> {

	private BCountry country;
	private String cnName;
	private String enName;
	private String createBy;
	private Integer status;
	private BRegion region = new BRegion();
	private String regionId;
	private String fatherId;
	private String otherId;
	private String coId;

	private String name;
	private Date createOn;
	private String code;

	private String returnValue;

	private BCountry obj = new BCountry();

	private TreeNode node;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BRegion getRegion() {
		return region;
	}

	public void setRegion(BRegion region) {
		this.region = region;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getFatherId() {
		return fatherId;
	}

	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	public String getCoId() {
		return coId;
	}

	public void setCoId(String coId) {
		this.coId = coId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BCountry getObj() {
		return obj;
	}

	public void setObj(BCountry obj) {
		this.obj = obj;
	}

	public String getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(String returnValue) {
		this.returnValue = returnValue;
	}

	public TreeNode getNode() {

		return node;
	}

	public void setNode(TreeNode node) {

		this.node = node;
	}

	public String getOtherId() {

		return otherId;
	}

	public void setOtherId(String otherId) {

		this.otherId = otherId;
	}

	public BCountry getCountry() {
		return country;
	}

	public void setCountry(BCountry country) {
		this.country = country;
	}

}
