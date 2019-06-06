package cn.digitalpublishing.service;

import java.util.Map;

import cn.digitalpublishing.po.SysAccount;


public interface RestsService extends BaseService {
	/**
	 * 获取账户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SysAccount getAccount(String id)throws Exception;
	/**
	 * 更新账户信息
	 * @param obj
	 * @throws Exception
	 */
	public void updateAccount(SysAccount obj)throws Exception;

	/**
	 * 发送邮件
	 * @param title
	 * @param body
	 * @param sysId
	 * @param mail
	 * @param ccMail
	 * @param filePath
	 * @param userId
	 * @param templateId
	 * @return
	 * @throws Exception
	 * 		by Ma Guoqing
	 */
	public boolean sendMail(String title,String body, String sysId, String mail,String ccMail,String filePath, String userId, String templateId,String orderId) throws Exception;

	/**
	 * 获取  模版信息
	 * @param templateId
	 * @param mailTitle
	 * @param mailBody
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> getTemplate (String templateId,Map<String,String> mailTitle,Map<String,String> mailBody) throws Exception;
}
