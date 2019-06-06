package cn.digitalpublishing.springmvc.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.google.common.base.Strings;

import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.model.Param;
import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.BCountry;
import cn.digitalpublishing.po.BRegion;
import cn.digitalpublishing.service.*;
import cn.digitalpublishing.util.DicCache;
import cn.org.rapid_framework.beanutils.BeanUtils;

public class BaseController extends MultiActionController {

    public Logger log = Logger.getLogger(this.getClass());

    public static final String FAILURE = "false";
    public static final String SUCCESS = "true";
    public static final String TIMEOUT = "timeout";
    
    protected String forwardString = "";

    private static final boolean DEBUG = true;

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    /**
     * 异常消息处理
     *
     * @param e
     * @return
     */
    public String exMsg(Exception e) {
        return exMsg(e, null, null);
    }

    /**
     * 异常消息处理
     *
     * @param e
     * @param language
     * @return
     */
    public String exMsg(Exception e, String language) {
        return exMsg(e, null, language);
    }

    /**
     * 异常消息处理
     *
     * @param msg
     * @param e
     * @return
     */
    public String exMsg(String msg, Exception e) {
        return exMsg(e, msg, null);
    }

    /**
     * 异常消息处理
     *
     * @param e
     * @param msg
     * @return
     */
    public String exMsg(Exception e, String msg, String language) {
        if (DEBUG) {
            e.printStackTrace();
        }
        if (msg != null && !msg.equals("")) {
            return msg;
        }
        if (e instanceof CcsException) {
            CcsException ce = (CcsException) e;
            return ce.getPrompt();
        } else {
            return e.getMessage();
        }
    }
    
    /**
     * 获取自定义属性下拉框选项值
     *
     * @param props:  自定义属性list
     * @param fields: 自定义属性对象字段名，index0=display, index1=source
     * @return
     */
    protected <A> Map<String, Map<String, String>> getCustomerSelectData(List<A> props, String[] fields) {
        Map<String, Map<String, String>> dicMap = new HashMap<String, Map<String, String>>();
        try {
            for (A a : props) {
                String display = BeanUtils.getProperty(a, fields[0]);
                String source = BeanUtils.getProperty(a, fields[1]);
                if (!Strings.isNullOrEmpty(display) && display.equals("select") && !Strings.isNullOrEmpty(source)) {
                    if (!dicMap.containsKey(source)) {
                        dicMap.put(source, DicCache.getDicData(source));
                    }
                }
            }
        } catch (Exception e) {
        }
        return dicMap;
    }
    
    public static final String getSwftoolsPath() {
		Map<String, String> config = Param.getParam("pdf2swf");
    	return config.get("src").replace("-", ":");
    }
    
    public static final String getUploadPath() {
		Map<String, String> config = Param.getParam("product.structure.element.path");
    	return config.get("src").replace("-", ":");
    }
    
    public static final String getXpdfPath() {
		Map<String, String> config = Param.getParam("pdf2swf");
    	return config.get("font").replace("-", ":");
    }
    
    public static final String getConfigByPage() {
		Map<String, String> config = Param.getParam("pdf2swf");
    	return config.get("page");
    }
    
    public static final String getConfigByTitle() {
		Map<String, String> config = Param.getParam("pdf2swf");
    	return config.get("title");
    }
    
    @Autowired
    @Qualifier("objectMapper")
    protected ObjectMapper objectMapper;

    /**
     * 基础
     */
    @Autowired
    @Qualifier("dicClassService")
    protected BDicClassService dicClassService;
    
    @Autowired
    @Qualifier("currencyService")
    protected BCurrencyService currencyService;

    @Autowired
    @Qualifier("exchangeService")
    protected BExchangeService exchangeService;

    /**
     * 产品
     */
    @Autowired
    @Qualifier("productService")
    protected PProductService productService;
    
