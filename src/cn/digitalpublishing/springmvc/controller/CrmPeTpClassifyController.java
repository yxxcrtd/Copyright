package cn.digitalpublishing.springmvc.controller;

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
import cn.digitalpublishing.po.CrmPeTpClassify;
import cn.digitalpublishing.po.CrmPersonType;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.CrmPeTpClassifyForm;
import cn.digitalpublishing.util.DicCache;

import com.google.common.base.Strings;

@Controller
@RequestMapping("/pages/crm/personTypeClassify")
public class CrmPeTpClassifyController extends BaseController {
	
	public Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = "/form/index")
	public ModelAndView index(CrmPeTpClassifyForm form) throws Exception {

		String forwardString = "crm/personTypeClassify/list";
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			form.setTid(request.getParameter("tid"));
			model.put("form", form);
		} catch (Exception e) {
			form.setMsg(exMsg(e));
			forwardString = "msg";
		}
		return new ModelAndView(forwardString, model);
	}
	
	@RequestMapping(value = "/form/manager", headers = "Accept=application/json")
	@ResponseBody
	public CrmPeTpClassifyForm manager(CrmPeTpClassifyForm form) throws Exception {

		Map<String, Object> condition = new HashMap<String, Object>();
		try {
			if (!Strings.isNullOrEmpty(form.getCode())) {
				condition.put("code", form.getCode());
			}
			if (!Strings.isNullOrEmpty(form.getName())) {
				condition.put("name", form.getName());
			}
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			condition.put("tid", form.getTid());
			form.setiTotalDisplayRecords(this.crmPeTpClassifyService.getCount(condition));
			form.setiTotalRecords(form.getiTotalDisplayRecords());
			List<CrmPeTpClassify> classifyList = new ArrayList<CrmPeTpClassify>();
			if (form.getiTotalDisplayRecords() > 0) {
				classifyList = this.crmPeTpClassifyService.getPagingList(condition, " order by a.order", form.getiDisplayLength(), form.getiDisplayStart());
			}
			form.setAaData(classifyList);
//			form.setClassList(classifyList);
		} catch (Exception e) {
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
	@RequestMapping(value = "/form/edit")
	public ModelAndView edit(CrmPeTpClassifyForm form) throws Exception {

		String forwardString = "crm/personTypeClassify/edit";
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String id = request.getParameter("id");
			// 修改
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("tid", form.getTid());
			form.setClassList(this.crmPeTpClassifyService.getList(condition));
			if (!Strings.isNullOrEmpty(id)) {
				form.setId(id);
				CrmPeTpClassify cla = this.crmPeTpClassifyService.getCrmPeTpClassify(id);
				form.setClassify(cla);
			}
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
			e.printStackTrace();
		}
		model.put("form", form);
		return new ModelAndView(forwardString, model);
	}
	
	@RequestMapping(value = "/form/editSubmit")
	@ResponseBody
	public CrmPeTpClassifyForm editSubmit(CrmPeTpClassifyForm form) throws Exception {
		try {
			CrmPeTpClassify obj = form.getClassify();
			if (!form.getParentClass().equals("0")) {
				CrmPeTpClassify typePropClassify = new CrmPeTpClassify();
				typePropClassify.setId(form.getParentClass());
				obj.setParentClassify(typePropClassify);
			}
			// 修改
			if (!Strings.isNullOrEmpty(form.getId())) {
				this.crmPeTpClassifyService.updateCrmPeTpClassify(obj, form.getId(), null);
				form.setMsg("修改属性分类成功！");
			} else if (!Strings.isNullOrEmpty(form.getTid())) {
				CrmPersonType crmPersonType = new CrmPersonType();
				crmPersonType.setId(form.getTid());
				obj.setPersonType(crmPersonType);
				obj.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
				this.crmPeTpClassifyService.insertCrmPeTpClassify(obj);
				form.setMsg("新增属性分类成功!");
			}
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
	public CrmPeTpClassifyForm delete(CrmPeTpClassifyForm form) throws Exception {

		Map<String, Object> condition = new HashMap<String, Object>();
		try {
			String id = request.getParameter("id");
			condition.put("cid", id);
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			// 已经被使用的不可删除
			if (this.crmPeTypePropService.getCount(condition) != 0) {
				form.setMsg("该类型已经被使用，不可删除！");
				form.setIsSuccess(FAILURE);
			} else {
				this.crmPeTpClassifyService.deleteCrmPeTpClassify(id);
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
	public CrmPeTpClassifyForm orderUnique(CrmPeTpClassifyForm form) throws Exception {

		try {
			String id = request.getParameter("id");
			String tid = request.getParameter("tid");
			if (this.crmPeTpClassifyService.orderUnique(id, form.getOrder(), tid)) {
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
