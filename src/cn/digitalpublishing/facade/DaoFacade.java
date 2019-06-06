package cn.digitalpublishing.facade;

import cn.digitalpublishing.dao.*;

/**
 * @author Stone
 */
public class DaoFacade {

	/**
	 * 基础
	 */
	BDicDao dicDao;
	BDicClassDao dicClassDao;
	BCountryDao countryDao;
	BRegionDao regionDao;
	BCurrencyDao currencyDao;
	BExchangeDao exchangeDao;

	/**
	 * 产品
	 */
	PProductDao productDao;
	PProductTypeDao productTypeDao;
	PStructureDao structureDao;
	PProductStructureRelationshipDao productStructureRelationshipDao;
	PStructureTypeDao structureTypeDao;
	PStructureTypePropClassifyDao structureTypePropClassifyDao;
	PStructureTypePropDao structureTypePropDao;
	PStructurePropDao structurePropDao;
	ProductOrderDao productOrderDao;

	/**
	 * 版税结算
	 */
	public CrSettlementDao settlementDao;
	
	/**
	 * 版权版税
	 */
	public PProductLicenseDao productLicenseDao;
    
    /**
	 * 合同
	 */
	public CrContractDao crcontractDao;
	
	/**
	 * 国别权利合同关系
	 */
	public CrCrcRelationshipDao crcRelationshipDao;
	
	/**
	 * 国别附属权利关系
	 */
	public CrCsrRelationshipDao csrRelationshipDao;
	
	/**
	 * 授权类型
	 */
	public CrLicenseTypeDao crLicenseTypeDao;
	
	/**
	 * 语种权利合同关系
	 */
	public CrLrcRelationshipDao lrcRelationshipDao;
	
	/**
	 * 语种附属权利关系
	 */
	public CrLsrRelationshipDao lsrRelationshipDao;
	
	/**
	 * 权利授权
	 */
	public CrRightDao crRightDao;
	
	/**
	 * 计算公式
	 */
	public CrRlFormulaDao crFormulaDao;
	
	/**
	 * 权利授权者
	 */
	public CrRlOwnerDao crOwnerDao;
	
	/**
	 * 预付款及固定费用
	 */
	public CrRlOwnerFeeDao crOwnerFeeDao;
	
	/**
	 * 付款对象
	 */
	public CrRlOwnerPayeeDao crOwnerPayeeDao;
	
	/**
	 * 人员版税计算规则
	 */
	public CrRlOwnerRoyaltyDao crOwnerRoyaltyDao;
	
	/**
	 * 权利授权产品
	 */
	public CrRlProductDao crProductDao;
	
	/**
	 * 版税规则库
	 */
	public CrRlRoyaltyRuleDao crRoyaltyRuleDao;
	
	/**
	 * 版税附属权利
	 */
	public CrSubsidaryRightDao subsidaryRightDao;
	
	/**
	 * 公司类型
	 */
	public CrmCorpTypeDao crmCorpTypeDao;
	
	/**
	 * 人员类型
	 */
	public CrmPersonTypeDao crmPersonTypeDao;
	
	/**
	 * 产品和贡献者关联
	 */
	public PProductPersonRelationshipDao productPersonRelationshipDao;
	
	/**
	 * 公司类型属性分组
	 */
	public CrmCorpTypePropClassifyDao crmCorpTypePropClassifyDao;
	
	/**
	 * 人员类型属性
	 */
	public CrmPeTypePropDao crmPeTypePropDao;
	
	/**
	 * 产品分类
	 */
	public PProductTypePropClassifyDao productTypePropClassifyDao;
	
	/**
	 * 公司类型属性
	 */
	public CrmCtypePropDao crmCtypePropDao;
	
	/**
	 * 策划
	 */
	public PProposalDao proposalDao;
	
	/**
	 * 策划人员关联表
	 */
	public PProposalPersonRelationshipDao proposalPersonRelationshipDao;
	
	/**
	 * 人员类型角色关系
	 */
	public CrmPersonTypeRelationshipDao crmPersonTypeRelationshipDao;
	
	/**
	 * 人员类型角色关系
	 */
	public PProductProposalPersonRelationshipDao productProposalPersonRelationshipDao;
	
	public CrmCtpClassifyDao crmCtpClassifyDao;
	
	public CrmCorpPropDao crmCorpPropDao;
	
	public CrmCorpDao crmCorpDao;
	
    public CrmPeTpClassifyDao crmPeTpClassifyDao;
	
	public CrmPersonPropDao crmPersonPropDao;
	
    public CrmCorpTypeRelationshipDao crmCorpTypeRelationshipDao;
	
	public CrmCorpTypePropDao crmCorpTypePropDao;
	
	public CrmPersonDao crmPersonDao;
	
	public PProposalAdviceDao proposalAdviceDao;
	
