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
import cn.digitalpublishing.po.CrmPeTpClassify;
import cn.digitalpublishing.po.CrmPeTypeProp;
import cn.digitalpublishing.po.CrmPersonProp;
import cn.digitalpublishing.po.CrmPersonType;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.CrmPeTypePropForm;
import cn.digitalpublishing.util.DicCache;

import com.google.common.base.Strings;

@Controller
@RequestMapping("/pages/crm/personTypeProp")
public class CrmPeTypePropController extends BaseController{

	@RequestMapping(value="/form/index")
	public ModelAndView index(CrmPeTypePropForm form) throws Exception {
		String forwardString="crm/personTypeProp/list";
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
	public CrmPeTypePropForm manager(CrmPeTypePropForm form)throws Exception {
		Map<String,Object> condition = new HashMap<String,Object>();
		try{
			condition.put("name", form.getName());
			condition.put("code", form.getCode());
			condition.put("tid",form.getTid() );
			condition.put("status",DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			form.setiTotalDisplayRecords(this.crmPeTypePropService.getCount(condition));
			 form.setiTotalRecords(form.getiTotalDisplayRecords());
			 List<CrmPeTypeProp> propList = new ArrayList<CrmPeTypeProp>();
			 if(form.getiTotalDisplayRecords() > 0){
				 propList = this.crmPeTypePropService.getPagingList(condition,"",form.getiDisplayLength(), form.getiDisplayStart());
			 }
			form.setAaData(propList);
			form.setTid(request.getParameter("tid"));
		}catch(Exception e){
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
	@RequestMapping(value="/form/edit")
	public ModelAndView edit(CrmPeTypePropForm form)throws Exception {
		String forwardString="crm/personTypeProp/edit"; 
		Map<String,Object> model = new HashMap<String,Object>();
		Map<String,Object> condition = new HashMap<String,Object>();
		try{
			form.setDisplay(DicCache.getDicData(DicConstants.DIC_DISPLAY));
			form.setMust(DicCache.getDicData(DicConstants.DIC_MUST));
			if(form.getTid() != null){
				condition.put("tid",form.getTid() );
				condition.put("status",DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
				List<CrmPeTpClassify> classifyList = this.crmPeTpClassifyService.getList(condition);
				form.setCrmPeTpClassifyList(classifyList);
				//修改
				if(request.getParameter("id") != null){
					String id = request.getParameter("id");
					form.setId(id);
					CrmPeTypeProp personTypeProp = this.crmPeTypePropService.getCrmPeTypeProp(id);
					form.setCrmPeTypeProp(personTypeProp);
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
	public CrmPeTypePropForm editSubmit(CrmPeTypePropForm form)throws Exception {
		try{
			CrmPeTypeProp personTypeProp = form.getCrmPeTypeProp();
			if("".equals(personTypeProp.getPersonTypePropClassify().getId()))
			{
				personTypeProp.setPersonTypePropClassify(null);
			}
		//修改
		if(!Strings.isNullOrEmpty(form.getId())){
			this.crmPeTypePropService.updateCrmPeTypeProp(personTypeProp, form.getId(), null);
			form.setMsg("修改产品类型属性成功！");
		}else if(!Strings.isNullOrEmpty(form.getTid())){
			//新增
			CrmPersonType crmPersonType = new CrmPersonType();
			crmPersonType.setId(form.getTid());
			personTypeProp.setPersonType(crmPersonType);
			personTypeProp.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			this.crmPeTypePropService.insertCrmPeTypeProp(personTypeProp);
			form.setMsg("新增产品类型属性成功!");
			//新增一个产品类型属性后，相应新增产品属性--piid为null
			CrmPersonProp personProp = new CrmPersonProp();
			personProp.setPersonTypeProp(personTypeProp);
			personProp.setCode(personTypeProp.getCode());
			personProp.setName(personTypeProp.getName());
			personProp.setDisplay(personTypeProp.getDisplay());
			personProp.setMust(personTypeProp.getMust());
			personProp.setOrder(personTypeProp.getOrder());
			personProp.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			this.crmPersonPropService.insertPersonProp(personProp);
		}
		form.setIsSuccess(SUCCESS);
		}catch(Exception e){
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
	@RequestMapping(value="/form/delete")
	@ResponseBody
	public CrmPeTypePropForm delete(CrmPeTypePropForm form)throws Exception {
		//Map<String,Object> condition = new HashMap<String,Object>();
		try {
			String id = request.getParameter("id");
			CrmPeTypeProp ptp = this.crmPeTypePropService.getCrmPeTypeProp(id);
			ptp.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE));
			this.crmPeTypePropService.deletetCrmPeTypeProp(ptp);
			//删除一个人员类型属性后，相应删除其相关联的 人员属性
//			condition.put("ptpid", id);
//			List<CrmPersonProp> personPropList = this.crmPersonPropService.getList(condition, "");
//			for(CrmPersonProp pp : personPropList){
//				pp.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE));
//				this.crmPersonPropService.deletetPersonProp(pp);
//			}
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
	public CrmPeTypePropForm orderUnique(CrmPeTypePropForm form) throws Exception {
		try{
			String id = request.getParameter("id");
			String tid = request.getParameter("tid");
			if(this.crmPeTypePropService.orderUnique(id, form.getOrder() ,tid)){
				form.setIsSuccess(SUCCESS);
				form.setMsg("通过验证");
			} else {
				form.setIsSuccess(FAILURE);
				form.setMsg("已存在相同order值");
			}
		}catch(Exception e){
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
}
