package cn.digitalpublishing.springmvc.controller.product;

import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.PProductPersonRelationship;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.product.PElementForm;
import cn.digitalpublishing.springmvc.form.product.PProductPersonRelationshipForm;
import cn.digitalpublishing.util.DicCache;
import com.google.common.base.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pages/productPersonRelationship")
public class PProductPersonRelationshipController extends BaseController {
	
	@RequestMapping(value = "/form/addPerson")
	public ModelAndView addPerson(PProductPersonRelationshipForm form) {
		String forwardString = "product/properson/list";
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			form.setProductId(form.getId());
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
    public PProductPersonRelationshipForm manage(PProductPersonRelationshipForm form) throws Exception {
        Map<String, Object> condition = new HashMap<String, Object>();
        try {
            condition.put("productId", form.getProductId());
            //condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
            form.setiTotalDisplayRecords(this.productPersonRelationshipService.getCount(condition));
            form.setiTotalRecords(form.getiTotalDisplayRecords());
            List<PProductPersonRelationship> infoList = new ArrayList<PProductPersonRelationship>();
            if (form.getiTotalRecords() > 0) {
                infoList = this.productPersonRelationshipService.getPagingList(condition, "", form.getiDisplayLength(), form.getiDisplayStart());
            }
            form.setAaData(infoList);
        } catch (Exception e) {
            form.setIsSuccess(FAILURE);
            form.setMsg(exMsg(e));
            return form;
        }
        return form;
    }
//    @RequestMapping(value = "/form/managerForProduct", headers = "Accept=application/json")
//    @ResponseBody
//    public PProductPersonRelationshipForm managerForProduct(PProductPersonRelationshipForm form) throws Exception {
//        Map<String, Object> condition = new HashMap<String, Object>();
//        try {
//            if (!Strings.isNullOrEmpty(form.getCode())) {
//                condition.put("pCode", form.getCode());
//            }
//            if (!Strings.isNullOrEmpty(form.getTitle())) {
//                condition.put("title", "%" + form.getTitle() + "%");
//            }
//            if (!Strings.isNullOrEmpty(form.getProductType())) {
//                condition.put("productType", form.getProductType());
//            }
//            if(!Strings.isNullOrEmpty(form.getWriter())){
//                condition.put("writer", "%"+form.getWriter()+"%");
//
//            }
//            String productId = request.getParameter("productId");
//            if (productId != null && !"".equals(productId)) {
//                condition.put("productId", productId);
//                condition.put("notProductId", productId);
//            }
//
//            //condition.put("code", form.getCode());
//            condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
//            condition.put("ownerFlag", DicCache.getIdByCode(DicConstants.PRODUCT_OWNER_FLAG, DicConstants.PRODUCT_OWNER_FLAG_SELF));
//            if ("product".equals(form.getFlag())) {
//                condition.put("flowStatus", DicCache.getIdByCode(DicConstants.DIC_FLOW_STATUS, DicConstants.FLOW_STATUS_END));
//            } else if ("app".equals(form.getFlag())) {
//                String[] flowStatus = new String[2];
//                flowStatus[0] = DicCache.getIdByCode(DicConstants.DIC_FLOW_STATUS, DicConstants.FLOW_STATUS_UNDO);
//                flowStatus[1] = DicCache.getIdByCode(DicConstants.DIC_FLOW_STATUS, DicConstants.FLOW_STATUS_DOING);
//                condition.put("someFlowStatus", flowStatus);
//            }
//
//            //condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
//            form.setiTotalDisplayRecords(this.productPersonRelationshipService.getCountForProduct(condition));
//            form.setiTotalRecords(form.getiTotalDisplayRecords());
//            List<PProductPersonRelationship> infoList = new ArrayList<PProductPersonRelationship>();
//            if (form.getiTotalRecords() > 0) {
//                infoList = this.productPersonRelationshipService.getPagingListForProduct(condition, "", form.getiDisplayLength(), form.getiDisplayStart());
//            }
//            form.setAaData(infoList);
//        } catch (Exception e) {
//            form.setIsSuccess(FAILURE);
//            form.setMsg(exMsg(e));
//            return form;
//        }
//        return form;
//    }

    @RequestMapping(value = "/form/authorIndex")
    public ModelAndView index(PProductPersonRelationshipForm form) throws Exception {
        String forwardString = "product/author/author_list";
        Map<String, Object> model = new HashMap<String, Object>();
        try {
        	form.setProductId(form.getProductId());
            model.put("form", form);
        } catch (Exception e) {
            form.setMsg(exMsg(e));
            forwardString = "msg";
        }
        return new ModelAndView(forwardString, model);
    }

    @RequestMapping(value = "/form/batchSave")
    @ResponseBody
    public PProductPersonRelationshipForm batchSave(PProductPersonRelationshipForm form) throws Exception {
        try {
            this.productPersonRelationshipService.saveAll(form.getIds(), form.getProductId());
            form.setMsg("添加成功");//设置类型成功！
            form.setIsSuccess(SUCCESS);
        } catch (Exception e) {
            form.setIsSuccess(FAILURE);
            form.setMsg(exMsg(e, "zh_CN"));
        }
        return form;
    }

    @RequestMapping(value = "/form/delete")
    @ResponseBody
    public PProductPersonRelationshipForm delete(PProductPersonRelationshipForm form) throws Exception {
        try {
            this.productPersonRelationshipService.delete(form.getId());
            form.setMsg("删除成功");//设置类型成功！
            form.setIsSuccess(SUCCESS);
        } catch (Exception e) {
            form.setIsSuccess(FAILURE);
            form.setMsg(exMsg(e, "zh_CN"));
        }
        return form;
    }
    
    /**
     * 查询产品贡献者
     * @param form
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/form/list")
    @ResponseBody
    public List<PProductPersonRelationship> list(PProductPersonRelationshipForm form) throws Exception {
    	List<PProductPersonRelationship> list = new ArrayList<PProductPersonRelationship>();
    	try {
        	Map<String, Object> condition = new HashMap<String, Object>();
        	condition.put("productId", form.getProductId());
        	list = this.productPersonRelationshipService.getList(condition);
        	form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
    	return list;
    }
}