package cn.digitalpublishing.springmvc.controller.product;

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
import cn.digitalpublishing.po.PProposal;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.product.PProposalForm;
import cn.digitalpublishing.util.DicCache;

import com.google.common.base.Strings;

@Controller
@RequestMapping("/pages/product/proposal")
public class PProposalController extends BaseController {
    @RequestMapping(value = "/form/index")
    public ModelAndView index(PProposalForm form) throws Exception {
        String forwardString = "product/proposal/list";
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
    public PProposalForm manage(PProposalForm form) throws Exception {
        Map<String, Object> condition = new HashMap<String, Object>();
        try {
            condition.put("name", form.getName() == null ? "" : "%" + form.getName() + "%");
            condition.put("desc", form.getDesc() == null ? "" : "%" + form.getDesc() + "%");
            form.setiTotalDisplayRecords(this.proposalService.getPProposalCount(condition));
            form.setiTotalRecords(form.getiTotalDisplayRecords());
            List<PProposal> propList = new ArrayList<PProposal>();
            if (form.getiTotalDisplayRecords() > 0) {
                propList = this.proposalService.getPProposalPagingList(condition, "", form.getiDisplayLength(), form.getiDisplayStart());
            }
            form.setAaData(propList);
        } catch (Exception e) {
            form.setMsg(exMsg(e));
        }
        return form;
    }

    @RequestMapping(value = "/form/edit")
    public ModelAndView editPProposal(PProposalForm form) throws Exception {
        String forwardString = "product/proposal/edit";
        Map<String, Object> model = new HashMap<String, Object>();
        try {
            String id = form.getId();
            if (!Strings.isNullOrEmpty(id)) {
                PProposal obj = this.proposalService.getPProposal(id);
                form.setObj(obj);
                form.setId(id);
            }
            Map<String,String> roleTypeMap = DicCache.getDicData(DicConstants.DIC_PROPOSAL_ROLE_TYPE);
            String teamWork = DicCache.getIdByCode(DicConstants.DIC_PROPOSAL_ROLE_TYPE,DicConstants.PROPOSAL_ROLE_PROTECTED);
            form.setTeamWork(teamWork);

            form.setRoleTypeMap(roleTypeMap);
            form.setIsSuccess(SUCCESS);
        } catch (Exception e) {
            form.setMsg(exMsg(e));
        }
        model.put("form", form);
        return new ModelAndView(forwardString, model);
    }

    @RequestMapping(value = "/form/editSubmit")
    @ResponseBody
    public PProposalForm editPProposalSubmit(PProposalForm form) throws Exception {
        try {
            if (form.getObj()!=null && !Strings.isNullOrEmpty(form.getObj().getId())) {
                this.proposalService.updatePProposal(form.getObj(), form.getObj().getId(), null);
                form.setMsg("修改策划成功！");
            } else {
                PProposal proposal = form.getObj();
                proposal.setCreateOn(new Date());
                proposalService.insertPProposal(proposal);
                form.setObj(proposal);
                form.setMsg("创建策划成功！");
            }

            form.setIsSuccess(SUCCESS);
        } catch (Exception e) {
            form.setIsSuccess(FAILURE);
            form.setMsg(exMsg(e));
        }
        return form;
    }

    @RequestMapping(value = "/form/nameUnique")
    @ResponseBody
    public PProposalForm nameUnique(PProposalForm form) throws Exception {
        try {
            String id = request.getParameter("id");
            if (this.proposalService.nameUnique(id, form.getName())) {
                form.setIsSuccess(SUCCESS);
                form.setMsg("通过验证");
            } else {
                form.setIsSuccess(FAILURE);
                form.setMsg("已存在相同name值");
            }
        } catch (Exception e) {
            form.setIsSuccess(FAILURE);
            form.setMsg(exMsg(e));
        }
        return form;
    }
    
    @RequestMapping(value = "/form/delete")
	@ResponseBody
	public PProposalForm delete(PProposalForm form) throws Exception {
		try {
			String id = form.getId();
			this.proposalService.deletePProposal(id);
			form.setMsg("策划创意成功！");
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}
    
}