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
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.BCurrency;
import cn.digitalpublishing.po.BExchange;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.base.BExchangeForm;
import cn.digitalpublishing.util.DicCache;
import com.google.common.base.Strings;

@Controller
@RequestMapping("/pages/base/exchange")
public class BExchangeController extends BaseController {

	@RequestMapping(value = "/form/index")
	public ModelAndView index(BExchangeForm form) throws Exception {
		Map<String, Object> condition = form.getCondition();
		String forwardString = "base/exchange/list";
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			condition.put("fromCurrencyCode", form.getFromCurrency());
			condition.put("toCurrencyCode", form.getToCurrency());
			condition.put("currencyStatus", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			List<BCurrency> currencyList = this.currencyService.getList(condition, "");
			form.setBlist(currencyList);
			//Map<String, String> dicData = DicCache.getDicData("ExchangeType");
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
	public BExchangeForm manage(BExchangeForm form) throws Exception {

		Map<String, Object> condition = form.getCondition();
		List<BExchange> list = new ArrayList<BExchange>();
		try {
			condition.put("exId", form.getExId());
			condition.put("fromCurrencyCode", form.getFromCurrency().getCurrencyCode());
			condition.put("toCurrencyCode", form.getToCurrency().getCurrencyCode());
			condition.put("exRate", form.getExRate());
			condition.put("exStatus", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			form.setiTotalDisplayRecords(this.exchangeService.getCount(condition, ""));
			form.setiTotalRecords(form.getiTotalDisplayRecords());
			
			if (form.getiTotalRecords() > 0) {
				list = this.exchangeService.getPagingList(condition, " order by exDate desc ", form.getiDisplayLength(), form.getiDisplayStart());
			}
			form.setIsSuccess(SUCCESS);
			form.setAaData(list);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
			return form;
		}
		return form;

	}
	
	/**
	 * 新增/修改 汇率信息
	 * @param form
	 * @return
	 * @throws Exception
	 *             by Zhang Huaishi
	 */
	@RequestMapping(value = "/form/editExchange")
	public ModelAndView editExchange(BExchangeForm form) throws Exception {

		String forwardString = "base/exchange/edit";
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			form.setExchangeType(DicCache.getDicData(DicConstants.EXCHANGE_TYPE));
			String id = request.getParameter("id");
			
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("currencyStatus", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			
			List<BCurrency> currencyList = this.currencyService.getList(m, "");
			form.setBlist(currencyList);
			if (id != null && !"".equals(id)) {
				BExchange bc = this.exchangeService.getBExchange(id);
				form.setId(id);
				if (bc != null) {
					form.setObj(bc);
				}
			}

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
	@RequestMapping(value = "/form/editExchangeSubmit")
	@ResponseBody
	public BExchangeForm editExchangeSubmit(BExchangeForm form) throws Exception {

//		BExchange bc = null;
//		bc = form.getObj();
		try {
			if (form.getObj() != null) {
				if (!Strings.isNullOrEmpty(form.getId())) {
					BExchange bExchange = new BExchange();
					bExchange.setExId(form.getObj().getExId());
					
					//获取源币种编号
					String fromCurrencyId = form.getObj().getFromCurrency().getCurrencyId();
					BCurrency fromBCurrency = this.currencyService.getBCurrency(fromCurrencyId);
					bExchange.setFromCurrency(fromBCurrency);
					
					//获取目标币种编号
					String toCurrencyId = form.getObj().getToCurrency().getCurrencyId();
					BCurrency toBCurrency = this.currencyService.getBCurrency(toCurrencyId);
					bExchange.setToCurrency(toBCurrency);
					
					bExchange.setExRate(form.getObj().getExRate());
					bExchange.setExDate(new Date());
					this.exchangeService.updateBExchange(bExchange, bExchange.getClass().getName(), form.getObj().getExId(), null);
					form.setIsSuccess(SUCCESS);
					form.setMsg("修改成功！");
				} else {
					BExchange bExchange = new BExchange();
					
					//获取源币种编号
					String fromCurrencyId = form.getObj().getFromCurrency().getCurrencyId();
					BCurrency fromBCurrency = this.currencyService.getBCurrency(fromCurrencyId);
					
					bExchange.setFromCurrency(fromBCurrency);
					
					//获取目标币种编号
					String toCurrencyId = form.getObj().getToCurrency().getCurrencyId();
					BCurrency toBCurrency = this.currencyService.getBCurrency(toCurrencyId);
					bExchange.setToCurrency(toBCurrency);
					
					bExchange.setExType(DicCache.getIdByCode(DicConstants.EXCHANGE_TYPE, DicConstants.EXCHANGE_YES));
					bExchange.setExRate(form.getObj().getExRate());
					bExchange.setExDate(new Date());
					bExchange.setExStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
					this.exchangeService.insertBExchange(bExchange);
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
	 * 删除 币种汇率信息
	 * @param form
	 * @return
	 * @throws Exception
	 *             by Zhang Huaishi
	 */
	@RequestMapping(value = "/form/delete")
	@ResponseBody
	public BExchangeForm delete(BExchangeForm form) throws Exception {
		BExchange bc = new BExchange();
		System.out.println("the ID I get is : " + form.getId());
		bc.setExId(form.getId());
		bc.setExStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE));
		try {
			this.exchangeService.deleteBExchange(bc);
			form.setIsSuccess(SUCCESS);
			form.setMsg("注销成功 ！");
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
}
