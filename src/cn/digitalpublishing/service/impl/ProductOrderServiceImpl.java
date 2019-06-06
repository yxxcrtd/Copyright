package cn.digitalpublishing.service.impl;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.com.daxtech.framework.bean.HqlBean;
import cn.com.daxtech.framework.exception.CcsException;
import cn.com.daxtech.framework.util.hql.HqlBeanCacheUtil;
import cn.digitalpublishing.po.ProductOrder;
import cn.digitalpublishing.service.ProductOrderService;
import cn.digitalpublishing.util.DateFormatUitl;

public class ProductOrderServiceImpl extends BaseServiceImpl implements ProductOrderService {

    @Override
    public void upload(InputStream inputStream) throws Exception {
        try {
            XSSFWorkbook xwb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = xwb.getSheetAt(0);
            for (int i = sheet.getFirstRowNum(); i <= sheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = sheet.getRow(i);
                if (row != null) {
                    XSSFCell code = row.getCell(0);
                    XSSFCell name = row.getCell(1);
                    XSSFCell isbn = row.getCell(2);
                    XSSFCell listPrice = row.getCell(3);
                    XSSFCell salePrice = row.getCell(4);
                    XSSFCell quantity = row.getCell(5);
                    XSSFCell discount = row.getCell(6);
                    XSSFCell tradeDate = row.getCell(7);
                    
                    ProductOrder order = new ProductOrder();
                    order.setCode(code.toString());
                    order.setName(name.toString());
                    order.setIsbn(isbn.toString());
                    order.setListPrice(new BigDecimal(listPrice.toString()));
                    order.setSalePrice(new BigDecimal(salePrice.toString()));
                    order.setQuantity(new BigDecimal(quantity.toString()));
                    order.setDiscount(new BigDecimal(discount.toString()));
                    order.setTradeDate(DateFormatUitl.stringToDate(tradeDate.toString()));
                    this.daoFacade.getProductOrderDao().insert(order);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new CcsException("解析Excel出错！");
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            this.daoFacade.getProductOrderDao().delete(ProductOrder.class.getName(), id);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.deletecTransAction.error", e);
        }
    }
    
    @Override
    public List<ProductOrder> getPagingList(Map<String, Object> condition, String sort, Integer pageCount, Integer page) throws Exception {
        List<ProductOrder> list = null;
        HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.ProductOrderDao").get("getPagingList");
        try {
            list = this.daoFacade.getProductOrderDao().getPagingList(condition, sort, pageCount, page, hqlBean);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionList.error", e);
        }
        return list;
    }

    @Override
    public Integer getCount(Map<String, Object> condition) throws Exception {
        Integer num = 0;
        HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.ProductOrderDao").get("getCount");
        try {
            num = this.daoFacade.getProductOrderDao().getCount(condition, hqlBean);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransactionCount.error", e);
        }
        return num;
    }

    public ProductOrder getOrderId(String id) throws Exception {
        ProductOrder cla = null;
        try {
            cla = (ProductOrder) this.daoFacade.getProductOrderDao().get(ProductOrder.class.getName(), id);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "transaction.info.getCTransaction.error", e);
        }
        return cla;
    }
    
    public List<ProductOrder> getList(Map<String, Object> condition, String sort) throws Exception {
        List<ProductOrder> list = null;
        try {
            HqlBean hqlBean = HqlBeanCacheUtil.gethqlBeanCache().get("cn.digitalpublishing.dao.ProductOrderDao").get("getList");
            list = this.daoFacade.getProductOrderDao().getList(condition, sort, hqlBean);
        } catch (Exception e) {
            throw new CcsException((e instanceof CcsException) ? ((CcsException) e).getPrompt() : "ProductOrder.getList.error", e);
        }
        return list;
    }
    
}