package cn.digitalpublishing.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @name 版税结算
 * @table CR_SETTLEMENT
 */
@SuppressWarnings("serial")
public class CrSettlement implements Serializable {

	/**
     * 主键
     */
    private String id;
    
    /**
     * 结算类型
     */
    private String setType;
    
    /**
     * 订单号
     */
    private String code;
    
    /**
     * 贡献者
     */
    private String name;
    
    /**
     * ISBN号
     */
    private String isbn;
    
    /**
     * 权利授权名称
     */
    private String authorityName;
    
    /**
     * 结算金额
     */
    private BigDecimal amount;
    
    /**
     * 结算状态
     */
    private String setStatus;
    
    /**
     * 状态
     */
    private String status;
    
    /**
     * 结算时间
     */
    private Date endDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSetType() {
		return setType;
	}

	public void setSetType(String setType) {
		this.setType = setType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    
}
