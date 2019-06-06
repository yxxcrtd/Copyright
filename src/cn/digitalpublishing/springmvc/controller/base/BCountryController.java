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

import com.google.common.base.Strings;

import cn.digitalpublishing.constants.DicConstants;
import cn.digitalpublishing.po.BCountry;
import cn.digitalpublishing.po.BRegion;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.base.BCountryForm;
import cn.digitalpublishing.util.DicCache;
import cn.digitalpublishing.util.TreeNode;

@Controller
@RequestMapping("/pages/base/country")
public class BCountryController extends BaseController {

	@RequestMapping(value = "/form/index")
	public ModelAndView index(BCountryForm form) throws Exception {
		String forwardString = "base/country/list";
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
	 * 获取国别信息
	 * @param form
	 * @return
	 * @throws Exception
	 *             by Ma Guoqing
	 */
	@RequestMapping(value = "/form/manager", headers = "Accept=application/json")
	@ResponseBody
	public BCountryForm manage(BCountryForm form) throws Exception {
		Map<String, Object> condition = form.getCondition();
		List<BCountry> list = new ArrayList<BCountry>();
		try {
			condition.put("cnName", form.getCnName() == null ? "" : "%" + form.getCnName() + "%");
			condition.put("enName", form.getEnName() == null ? "" : "%" + form.getEnName() + "%");
			
			if(!Strings.isNullOrEmpty(request.getParameter("cnIdInCrRight"))) {
				condition.put("cnIdInCrRight", request.getParameter("cnIdInCrRight"));
			}
			if(!Strings.isNullOrEmpty(request.getParameter("cnIdSubsidaryRight"))) {
				condition.put("cnIdSubsidaryRight", request.getParameter("cnIdSubsidaryRight"));
			}
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			form.setiTotalDisplayRecords(this.countryService.getCount(condition, ""));
			form.setiTotalRecords(form.getiTotalDisplayRecords());
			if (form.getiTotalRecords() > 0) {
				list = this.countryService.getPagingList(condition, " order by createOn desc ", form.getiDisplayLength(), form.getiDisplayStart());
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
	 * 菜单 list
	 * @param form
	 * @throws Exception
	 *             by Ma Guoqing
	 *//*
	@RequestMapping(value = "/form/getMenuZTree")
    @ResponseBody
	public List<TreeNode> getList(BCountryForm form) throws Exception {
		String forwardString = "base/country/show";
		Map<String, Object> model = new HashMap<String, Object>();
		String countryId = request.getParameter("countryId");
		//String reId = request.getParameter("otherId");
		String fatherId = request.getParameter("id");
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		if (fatherId == null) {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("parentId", "1");
			condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
			condition.put("coId", countryId);
			List<BRegion> regions = this.regionService.getList(condition, " order by a.code ");
			if (regions != null && regions.size() > 0) {
				TreeNode node = null;
				for (BRegion br : regions) {
					node = new TreeNode(br.getId(), br.getName(), true, false, null, countryId);
					nodes.add(node);
				}
			}
		} else {
			List<BRegion> regionList = null;
			Map<String, Object> condition = new HashMap<String, Object>();
			if (fatherId.equals(countryId)) {
				condition.clear();
				condition.put("parentId", "1");
				condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
				condition.put("coId", countryId);
				regionList = this.regionService.getList(condition, " order by a.code ");

			} else {
				condition.clear();
				condition.put("parentId", fatherId);
				condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
				condition.put("coId", countryId);
				regionList = this.regionService.getList(condition, " order by a.code ");
			}
			if (regionList != null && regionList.size() > 0) {
				TreeNode node = null;
				condition.clear();
				for (BRegion br : regionList) {
					condition.put("parentId", br.getId());
					condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
					condition.put("coId", countryId);

					int count = this.regionService.getBRegionCount(condition, "");
					if (count != 0) {
						node = new TreeNode(br.getId(), br.getName(), true, false, null, countryId);
					} else {
						node = new TreeNode(br.getId(), br.getName(), false, false, null, countryId);
					}
					nodes.add(node);
				}
			}
		}
		return nodes;

		// 创建JSON对象
		JSONArray nodesString = JSONArray.fromObject(nodes);
		// 设置响应类型
		response.setContentType("text/Xml;charset=utf-8");
		PrintWriter writer = null;
		try {
			// 获取输出流
			writer = response.getWriter();
			writer.print(nodesString.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

		model.put("form", form);
		return new ModelAndView(forwardString, model);
	}*/

	/**
	 * 菜单 list
	 * @param form
	 * @throws Exception
	 *             by Ma Guoqing
	 */
	@RequestMapping(value = "/form/getAllMenuZTree")
    @ResponseBody
	public List<TreeNode> getTreeList(BCountryForm form) throws Exception {
		String countryId = request.getParameter("countryId");
		String fatherId = request.getParameter("id");
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("parentId", fatherId);
		condition.put("status", DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
		condition.put("coId", countryId);
		List<BRegion> regionList = this.regionService.getList(condition, " order by a.code ");
		for (BRegion br : regionList) {
			TreeNode node = null;
			if (br.getChildSize() > 0) {
				node = new TreeNode(br.getId(), br.getName(), true, false, null, countryId);
			} else {
				node = new TreeNode(br.getId(), br.getName(), false, false, null, countryId);
			}
			if (br.getParentRegion()== null) {
    			node.setPid("root");
    		} else {
    			node.setPid(br.getParentRegion().getId());
    		}
			nodes.add(node);
		}
		
		return nodes;

	}
	/**
	 * 获取 地域 修改信息
	 * @param form
	 * @return
	 * @throws Exception
	 *             by Ma Guoqing
	 */
	@RequestMapping(value = "/form/editRegion")
	public ModelAndView editRegion(BCountryForm form) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		String forwardString = "base/country/editRegion";
		String eid = request.getParameter("eid");
		String otherId = request.getParameter("countryId");
		String fatherId = request.getParameter("fatherId");
		try {
			if (otherId != null && !otherId.equals("") && fatherId != null && !fatherId.equals("")) {
				form.setFatherId(fatherId);
				form.setOtherId(otherId);
			} else {
				BRegion br = this.regionService.getBRegion(eid);
				form.setName(br.getName());
				form.setCode(br.getCode());
				form.setId(br.getId());
				form.setOtherId(otherId);
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
	 * 修改地域信息
	 * @param form
	 * @return
	 * @throws Exception
	 *             by Ma Guoqing
	 */
	@RequestMapping(value = "/form/editRegionSubmit")
	@ResponseBody
	public BCountryForm editRegionSubmit(BCountryForm form) throws Exception {

		String otherId = request.getParameter("otherId");
		String fatherId = request.getParameter("fatherId");

		try {

			if (otherId != null && !otherId.equals("") && fatherId != null && !fatherId.equals("")) {

				BRegion br = new BRegion();
				br.setCode(form.getCode());
				br.setName(form.getName());
				br.setCreateOn(new Date());
				br.setCreateBy(form.getCreateBy());
				br.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
				BCountry bc = new BCountry();
				bc.setId(form.getOtherId());
				br.setCountry(bc);
				BRegion b = this.regionService.getBRegion(form.getFatherId());
				br.setFullName((b.getFullName() == null ? b.getName() : b.getFullName()) + "-" + br.getName());
				br.setParentRegion(b);

				this.regionService.insertRegion(br);
				TreeNode node = new TreeNode(br.getId(), br.getName(), false, false, null, br.getCountry().getId());
				form.setNode(node);
				form.setIsSuccess(SUCCESS);
				form.setMsg("添加成功");

			} else {

				BRegion br = new BRegion();
				br.setName(form.getName());
				br.setCode(form.getCode());
				br.setId(form.getId());
				br.setUpdateOn(new Date());
				this.regionService.update(br);
				TreeNode node = new TreeNode(null, br.getName(), false, false, null, null);
				form.setNode(node);
				form.setIsSuccess(SUCCESS);
				form.setMsg("修改成功！");
			}
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}

	/**
	 * 删除地域信息
	 * @param form
	 * @return
	 * @throws Exception
	 *             by Ma Guoqing
	 */

	@RequestMapping(value = "/form/deleteRegion")
	@ResponseBody
	public BCountryForm deleteRegion(BCountryForm form) throws Exception {

		Map<String, Object> model = new HashMap<String, Object>();
		String eid = request.getParameter("eid");

		try {
			this.regionService.delete(eid);
			form.setIsSuccess(SUCCESS);
			form.setMsg("删除成功！");
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}

		model.put("form", form);
		return form;
	}

	/**
	 * 新增/修改 国别信息
	 * @param form
	 * @return
	 * @throws Exception
	 *             by Ma Guoqing
	 */
	@RequestMapping(value = "/form/editCountry")
	public ModelAndView editCountry(BCountryForm form) throws Exception {

		Map<String, Object> model = new HashMap<String, Object>();
		String forwardString = "base/country/edit";
		String id = request.getParameter("eid");
		try {

			if (id != null && !"".equals(id)) {
				BCountry bc = this.countryService.getBCountry(id);
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
	 * 增加/修改 国别信息
	 * @param form
	 * @return
	 * @throws Exception
	 *             by Ma Guoqing
	 */
	@RequestMapping(value = "/form/editCountrySubmit")
	@ResponseBody
	public BCountryForm editCountrySubmit(BCountryForm form) throws Exception {

		BCountry bc = null;
		bc = form.getObj();
		try {
			if (bc != null) {
				if (bc.getId() != null && !bc.getId().equals("")) {
					bc.setUpdateOn(new Date());
					this.countryService.update(bc);

					Map<String, Object> condition = new HashMap<String, Object>();
					condition.put("parentId", "1");
					condition.put("coId", bc.getId());
					List<BRegion> list = regionService.getList(condition, "");
					if (list != null) {
						BRegion br = list.get(0);
						br.setName(bc.getCnName());
						this.regionService.update(br);
					}
					form.setIsSuccess(SUCCESS);
					form.setMsg("修改成功！");
				} else {
					bc.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
					this.countryService.insert(bc);
					BRegion br = new BRegion();
					br.setCountry(bc);
					br.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_AVAILABLE));
					br.setName(bc.getCnName());
					br.setCreateOn(bc.getCreateOn());
					br.setCreateBy(bc.getCreateBy());
					br.setCode("000");
					br.setParentRegion(null);
					this.regionService.insertRegion(br);
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
	 * 删除国别信息
	 * @param form
	 * @return
	 * @throws Exception
	 *             by Ma Guoqing
	 */
	@RequestMapping(value = "/form/delete")
	@ResponseBody
	public BCountryForm delete(BCountryForm form) throws Exception {

		BCountry bc = new BCountry();

		bc.setId(form.getId());
		bc.setStatus(DicCache.getIdByCode(DicConstants.DIC_STATUS, DicConstants.DATA_STATUS_UN_AVAILABLE));
		try {
			this.countryService.update(bc);
			form.setIsSuccess(SUCCESS);
			form.setMsg("注销成功 ！");
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}

		return form;
	}

	@RequestMapping(value = "/form/cnNameUnique")
	@ResponseBody
	public BCountryForm cnNameUnique(BCountryForm form) throws Exception {
		try {
			
			String cnName = form.getCnName();
			if (this.countryService.cnNameUnique(cnName)) {
				form.setIsSuccess(SUCCESS);
				form.setMsg("通过验证");
			} else {
				form.setIsSuccess(FAILURE);
				form.setMsg("已存在相同中文国别名");
			}
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
	@RequestMapping(value = "/form/enNameUnique")
	@ResponseBody
	public BCountryForm enNameUnique(BCountryForm form) throws Exception {
		try {
			
			String enName = form.getEnName();
			if (this.countryService.enNameUnique(enName)) {
				form.setIsSuccess(SUCCESS);
				form.setMsg("通过验证");
			} else {
				form.setIsSuccess(FAILURE);
				form.setMsg("已存在相同英文国别名");
			}
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
	@RequestMapping(value = "/form/codeUnique")
	@ResponseBody
	public BCountryForm codeUnique(BCountryForm form) throws Exception {
		try {
			String countryId = request.getParameter("countryId");
			String code = form.getCode();
			String id = form.getId();
			if (this.regionService.codeUnique(id, code, countryId)) {
				form.setIsSuccess(SUCCESS);
				form.setMsg("通过验证");
			} else {
				form.setIsSuccess(FAILURE);
				form.setMsg("已存在区域代码！");
			}
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}
}