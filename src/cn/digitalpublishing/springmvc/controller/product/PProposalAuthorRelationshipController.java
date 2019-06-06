package cn.digitalpublishing.springmvc.controller.product;

import cn.digitalpublishing.po.PProposalAuthorRelationship;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.product.PProposalAuthorRelationshipForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pages/proposalAuthorRelationship")
public class PProposalAuthorRelationshipController extends BaseController {

    @RequestMapping(value = "/form/manager", headers = "Accept=application/json")
    @ResponseBody
    public PProposalAuthorRelationshipForm manage(PProposalAuthorRelationshipForm form) throws Exception {
        Map<String, Object> condition = new HashMap<String, Object>();
        List<PProposalAuthorRelationship> infoList = new ArrayList<PProposalAuthorRelationship>();
        try {
        	String proposalId = form.getProposalId();
        	if(proposalId != null && !"".equals(proposalId.trim())){
        		condition.put("proposalId", form.getProposalId());
        		form.setiTotalDisplayRecords(this.proposalAuthorRelationshipService.getCount(condition));
                form.setiTotalRecords(form.getiTotalDisplayRecords());
                if (form.getiTotalRecords() > 0) {
                    infoList = this.proposalAuthorRelationshipService.getPagingList(condition, "", form.getiDisplayLength(), form.getiDisplayStart());
                }
        	} else{
        		form.setiTotalDisplayRecords(0);
                form.setiTotalRecords(0);
        	}
            form.setAaData(infoList);
        } catch (Exception e) {
            form.setIsSuccess(FAILURE);
            form.setMsg(exMsg(e));
            return form;
        }
        return form;
    }
    
    @RequestMapping(value = "/form/authorIndex")
    public ModelAndView index(PProposalAuthorRelationshipForm form) throws Exception {
        String forwardString = "product/proposalAuthor/author_list";
        Map<String, Object> model = new HashMap<String, Object>();
        try {
            model.put("form", form);
        } catch (Exception e) {
            form.setMsg(exMsg(e));
            forwardString = "msg";
        }
        return new ModelAndView(forwardString, model);
    }

    @RequestMapping(value = "/form/batchSave")
    @ResponseBody
    public PProposalAuthorRelationshipForm batchSave(PProposalAuthorRelationshipForm form) throws Exception {
        try {
        	if(null != form.getProposalId()&& !"".equals(form.getProposalId().trim())){
        		this.proposalAuthorRelationshipService.saveAll(form.getIds(), form.getProposalId());
                form.setMsg("成功");//设置类型成功！
                form.setIsSuccess(SUCCESS);

        	} else{
        		 form.setIsSuccess(FAILURE);
                 form.setMsg("请先保存策划!");
        	}
        } catch (Exception e) {
            form.setIsSuccess(FAILURE);
            form.setMsg(exMsg(e, "zh_CN"));
        }
        return form;
    }

    @RequestMapping(value = "/form/delete")
    @ResponseBody
    public PProposalAuthorRelationshipForm delete(PProposalAuthorRelationshipForm form) throws Exception {
        try {
            this.proposalAuthorRelationshipService.delete(form.getId());
            form.setMsg("成功");//设置类型成功！
            form.setIsSuccess(SUCCESS);
        } catch (Exception e) {
            form.setIsSuccess(FAILURE);
            form.setMsg(exMsg(e, "zh_CN"));
        }
        return form;
    }
}