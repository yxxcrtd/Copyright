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
import cn.digitalpublishing.po.CrmCorpType;
import cn.digitalpublishing.po.CrmCtpClassify;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.CrmCtpClassifyForm;
import cn.digitalpublishing.util.DicCache;

import com.google.common.base.Strings;

@Controller
@RequestMapping("/pages/crm/corpTypePropClassify")
public class CrmCtpClassifyController extends BaseController {
	
	public Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = "/form/index")
	public ModelAndView index(CrmCtpClassifyForm form) throws Exception {
		String forwardString = "crm/corpTypePropClassify/list";
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
	public CrmCtpClassifyForm manager(CrmCtpClassifyForm form) throws Exception {

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
			form.setiTotalDisplayRecords(this.crmCtpClassifyService.getCount(condition));
			form.setiTotalRecords(form.getiTotalDisplayRecords());
			List<CrmCtpClassify> classifyList = new ArrayList<CrmCtpClassify>();
			if (form.getiTotalDisplayRecords() > 0) {
				classifyList = this.crmCtpClassifyService.getPagingList(condition, " order by a.order", form.getiDisplayLength(), form.getiDisplayStart());
			}
			form.setAaData(classifyList);
		} catch (Exception e) {
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
	@RequestMapping(value = "/form/edit")
	public ModelAndView edit(CrmCtpClassifyForm form) throws Exception {

		String forwardString = "crm/corpTypePropClassify/edit";
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String id = request.getParameter("id");
			// 修改
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("tid", form.getTid());
			form.setClassList(this.crmCtpClassifyService.getList(condition));
			if (!Strings.isNullOrEmpty(id)) {
				form.setId(id);
				CrmCtpClassify cla = this.crmCtpClassifyService.getCrmCtpClassify(id);
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
	public CrmCtpClassifyForm editSubmit(CrmCtpClassifyForm form) throws Exception {

		try {
			CrmCtpClassify obj = form.getClassify();
			if (!form.getParentClass().equals("0")) {
				CrmCtpClassify typePropClassify = new CrmCtpClassify();
				typePropClassify.setId(form.getParentClass());
				obj.setParentClassify(typePropClassify);
			}
			// 修改
			if (!Strings.isNullOrEmpty(form.getId())) {
				this.crmCtpClassifyService.updateCrmCtpClassify(obj, form.getId(), null);
				form.setMsg("修改属性分类成功！");
			} else if (!Strings.isNullOrEmpty(form.getTid())) {
				CrmCorpType crmCropType = new CrmCorpType();
				crmCropType.setId(form.getTid());
				obj.setCorpType(crmCropType);
				obj.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
				this.crmCtpClassifyService.insertCrmCtpClassify(obj);
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
	public CrmCtpClassifyForm delete(CrmCtpClassifyForm form) throws Exception {

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
				this.crmCtpClassifyService.deleteCrmCtpClassify(id);
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
	public CrmCtpClassifyForm orderUnique(CrmCtpClassifyForm form) throws Exception {

		try {
			String id = request.getParameter("id");
			String tid = request.getParameter("tid");
			if (this.crmCtpClassifyService.orderUnique(id, form.getOrder(), tid)) {
				form.setIsSuccess(SUCCESS);
				form.setMsg("通过验证");
			} else {
				form.setIsSuccess(FAILURE);
				form.setMsg("已存在相同序列");
			}
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
}