	public PProposalAuthorRelationshipDao proposalAuthorRelationshipDao;
	
	public CrmCorpAccountDao crmCorpAccountDao;

	public BDicDao getDicDao() {
		return dicDao;
	}

	public void setDicDao(BDicDao dicDao) {
		this.dicDao = dicDao;
	}

	public BDicClassDao getDicClassDao() {
		return dicClassDao;
	}

	public void setDicClassDao(BDicClassDao dicClassDao) {
		this.dicClassDao = dicClassDao;
	}

	public PProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(PProductDao productDao) {
		this.productDao = productDao;
	}

	public PProductTypeDao getProductTypeDao() {
		return productTypeDao;
	}

	public void setProductTypeDao(PProductTypeDao productTypeDao) {
		this.productTypeDao = productTypeDao;
	}

	public PStructureDao getStructureDao() {
		return structureDao;
	}

	public void setStructureDao(PStructureDao structureDao) {
		this.structureDao = structureDao;
	}

	public PProductStructureRelationshipDao getProductStructureRelationshipDao() {
		return productStructureRelationshipDao;
	}

	public void setProductStructureRelationshipDao(PProductStructureRelationshipDao productStructureRelationshipDao) {
		this.productStructureRelationshipDao = productStructureRelationshipDao;
	}

	public CrContractDao getCrcontractDao() {
		return crcontractDao;
	}

	public void setCrcontractDao(CrContractDao crcontractDao) {
		this.crcontractDao = crcontractDao;
	}

	public CrCrcRelationshipDao getCrcRelationshipDao() {
		return crcRelationshipDao;
	}

	public void setCrcRelationshipDao(CrCrcRelationshipDao crcRelationshipDao) {
		this.crcRelationshipDao = crcRelationshipDao;
	}

	public CrCsrRelationshipDao getCsrRelationshipDao() {
		return csrRelationshipDao;
	}

	public void setCsrRelationshipDao(CrCsrRelationshipDao csrRelationshipDao) {
		this.csrRelationshipDao = csrRelationshipDao;
	}

	public CrLicenseTypeDao getCrLicenseTypeDao() {
		return crLicenseTypeDao;
	}

	public void setCrLicenseTypeDao(CrLicenseTypeDao crLicenseTypeDao) {
		this.crLicenseTypeDao = crLicenseTypeDao;
	}

	public CrLrcRelationshipDao getLrcRelationshipDao() {
		return lrcRelationshipDao;
	}

	public void setLrcRelationshipDao(CrLrcRelationshipDao lrcRelationshipDao) {
		this.lrcRelationshipDao = lrcRelationshipDao;
	}

	public CrLsrRelationshipDao getLsrRelationshipDao() {
		return lsrRelationshipDao;
	}

	public void setLsrRelationshipDao(CrLsrRelationshipDao lsrRelationshipDao) {
		this.lsrRelationshipDao = lsrRelationshipDao;
	}

	public CrRightDao getCrRightDao() {
		return crRightDao;
	}

	public void setCrRightDao(CrRightDao crRightDao) {
		this.crRightDao = crRightDao;
	}

	public CrRlFormulaDao getCrFormulaDao() {
		return crFormulaDao;
	}

	public void setCrFormulaDao(CrRlFormulaDao crFormulaDao) {
		this.crFormulaDao = crFormulaDao;
	}

	public CrRlOwnerDao getCrOwnerDao() {
		return crOwnerDao;
	}

	public void setCrOwnerDao(CrRlOwnerDao crOwnerDao) {
		this.crOwnerDao = crOwnerDao;
	}

	public CrRlOwnerFeeDao getCrOwnerFeeDao() {
		return crOwnerFeeDao;
	}

	public void setCrOwnerFeeDao(CrRlOwnerFeeDao crOwnerFeeDao) {
		this.crOwnerFeeDao = crOwnerFeeDao;
	}

	public CrRlOwnerPayeeDao getCrOwnerPayeeDao() {
		return crOwnerPayeeDao;
	}

	public void setCrOwnerPayeeDao(CrRlOwnerPayeeDao crOwnerPayeeDao) {
		this.crOwnerPayeeDao = crOwnerPayeeDao;
	}

	public CrRlOwnerRoyaltyDao getCrOwnerRoyaltyDao() {
		return crOwnerRoyaltyDao;
	}

	public void setCrOwnerRoyaltyDao(CrRlOwnerRoyaltyDao crOwnerRoyaltyDao) {
		this.crOwnerRoyaltyDao = crOwnerRoyaltyDao;
	}

	public CrRlProductDao getCrProductDao() {
		return crProductDao;
	}

	public void setCrProductDao(CrRlProductDao crProductDao) {
		this.crProductDao = crProductDao;
	}

	public CrRlRoyaltyRuleDao getCrRoyaltyRuleDao() {
		return crRoyaltyRuleDao;
	}

