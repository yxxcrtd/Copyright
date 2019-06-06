package cn.digitalpublishing.springmvc.form.product;

import cn.digitalpublishing.po.PProductStructureRelationship;
import cn.digitalpublishing.po.PStructure;
import cn.digitalpublishing.po.PStructureType;
import cn.digitalpublishing.springmvc.form.DataTableForm;

public class PProductStructureRelationshipForm extends DataTableForm<PProductStructureRelationship> {

    private PStructure element;
    private PStructureType elementType;

    public PStructure getElement() {
        return element;
    }

    public void setElement(PStructure element) {
        this.element = element;
    }

    public PStructureType getElementType() {
        return elementType;
    }

    public void setElementType(PStructureType elementType) {
        this.elementType = elementType;
    }
}