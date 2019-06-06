package cn.digitalpublishing.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Strings;

import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.CrmCorp;
import cn.digitalpublishing.po.CrmCorpType;
import cn.digitalpublishing.po.CrmCorpTypeRelationship;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.CrmCorpForm;
import cn.digitalpublishing.springmvc.form.CrmCorpTypeRelationshipForm;
import cn.digitalpublishing.util.AutocompleteCorp;
import cn.digitalpublishing.util.DicCache;
import cn.digitalpublishing.util.TreeNode;
import cn.digitalpublishing.util.io.ImportExcelUtil;

@Controller
@RequestMapping("/pages/crmCorp")
public class CrmCorpController extends BaseController {
	
	/**
	 * 初始化组织机构管理首页
	 * @param code
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/form/index/{code}")
	public ModelAndView index(@PathVariable String code, CrmCorpForm form) {
		String forwardString = "crm/corp/tree";
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			CrmCorpType corpType = this.crmCorpTypeService.getCorpTypeByCode(code);
			if (corpType == null) {
				throw new Exception("非法操作！");
			}
			
			form.setCorpType(corpType);
			model.put("form", form);
		} catch (Exception e) {
			form.setMsg(exMsg(e));
			forwardString = "msg";
		}
		return new ModelAndView(forwardString, model);
	}
	
	/**
	 * 获取树形菜单子节点JSON
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/form/getChildNodes")
	@ResponseBody
	public List<TreeNode> getChildNodes(CrmCorpForm form) {
		List<TreeNode> list = null;
		try {
			list = this.crmCorpService.getChildCorpTreeNodes(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/form/getAllTreeNodes")
	@ResponseBody
	public List<TreeNode> getAllTreeNodes(CrmCorpForm form) {
		List<TreeNode> list = null;
		try {
			list = this.crmCorpService.getChildCorpTreeNodes(form);
		} catch (Exception e) {
		}
		return list;
	}
	
	/**
	 * 获取当前类型可用的公司数据
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/form/getAvailableCorpList")
	@ResponseBody
	public List<AutocompleteCorp> getAvailableCorpList(CrmCorpForm form) {
		List<AutocompleteCorp> autocompleteCorpList = new ArrayList<AutocompleteCorp>();
		try {
			List<CrmCorp> corpList = crmCorpService.getAvailableCorpCode(form.getCorpType());
			for (CrmCorp corp : corpList) {
				AutocompleteCorp autocompleteCorp = new AutocompleteCorp();
				autocompleteCorp.setId(corp.getId());
				autocompleteCorp.setCode(corp.getCode());
				autocompleteCorp.setFullName(corp.getFullName());
				autocompleteCorp.setShortName(corp.getShortName());
				autocompleteCorp.setIntroduction(corp.getIntroduction());
				autocompleteCorp.setLabel(autocompleteCorp.getCode() + " " + autocompleteCorp.getShortName());
				autocompleteCorpList.add(autocompleteCorp);
			}
		} catch (Exception e) {
		}
		return autocompleteCorpList;
	}
	
	@RequestMapping(value = "/form/editTreeNode")
	@ResponseBody
	public CrmCorpForm editTreeNode(CrmCorpForm form) {
		CrmCorpTypeRelationship relation = form.getRelation();
		try {
			if (!Strings.isNullOrEmpty(relation.getId())) {
				relation = crmCorpService.editTreeNode(relation);
				if (relation.getParentRelationship() == null) {
					CrmCorpTypeRelationship parent = new CrmCorpTypeRelationship();
					parent.setId("root");
					relation.setParentRelationship(parent);
				}
				form.setRelation(relation);
			}
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(e.getMessage());
		}
		return form;
	}
	
	@RequestMapping(value = "/form/editTreeNodeSubmit")
	@ResponseBody
	public CrmCorpForm editTreeNodeSubmit(CrmCorpForm form) {
		CrmCorpType type = form.getCorpType();
		CrmCorpTypeRelationship relation = form.getRelation();
		try {
			if (Strings.isNullOrEmpty(relation.getId())) {
				this.crmCorpService.saveCorp(form);
				form.setMsg(type.getName()+"保存成功。");
			} else {
				this.crmCorpService.updateCorp(form);
				form.setMsg(type.getName()+"修改成功。");
			}
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(form.getCorpType().getName()+"操作失败。", e));
		}
		return form;
	}
	
	@RequestMapping(value = "/form/addTab")
	@ResponseBody
	public CrmCorpForm addTab(CrmCorpForm form) {
		try {
			crmCorpService.addTab(form);
			form.setDicMap(getCustomerSelectData(form.getCorpPropList(), new String[] {"display", "source"}));
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
		}
		
		return form;
	}
	
	@RequestMapping(value = "/form/delete")
	@ResponseBody
	public CrmCorpForm delete(CrmCorpForm form) {
		try {
			this.crmCorpService.delete(form.getRelation());
			form.setIsSuccess(SUCCESS);
			form.setMsg("删除成功！");
		} catch (Exception e) {
			form.setMsg("删除失败！");
			form.setIsSuccess(FAILURE);
		}
		return form;
	}
	
	@RequestMapping(value = "/form/checkCodeIsAvailable")
	@ResponseBody
	public CrmCorpForm checkCodeIsAvailable(CrmCorpForm form) {
		try {
			form.setCorpCodeIsAvailable(this.crmCorpService.checkCodeIsAvailable(form.getCorp()));
		} catch (Exception e) {
		}
		return form;
	}
	
	@RequestMapping(value = "/form/upload")
	public ModelAndView upload(CrmCorpForm form) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        String forwardString = "crm/corp/upload";
        try {
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
    public CrmCorpForm uploadSubmit(CrmCorpForm form) throws Exception {
        try {
			CommonsMultipartFile excel = form.getExcelFile();
			if (ImportExcelUtil.checkExcelExtension(excel.getOriginalFilename())) {
				List<TreeNode> nodeList = this.crmCorpService.upload(form.getCorpType(), excel.getInputStream());
				form.setNodeList(nodeList);
			} else {
				throw new CcsException("上传格式不正确，请上传xls或xlsx！");
			}
			
            form.setIsSuccess(SUCCESS);
            form.setMsg("上传成功！");
        } catch (Exception e) {
            form.setIsSuccess(FAILURE);
            form.setMsg(exMsg(e));
        } finally {
        	form.setExcelFile(null);
        }
        return form;
    }
    
    /**
     * 组织机构自动补全控件数据
     * 公用
     * @param form
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/form/autocompleteCorpList", headers="Accept=application/json")
	@ResponseBody
	public List<AutocompleteCorp> autocompleteCorpList(CrmCorpForm form)throws Exception {
		List<AutocompleteCorp> list = new ArrayList<AutocompleteCorp>();
		Map<String,Object> condition = new HashMap<String, Object>();
		try{
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			condition.put("corpType_code", form.getCorpType().getCode());
			List<CrmCorpTypeRelationship> corpList = this.crmCorpTypeRelationshipService.getList(condition, "");
			for (CrmCorpTypeRelationship corp : corpList) {
				AutocompleteCorp autocompleteCorp = new AutocompleteCorp();
				autocompleteCorp.setId(corp.getId());
				autocompleteCorp.setCode(corp.getCorp().getCode());
				autocompleteCorp.setFullName(corp.getCorp().getFullName());
				autocompleteCorp.setShortName(corp.getCorp().getShortName());
				autocompleteCorp.setIntroduction(corp.getCorp().getIntroduction());
				autocompleteCorp.setLabel(corp.getCorp().getNameFirstChar() + " " + autocompleteCorp.getShortName());
				list.add(autocompleteCorp);
			}
		}catch(Exception e){
			form.setMsg(exMsg(e));
		}
		return list;
	}
	
	/**
	 * 组织机构分页查询
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/form/manager", headers = "Accept=application/json")
	@ResponseBody
	public CrmCorpTypeRelationshipForm manager(CrmCorpTypeRelationshipForm form) throws Exception {
		List<CrmCorpTypeRelationship> list = new ArrayList<CrmCorpTypeRelationship>();
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			CrmCorp corp = form.getCorp();
			CrmCorpType corpType = form.getCorpType();
			
			if (!Strings.isNullOrEmpty(corp.getShortName())) {
				condition.put("corp_shortName", "%" + corp.getShortName() + "%");
			}
			
			if (!Strings.isNullOrEmpty(corpType.getId())) {
				condition.put("corpTypeId", corpType.getId());
			}
			
			form.setiTotalRecords(this.crmCorpTypeRelationshipService.getCount(condition, ""));
			form.setiTotalDisplayRecords(form.getiTotalRecords());
			if (form.getiTotalRecords() > 0) {
				list = this.crmCorpTypeRelationshipService.getPagingList(condition, "", form.getiDisplayLength(), form.getiDisplayStart());
			}
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		form.setAaData(list);
		return form;
	}

}