package cn.digitalpublishing.springmvc.controller.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import cn.com.daxtech.framework.exception.CcsException;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.PStructureType;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.product.PStructureTypeForm;
import cn.digitalpublishing.util.DicCache;
import cn.digitalpublishing.util.io.ImportExcelUtil;
import com.google.common.base.Strings;

@Controller
@RequestMapping("/pages/product/structureType")
public class PStructureTypeController extends BaseController {

	@RequestMapping(value = "/form/index")
	public ModelAndView index(PStructureTypeForm form) {
		String forwardString = "product/structureType/list";
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model.put("form", form);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
			forwardString = "msg";
		}
		return new ModelAndView(forwardString, model);
	}

	@RequestMapping(value = "/form/manager", headers = "Accept=application/json")
	@ResponseBody
	public PStructureTypeForm manager(PStructureTypeForm form) {
		PStructureType structureType = form.getStructureType();
		Map<String, Object> condition = form.getCondition();
		List<PStructureType> corpTypeList = new ArrayList<PStructureType>();
		try {
			if (!Strings.isNullOrEmpty(structureType.getCode())) {
				condition.put("code", "%" + structureType.getCode() + "%");
			}
			if (!Strings.isNullOrEmpty(structureType.getName())) {
				condition.put("name", "%" + structureType.getName() + "%");
			}
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			form.setiTotalDisplayRecords(this.structureTypeService.getCorpTypeCount(condition));
			form.setiTotalRecords(form.getiTotalDisplayRecords());

			if (form.getiTotalRecords() > 0) {
				corpTypeList = this.structureTypeService.getCorpTypePagingList(
						condition, "", form.getiDisplayLength(),
						form.getiDisplayStart());
			}

			form.setAaData(corpTypeList);
		} catch (Exception e) {
			form.setMsg(exMsg(e));
		}
		return form;
	}

	@RequestMapping(value = "/form/edit")
	public ModelAndView edit(PStructureTypeForm form) {
		PStructureType type = form.getStructureType();
		String forwardString = "product/structureType/edit";
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			if (!Strings.isNullOrEmpty(type.getId())) {
				type = this.structureTypeService.getCorpType(type.getId());
				form.setStructureType(type);
			}
		} catch (Exception e) {
			form.setMsg("获取数据出错！");
		}
		model.put("form", form);
		return new ModelAndView(forwardString, model);
	}

	@RequestMapping(value = "/form/editSubmit")
	@ResponseBody
	public PStructureTypeForm editSubmit(PStructureTypeForm form) {
		PStructureType type = form.getStructureType();
		try {
			if (Strings.isNullOrEmpty(type.getId())) {
				this.structureTypeService.insertCorpType(type);
				form.setMsg("新增素材类型信息成功!");
			} else {
				this.structureTypeService.updateCorpType(type, type.getId(), null);
				form.setMsg("修改素材类型信息成功！");
			}
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setMsg("维护素材类型信息出错！");
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
	public PStructureTypeForm delete(PStructureTypeForm form) {
		PStructureType type = form.getStructureType();
		try {
			this.structureTypeService.falseDel(type.getId());
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
	public PStructureTypeForm checkCodeAvailable(PStructureTypeForm form) {
		PStructureType type = form.getStructureType();
		try {
			boolean result = structureTypeService.checkCodeAvailable(type);
			if (result) {
				form.setIsSuccess(SUCCESS);
				form.setMsg("通过验证");
			} else {
				form.setIsSuccess(FAILURE);
				form.setMsg("编码已存在");
			}
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}

	@RequestMapping(value = "/form/upload")
	public ModelAndView upload(PStructureTypeForm form) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		String forwardString = "product/structureType/upload";
		try {
			form.setStructureType(this.structureTypeService.getCorpType(form.getStructureType().getId()));
			model.put("form", form);
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg((e instanceof CcsException) ? ((CcsException) e).getPrompt() : e.getMessage());
			forwardString = "msg";
		}
		return new ModelAndView(forwardString, model);
	}

	@RequestMapping(value = "/form/uploadSubmit")
	@ResponseBody
	public PStructureTypeForm uploadSubmit(PStructureTypeForm form) throws Exception {
		try {
			CommonsMultipartFile excel = form.getTxtFile();
			if (ImportExcelUtil.checkExcelExtension(excel.getOriginalFilename())) {
				this.structureTypeService.upload(form.getStructureType(), excel.getInputStream());
			} else {
				throw new CcsException("上传格式不正确，请上传xls或xlsx！");
			}
			
			form.setIsSuccess(SUCCESS);
			form.setMsg("上传成功！");
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		} finally {
			form.setTxtFile(null);
		}
		return form;
	}

}