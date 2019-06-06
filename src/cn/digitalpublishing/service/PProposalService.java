package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.PProposal;


public interface PProposalService extends BaseService {
	
	public void updatePProposal(PProposal obj, String id, String[] properties) throws Exception;
	
	public void insertPProposal(PProposal obj) throws Exception;
	
	public void deletePProposal(String id) throws Exception;
	
    public List<PProposal> getPProposalPagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;
	
	public Integer getPProposalCount(Map<String, Object> condition) throws Exception;
	
	public PProposal getPProposal(String id) throws Exception;
	
	public List<PProposal> getPProposalList(Map<String,Object> condition,String sort)throws Exception;
	 
	public boolean nameUnique(String id,String tid)throws Exception;
}
