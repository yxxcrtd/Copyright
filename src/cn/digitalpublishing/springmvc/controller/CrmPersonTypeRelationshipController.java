package cn.digitalpublishing.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.model.Param;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.CrmPerson;
import cn.digitalpublishing.po.CrmPersonType;
import cn.digitalpublishing.po.CrmPersonTypeRelationship;
import cn.digitalpublishing.po.SysAccount;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.CrmPersonTypeRelationshipForm;
import cn.digitalpublishing.util.AutocompletePerson;
import cn.digitalpublishing.util.DicCache;
import cn.digitalpublishing.util.io.FileUtil;
import cn.digitalpublishing.util.io.PathUtil;
import cn.digitalpublishing.util.io.UploadFileUtil;

import com.google.common.base.Strings;
//import weibo4j.Account;


@Controller
@RequestMapping("/pages/crm/personInfo")
public class CrmPersonTypeRelationshipController extends BaseController {

	@RequestMapping(value = "/form/index/{code}")
	public ModelAndView index(@PathVariable String code, CrmPersonTypeRelationshipForm form) throws Exception {

		String forwardString = "crm/personInfo/list";
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			form.setCode(code);
			CrmPersonType personType = this.crmPersonTypeService.getCrmPersonTypeByCode(code);
			CrmPersonType crmPersonType = this.crmPersonTypeService.getCrmPersonType(personType.getId());
			form.setPersonType(crmPersonType);
			model.put("form", form);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
			forwardString = "msg";
		}

