package cn.digitalpublishing.springmvc.form.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.PStructureType;
import cn.digitalpublishing.po.PStructureTypeProp;
import cn.digitalpublishing.po.PStructureTypePropClassify;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class PStructureTypePropForm extends DataTableForm<PStructureTypeProp> {

	private PStructureTypeProp structureTypeProp = new PStructureTypeProp();
	private PStructureType structureType = new PStructureType();
	private List<PStructureTypePropClassify> classifyList;
	private Map<String, String> dicDisplay;
	private Map<String, String> dicMust;
	private Map<String, Object> dic = new HashMap<String, Object>();

	private String order;
	public PStructureTypeProp getStructureTypeProp() {
		return structureTypeProp;
	}

	public void setStructureTypeProp(PStructureTypeProp structureTypeProp) {
		this.structureTypeProp = structureTypeProp;
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

	public Map<String, String> getDicDisplay() {
		return dicDisplay;
	}

	public void setDicDisplay(Map<String, String> dicDisplay) {
		this.dicDisplay = dicDisplay;
	}

	public Map<String, String> getDicMust() {
		return dicMust;
	}

	public void setDicMust(Map<String, String> dicMust) {
		this.dicMust = dicMust;
	}

	public Map<String, Object> getDic() {
		return dic;
	}

	public void setDic(Map<String, Object> dic) {
		this.dic = dic;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}