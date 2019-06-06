package cn.digitalpublishing.springmvc.form;

import cn.digitalpublishing.po.CrmCorpAccount;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class CrmCorpAccountForm extends DataTableForm<CrmCorpAccount> {

	private CrmCorpAccount account = new CrmCorpAccount();

	public CrmCorpAccount getAccount() {
		return account;
	}

	public void setAccount(CrmCorpAccount account) {
		this.account = account;
	}

}