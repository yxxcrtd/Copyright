package cn.digitalpublishing.springmvc.controller.product;

import cn.digitalpublishing.po.CrmCorpAccount;
import cn.digitalpublishing.po.CrmPersonTypeRelationship;
import cn.digitalpublishing.po.PProposalPersonRelationship;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.CrmCorpAccountForm;
import cn.digitalpublishing.springmvc.form.product.PProposalPersonRelationshipForm;
import com.google.common.base.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huangchenxi on 14-7-15.
 */

@Controller
@RequestMapping("/pages/product/proposalPersonRela")
public class PProposalPersonRelationshipController extends BaseController {
    @RequestMapping(value = "/form/manager", headers = "Accept=application/json")
    @ResponseBody
    public PProposalPersonRelationshipForm manage(PProposalPersonRelationshipForm form) throws Exception {
        Map<String, Object> condition = new HashMap<String, Object>();
        Map<String, Object> accountInfo = (Map<String, Object>) session.getAttribute("pt_accountInfo");
        String accountId = accountInfo.get("employeeId").toString();
        condition.put("id", accountId);

        CrmPersonTypeRelationship crmPersonTypeRelationship = this.crmPersonTypeRelationshipService.getCrmPersonTypeRelationship(accountId);
        condition.clear();
        String personId = null;
        if (crmPersonTypeRelationship != null) {
            personId = crmPersonTypeRelationship.getPerson().getId();
        }
        try {
            if(!Strings.isNullOrEmpty(form.getName())){
                condition.put("name",form.getName());
            }
            if(!Strings.isNullOrEmpty(form.getDesc())){
                condition.put("desc",form.getDesc());
            }
            if (!Strings.isNullOrEmpty(form.getPersonId()) && !Strings.isNullOrEmpty(personId)) {
                condition.put("personId", personId);
            } else if (!Strings.isNullOrEmpty(form.getPersonId()) && Strings.isNullOrEmpty(personId)) {
                condition.put("all", "1");
            } else if (!Strings.isNullOrEmpty(form.getProposalId())) {
                condition.put("proposalId", form.getProposalId());
                String ptId = this.proposalService.getPProposal(form.getProposalId()).getCreateBy();
                String owner = this.crmPersonTypeRelationshipService.getCrmPersonTypeRelationship(ptId).getPerson().getId();
                condition.put("notMe", owner);
            }
            if (condition.isEmpty()) {
                form.setiTotalDisplayRecords(0);
                form.setiTotalRecords(0);
                form.setAaData(null);
                return form;
            }
            form.setiTotalDisplayRecords(this.proposalPersonRelationshipService.getCount(condition));
            form.setiTotalRecords(form.getiTotalDisplayRecords());
            List<PProposalPersonRelationship> propList = new ArrayList<PProposalPersonRelationship>();
            if (form.getiTotalDisplayRecords() > 0) {
                propList = this.proposalPersonRelationshipService.getProposalPersonRelaPagingList(condition, "", form.getiDisplayLength(), form.getiDisplayStart());
            }
            form.setAaData(propList);
        } catch (Exception e) {
            form.setMsg(exMsg(e));
        }
        return form;
    }

    @RequestMapping(value = "/form/savePersons", headers = "Accept=application/json")
    @ResponseBody
    public PProposalPersonRelationshipForm savePersons(PProposalPersonRelationshipForm form) throws Exception {
        try {
            this.proposalPersonRelationshipService.savePersons(form.getId(), form.getIds());
            form.setIsSuccess(SUCCESS);
            form.setMsg("选择人员成功");
        } catch (Exception e) {
            form.setMsg(exMsg(e));
        }
        return form;
    }

    @RequestMapping(value = "/form/delPerson", headers = "Accept=application/json")
    @ResponseBody
    public PProposalPersonRelationshipForm delPerson(PProposalPersonRelationshipForm form) throws Exception {
        try {
            this.proposalPersonRelationshipService.delProposalPersonRela(form.getId());
            form.setIsSuccess(SUCCESS);
            form.setMsg("删除可见人员成功");
        } catch (Exception e) {
            form.setMsg(exMsg(e));
        }
        return form;
    }

    @RequestMapping(value = "/form/selectPerson")
    public ModelAndView edit(CrmCorpAccountForm form) {
    	//form.getId();
        String forwardString = "product/proposal/org";
        Map<String, Object> model = new HashMap<String, Object>();
        CrmCorpAccount account = form.getAccount();
        try {
            if (!Strings.isNullOrEmpty(account.getId())) {
                form.setAccount(this.crmCorpAccountService.get(account));
            }
            model.put("form", form);
        } catch (Exception e) {
            form.setMsg(exMsg(e));
        }
        return new ModelAndView(forwardString, model);
    }
}
