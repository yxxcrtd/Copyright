package cn.digitalpublishing.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.CrmCtpClassify;
import cn.digitalpublishing.po.CrmCtypeProp;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.CrmCtypePropForm;
import cn.digitalpublishing.util.DicCache;

import com.google.common.base.Strings;

@Controller
@RequestMapping("/pages/crm/corpTypeProp")
public class CrmCtypePropController extends BaseController{

	@RequestMapping(value="/form/index")
	public ModelAndView index(CrmCtypePropForm form) throws Exception {
		String forwardString="crm/corpTypeProp/list";
		Map<String,Object> model = new HashMap<String,Object>();
		try{
			form.setTid(request.getParameter("tid"));
			model.put("form", form);
		}catch(Exception e){
			form.setMsg(exMsg(e));
			forwardString = "msg";
		}
		return new ModelAndView(forwardString, model);
	}
	
	@RequestMapping(value="/form/manager", headers="Accept=application/json")
	@ResponseBody
	public CrmCtypePropForm manager(CrmCtypePropForm form)throws Exception {
		Map<String,Object> condition = new HashMap<String,Object>();
		try{
			condition.put("name", form.getName());
			condition.put("code", form.getCode());
			condition.put("tid",form.getTid() );
			condition.put("status",DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			form.setiTotalDisplayRecords(this.crmCtypePropService.getCount(condition));
			 form.setiTotalRecords(form.getiTotalDisplayRecords());
			 List<CrmCtypeProp> propList = new ArrayList<CrmCtypeProp>();
			 if(form.getiTotalDisplayRecords() > 0){
				 propList = this.crmCtypePropService.getPagingList(condition,"",form.getiDisplayLength(), form.getiDisplayStart());
			 }
			form.setAaData(propList);
			form.setTid(request.getParameter("tid"));
		}catch(Exception e){
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
	@RequestMapping(value="/form/edit")
	public ModelAndView edit(CrmCtypePropForm form)throws Exception {
		String forwardString="crm/corpTypeProp/edit"; 
		Map<String,Object> model = new HashMap<String,Object>();
		Map<String,Object> condition = new HashMap<String,Object>();
		try{
			form.setDisplay(DicCache.getDicData(DicConstants.DIC_DISPLAY));
			form.setMust(DicCache.getDicData(DicConstants.DIC_MUST));
			if(form.getTid() != null){
				condition.put("tid",form.getTid() );
				condition.put("status",DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
				List<CrmCtpClassify> classifyList = this.crmCtpClassifyService.getList(condition);
				form.setCrmCtpClassifyList(classifyList);
				//修改
				if(request.getParameter("id") != null){
					String id = request.getParameter("id");
					form.setId(id);
					CrmCtypeProp corpTypeProp = this.crmCtypePropService.getCrmCtypeProp(id);
					form.setCrmCtypeProp(corpTypeProp);
				}
			}
		}catch(Exception e){
			form.setMsg(exMsg(e));
		}
		model.put("form", form);
		return new ModelAndView(forwardString, model);
	}
	
	@RequestMapping(value="/form/editSubmit")
	@ResponseBody
	public CrmCtypePropForm editSubmit(CrmCtypePropForm form)throws Exception {
		try{
			CrmCtypeProp corpTypeProp = form.getCrmCtypeProp();
			String classifyId = request.getParameter("crmCtypeProp.corpTypePropClassify.id");
			if(classifyId != null  && !"".equals(classifyId)){
				CrmCtpClassify classify = new CrmCtpClassify();
				classify.setId(classifyId);
				corpTypeProp.setCorpTypePropClassify(classify);
				
				//修改
				if(!Strings.isNullOrEmpty(form.getId())){
					this.crmCtypePropService.updateCrmCtypeProp(corpTypeProp, form.getId(), null);
					form.setMsg("修改产品类型属性成功！");
				}else if(!Strings.isNullOrEmpty(form.getTid())){
					//新增
					this.crmCtypePropService.addCrmCtypeProp(corpTypeProp, form.getTid());
					form.setMsg("新增产品类型属性成功!");
				}
				form.setIsSuccess(SUCCESS);
			} else {
				form.setIsSuccess(FAILURE);
				form.setMsg("新增产品类型属性失败!");
			}
			
			
		}catch(Exception e){
			form.setMsg("新增产品类型属性失败!");
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
	@RequestMapping(value="/form/delete")
	@ResponseBody
	public CrmCtypePropForm delete(CrmCtypePropForm form)throws Exception {
		try {
			this.crmCtypePropService.falseDel(request.getParameter("id"));
			form.setMsg("注销数据成功！");
			form.setIsSuccess(SUCCESS);
		}catch(Exception e){
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
	@RequestMapping(value="/form/orderUnique")
	@ResponseBody
	public CrmCtypePropForm orderUnique(CrmCtypePropForm form) throws Exception {
		try{
			String id = request.getParameter("id");
			String tid = request.getParameter("tid");
			if(this.crmCtypePropService.orderUnique(id, form.getOrder() ,tid)){
				form.setIsSuccess(SUCCESS);
				form.setMsg("通过验证");
			} else {
				form.setIsSuccess(FAILURE);
				form.setMsg("已存在相同排序");
			}
		}catch(Exception e){
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
}