    /**
     * 产品订单
     */
    @Autowired
    @Qualifier("productOrderService")
    protected ProductOrderService productOrderService;

    /**
     * 产品分类
     */
    @Autowired
    @Qualifier("productTypeService")
    protected PProductTypeService productTypeService;

    /**
     * 碎片化
     */
    @Autowired
    @Qualifier("structureService")
    protected PStructureService structureService;
    
    @Autowired
    @Qualifier("structureTypeService")
    protected PStructureTypeService structureTypeService;
    
    @Autowired
    @Qualifier("structureTypePropClassifyService")
    protected PStructureTypePropClassifyService structureTypePropClassifyService;

    @Autowired
    @Qualifier("structureTypePropService")
    protected PStructureTypePropService structureTypePropService;
    
	/**
	 * 结构
	 */
	@Autowired
	@Qualifier("productElementService")
	protected PElementService productElementService;
	
	@Autowired
    @Qualifier("productLicenseService")
    protected PProductLicenseService productLicenseService;

	/**
	 * 合同
	 */
    @Autowired
    @Qualifier("crContractService")
    protected CrContractService crContractService;
	
    /**
	 * 国别权利合同关系
	 */
    @Autowired
    @Qualifier("crcRelationshipService")
    protected CrCrcRelationshipService crcRelationshipService;
    
    /**
	 * 国别附属权利关系
	 */
    @Autowired
    @Qualifier("csrRelationshipService")
    protected CrCsrRelationshipService csrRelationshipService;
    
    /**
	 * 授权类型
	 */
	@Autowired
	@Qualifier("crLicenseTypeService")
	protected CrLicenseTypeService crLicenseTypeService;
    
    /**
	 * 语种权利合同关系
	 */
	@Autowired
    @Qualifier("lrcRelationshipService")
    protected CrLrcRelationshipService lrcRelationshipService;
	
    /**
	 * 语种附属权利关系
	 */
    @Autowired
    @Qualifier("lsrRelationshipService")
    protected CrLsrRelationshipService lsrRelationshipService;

    /**
	 * 权利授权
	 */
    @Autowired
    @Qualifier("crRightService")
    protected CrRightService crRightService;

    /**
	 * 计算公式
	 */
    @Autowired
    @Qualifier("crFormulaService")
    protected CrRlFormulaService crFormulaService; 
    
    /**
	 * 权利授权者
	 */
    @Autowired
    @Qualifier("crOwnerService")
    protected CrRlOwnerService crOwnerService;

    /**
	 * 预付款及固定费用
	 */
    @Autowired
    @Qualifier("crOwnerFeeService")
    protected CrRlOwnerFeeService crOwnerFeeService;
    
    /**
	 * 付款对象
	 */
    @Autowired
    @Qualifier("crOwnerPayeeService")
    protected CrRlOwnerPayeeService crOwnerPayeeService;
    
    /**
	 * 人员版税计算规则
	 */
    @Autowired
    @Qualifier("crOwnerRoyaltyService")
    protected CrRlOwnerRoyaltyService crOwnerRoyaltyService;
    
    /**
	 * 权利授权产品
	 */
    @Autowired
    @Qualifier("crProductService")
    protected CrRlProductService crProductService;
    
    /**
	 * 版税规则库
	 */
    @Autowired
    @Qualifier("crRoyaltyRuleService")
    protected CrRlRoyaltyRuleService crRoyaltyRuleService;
    
    /**
	 * 版税附属权利
	 */
    @Autowired
    @Qualifier("subsidaryRightService")
    protected CrSubsidaryRightService subsidaryRightService;
    
    /**
	 * 版税结算
	 */
    @Autowired
    @Qualifier("settlementService")
    protected CrSettlementService settlementService;
	
    /**
     * CRM
     */
    @Autowired
    @Qualifier("crmCorpTypeService")
    protected CrmCorpTypeService crmCorpTypeService;
    
