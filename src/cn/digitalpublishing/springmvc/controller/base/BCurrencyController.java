package cn.digitalpublishing.springmvc.controller.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.daxtech.framework.Internationalization.Lang;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.BCurrency;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.base.BCurrencyForm;
import cn.digitalpublishing.util.DicCache;

import com.google.common.base.Strings;

@Controller
@RequestMapping("/pages/base/currency")
public class BCurrencyController extends BaseController{

	@RequestMapping(value = "/form/index")
	public ModelAndView index(BCurrencyForm form) throws Exception {

		String forwardString = "base/currency/list";
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

	/**
	 * 获取币种信息
	 * @param form
	 * @return
	 * @throws Exception
	 *             by Zhang Huaishi
	 */
	@RequestMapping(value = "/form/manager", headers = "Accept=application/json")
	@ResponseBody
	public BCurrencyForm manage(BCurrencyForm form) throws Exception {

		Map<String, Object> condition = form.getCondition();
		List<BCurrency> list = new ArrayList<BCurrency>();
		try {

			condition.put("currencyCode", "%"+form.getCurrencyCode()+"%");
			condition.put("currencyName", "%"+form.getCurrencyName()+"%");
			condition.put("currencyStatus", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			form.setiTotalDisplayRecords(this.currencyService.getCount(condition, ""));
			form.setiTotalRecords(form.getiTotalDisplayRecords());

			if (form.getiTotalRecords() > 0) {
				list = this.currencyService.getPagingList(condition, " order by currencyCreateOn desc ", form.getiDisplayLength(), form.getiDisplayStart());
			}

			form.setAaData(list);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
			return form;
		}
		return form;

	}
	
	/**
	 * 新增/修改 币种信息
	 * @param form
	 * @return
	 * @throws Exception
	 *             by Zhang Huaishi
	 */
	@RequestMapping(value = "/form/editCurrency")
	public ModelAndView editCurrency(BCurrencyForm form) throws Exception {

		Map<String, Object> model = new HashMap<String, Object>();
		String forwardString = "base/currency/edit";
		String id = request.getParameter("eid");
		try {

			if (id != null && !"".equals(id)) {
				BCurrency bc = this.currencyService.getBCurrency(id);
				if (bc != null) {
					form.setObj(bc);
				}
			}

			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
			forwardString = "msg";
		}

		model.put("form", form);
		return new ModelAndView(forwardString, model);

	}
	
	/**
	 * 新增/修改 币种信息
	 * @param form
	 * @return
	 * @throws Exception
	 *             by Zhang Huaishi
	 */
	@RequestMapping(value = "/form/editCurrencySubmit")
	@ResponseBody
	public BCurrencyForm editCountrySubmit(BCurrencyForm form) throws Exception {

		BCurrency bc = null;
		bc = form.getObj();
		try {
			if (bc != null) {
				if (bc.getCurrencyId() != null && !bc.getCurrencyId().equals("")) {
					BCurrency bCurrency = new BCurrency();
					bCurrency.setCurrencyId(bc.getCurrencyId());
					bCurrency.setCurrencyCode(bc.getCurrencyCode());
					bCurrency.setCurrencyName(bc.getCurrencyName());
					bCurrency.setCurrencyStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
					bCurrency.setCurrencyUpdateOn(new Date());
					this.currencyService.update(bCurrency);
//					Map<String, Object> condition = new HashMap<String, Object>();
//					condition.put("parentId", "1");
//					condition.put("coId", bc.getCurrencyId());
//					List<BRegion> list = bRegionService.getList(condition, "");
//					if (list != null) {
//						BRegion br = list.get(0);
//						br.setName(bc.getCnName());
//						this.bRegionService.update(br);
//					}
					form.setIsSuccess(SUCCESS);
					form.setMsg("修改成功！");
				} else {
					BCurrency bCurrency = new BCurrency();
					bCurrency.setCurrencyCode(bc.getCurrencyCode());
					bCurrency.setCurrencyName(bc.getCurrencyName());
					Map<String, Object> accountInfo = (Map<String, Object>) session.getAttribute("pt_accountInfo");
					String accountId = accountInfo.get("employeeId").toString();
					bCurrency.setCurrencyCreateBy(accountId);
					bCurrency.setCurrencyUpdateBy(accountId);
					bCurrency.setCurrencyCreateOn(new Date());
					bCurrency.setCurrencyUpdateOn(new Date());
					bCurrency.setCurrencyStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
					
					this.currencyService.insert(bCurrency);
					form.setIsSuccess(SUCCESS);
					form.setMsg("添加成功！");
				}
			}
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}

		return form;
	}
	
	/**
	 * 删除 币种信息
	 * @param form
	 * @return
	 * @throws Exception
	 *             by Zhang Huaishi
	 */
	@RequestMapping(value = "/form/delete")
	@ResponseBody
	public BCurrencyForm delete(BCurrencyForm form) throws Exception {
		BCurrency bc = new BCurrency();
		bc.setCurrencyId(form.getId());
		bc.setCurrencyStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE));
		try {
			this.currencyService.update(bc);
			form.setIsSuccess(SUCCESS);
			form.setMsg("注销成功 ！");
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
	/**
	 * 验证币种编号唯一
	 * @param form
	 * @return
	 * @throws Exception
	 *             by Zhang Huaishi
	 */
	@RequestMapping(value = "/form/validateBCurrencyCodeUnique")
	@ResponseBody
	public BCurrencyForm validateBCurrencyCodeUnique(BCurrencyForm form) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("currencyCode", form.getCurrencyCode());
			condition.put("currencyStatus", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			if (Strings.isNullOrEmpty(form.getCurrencyId())) {
				form.setiTotalRecords(this.currencyService.getCount(condition, ""));
				if (form.getiTotalRecords() > 0) {
					form.setIsSuccess(FAILURE);
					form.setMsg(Lang.getLanguage(
							"System.Info.ValidateNameUnique.Failure", request
							.getSession().getAttribute("lang")
							.toString()));
				} else {
					form.setIsSuccess(SUCCESS);
					form.setMsg(Lang.getLanguage(
							"System.Info.ValidateNameUnique.Success", request
							.getSession().getAttribute("lang")
							.toString()));
				}
			} else {
				form.setIsSuccess(SUCCESS);
				form.setMsg(Lang.getLanguage(
						"System.Info.ValidateNameUnique.Success", request
						.getSession().getAttribute("lang").toString()));
			}
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		
		model.put("form", form);
		return form;
	}
	
	@RequestMapping(value = "/form/validateCurrencyNameUnique")
	@ResponseBody
	public BCurrencyForm validateCurrencyNameUnique(BCurrencyForm form) throws Exception {
		
		try {
			
			String currencyName = form.getCurrencyName();
			if (this.currencyService.currencyNameUnique(currencyName)) {
				form.setIsSuccess(SUCCESS);
				form.setMsg("通过验证");
			} else {
				form.setIsSuccess(FAILURE);
				form.setMsg("已存在相同币种名称");
			}
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
	
}