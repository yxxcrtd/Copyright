package cn.digitalpublishing.springmvc.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import cn.digitalpublishing.po.CrSettlement;

public class CrSettlementForm extends DataTableForm<CrSettlement> {

	private CrSettlement settlement = new CrSettlement();
	private Map<String, Object> dic = new HashMap<String, Object>();
    private String name;
    private String code;
    private BigDecimal amount;
    private String setStatus;
    private String isbn;
    private String setType;
    
	public CrSettlement getSettlement() {
		return settlement;
	}
	public void setSettlement(CrSettlement settlement) {
		this.settlement = settlement;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getSetStatus() {
		return setStatus;
	}
	public void setSetStatus(String setStatus) {
		this.setStatus = setStatus;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getSetType() {
		return setType;
	}
	public void setSetType(String setType) {
		this.setType = setType;
	}
	
}