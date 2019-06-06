package cn.digitalpublishing.springmvc.controller.product;

import cn.digitalpublishing.po.PProposal;
import cn.digitalpublishing.po.PProposalAdvice;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.product.PProposalAdviceForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/pages/product/proposalAdvice")
public class PProposalAdviceController extends BaseController {
    @RequestMapping(value = "/form/index")
    public ModelAndView index(PProposalAdviceForm form) throws Exception {
        String forwardString = "product/proposalAdvice/list";
        Map<String, Object> model = new HashMap<String, Object>();
        try {
            form.setIsSuccess(SUCCESS);
        } catch (Exception e) {
            form.setIsSuccess(FAILURE);
            form.setMsg(exMsg(e));
        }
        model.put("form", form);
        return new ModelAndView(forwardString, model);
    }

    @RequestMapping(value = "/form/manager", headers = "Accept=application/json")
    @ResponseBody
    public PProposalAdviceForm manage(PProposalAdviceForm form) throws Exception {
        Map<String, Object> condition = new HashMap<String, Object>();
        try {
            condition.put("tid", form.getTid());
            condition.put("desc", form.getDesc() == null ? "" : "%" + form.getDesc() + "%");
            form.setiTotalDisplayRecords(this.proposalAdviceService.getPProposalAdviceCount(condition));
            form.setiTotalRecords(form.getiTotalDisplayRecords());
            List<PProposalAdvice> propList = new ArrayList<PProposalAdvice>();
            if (form.getiTotalDisplayRecords() > 0) {
                propList = this.proposalAdviceService.getPProposalAdvicePagingList(condition, "", form.getiDisplayLength(), form.getiDisplayStart());
            }
            form.setAaData(propList);
        } catch (Exception e) {
            form.setMsg(exMsg(e));
        }
        return form;
    }

    @RequestMapping(value = "/form/edit")
    public ModelAndView editPProposal(PProposalAdviceForm form) throws Exception {
        String forwardString = "product/proposalAdvice/edit";
        Map<String, Object> model = new HashMap<String, Object>();
        Map<String, Object> condition = new HashMap<String, Object>();
        try {
            form.setIsSuccess(SUCCESS);
        } catch (Exception e) {
            form.setMsg(exMsg(e));
        }
        model.put("form", form);
        return new ModelAndView(forwardString, model);
    }

    @RequestMapping(value = "/form/editSubmit")
    @ResponseBody
    public PProposalAdviceForm editPProposalSubmit(PProposalAdviceForm form) throws Exception {
        try {
            /*if(!Strings.isNullOrEmpty(form.getId())){
                this.proposalAdviceService.updatePProposalAdvice(form.getObj(), form.getId(),null);
				form.setMsg("修改策划成功！");
			}else {*/
            Map<String, Object> startMap = new HashMap<String, Object>();
            Map<String, Object> accountInfo = (Map<String, Object>) request.getSession().getAttribute("pt_accountInfo");
            String accountId = accountInfo.get("employeeId").toString();

            PProposalAdvice proposalAdvice = new PProposalAdvice();
            proposalAdvice.setCreateBy(accountId);
            proposalAdvice.setCreateOn(new Date());
            proposalAdvice.setDesc(form.getObj().getDesc());
            PProposal proposal = new PProposal();
            proposal.setId(form.getTid());
            proposalAdvice.setProposal(proposal);
            proposalAdviceService.insertPProposalAdvice(proposalAdvice);
            form.setMsg("新增策划意见成功！");
            /*}*/
            form.setIsSuccess(SUCCESS);
        } catch (Exception e) {
        	form.setMsg("新增策划意见失败！");
            form.setIsSuccess(FAILURE);
            form.setMsg(exMsg(e));
        }
        return form;
    }
}
