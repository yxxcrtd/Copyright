package cn.digitalpublishing.springmvc.controller;

import java.math.BigDecimal;
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
import cn.digitalpublishing.po.CrRlFormula;
import cn.digitalpublishing.po.CrRlOwner;
import cn.digitalpublishing.po.CrRlOwnerRoyalty;
import cn.digitalpublishing.po.CrRlProduct;
import cn.digitalpublishing.po.CrSettlement;
import cn.digitalpublishing.po.CrmPersonTypeRelationship;
import cn.digitalpublishing.po.PProduct;
import cn.digitalpublishing.po.ProductOrder;
import cn.digitalpublishing.springmvc.form.CrSettlementForm;
import cn.digitalpublishing.util.DicCache;

import com.google.common.base.Strings;

@Controller
@RequestMapping(value = "/pages/settlement")
public class CrSettlementController extends BaseController {

	/**
	 * 显示结算信息首页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/form/index")
	public ModelAndView index(CrSettlementForm form) throws Exception {
		String forwardString = "rightLicense/crSettlement/list";
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			//获取结算状态值
			this.settlementService.edit(null, form.getDic());
			model.put("form", form);
		} catch (Exception e) {
			form.setMsg(exMsg(e));
		}
		return new ModelAndView(forwardString, model);
	}

	/**
	 * 获取版税结算列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/form/manager", headers = "Accept=application/json")
	@ResponseBody
	public CrSettlementForm manager(CrSettlementForm form) throws Exception {
		List<CrSettlement> list = new ArrayList<CrSettlement>();
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			//订单号查询
			if (!Strings.isNullOrEmpty(form.getCode())) {
				condition.put("code", form.getCode());
			}
			//贡献者查询
			if (!Strings.isNullOrEmpty(form.getName())) {
				condition.put("name", form.getName());
			}
			//版税结算状态查询
			if (!Strings.isNullOrEmpty(form.getSetStatus())) {
				condition.put("setStatus", form.getSetStatus());
			}
			//状态是可用
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			
			form.setiTotalRecords(this.settlementService.getCount(condition));
			form.setiTotalDisplayRecords(form.getiTotalRecords());
			if (form.getiTotalRecords() > 0) {
				list = this.settlementService.getPagingList(condition, "", form.getiDisplayLength(), form.getiDisplayStart());
			}
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		form.setAaData(list);
		return form;
	}

	/**
	 * 版税计算公式实现结算
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/form/add")
	@ResponseBody
	public CrSettlementForm add(CrSettlementForm form) throws Exception {
		try {
			//*******根据订单号获取结算方式信息start*******//
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("code", form.getCode());
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			List<CrSettlement> settleList = this.settlementService.getList(condition, "");
			if(0 < settleList.size()){
				form.setIsSuccess(FAILURE);
				form.setMsg("该订单号已结算，请继续执行下个订单！");
			}else{
				//获取订单信息
				List<ProductOrder> orderList = this.productOrderService.getList(condition, "");
				if(0 < orderList.size()){
					//获取产品信息
					Map<String, Object> conditionn = new HashMap<String, Object>();
					conditionn.put("isbn", orderList.get(0).getIsbn());
					List<PProduct> productList = this.productService.getList(conditionn, "");
					//判定ISBN号是否存在
					if(0 < productList.size()){
						//获取授权产品信息
						Map<String, Object> cond = new HashMap<String, Object>();
						cond.put("productId", productList.get(0).getId());
						List<CrRlProduct> crProductList = this.crProductService.getList(cond);
						
						//获取权利授权者信息
						Map<String, Object> condd = new HashMap<String, Object>();
						condd.put("rlpId", crProductList.get(0).getRlpId());
						List<CrRlOwner> ownerList = this.crOwnerService.getList(condd);
						
						//*******获取不同贡献者信息*******//
						for(int j=0;j<ownerList.size();j++){
							CrSettlement settlement = new CrSettlement();
							
							//获取人员版税计算规则信息
							Map<String, Object> conded = new HashMap<String, Object>();
							conded.put("rlownerId", ownerList.get(j).getRlownerId());
							List<CrRlOwnerRoyalty> royaltyList = this.crOwnerRoyaltyService.getList(conded);
							
							//获取计算公式
							Map<String, Object> condit = new HashMap<String, Object>();
							condit.put("rloRoyaltyId", royaltyList.get(0).getRloRoyaltyId());
							List<CrRlFormula> rlFormulaList = this.crFormulaService.getList(condit);
							//*******根据ISBN获取结算方式信息end*******//
							
							//*******获取贡献者信息*******//
							//获取人员类型信息
							Map<String, Object> owner = new HashMap<String, Object>();
							owner.put("id", ownerList.get(j).getPersonTrcr().getId());
							List<CrmPersonTypeRelationship> personTypeList = this.crmPersonTypeRelationshipService.getList(owner, "");
							
							//计算公式判定
							if(0 < rlFormulaList.size()){
								//按销售量计算
								if("402880394825deef014825deef3e000b".equals(royaltyList.get(0).getAdjustRule())){
									for(int i=0;i<rlFormulaList.size();i++){
										BigDecimal salePrice = orderList.get(0).getSalePrice();
										BigDecimal quantity = orderList.get(0).getQuantity();
										BigDecimal breakPoint =  rlFormulaList.get(i).getBreakPoint();
										if(quantity.compareTo(breakPoint)>0){
											BigDecimal saleNum = salePrice.multiply(quantity);
											BigDecimal rateValue = rlFormulaList.get(i).getRateValue();
											BigDecimal Rate = rateValue.divide(new BigDecimal(100));
											BigDecimal amount = saleNum.multiply(Rate);
											settlement.setAmount(amount);
										}else if(quantity.compareTo(breakPoint)<0){
											break;
										}else{
											BigDecimal saleNum = salePrice.multiply(quantity);
											BigDecimal rateValue = rlFormulaList.get(i).getRateValue();
											BigDecimal Rate = rateValue.divide(new BigDecimal(100));
											BigDecimal amount = saleNum.multiply(Rate);
											settlement.setAmount(amount);
										}
									}
								}else{
									//按销售额计算
									for(int i=0;i<rlFormulaList.size();i++){
										BigDecimal salePrice = orderList.get(0).getSalePrice();
										BigDecimal quantity = orderList.get(0).getQuantity();
										BigDecimal breakPoint =  rlFormulaList.get(i).getBreakPoint();
										BigDecimal saleNum = salePrice.multiply(quantity);
										if(saleNum.compareTo(breakPoint)>0){
											BigDecimal rateValue = rlFormulaList.get(i).getRateValue();
											BigDecimal Rate = rateValue.divide(new BigDecimal(100));
											BigDecimal amount = saleNum.multiply(Rate);
											settlement.setAmount(amount);
										}else if(saleNum.compareTo(breakPoint)<0){
											break;
										}else{
											BigDecimal rateValue = rlFormulaList.get(i).getRateValue();
											BigDecimal Rate = rateValue.divide(new BigDecimal(100));
											BigDecimal amount = saleNum.multiply(Rate);
											settlement.setAmount(amount);
										}
									}
								}
							}else{
								//*****开始计算金额*****//
								//销售额
								BigDecimal salePrice = orderList.get(0).getSalePrice();
								BigDecimal quantity = orderList.get(0).getQuantity();
								BigDecimal saleNum = salePrice.multiply(quantity);
								//初始比例和销售额
								BigDecimal initRate = royaltyList.get(0).getInitRate();
								BigDecimal Rate = initRate.divide(new BigDecimal(100));
								BigDecimal amount = saleNum.multiply(Rate);
								settlement.setAmount(amount);
							}
							
							//版税结算结果记录
							settlement.setSetType(royaltyList.get(0).getAdjustRule());
							settlement.setIsbn(orderList.get(0).getIsbn());
							settlement.setCode(orderList.get(0).getCode());
							settlement.setName(personTypeList.get(0).getPerson().getName());
							//未结算状态
							settlement.setSetStatus(DicCache.getIdByCode(DicConstants.CR_SETTLEMENT_TYPE, DicConstants.CR_SETTLEMENT_TYPE_1));
							//可用
							settlement.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
							this.settlementService.insert(settlement);
						}
						form.setMsg("新增结算信息成功！");
						form.setIsSuccess(SUCCESS);
					}else{
						form.setIsSuccess(FAILURE);
						form.setMsg("ISBN号不存在！");
					}
				}else{
					form.setIsSuccess(FAILURE);
					form.setMsg("订单号不完整或不存在！");
				}
			}
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg("结算出错！找不到相应的授权！");
		}
		return form;
	}
	
	/**
	 * 已结算
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/form/settle")
	@ResponseBody
	public CrSettlementForm settle(CrSettlementForm form) throws Exception {
		try {
			CrSettlement settlement = this.settlementService.getById(form.getId());
			//已结算状态
			settlement.setSetStatus(DicCache.getIdByCode(DicConstants.CR_SETTLEMENT_TYPE, DicConstants.CR_SETTLEMENT_TYPE_2));
			settlement.setEndDate(new Date());
			this.settlementService.update(settlement);
			form.setIsSuccess(SUCCESS);
			form.setMsg("结算状态修改成功！");
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}

	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/form/delete")
	@ResponseBody
	public CrSettlementForm delete(CrSettlementForm form) throws Exception {
		try {
			CrSettlement settlement = this.settlementService.getById(form.getId());
			//不可用
			settlement.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE));
			this.settlementService.update(settlement);
			form.setIsSuccess(SUCCESS);
			form.setMsg("信息注销成功！");
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
}