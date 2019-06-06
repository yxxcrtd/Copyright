package cn.digitalpublishing.springmvc.form.product;

import java.util.List;

import cn.digitalpublishing.po.CrmPerson;
import cn.digitalpublishing.po.PProductPersonRelationship;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class PProductPersonRelationshipForm extends DataTableForm<PProductPersonRelationship> {

	private String productId;
	private String name;
	private String ids;
	private String topicId;
	private String code;
    private String title;
    private String productType;
    private String flag;
    private String writer;

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
