package cn.digitalpublishing.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.model.Param;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.CrmPersonType;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.CrmPersonTypeForm;
import cn.digitalpublishing.util.DicCache;
import cn.digitalpublishing.util.TreeNode;
import cn.digitalpublishing.util.io.FileUtil;
import cn.digitalpublishing.util.io.PathUtil;
import cn.digitalpublishing.util.io.UploadFileUtil;

import com.google.common.base.Strings;

@Controller
@RequestMapping("/pages/crm/personType")
public class CrmPersonTypeController extends BaseController{

	
	@RequestMapping(value="/form/index")
	public ModelAndView index(CrmPersonTypeForm form) throws Exception {
		String forwardString="crm/personType/list";
//		String forwardString="product/productType/list";
		Map<String,Object> model = new HashMap<String,Object>();
		try{
			model.put("form", form);
		}catch(Exception e){
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
			forwardString = "msg";
		}
		return new ModelAndView(forwardString, model);
	}
	
	@RequestMapping(value="/form/manager", headers="Accept=application/json")
	@ResponseBody
	public CrmPersonTypeForm manager(CrmPersonTypeForm form)throws Exception {
		
		Map<String,Object> condition = form.getCondition();
		List<CrmPersonType> personTypeList = new ArrayList<CrmPersonType>();
		try{
			if(!Strings.isNullOrEmpty(form.getCode())){
				condition.put("code", form.getCode());
			}
			if(!Strings.isNullOrEmpty(form.getName())){
				condition.put("name", form.getName());
			}
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			form.setiTotalDisplayRecords(this.crmPersonTypeService.getCount(condition,""));
			form.setiTotalRecords(form.getiTotalDisplayRecords());
			
			if(form.getiTotalRecords()>0)
			{
				personTypeList = this.crmPersonTypeService.getPagingList(condition,"",form.getiDisplayLength(), form.getiDisplayStart());
			}
			
			form.setAaData(personTypeList);
		}catch(Exception e){
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
	@RequestMapping(value="/form/edit")
	public ModelAndView edit(CrmPersonTypeForm form)throws Exception {
		String forwardString="crm/personType/edit"; 
		Map<String,Object> model = new HashMap<String,Object>();
		try{
			//修改
			String id = request.getParameter("id");
			if(!Strings.isNullOrEmpty(id)){
				form.setId(id);
				CrmPersonType personType = this.crmPersonTypeService.getCrmPersonType(id);
				form.setCrmPersonType(personType);
			}
		}catch(Exception e){
			form.setMsg("获取数据出错！");
		}
		model.put("form", form);
		return new ModelAndView(forwardString, model);
	}
	
	@RequestMapping(value="/form/editSubmit")
	@ResponseBody
	public CrmPersonTypeForm editSubmit(CrmPersonTypeForm form)throws Exception {
		try{
			CrmPersonType obj = form.getCrmPersonType();
		//修改
		if(!Strings.isNullOrEmpty(form.getId())){
			this.crmPersonTypeService.updateCrmPersonType(obj, form.getId(), null);
			form.setMsg("修改人员类型信息成功！");
		}else{
			CrmPersonType crmPersonType = new CrmPersonType();
			//crmPersonType.setId(form.getFatherId());
			crmPersonType.setCode(obj.getCode());
			crmPersonType.setName(obj.getName());
			crmPersonType.setInternationCode(obj.getInternationCode());
			crmPersonType.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			this.crmPersonTypeService.insertCrmPersonType(crmPersonType);
			TreeNode node = new TreeNode(obj.getId(), obj.getName(), false, false, null);
			form.setNode(node);
			form.setMsg("新增人员类型信息成功!");
		}
		form.setIsSuccess(SUCCESS);
		}catch(Exception e){
			form.setMsg("新增人员类型信息出错！");
			form.setIsSuccess(FAILURE);
			e.printStackTrace();
		}
		return form;
	}
	
	@RequestMapping(value = "/form/delete")
	@ResponseBody
	public CrmPersonTypeForm delete(CrmPersonTypeForm form) throws Exception {
		CrmPersonType crmPersonType = new CrmPersonType();
		crmPersonType.setId(form.getId());
		crmPersonType.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE));
		try {
			this.crmPersonTypeService.deletetCrmPersonType(crmPersonType);
			form.setIsSuccess(SUCCESS);
			form.setMsg("注销成功 ！");
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
	@RequestMapping(value="/form/codeUnique")
	@ResponseBody
	public CrmPersonTypeForm codeUnique(CrmPersonTypeForm form) throws Exception {
		try{
			String id = request.getParameter("id");
			if(this.crmPersonTypeService.codeUnique(id, form.getCode())) {
				form.setIsSuccess(SUCCESS);
				form.setMsg("通过验证");
			} else {
				form.setIsSuccess(FAILURE);
				form.setMsg("已存在相同编号");
			}
		}catch(Exception e){
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}

    @RequestMapping(value = "/form/upload")
    public ModelAndView upload(HttpServletRequest request, HttpServletResponse response, CrmPersonTypeForm form) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        String forwardString = "crm/personType/upload";
        try {
            String personTypeId = request.getParameter("id");
            form.setCode(personTypeId);
            model.put("form", form);
        } catch (Exception e) {
            form.setIsSuccess(FAILURE);
            form.setMsg((e instanceof CcsException) ? ((CcsException) e).getPrompt() : e.getMessage());
            forwardString = "msg";
        }
        return new ModelAndView(forwardString, model);
    }

    @RequestMapping(value = "/form/uploadSubmit")
    @ResponseBody
    public CrmPersonTypeForm uploadSubmit(HttpServletRequest request, HttpServletResponse response, CrmPersonTypeForm form) throws Exception {
        try {
            String personTypeId = form.getCode();
            if (form.getTxtFile() != null && form.getTxtFile().getSize() != 0) {
                String txtFileName = form.getTxtFile().getOriginalFilename();
                String txtFormat = txtFileName.substring(txtFileName.indexOf(".") + 1);
                if (form.getTxtFormat().toLowerCase().indexOf(txtFormat.toLowerCase()) == -1) {
                    throw new CcsException("上传格式不正确，请上传xls或xlsx");
                }
                this.crmPersonTypeService.upload(personTypeId, form.getTxtFile().getInputStream());
            }
            form.setTxtFile(null);
            form.setIsSuccess(SUCCESS);
            form.setMsg("上传成功!");
        } catch (Exception e) {
            form.setTxtFile(null);
            form.setIsSuccess(FAILURE);
            form.setMsg((e instanceof CcsException) ? ((CcsException) e).getPrompt() : e.getMessage());
        }
        return form;
    }
}
