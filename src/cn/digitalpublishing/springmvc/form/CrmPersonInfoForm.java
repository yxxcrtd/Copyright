package cn.digitalpublishing.springmvc.form;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.CrmCorp;
import cn.digitalpublishing.po.CrmPeTpClassify;
import cn.digitalpublishing.po.CrmPeTypeProp;
import cn.digitalpublishing.po.CrmPerson;
import cn.digitalpublishing.po.CrmPersonProp;
import cn.digitalpublishing.po.CrmPersonType;
import cn.digitalpublishing.po.CrmPersonTypeRelationship;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class CrmPersonInfoForm extends DataTableForm<CrmPerson>{

	private CrmPerson obj = new CrmPerson();

	private CrmPersonType personType;

	private CrmPeTpClassify peTpClassify;

	private CrmPersonTypeRelationship relation;

	private CrmPeTypeProp peTypeProp;

	private List<CrmPersonProp> personPropList;

	private List<CrmPeTpClassify> peTpClassifieList;

	private String name;

	private String clientId;

	private CrmCorp corp = new CrmCorp();

	private String corpName;

	private String corpId;

	private String code;

	private String existCode;

	private List<CrmPerson> personList;// 员工信息

	private String position;

	private String accountId;

	private String personId;

	private String clientTypeId;

	private String clientTypeName;

	private Map<String, String> personMap;// 员工Map

	private String[] propsId;

	private String[] propsValue;

	public CrmPerson getObj() {
		return obj;
	}

	public void setObj(CrmPerson obj) {
		this.obj = obj;
	}

	public CrmCorp getCorp() {
		return corp;
	}

	public void setCorp(CrmCorp corp) {
		this.corp = corp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getExistCode() {
		return existCode;
	}

	public void setExistCode(String existCode) {
		this.existCode = existCode;
	}

	public List<CrmPerson> getPersonList() {
		return personList;
	}

	public void setPersonList(List<CrmPerson> personList) {
		this.personList = personList;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public CrmPersonType getPersonType() {
		return personType;
	}

	public void setPersonType(CrmPersonType personType) {
		this.personType = personType;
	}

	public Map<String, String> getPersonMap() {
		return personMap;
	}

	public void setPersonMap(Map<String, String> personMap) {
		this.personMap = personMap;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String[] getPropsId() {
		return propsId;
	}

	public void setPropsId(String[] propsId) {
		this.propsId = propsId;
	}

	public String[] getPropsValue() {
		return propsValue;
	}

	public void setPropsValue(String[] propsValue) {
		this.propsValue = propsValue;
	}

	public String getClientTypeId() {
		return clientTypeId;
	}

	public void setClientTypeId(String clientTypeId) {
		this.clientTypeId = clientTypeId;
	}

	public String getClientTypeName() {
		return clientTypeName;
	}

	public void setClientTypeName(String clientTypeName) {
		this.clientTypeName = clientTypeName;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public CrmPeTpClassify getPeTpClassify() {
		return peTpClassify;
	}

	public void setPeTpClassify(CrmPeTpClassify peTpClassify) {
		this.peTpClassify = peTpClassify;
	}

	public CrmPersonTypeRelationship getRelation() {
		return relation;
	}

	public void setRelation(CrmPersonTypeRelationship relation) {
		this.relation = relation;
	}

	public CrmPeTypeProp getPeTypeProp() {
		return peTypeProp;
	}

	public void setPeTypeProp(CrmPeTypeProp peTypeProp) {
		this.peTypeProp = peTypeProp;
	}

	public List<CrmPersonProp> getPersonPropList() {
		return personPropList;
	}

	public void setPersonPropList(List<CrmPersonProp> personPropList) {
		this.personPropList = personPropList;
	}

	public List<CrmPeTpClassify> getPeTpClassifieList() {
		return peTpClassifieList;
	}

	public void setPeTpClassifieList(List<CrmPeTpClassify> peTpClassifieList) {
		this.peTpClassifieList = peTpClassifieList;
	}

	
}
