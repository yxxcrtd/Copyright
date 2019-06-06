package cn.digitalpublishing.springmvc.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.CrLicenseType;
import cn.digitalpublishing.po.CrRight;
import cn.digitalpublishing.po.CrSubsidaryRight;
import cn.digitalpublishing.po.PProposal;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class CrRightForm extends DataTableForm<CrRight> {

	private CrRight crRight = new CrRight();
	private Map<String, Object> dic = new HashMap<String, Object>();
	private CrSubsidaryRight obj = new CrSubsidaryRight();

	private Map<String, String> levelMap = new HashMap<String, String>();
	private List<CrLicenseType> licenseTypeList = new ArrayList<CrLicenseType>();
	private List<PProposal> proposalList = new ArrayList<PProposal>();

	public CrRight getCrRight() {
		return crRight;
	}

	public void setCrRight(CrRight crRight) {
		this.crRight = crRight;
	}

	public Map<String, Object> getDic() {
		return dic;
	}

	public void setDic(Map<String, Object> dic) {
		this.dic = dic;
	}

	public CrSubsidaryRight getObj() {
		return obj;
	}

	public void setObj(CrSubsidaryRight obj) {
		this.obj = obj;
	}

	public Map<String, String> getLevelMap() {
		return levelMap;
	}

	public void setLevelMap(Map<String, String> levelMap) {
		this.levelMap = levelMap;
	}

	public List<CrLicenseType> getLicenseTypeList() {
		return licenseTypeList;
	}

	public void setLicenseTypeList(List<CrLicenseType> licenseTypeList) {
		this.licenseTypeList = licenseTypeList;
	}

	public List<PProposal> getProposalList() {
		return proposalList;
	}

	public void setProposalList(List<PProposal> proposalList) {
		this.proposalList = proposalList;
	}

}