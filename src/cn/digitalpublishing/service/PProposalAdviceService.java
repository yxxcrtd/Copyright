package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.PProposalAdvice;

public interface PProposalAdviceService extends BaseService {
	
	
	public void updatePProposalAdvice(PProposalAdvice obj, String id, String[] properties) throws Exception;
	
	public void insertPProposalAdvice(PProposalAdvice obj) throws Exception;
	
    public List<PProposalAdvice> getPProposalAdvicePagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;
	
	public Integer getPProposalAdviceCount(Map<String, Object> condition) throws Exception;
	
	public PProposalAdvice getPProposalAdvice(String id) throws Exception;
	
	public List<PProposalAdvice> getPProposalAdviceList(Map<String,Object> condition,String sort)throws Exception;

}
