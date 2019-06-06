package cn.digitalpublishing.springmvc.form.product;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.PStructureType;
import cn.digitalpublishing.po.PStructureTypePropClassify;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class PStructureTypePropClassifyForm extends DataTableForm<PStructureTypePropClassify> {

	private PStructureTypePropClassify structureTypePropClassify = new PStructureTypePropClassify();
	private PStructureType structureType = new PStructureType();
	private List<PStructureTypePropClassify> classifyList;
	private Map<String, String> dicTest;
	
	public Map<String, String> getDicTest() {
		return dicTest;
	}

	public void setDicTest(Map<String, String> dicTest) {
		this.dicTest = dicTest;
	}

	public PStructureTypePropClassify getStructureTypePropClassify() {
		return structureTypePropClassify;
	}

	public void setStructureTypePropClassify(PStructureTypePropClassify structureTypePropClassify) {
		this.structureTypePropClassify = structureTypePropClassify;
	}

	public PStructureType getStructureType() {
		return structureType;
	}

	public void setStructureType(PStructureType structureType) {
		this.structureType = structureType;
	}

	public List<PStructureTypePropClassify> getClassifyList() {
		return classifyList;
	}

	public void setClassifyList(List<PStructureTypePropClassify> classifyList) {
		this.classifyList = classifyList;
	}
}