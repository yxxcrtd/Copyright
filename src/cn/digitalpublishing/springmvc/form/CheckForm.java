package cn.digitalpublishing.springmvc.form;

import java.util.List;

import cn.digitalpublishing.po.BCountry;
import cn.digitalpublishing.po.BRegion;
import cn.digitalpublishing.util.Check;

public class CheckForm extends DataTableForm<Check> {

	private String type;
	private String code;
	private List<BCountry> countryList;
	private	List<BRegion> regionList;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<BCountry> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<BCountry> countryList) {
		this.countryList = countryList;
	}

	public List<BRegion> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<BRegion> regionList) {
		this.regionList = regionList;
	}


}
