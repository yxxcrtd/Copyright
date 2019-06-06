package cn.digitalpublishing.po;

import java.io.Serializable;
import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import cn.digitalpublishing.util.converter.CustomDateTimeSerializer;

/**
 * @name 09_入库验更单
 * @table IV_CHECK
 */
@SuppressWarnings("serial")
public class IvCheck implements Serializable {

	private String checkId; // 入库验更单ID
	private String checkCode; // 入库验更单号
	private Date checkCreateOn; // 入库验更单创建日期
	private String checkCreateBy; // 入库验更单创建人
	private String checkType; // 入库验更单类型
	private String checkIsbn; // 入库验更单ISBN
	private String checkTitle; // 入库验更单书名
	private Integer checkCount; // 入库验更单数量
	private IvStockIn stockIn; // 09_入库单
	private IvStockInItem stockInItem; // 09_入库单明细


	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public Date getCheckCreateOn() {
		return checkCreateOn;
	}

	public void setCheckCreateOn(Date checkCreateOn) {
		this.checkCreateOn = checkCreateOn;
	}

	public String getCheckCreateBy() {
		return checkCreateBy;
	}

	public void setCheckCreateBy(String checkCreateBy) {
		this.checkCreateBy = checkCreateBy;
	}

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getCheckIsbn() {
		return checkIsbn;
	}

	public void setCheckIsbn(String checkIsbn) {
		this.checkIsbn = checkIsbn;
	}

	public String getCheckTitle() {
		return checkTitle;
	}

	public void setCheckTitle(String checkTitle) {
		this.checkTitle = checkTitle;
	}

	public Integer getCheckCount() {
		return checkCount;
	}

	public void setCheckCount(Integer checkCount) {
		this.checkCount = checkCount;
	}

	public IvStockIn getStockIn() {
		return stockIn;
	}

	public void setStockIn(IvStockIn stockIn) {
		this.stockIn = stockIn;
	}

	public IvStockInItem getStockInItem() {
		return stockInItem;
	}

	public void setStockInItem(IvStockInItem stockInItem) {
		this.stockInItem = stockInItem;
	}
}