package cn.digitalpublishing.springmvc.form;

import java.util.HashMap;
import java.util.Map;

import cn.digitalpublishing.po.CrRight;
import cn.digitalpublishing.po.CrRlOwner;
import cn.digitalpublishing.po.CrRlOwnerRoyalty;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class CrRlOwnerForm extends DataTableForm<CrRlOwner> {

	private CrRlOwner crOwner = new CrRlOwner();
	private CrRight right;
	private Map<String, Object> dic = new HashMap<String, Object>();

	private CrRlOwnerRoyalty crOwnerRoyalty = new CrRlOwnerRoyalty();

	private String name;
	private String royaltyType;
	private String priceType;
	private String taxDescription;

	public CrRlOwner getCrOwner() {
		return crOwner;
	}

	public void setCrOwner(CrRlOwner crOwner) {
		this.crOwner = crOwner;
	}

	public CrRight getRight() {
		return right;
	}

	public void setRight(CrRight right) {
		this.right = right;
	}

	public Map<String, Object> getDic() {
		return dic;
	}

	public void setDic(Map<String, Object> dic) {
		this.dic = dic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoyaltyType() {
		return royaltyType;
	}

	public void setRoyaltyType(String royaltyType) {
		this.royaltyType = royaltyType;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public String getTaxDescription() {
		return taxDescription;
	}

	public void setTaxDescription(String taxDescription) {
		this.taxDescription = taxDescription;
	}

	public CrRlOwnerRoyalty getCrOwnerRoyalty() {
		return crOwnerRoyalty;
	}

	public void setCrOwnerRoyalty(CrRlOwnerRoyalty crOwnerRoyalty) {
		this.crOwnerRoyalty = crOwnerRoyalty;
	}

}