		return new ModelAndView(forwardString, model);
	}
	
	@RequestMapping(value="/form/manager", headers="Accept=application/json")
	@ResponseBody
	public CrmPersonTypeRelationshipForm manager(CrmPersonTypeRelationshipForm form)throws Exception {
		Map<String,Object> condition = form.getCondition();
		try{
			if(!Strings.isNullOrEmpty(form.getName())){
				condition.put("name","%"+form.getName().trim()+"%");
			}
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			condition.put("code", form.getCode());
            condition.put("corpId", form.getCorpId());
			String productId = form.getProductId();
			if(productId != null && !productId.isEmpty()){
				condition.put("productId", productId);
			}
			String proposalId = form.getProposalId();
			if(proposalId != null && !proposalId.isEmpty()){
				condition.put("proposalId", proposalId);
			}
			
			String proposalAuthorId = form.getProposalAuthorId();
			if(proposalAuthorId != null && !proposalAuthorId.isEmpty()){
				condition.put("proposalAuthorId", proposalAuthorId);
			}
			
			form.setiTotalDisplayRecords(this.crmPersonTypeRelationshipService.getCount(condition,""));
			form.setiTotalRecords(form.getiTotalDisplayRecords());
			if(form.getiTotalRecords()>0)
			{
				List<CrmPersonTypeRelationship> pagingList = this.crmPersonTypeRelationshipService.getPagingList(condition,"",form.getiDisplayLength(), form.getiDisplayStart());
				form.setAaData(pagingList);
			} else {
				form.setAaData(new ArrayList<CrmPersonTypeRelationship>());
			}
			
		}catch(Exception e){
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
	@RequestMapping(value="/form/edit/{code}")
	public ModelAndView edit(@PathVariable String code, CrmPersonTypeRelationshipForm form)throws Exception {
		CrmPersonType peType = form.getPersonType();
		String forwardString="crm/personInfo/edit"; 
		Map<String,Object> model = new HashMap<String,Object>();
		try{
		//新建三种人员类型页面显示不同信息
			CrmPersonType personType = this.crmPersonTypeService.getCrmPersonTypeByCode(code);
			CrmPersonType crmPersonType = this.crmPersonTypeService.getCrmPersonType(personType.getId());
			form.setPersonType(crmPersonType);
		//修改
		form.setCode(code);
		String id = request.getParameter("id");
		CrmPersonTypeRelationship crmPersonTypeRelationship = new CrmPersonTypeRelationship();
		if(!Strings.isNullOrEmpty(id)){
			form.setId(id);
			crmPersonTypeRelationship = this.crmPersonTypeRelationshipService.getCrmPersonTypeRelationship(id);
			form.setRelation(crmPersonTypeRelationship);
			if (form.getCode().equals("employee")) {
				if(crmPersonTypeRelationship.getPerson().getCrmCorpTypeRelationship() != null){
					form.setCorpName(crmPersonTypeRelationship.getPerson().getCrmCorpTypeRelationship().getCorp().getShortName());
				}
			}
			CrmPerson person = this.crmPersonService.getCrmPerson(crmPersonTypeRelationship.getPerson().getId());
			form.setObj(person);
		}else {
			form.setAvailablePersonList(crmPersonService.getAvailablePersonCode(personType));
		}
		form.setIsSuccess(SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			form.setIsSuccess(FAILURE);
			form.setMsg("获取数据出错！");
			
		}
		
		model.put("form", form);
		return new ModelAndView(forwardString, model);
	}
	
	@RequestMapping(value="/form/editSubmit")
	@ResponseBody
	public CrmPersonTypeRelationshipForm editSubmit(CrmPersonTypeRelationshipForm form)throws Exception {
		try{
			form.setPersonType(this.crmPersonTypeService.getCrmPersonTypeByCode(form.getCode()));
			CrmPerson obj = form.getObj();
		//修改
			
		CrmPerson crmPerson = new CrmPerson();
		
		if(!Strings.isNullOrEmpty(form.getId())){
			this.crmPersonService.updateCrmPerson(obj, obj.getId(), null);
			form.setMsg("修改人员类型信息成功！");
			form.setIsSuccess(SUCCESS);
		}else{
			String personId = obj.getId();
			if(!Strings.isNullOrEmpty(personId)){
				crmPerson.setId(personId);
			}else{
				
				Map<String, Object> accountInfo = (Map<String, Object>) session.getAttribute("pt_accountInfo");
				String accountId = accountInfo.get("employeeId").toString();
				obj.setCreateBy(accountId);
				obj.setUpdateBy(accountId);
				obj.setCreateOn(new Date());
				obj.setUpdateOn(new Date());
				obj.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			}
			this.crmPersonTypeRelationshipService.insertCrmPersonTypeRelationship(form);
			
			form.setMsg("新增人员信息成功!");
			form.setIsSuccess(SUCCESS);
		}
		
		}catch(Exception e){
			form.setMsg("新增人员信息出错！");
			form.setIsSuccess(FAILURE);
			e.printStackTrace();
		}
		return form;
	}
	
	@RequestMapping(value = "/form/delete")
	@ResponseBody
	public CrmPersonTypeRelationshipForm delete(CrmPersonTypeRelationshipForm form) throws Exception {
		
		String id = request.getParameter("id");
		try {
			CrmPersonTypeRelationship crmPersonTypeRelationship = this.crmPersonTypeRelationshipService.getCrmPersonTypeRelationship(id);
			crmPersonTypeRelationship.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE));
			this.crmPersonTypeRelationshipService.delete(crmPersonTypeRelationship);
			
			String personType = crmPersonTypeRelationship.getPersonType().getCode();
			if(personType == "employee") {
				// 注销webgate账户信息，设置账户状态为停用
				SysAccount account = this.restsService.getAccount(crmPersonTypeRelationship.getId());
				account.setStatus(DicConstants.WEBGATE_ACCOUNT_STATUS_USELESS);
				this.restsService.updateAccount(account);
			}
			form.setIsSuccess(SUCCESS);
			form.setMsg("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		
		return form;
	}
	
	
	
	@RequestMapping(value = "/form/queryExistPerson")
	@ResponseBody
	public CrmPerson queryExistPerson(CrmPersonTypeRelationshipForm form) throws Exception {
		
		String code = request.getParameter("code");
		
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("code", code);
		CrmPerson crmPersonByCode = this.crmPersonService.getCrmPersonByCode(condition);
			
		return crmPersonByCode;
		
	}
	

	@RequestMapping(value = "/form/validatePersonCodeUnique")
	@ResponseBody
	public CrmPersonTypeRelationshipForm validatePersonCodeUnique(CrmPersonTypeRelationshipForm form) throws Exception {
		
		try {
			form.setPersonCodeIsAvailable(this.crmPersonService.checkCodeIsAvailable(form.getObj()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return form;
		
	}
	
	@RequestMapping(value = "/form/addTab")
	@ResponseBody
	public CrmPersonTypeRelationshipForm addTab(CrmPersonTypeRelationshipForm form) {
		try {
			form.setPersonType(this.crmPersonTypeService.getCrmPersonTypeByCode(form.getPersonType().getCode()));
			this.crmPersonTypeRelationshipService.addTab(form);
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			form.setIsSuccess(FAILURE);
		}
		
		return form;
	}
	
	@RequestMapping(value = "/form/upload")
	public ModelAndView upload(CrmPersonTypeRelationshipForm form) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        String forwardString = "crm/personInfo/upload";
        try {
            String personTypeId = request.getParameter("personTypeId");
            CrmPersonType personType = new CrmPersonType();
            personType.setId(personTypeId);
            form.setPersonType(personType);
            
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
    public CrmPersonTypeRelationshipForm uploadSubmit(CrmPersonTypeRelationshipForm form) throws Exception {
        try {
           // String relationId = form.getCode();
            String pathFileName = Param.getParam("upload.directory.config").get("account");
            String path = Param.getParam("ebmep.root.path").get("dir").replace("-", ":");
            FileUtil.newFolder(PathUtil.bulidFullPath(path, pathFileName));
            String marcPath = "";
            if (form.getTxtFile() != null && form.getTxtFile().getSize() != 0) {
                String txtFileName = form.getTxtFile().getOriginalFilename();
                String txtFormat = txtFileName.substring(txtFileName.indexOf(".") + 1);
                String newName = UploadFileUtil.createUploadFileName(txtFormat);
                marcPath = PathUtil.bulidFullPath(pathFileName, newName);
                if (form.getTxtFormat().toLowerCase().indexOf(txtFormat.toLowerCase()) == -1) {
                    throw new CcsException("上传格式不正确，请上传xls或xlsx");
                }
                // 将上传的文件写入FTP服务器
                UploadFileUtil.writeFile(path, marcPath, form.getTxtFile().getFileItem().get());
                //ImportDataFromExcel.readExcel(path + marcPath);
               // CrmPersonType personType = form.getPersonType();
                Map<String, Object> accountInfo = (Map<String, Object>) session.getAttribute("pt_accountInfo");
				String accountId = accountInfo.get("employeeId").toString();
				
               this.crmPersonTypeRelationshipService.upload( path + marcPath, form.getPersonType().getId(), accountId);
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
    /**
     * 同步账户
     *
     * @param form
     * @return
     * @throws Exception
     *             by Ma Guoqing
     */
    @RequestMapping(value = "/form/editSysAccount")
    public ModelAndView editSysAccount(CrmPersonTypeRelationshipForm form) throws Exception {

        String forwardString = "crm/personInfo/editSysAccount";
        Map<String, Object> model = new HashMap<String, Object>();
        try {
            String id = request.getParameter("id");
            SysAccount account = this.restsService.getAccount(id);
            Map<String, Object> statusMap = new HashMap<String, Object>();
            Map<String, Object> encryptionMap = new HashMap<String, Object>();

            statusMap.put("2", "停用");
            statusMap.put("1", "在用");

            encryptionMap.put("1", "不加密");
            encryptionMap.put("2", "加密");

            form.setStatusMap(statusMap);
            form.setEncryptionMap(encryptionMap);
            if (account != null && account.getId() != null) {
                account.setPass("");
            } else {
                account = new SysAccount();
                account.setStatus(1);
                account.setEncryption(1);
            }
            form.setId(id);
            form.setAccount(account);
            model.put("form", form);
        } catch (Exception e) {
            e.printStackTrace();
            form.setIsSuccess(FAILURE);
            form.setMsg(exMsg(e));
        }

        return new ModelAndView(forwardString, model);
    }

    @RequestMapping(value = "/form/editSysAccountSubmit")
    @ResponseBody
    public CrmPersonTypeRelationshipForm editSysAccountSubmit(CrmPersonTypeRelationshipForm form) throws Exception {
        SysAccount account = form.getAccount();
        try {
            account.setEmployeeId(form.getId());
            this.restsService.updateAccount(account);
            form.setIsSuccess(SUCCESS);
            form.setMsg("更新账户信息成功！");
        } catch (Exception e) {
            form.setIsSuccess(FAILURE);
            form.setMsg(exMsg(e));
        }
        return form;
    }
    
    /**
     * 人员自动补全控件数据
     * 公用
     * @param form
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/form/autocompletePersonList", headers="Accept=application/json")
	@ResponseBody
	public List<AutocompletePerson> autocompletePersonList(CrmPersonTypeRelationshipForm form)throws Exception {
		List<AutocompletePerson> list = new ArrayList<AutocompletePerson>();
		Map<String,Object> condition = new HashMap<String, Object>();
		try{
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			condition.put("code", form.getPersonType().getCode());
			List<CrmPersonTypeRelationship> personList = crmPersonTypeRelationshipService.getList(condition, "");
			for (CrmPersonTypeRelationship person : personList) {
				AutocompletePerson autocompletePerson = new AutocompletePerson();
				autocompletePerson.setId(person.getId());
				autocompletePerson.setName(person.getPerson().getName()); // 人员名称
				autocompletePerson.setTelephone(person.getPerson().getTelephone()); // 座机
				autocompletePerson.setPhone(person.getPerson().getPhone()); // 手机
				autocompletePerson.setAddress(person.getPerson().getAddress()); // 联系地址
				autocompletePerson.setPostCode(person.getPerson().getPostCode()); // 邮编
				autocompletePerson.setEmail(person.getPerson().getEmail()); // 电子邮箱
				autocompletePerson.setFax(person.getPerson().getFax()); // 传真
				autocompletePerson.setLowerPinyin(person.getPerson().getLowerPinyin()); // 拼音小写
				autocompletePerson.setLabel(autocompletePerson.getLowerPinyin() + " " + autocompletePerson.getName());
				list.add(autocompletePerson);
			}
		}catch(Exception e){
			form.setMsg(exMsg(e));
		}
		return list;
	}

}