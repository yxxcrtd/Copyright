package cn.digitalpublishing.springmvc.controller.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.PStructureType;
import cn.digitalpublishing.po.PStructureTypePropClassify;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.product.PStructureTypePropClassifyForm;
import cn.digitalpublishing.util.DicCache;
import com.google.common.base.Strings;

@Controller
@RequestMapping("/pages/product/structureTypePropClassify")
public class PStructureTypePropClassifyController extends BaseController {

	public Logger log = Logger.getLogger(this.getClass());

	@RequestMapping(value = "/form/index")
	public ModelAndView index(PStructureTypePropClassifyForm form) throws Exception {
		String forwardString = "product/structureTypePropClassify/list";
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("form", form);
		return new ModelAndView(forwardString, model);
	}

	@RequestMapping(value = "/form/manager", headers = "Accept=application/json")
	@ResponseBody
	public PStructureTypePropClassifyForm manager(PStructureTypePropClassifyForm form) throws Exception {
		PStructureTypePropClassify classify = form.getStructureTypePropClassify();
		PStructureType type = form.getStructureType();
		Map<String, Object> condition = new HashMap<String, Object>();
		try {
			if (!Strings.isNullOrEmpty(classify.getCode())) {
				condition.put("code", classify.getCode());
			}
			if (!Strings.isNullOrEmpty(classify.getName())) {
				condition.put("name", classify.getName());
			}
			condition.put("structureType_id", type.getId());
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			form.setiTotalDisplayRecords(this.structureTypePropClassifyService.getCount(condition));
			form.setiTotalRecords(form.getiTotalDisplayRecords());
			List<PStructureTypePropClassify> classifyList = new ArrayList<PStructureTypePropClassify>();
			if (form.getiTotalDisplayRecords() > 0) {
				classifyList = this.structureTypePropClassifyService
						.getPagingList(condition, " order by a.order",
								form.getiDisplayLength(),
								form.getiDisplayStart());
			}
			form.setAaData(classifyList);
		} catch (Exception e) {
			form.setMsg(exMsg(e));
		}
		return form;
	}

	@RequestMapping(value = "/form/edit")
	public ModelAndView edit(PStructureTypePropClassifyForm form) throws Exception {
		PStructureTypePropClassify classify = form.getStructureTypePropClassify();
		PStructureType type = form.getStructureType();
		String forwardString = "product/structureTypePropClassify/edit";
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Map<String, Object> condition = form.getCondition();
			condition.put("structureType_id", type.getId());
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			
			if (!Strings.isNullOrEmpty(classify.getId())) {
				classify = this.structureTypePropClassifyService.getPStructureTypePropClassify(classify.getId());
				form.setStructureTypePropClassify(classify);
				
				condition.put("not_contain_id", classify.getId());
			}
			
			List<PStructureTypePropClassify> list = this.structureTypePropClassifyService.getList(condition);
			form.setClassifyList(list);
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		model.put("form", form);
		return new ModelAndView(forwardString, model);
	}

	@RequestMapping(value = "/form/editSubmit")
	@ResponseBody
	public PStructureTypePropClassifyForm editSubmit(PStructureTypePropClassifyForm form) throws Exception {
		try {
			PStructureTypePropClassify classify = form.getStructureTypePropClassify();
			if (Strings.isNullOrEmpty(classify.getParentClassify().getId())) {
				classify.setParentClassify(null);
			}
			if (Strings.isNullOrEmpty(classify.getId())) {
				classify.setStructureType(form.getStructureType());
				this.structureTypePropClassifyService.insertPStructureTypePropClassify(classify);
				form.setMsg("新增属性分类成功！");
			} else {
				String[] prop = null;
				if (classify.getParentClassify() == null) {
					prop = new String[] {"parentClassify"};
				}
				this.structureTypePropClassifyService.updatePStructureTypePropClassify(classify, null, prop);
				form.setMsg("修改属性分类成功！");
			}
			
			// PStructureTypePropClassify obj = form.getClassify();
			// if (!form.getParentClass().equals("0")) {
			// PStructureTypePropClassify typePropClassify = new
			// PStructureTypePropClassify();
			// typePropClassify.setId(form.getParentClass());
			// obj.setParentClassify(typePropClassify);
			// }
			// 修改
			// if (!Strings.isNullOrEmpty(form.getId())) {
			// this.structureTypePropClassifyService.updatePStructureTypePropClassify(obj, form.getId(), null);
			// form.setMsg("修改属性分类成功！");
			// } else if (!Strings.isNullOrEmpty(form.getTid())) {
			// PStructureType crmCropType = new PStructureType();
			// crmCropType.setId(form.getTid());
			// // obj.setStructureType(crmCropType);
			// // obj.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS,
			// DicConstants.DATA_STATUS_AVAILABLE));
			// this.structureTypePropClassifyService.insertPStructureTypePropClassify(obj);
			// form.setMsg("新增属性分类成功!");
			// }
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
			e.printStackTrace();
		}
		return form;
	}

	@RequestMapping(value = "/form/delete")
	@ResponseBody
	public PStructureTypePropClassifyForm delete(PStructureTypePropClassifyForm form) throws Exception {
		Map<String, Object> condition = form.getCondition();
		try {
			PStructureTypePropClassify classify = form.getStructureTypePropClassify();
			condition.put("structureTypePropClassify_id", classify.getId());
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			// 已经被使用的不可删除
			if (this.structureTypePropService.getCount(condition) != 0) {
				form.setMsg("该类型已经被使用，不可删除！");
				form.setIsSuccess(FAILURE);
			} else {
				this.structureTypePropClassifyService.deletePStructureTypePropClassify(classify);
				form.setMsg("注销数据成功！");
				form.setIsSuccess(SUCCESS);
			}
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}

	@RequestMapping(value = "/form/orderUnique")
	@ResponseBody
	public PStructureTypePropClassifyForm orderUnique(PStructureTypePropClassifyForm form) throws Exception {
		try {
			String id = request.getParameter("id");
			String tid = request.getParameter("tid");
			// if (this.structureTypePropClassifyService.orderUnique(id,
			// form.getOrder(), tid)) {
			// form.setIsSuccess(SUCCESS);
			// form.setMsg("通过验证");
			// } else {
			// form.setIsSuccess(FAILURE);
			// form.setMsg("已存在相同order值");
			// }
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}
}