	public void setCrRoyaltyRuleDao(CrRlRoyaltyRuleDao crRoyaltyRuleDao) {
		this.crRoyaltyRuleDao = crRoyaltyRuleDao;
	}

	public CrSubsidaryRightDao getSubsidaryRightDao() {
		return subsidaryRightDao;
	}

	public void setSubsidaryRightDao(CrSubsidaryRightDao subsidaryRightDao) {
		this.subsidaryRightDao = subsidaryRightDao;
	}

	public PProductLicenseDao getProductLicenseDao() {
		return productLicenseDao;
	}

	public void setProductLicenseDao(PProductLicenseDao productLicenseDao) {
		this.productLicenseDao = productLicenseDao;
	}

	public CrmCorpTypeDao getCrmCorpTypeDao() {
		return crmCorpTypeDao;
	}

	public void setCrmCorpTypeDao(CrmCorpTypeDao crmCorpTypeDao) {
		this.crmCorpTypeDao = crmCorpTypeDao;
	}

	public CrmPersonTypeDao getCrmPersonTypeDao() {
		return crmPersonTypeDao;
	}

	public void setCrmPersonTypeDao(CrmPersonTypeDao crmPersonTypeDao) {
		this.crmPersonTypeDao = crmPersonTypeDao;
	}

	public PProductPersonRelationshipDao getProductPersonRelationshipDao() {
		return productPersonRelationshipDao;
	}

	public void setProductPersonRelationshipDao(PProductPersonRelationshipDao productPersonRelationshipDao) {
		this.productPersonRelationshipDao = productPersonRelationshipDao;
	}

	public CrmCorpTypePropClassifyDao getCrmCorpTypePropClassifyDao() {
		return crmCorpTypePropClassifyDao;
	}

	public void setCrmCorpTypePropClassifyDao(CrmCorpTypePropClassifyDao crmCorpTypePropClassifyDao) {
		this.crmCorpTypePropClassifyDao = crmCorpTypePropClassifyDao;
	}

	public CrmPeTypePropDao getCrmPeTypePropDao() {
		return crmPeTypePropDao;
	}

	public void setCrmPeTypePropDao(CrmPeTypePropDao crmPeTypePropDao) {
		this.crmPeTypePropDao = crmPeTypePropDao;
	}

	public PProductTypePropClassifyDao getProductTypePropClassifyDao() {
		return productTypePropClassifyDao;
	}

	public void setProductTypePropClassifyDao(PProductTypePropClassifyDao productTypePropClassifyDao) {
		this.productTypePropClassifyDao = productTypePropClassifyDao;
	}

	public CrmCtypePropDao getCrmCtypePropDao() {
		return crmCtypePropDao;
	}

	public void setCrmCtypePropDao(CrmCtypePropDao crmCtypePropDao) {
		this.crmCtypePropDao = crmCtypePropDao;
	}

	public PProposalDao getProposalDao() {
		return proposalDao;
	}

	public void setProposalDao(PProposalDao proposalDao) {
		this.proposalDao = proposalDao;
	}

	public PProposalPersonRelationshipDao getProposalPersonRelationshipDao() {
		return proposalPersonRelationshipDao;
	}

	public void setProposalPersonRelationshipDao(PProposalPersonRelationshipDao proposalPersonRelationshipDao) {
		this.proposalPersonRelationshipDao = proposalPersonRelationshipDao;
	}

	public CrmPersonTypeRelationshipDao getCrmPersonTypeRelationshipDao() {
		return crmPersonTypeRelationshipDao;
	}

	public void setCrmPersonTypeRelationshipDao(CrmPersonTypeRelationshipDao crmPersonTypeRelationshipDao) {
		this.crmPersonTypeRelationshipDao = crmPersonTypeRelationshipDao;
	}

	public PProductProposalPersonRelationshipDao getProductProposalPersonRelationshipDao() {
		return productProposalPersonRelationshipDao;
	}

	public void setProductProposalPersonRelationshipDao(PProductProposalPersonRelationshipDao productProposalPersonRelationshipDao) {
		this.productProposalPersonRelationshipDao = productProposalPersonRelationshipDao;
	}

	public BCountryDao getCountryDao() {
		return countryDao;
	}

	public void setCountryDao(BCountryDao countryDao) {
		this.countryDao = countryDao;
	}

	public BRegionDao getRegionDao() {
		return regionDao;
	}

	public void setRegionDao(BRegionDao regionDao) {
		this.regionDao = regionDao;
	}

	public PStructureTypeDao getStructureTypeDao() {
		return structureTypeDao;
	}

	public void setStructureTypeDao(PStructureTypeDao structureTypeDao) {
		this.structureTypeDao = structureTypeDao;
	}

