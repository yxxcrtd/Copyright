package cn.digitalpublishing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.PProductType;
import cn.digitalpublishing.po.PProposalAdvice;
import cn.digitalpublishing.service.PProductTypePropClassifyService;
import cn.digitalpublishing.service.PProductTypeService;
import cn.digitalpublishing.service.PProposalAdviceService;

public class PProposalAdviceServiceImpl extends BaseServiceImpl implements PProposalAdviceService{

	@Override
	public void updatePProposalAdvice(PProposalAdvice obj, String id,
			String[] properties) throws Exception {
		try {
			this.daoFacade.getProposalAdviceDao().update(obj,PProposalAdvice.class.getName(), id, properties);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "exhibit.info.updateEExhibit.error", e);
		}
		
	}

	@Override
	public void insertPProposalAdvice(PProposalAdvice obj) throws Exception {
		try {
			this.daoFacade.getProposalAdviceDao().insert(obj);
	} catch (Exception e) {
		throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.insertCTransaction.error", e);
		}
		
	}

	@Override
	public List<PProposalAdvice> getPProposalAdvicePagingList(Map<String, Object> condition, String sort, Integer pageCount,Integer page) throws Exception {
		List<PProposalAdvice> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProposalAdviceDao").get("getPagingList");
		try{
			list=this.daoFacade.getProposalAdviceDao().getPProposalAdvicePagingList(condition,sort,pageCount,page,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
	}

	@Override
	public Integer getPProposalAdviceCount(Map<String, Object> condition)
			throws Exception {
		Integer num = 0;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProposalAdviceDao").get("getCount");
		try {													 
			num = this.daoFacade.getProposalAdviceDao().getCount(condition,hqlBean);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
		}
		return num;
	}
	
    public PProposalAdvice getPProposalAdvice(String id) throws Exception{
    	PProposalAdvice cla = null;
		try {
			cla = (PProposalAdvice) this.daoFacade.getProposalAdviceDao().get(PProposalAdvice.class.getName(), id);
		} catch (Exception e) {
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransaction.error", e);
		}
		return cla;
    }

	@Override
	public List<PProposalAdvice> getPProposalAdviceList(
			Map<String, Object> condition, String sort) throws Exception {
		List<PProposalAdvice> list=null;
		HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.PProposalAdviceDao").get("getList");
		try{
			list=this.daoFacade.getProposalAdviceDao().getPProposalAdviceList(condition,sort,hqlBean);
		}catch(Exception e){
			throw new CcsException((e instanceof CcsException) ? ((CcsException)e).getPrompt() : "transaction.info.getCTransactionList.error", e);
		}
		return list;
		}
	
}
