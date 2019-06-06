package cn.digitalpublishing.springmvc.controller.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.common.base.Strings;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.PStructureType;
import cn.digitalpublishing.po.PStructureTypeProp;
import cn.digitalpublishing.po.PStructureTypePropClassify;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.product.PStructureTypePropForm;
import cn.digitalpublishing.util.DicCache;

@Controller
@RequestMapping("/pages/product/structureTypeProp")
public class PStructureTypePropController extends BaseController {

	@RequestMapping(value = "/form/index")
	public ModelAndView index(PStructureTypePropForm form) throws Exception {
		String forwardString = "product/structureTypeProp/list";
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			PStructureType type = form.getStructureType();
			Map<String, Object> condition = form.getCondition();
			condition.put("structureType_id", type.getId());
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			List<PStructureTypePropClassify> list = this.structureTypePropClassifyService.getList(condition);
			form.setClassifyList(list);
			
			model.put("form", form);
		} catch (Exception e) {
			form.setMsg(exMsg(e));
			forwardString = "msg";
		}
		return new ModelAndView(forwardString, model);
	}

	@RequestMapping(value = "/form/manager", headers = "Accept=application/json")
	@ResponseBody
	public PStructureTypePropForm manager(PStructureTypePropForm form) throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		try {
			PStructureType type = form.getStructureType();
			PStructureTypeProp typeProp = form.getStructureTypeProp();
			condition.put("name", "%"+ typeProp.getName() +"%");
			condition.put("code", "%"+ typeProp.getCode() +"%");
			condition.put("structureType_id", type.getId());
			condition.put("structureTypePropClassify_id", form.getStructureTypeProp().getStructureTypePropClassify().getId());
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			
			form.setiTotalDisplayRecords(this.structureTypePropService.getCount(condition));
			form.setiTotalRecords(form.getiTotalDisplayRecords());
			List<PStructureTypeProp> propList = new ArrayList<PStructureTypeProp>();
			if (form.getiTotalDisplayRecords() > 0) {
				propList = this.structureTypePropService.getPagingList(
						condition, "", form.getiDisplayLength(),
						form.getiDisplayStart());
			}
			form.setAaData(propList);
		} catch (Exception e) {
			form.setMsg(exMsg(e));
		}
		return form;
	}

	@RequestMapping(value = "/form/edit")
	public ModelAndView edit(PStructureTypePropForm form) throws Exception {
		String forwardString = "product/structureTypeProp/edit";
		PStructureType type = form.getStructureType();
		PStructureTypeProp typeProp = form.getStructureTypeProp();
		
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> condition = form.getCondition();
		try {
			form.setDicDisplay(DicCache.getDicData(DicConstants.DIC_DISPLAY));
			form.setDicMust(DicCache.getDicData(DicConstants.DIC_MUST));
			
			condition.put("structureType_id", type.getId());
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			List<PStructureTypePropClassify> list = this.structureTypePropClassifyService.getList(condition);
			form.setClassifyList(list);
			
			if (!Strings.isNullOrEmpty(typeProp.getId())) {
				typeProp = this.structureTypePropService.getPStructureTypeProp(typeProp.getId());
				form.setStructureTypeProp(typeProp);
			}
			
		} catch (Exception e) {
			form.setMsg(exMsg(e));
		}
		model.put("form", form);
		return new ModelAndView(forwardString, model);
	}

	@RequestMapping(value = "/form/editSubmit")
	@ResponseBody
	public PStructureTypePropForm editSubmit(PStructureTypePropForm form) throws Exception {
		try {
			PStructureType type = form.getStructureType();
			PStructureTypeProp typeProp = form.getStructureTypeProp();
			typeProp.setStructureType(type);
			
			if (Strings.isNullOrEmpty(typeProp.getId())) {
				this.structureTypePropService.addPStructureTypeProp(typeProp, null);
				form.setMsg("新增产品结构类型属性成功!");
			} else {
				this.structureTypePropService.updatePStructureTypeProp(typeProp, null, null);
				form.setMsg("修改产品结构类型属性成功！");
			}
			
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setMsg("新增产品结构类型属性失败!");
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}

	@RequestMapping(value = "/form/delete")
	@ResponseBody
	public PStructureTypePropForm delete(PStructureTypePropForm form) throws Exception {
		try {
			PStructureTypeProp typeProp = form.getStructureTypeProp();
			this.structureTypePropService.falseDel(typeProp);
			form.setMsg("注销数据成功！");
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}

	@RequestMapping(value = "/form/orderUnique")
	@ResponseBody
	public PStructureTypePropForm orderUnique(PStructureTypePropForm form)
			throws Exception {
		try {
			String id = request.getParameter("id");
			String tid = request.getParameter("tid");
			if (this.structureTypePropService.orderUnique(id, form.getOrder(), tid)) {
				form.setIsSuccess(SUCCESS);
				form.setMsg("通过验证");
			} else {
				form.setIsSuccess(FAILURE);
				form.setMsg("已存在相同order值");
			}
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}

}