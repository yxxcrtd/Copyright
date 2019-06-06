package cn.digitalpublishing.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.BCountry;
import cn.digitalpublishing.po.BRegion;
import cn.digitalpublishing.springmvc.form.CheckForm;
import cn.digitalpublishing.util.DicCache;

@Controller
@RequestMapping(value = "/check")
public class CheckController extends BaseController {
	/**
	 * 国别信息
	 * @param form
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	@RequestMapping(value="/form/showCountry")
	@ResponseBody
	public List<BCountry> showCountry(CheckForm form)throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		List<BCountry> countryList = null;
		try{
			condition.put("status",  DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			countryList = this.countryService.getList(condition, "");
			form.setCountryList(countryList);
			form.setIsSuccess(SUCCESS);
		}catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		
		return countryList;
	}
	/**
	 * 地域信息
	 * @param form
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	@RequestMapping(value="/form/showRegion")
	@ResponseBody
	public List<BRegion> showRegion(CheckForm form)throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		List<BRegion> regionList = new ArrayList<BRegion>();
		try{
			String countryId = request.getParameter("countryId");
			condition.put("coId", countryId);
			condition.put("status",  DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			regionList = this.regionService.getListNoParent(condition, "");
			form.setRegionList(regionList);
			form.setIsSuccess(SUCCESS);
		}catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return regionList;
	}
}