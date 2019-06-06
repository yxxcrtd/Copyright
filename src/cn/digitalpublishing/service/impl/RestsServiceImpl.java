package cn.digitalpublishing.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.common.base.Strings;

import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.model.ResultObject;
import cn.com.daxtech.mail.po.MailTemplate;
import cn.digitalpublishing.po.MPromotion;
import cn.digitalpublishing.po.SysAccount;
import cn.digitalpublishing.remote.service.RestService;
import cn.digitalpublishing.service.RestsService;
import cn.digitalpublishing.util.Map2Object;
import cn.digitalpublishing.util.SendMail;

public class RestsServiceImpl extends BaseServiceImpl implements RestsService {
	
	public final static Integer RESULT_SUCCESS = 1; 
	
	public final static Integer RESULT_FAILURE = 2;
	
	protected RestService urls;
	
	protected RestTemplate template;
	
	public RestService getUrls() {
		return urls;
	}

	public void setUrls(RestService urls) {
		this.urls = urls;
	}

	public RestTemplate getTemplate() {
		return template;
	}

	public void setTemplate(RestTemplate template) {
		this.template = template;
	}

	@Override
	public SysAccount getAccount(String id) throws Exception {

		// TODO Auto-generated method stub
		SysAccount account = null;
		String url = this.getUrls().getService("getAccount") + id + ".json";
		try {
			@SuppressWarnings("rawtypes")
			ResponseEntity<ResultObject> entity = template.getForEntity(url, ResultObject.class);
			@SuppressWarnings({ "rawtypes" })
			ResultObject obj = entity.getBody();
			if (obj.getType() == RESULT_SUCCESS) {
				Object o = obj.getObj() == null ? (new SysAccount()) : obj.getObj().get(0);
				if (LinkedHashMap.class.getName().equals(o.getClass().getName())) {
					account = (SysAccount) Map2Object.convert((LinkedHashMap) o, SysAccount.class.getName());
				}
				if (SysAccount.class.getName().equals(o.getClass().getName())) {
					account = (SysAccount) o;
				}
			} else {
				throw new CcsException(obj.getMsg());
			}
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "Rest.Get.Account.Failure", e);
		}
		return account;
	}

	@Override
	public void updateAccount(SysAccount obj) throws Exception {

		// TODO Auto-generated method stub
		String url = this.getUrls().getService("insertAccount");
		try {
			String operType = (obj.getId() != null && !"".equals(obj.getId()) ? "2" : "1");
			String param = "operType=" + operType;
			url = url + "?" + param;
			if (obj.getLevel() == null) {
				obj.setLevel(2);
			}
			if (obj.getType() == null) {
				obj.setType(1);
			}
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("operType", operType);
			params.put("account", obj);
			@SuppressWarnings("rawtypes")
			ResponseEntity<ResultObject> entity = template.postForEntity(url, params, ResultObject.class);
			@SuppressWarnings("unchecked")
			ResultObject<SysAccount> o = entity.getBody();
			if (o.getType() == RESULT_SUCCESS) {
			} else {
				throw new CcsException(o.getMsg());
			}
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "Rest.Operation.Account.Failure", e);
		}
	}

	@Override
	public boolean sendMail(String title, String body, String sysId, String mail, String ccMail, String filePath, String userId, String templateId,String productId) throws Exception {

		String url = this.getUrls().getService("mail");
		SendMail sendMail = new SendMail(url);
		try {
			Map<String,String> titleMap = new HashMap<String,String>();
			titleMap.put("title", title);
			
			Map<String,String> bodyMap = new HashMap<String,String>();
			bodyMap.put("body", body);
			
			return sendMail.sendMail(titleMap, bodyMap, sysId, mail, ccMail, filePath, userId, templateId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Map<String, String> getTemplate(String templateId,Map<String,String> mailTitle,Map<String,String> mailBody) throws Exception {
		Map<String, String> templateMap = new HashMap<String,String>();
		String url = this.getUrls().getService("getTemplate");
		MailTemplate obj  = new MailTemplate();
		try {
			if (!Strings.isNullOrEmpty(templateId)) {
				obj.setName(templateId);
				
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("template", obj);
				params.put("operType", "3");
				@SuppressWarnings("rawtypes")
				ResponseEntity<ResultObject> entity = template.postForEntity(url, params, ResultObject.class);
				@SuppressWarnings("unchecked")
				ResultObject objr = entity.getBody();
				if (objr.getType() == RESULT_SUCCESS) {
					
					Object o = objr.getObj() == null ? (new MailTemplate()) : objr.getObj().get(0);
					if (LinkedHashMap.class.getName().equals(o.getClass().getName())) {
						obj = (MailTemplate) Map2Object.convert((LinkedHashMap) o, MailTemplate.class.getName());
					}
					if (MailTemplate.class.getName().equals(o.getClass().getName())) {
						obj = (MailTemplate) o;
					}
					
					Map<String,String> reMap = SendMail.pretreatment(mailTitle, mailBody);
					Map<String,String> map = new HashMap<String,String>();
					map.put("title",reMap.get("title"));
					map.put("body",reMap.get("body"));
					map.put("bodyTemplate", obj.getContent());
					map.put("titleTemplate", obj.getTitle());
					templateMap = SendMail.conversion(map);
				} else {
					throw new CcsException(objr.getMsg());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "Rest.Operation.Account.Failure", e);
		}
		return templateMap;
	}

}