    @Autowired
    @Qualifier("crmPersonTypeService")
    protected CrmPersonTypeService crmPersonTypeService;
    
    @Autowired
    @Qualifier("crmCtypePropService")
    protected CrmCtypePropService crmCtypePropService;
    
    @Autowired
    @Qualifier("crmPeTypePropService")
    protected CrmPeTypePropService crmPeTypePropService;
    
    @Autowired
    @Qualifier("crmCtpClassifyService")
    protected CrmCtpClassifyService crmCtpClassifyService;
    
    @Autowired
    @Qualifier("crmPersonPropService")
    protected CrmPersonPropService crmPersonPropService;
    
    @Autowired
    @Qualifier("crmPeTpClassifyService")
    protected CrmPeTpClassifyService crmPeTpClassifyService;
    
    @Autowired
    @Qualifier("crmCorpService")
    protected CrmCorpService crmCorpService;
    
    @Autowired
    @Qualifier("crmCorpTypeRelationshipService")
    protected CrmCorpTypeRelationshipService crmCorpTypeRelationshipService;
    
    @Autowired
    @Qualifier("crmPersonService")
    protected CrmPersonService crmPersonService;

    @Autowired
    @Qualifier("crmPersonTypeRelationshipService")
    protected CrmPersonTypeRelationshipService crmPersonTypeRelationshipService;
    
    @Autowired
    @Qualifier("crmCorpAccountService")
    protected CrmCorpAccountService crmCorpAccountService;
    
    /**
     * 策划
     */
    @Autowired
    @Qualifier("proposalService")
    protected PProposalService proposalService;
    
    @Autowired
    @Qualifier("proposalAdviceService")
    protected PProposalAdviceService proposalAdviceService;
    
    @Autowired
    @Qualifier("proposalAuthorRelationshipService")
    protected PProposalAuthorRelationshipService proposalAuthorRelationshipService;
    
    @Autowired
    @Qualifier("proposalPersonRelationshipService")
    protected PProposalPersonRelationshipService proposalPersonRelationshipService;
    
    @Autowired
    @Qualifier("productTypePropClassifyService")
    protected PProductTypePropClassifyService productTypePropClassifyService;
    
    @Autowired
    @Qualifier("productPersonRelationshipService")
    protected PProductPersonRelationshipService productPersonRelationshipService;
    
    @Autowired
    @Qualifier("countryService")
    protected BCountryService countryService;

    @Autowired
    @Qualifier("regionService")
    protected BRegionService regionService;
    
    /**
     * 其他
     */
    @Autowired
    @Qualifier("restsService")
    protected RestsService restsService;
    
    /**
     * 返回ajax请求后的信息
     *
     * @param response
     * @param result
     * @throws IOException by Ma Guoqing
     */
    public void ajaxReturn(HttpServletResponse response, String result) throws IOException {

        PrintWriter writer = null;
        try {
            response.setContentType("text/html;charset=utf-8");
            // 获取输出流
            writer = response.getWriter();
            writer.print(result);
        } catch (IOException e) {
            throw e;
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * 地域信息
     *
     * @param request
     * @param response
     * @param form
     * @return
     * @throws Exception by Ma Guoqing
     */
    public List<BRegion> showRegion(HttpServletRequest request, HttpServletResponse response, String countryId) throws Exception {
        Map<String, Object> condition = new HashMap<String, Object>();
        List<BRegion> regionList = new ArrayList<BRegion>();
        condition.put("coId", countryId);
        condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
        regionList = this.regionService.getListNoParent(condition, "");

        return regionList;
    }

    /**
     * 国别信息
     *
     * @param request
     * @param response
     * @param form
     * @return
     * @throws Exception by Ma Guoqing
     */
    public List<BCountry> showCountry(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> condition = new HashMap<String, Object>();
        List<BCountry> countryList = null;
        condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
        countryList = this.countryService.getList(condition, "");
        return countryList;
    }
}