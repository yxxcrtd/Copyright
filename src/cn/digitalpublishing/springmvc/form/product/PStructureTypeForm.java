package cn.digitalpublishing.springmvc.form.product;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
import cn.digitalpublishing.po.PStructureType;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class PStructureTypeForm extends DataTableForm<PStructureType> {

	private PStructureType structureType = new PStructureType();
	private CommonsMultipartFile txtFile;

	public PStructureType getStructureType() {
		return structureType;
	}

	public void setStructureType(PStructureType structureType) {
		this.structureType = structureType;
	}

	public CommonsMultipartFile getTxtFile() {
		return txtFile;
	}

	public void setTxtFile(CommonsMultipartFile txtFile) {
		this.txtFile = txtFile;
	}
}