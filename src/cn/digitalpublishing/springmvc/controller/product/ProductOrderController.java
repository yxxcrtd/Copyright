package cn.digitalpublishing.springmvc.controller.product;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.digitalpublishing.po.ProductOrder;
import cn.digitalpublishing.springmvc.controller.BaseController;
import cn.digitalpublishing.springmvc.form.product.ProductOrderForm;

import com.google.common.base.Strings;

@Controller
@RequestMapping("/pages/productOrder")
public class ProductOrderController extends BaseController {

	/**
	 * 显示订单信息首页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/index")
	public ModelAndView index() throws Exception {
		return new ModelAndView("product/order/list");
	}

	/**
	 * 获取订单信息列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/form/manager", headers = "Accept=application/json")
	@ResponseBody
	public ProductOrderForm manage(ProductOrderForm form) throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		try {
			//商品名
			if (!Strings.isNullOrEmpty(form.getName())) {
				condition.put("name", form.getName());
			}
			//ISBN
			if (!Strings.isNullOrEmpty(form.getIsbn())) {
				condition.put("isbn", form.getIsbn());
			}
			form.setiTotalDisplayRecords(this.productOrderService.getCount(condition));
			form.setiTotalRecords(form.getiTotalDisplayRecords());
			List<ProductOrder> orderList = new ArrayList<ProductOrder>();
			if (form.getiTotalRecords() > 0) {
				orderList = this.productOrderService.getPagingList(condition, "", form.getiDisplayLength(), form.getiDisplayStart());
			}
			form.setAaData(orderList);
		} catch (Exception e) {
			form.setMsg(exMsg(e));
		}
		return form;
	}
	
	/**
	 * 显示订单上传页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/form/edit")
	public ModelAndView edit() throws Exception {
		return new ModelAndView("product/order/upload");
	}
	
	/**
	 * 编辑
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/form/add")
	@ResponseBody
	public ProductOrderForm add(ProductOrderForm form) throws Exception {
		try {
			InputStream is = form.getTxtFile().getInputStream();
            this.productOrderService.upload(is);
			form.setMsg("上传订单信息成功!");
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setMsg("上传出错！");
			form.setIsSuccess(FAILURE);
		} finally {
			form.setTxtFile(null);
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
	public ProductOrderForm delete(ProductOrderForm form) throws Exception {
		try {
			this.productOrderService.delete(form.getId());
			form.setMsg("删除成功！");
			form.setIsSuccess(SUCCESS);
		} catch (Exception e) {
			form.setIsSuccess(FAILURE);
			form.setMsg(exMsg(e));
		}
		return form;
	}

}