	public PStructureTypePropClassifyDao getStructureTypePropClassifyDao() {
		return structureTypePropClassifyDao;
	}

	public void setStructureTypePropClassifyDao(PStructureTypePropClassifyDao structureTypePropClassifyDao) {
		this.structureTypePropClassifyDao = structureTypePropClassifyDao;
	}

	public PStructureTypePropDao getStructureTypePropDao() {
		return structureTypePropDao;
	}

	public void setStructureTypePropDao(PStructureTypePropDao structureTypePropDao) {
		this.structureTypePropDao = structureTypePropDao;
	}

	public PStructurePropDao getStructurePropDao() {
		return structurePropDao;
	}

	public void setStructurePropDao(PStructurePropDao structurePropDao) {
		this.structurePropDao = structurePropDao;
	}

	public CrmCtpClassifyDao getCrmCtpClassifyDao() {
		return crmCtpClassifyDao;
	}

	public void setCrmCtpClassifyDao(CrmCtpClassifyDao crmCtpClassifyDao) {
		this.crmCtpClassifyDao = crmCtpClassifyDao;
	}

	public CrmCorpPropDao getCrmCorpPropDao() {
		return crmCorpPropDao;
	}

	public void setCrmCorpPropDao(CrmCorpPropDao crmCorpPropDao) {
		this.crmCorpPropDao = crmCorpPropDao;
	}

	public CrmCorpDao getCrmCorpDao() {
		return crmCorpDao;
	}

	public void setCrmCorpDao(CrmCorpDao crmCorpDao) {
		this.crmCorpDao = crmCorpDao;
	}

	public CrmPeTpClassifyDao getCrmPeTpClassifyDao() {
		return crmPeTpClassifyDao;
	}

	public void setCrmPeTpClassifyDao(CrmPeTpClassifyDao crmPeTpClassifyDao) {
		this.crmPeTpClassifyDao = crmPeTpClassifyDao;
	}

	public CrmPersonPropDao getCrmPersonPropDao() {
		return crmPersonPropDao;
	}

	public void setCrmPersonPropDao(CrmPersonPropDao crmPersonPropDao) {
		this.crmPersonPropDao = crmPersonPropDao;
	}

	public CrmCorpTypeRelationshipDao getCrmCorpTypeRelationshipDao() {
		return crmCorpTypeRelationshipDao;
	}

	public void setCrmCorpTypeRelationshipDao(CrmCorpTypeRelationshipDao crmCorpTypeRelationshipDao) {
		this.crmCorpTypeRelationshipDao = crmCorpTypeRelationshipDao;
	}

	public CrmCorpTypePropDao getCrmCorpTypePropDao() {
		return crmCorpTypePropDao;
	}

	public void setCrmCorpTypePropDao(CrmCorpTypePropDao crmCorpTypePropDao) {
		this.crmCorpTypePropDao = crmCorpTypePropDao;
	}

	public CrmPersonDao getCrmPersonDao() {
		return crmPersonDao;
	}

	public void setCrmPersonDao(CrmPersonDao crmPersonDao) {
		this.crmPersonDao = crmPersonDao;
	}

	public PProposalAdviceDao getProposalAdviceDao() {
		return proposalAdviceDao;
	}

	public void setProposalAdviceDao(PProposalAdviceDao proposalAdviceDao) {
		this.proposalAdviceDao = proposalAdviceDao;
	}

	public PProposalAuthorRelationshipDao getProposalAuthorRelationshipDao() {
		return proposalAuthorRelationshipDao;
	}

	public void setProposalAuthorRelationshipDao(PProposalAuthorRelationshipDao proposalAuthorRelationshipDao) {
		this.proposalAuthorRelationshipDao = proposalAuthorRelationshipDao;
	}

	public CrmCorpAccountDao getCrmCorpAccountDao() {
		return crmCorpAccountDao;
	}

	public void setCrmCorpAccountDao(CrmCorpAccountDao crmCorpAccountDao) {
		this.crmCorpAccountDao = crmCorpAccountDao;
	}

	public BCurrencyDao getCurrencyDao() {
		return currencyDao;
	}

	public void setCurrencyDao(BCurrencyDao currencyDao) {
		this.currencyDao = currencyDao;
	}

	public BExchangeDao getExchangeDao() {
		return exchangeDao;
	}

	public void setExchangeDao(BExchangeDao exchangeDao) {
		this.exchangeDao = exchangeDao;
	}

	public ProductOrderDao getProductOrderDao() {
		return productOrderDao;
	}

	public void setProductOrderDao(ProductOrderDao productOrderDao) {
		this.productOrderDao = productOrderDao;
	}

	public CrSettlementDao getSettlementDao() {
		return settlementDao;
	}

	public void setSettlementDao(CrSettlementDao settlementDao) {
		this.settlementDao = settlementDao;
	}
	
}