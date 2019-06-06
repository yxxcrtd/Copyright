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
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.CrmCorpType;
import cn.digitalpublishing.springmvc.form.CrmCorpTypeForm;
import cn.digitalpublishing.util.DicCache;

import com.google.common.base.Strings;

@Controller
@RequestMapping("/pages/crm/corpType")
public class CrmCorpTypeController extends BaseController {

	@RequestMapping(value = "/form/index")
	public ModelAndView index(CrmCorpTypeForm form) {
		String forwardString = "crm/corpType/list";
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
	
	@RequestMapping(value = "/form/manager", headers = "Accept=application/json")
	@ResponseBody
	public CrmCorpTypeForm manage(CrmCorpTypeForm form) {
		Map<String,Object> condition = form.getCondition();
		List<CrmCorpType> corpTypeList = new ArrayList<CrmCorpType>();
		try{
			 if(!Strings.isNullOrEmpty(form.getCode())){
			 condition.put("code","%"+form.getCode()+"%");
			 }
			 if(!Strings.isNullOrEmpty(form.getName())){
			 condition.put("name","%"+form.getName()+"%");
			 }
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			form.setiTotalDisplayRecords(this.crmCorpTypeService.getCorpTypeCount(condition));
			form.setiTotalRecords(form.getiTotalDisplayRecords());
			
			if(form.getiTotalRecords()>0)
			{
				corpTypeList = this.crmCorpTypeService.getCorpTypePagingList(condition,"",form.getiDisplayLength(), form.getiDisplayStart());
			}
			
			form.setAaData(corpTypeList);
		}catch(Exception e){
			form.setMsg(exMsg(e));
		}
		return form;
	}

	@RequestMapping(value = "/form/edit")
	public ModelAndView edit(CrmCorpTypeForm form) {
		String forwardString = "crm/corpType/edit";
		Map<String, Object> model = new HashMap<String, Object>();
		 try{
			 //修改
			 String id = request.getParameter("id");
			 if(!Strings.isNullOrEmpty(id)){
				 form.setId(id);
				 form.setCrmCorpType(this.crmCorpTypeService.getCorpType(id));
			 }
		 }catch(Exception e){
			 form.setMsg("获取数据出错！");
		 }
		 model.put("form", form);
		return new ModelAndView(forwardString, model);
	}

	@RequestMapping(value = "/form/editSubmit")
	@ResponseBody
	public CrmCorpTypeForm editSubmit(CrmCorpTypeForm form) {
		try{
			CrmCorpType obj = form.getCrmCorpType();
			//修改
			if(!Strings.isNullOrEmpty(form.getId())){
				this.crmCorpTypeService.updateCorpType(obj, form.getId(), null);
				form.setMsg("修改公司类型信息成功！");
			}else{
				CrmCorpType crmCorpType = new CrmCorpType();
				crmCorpType.setCode(obj.getCode());
				crmCorpType.setName(obj.getName());
				crmCorpType.setInternationCode(obj.getInternationCode());
				crmCorpType.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
				this.crmCorpTypeService.insertCorpType(crmCorpType);
				form.setMsg("新增公司类型信息成功!");
			}
			form.setIsSuccess(SUCCESS);
		}catch(Exception e){
			form.setMsg("新增公司类型信息出错！");
			form.setIsSuccess(FAILURE);
			e.printStackTrace();
		}
		return form;
	}

	/**
	 * 删除公司代码
	 * 
	 * @param request
	 * @param response
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/form/delete")
	@ResponseBody
	public CrmCorpTypeForm delete(CrmCorpTypeForm form) {
	
		try {
			this.crmCorpTypeService.falseDel(form.getId());
			form.setIsSuccess(SUCCESS);
			form.setMsg("注销成功 ！");
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}

	/**
	 * 检查公司代码是否存在
	 * 
	 * @param request
	 * @param response
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/form/checkCodeExists")
	@ResponseBody
	public CrmCorpTypeForm checkCodeExists(CrmCorpTypeForm form) {
		 try{
			 String id = request.getParameter("id");
			 if(this.crmCorpTypeService.codeUnique(id, form.getCode())) {
				 form.setIsSuccess(SUCCESS);
				 form.setMsg("通过验证");
			 } else {
				 form.setIsSuccess(FAILURE);
				 form.setMsg("已存在相同编号");
			 }
		 }catch(Exception e){
			 form.setIsSuccess(FAILURE);
			// form.setMsg( (e instanceof CcsException) ? ((CcsException)e).getMessage() :e.getMessage());
			 form.setMsg(exMsg(e));
		 }
		return form;
	}

    @RequestMapping(value = "/form/upload")
    public ModelAndView upload(HttpServletRequest request, HttpServletResponse response, CrmCorpTypeForm form) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        String forwardString = "crm/corpType/upload";
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
    public CrmCorpTypeForm uploadSubmit(HttpServletRequest request, HttpServletResponse response, CrmCorpTypeForm form) throws Exception {
        try {
            String personTypeId = form.getCode();
            if (form.getTxtFile() != null && form.getTxtFile().getSize() != 0) {
                String txtFileName = form.getTxtFile().getOriginalFilename();
                String txtFormat = txtFileName.substring(txtFileName.indexOf(".") + 1);
                
                if (form.getTxtFormat().toLowerCase().indexOf(txtFormat.toLowerCase()) == -1) {
                    throw new CcsException("上传格式不正确，请上传xls或xlsx");
                }
                this.crmCorpTypeService.upload(personTypeId, form.getTxtFile().getInputStream());
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