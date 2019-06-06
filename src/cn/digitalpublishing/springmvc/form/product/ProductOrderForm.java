package cn.digitalpublishing.springmvc.form.product;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.digitalpublishing.po.ProductOrder;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class ProductOrderForm extends DataTableForm<ProductOrder> {

	private ProductOrder order = new ProductOrder();
    private String name;
    private String isbn;
	private CommonsMultipartFile txtFile = null;

	public ProductOrder getOrder() {
		return order;
	}

	public void setOrder(ProductOrder order) {
		this.order = order;
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

	public CommonsMultipartFile getTxtFile() {
		return txtFile;
	}

	public void setTxtFile(CommonsMultipartFile txtFile) {
		this.txtFile = txtFile;
	}
	
}