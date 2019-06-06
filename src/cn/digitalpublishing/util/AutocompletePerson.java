package cn.digitalpublishing.util;

public class AutocompletePerson {

	private String id; // 人员类型角色关系ID
	private String name; // 人员名称
	private String telephone; // 座机
	private String phone; // 手机
	private String address; // 联系地址
	private String postCode; // 邮编
	private String email; // 电子邮箱
	private String fax; // 传真
	private String lowerPinyin; // 拼音小写
	private String label;

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getLowerPinyin() {
		return lowerPinyin;
	}

	public void setLowerPinyin(String lowerPinyin) {
		this.lowerPinyin = lowerPinyin;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}