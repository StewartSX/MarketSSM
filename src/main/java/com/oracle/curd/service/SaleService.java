package com.oracle.curd.service;

import com.oracle.curd.bean.Sale;
import com.oracle.curd.bean.SaleExample;
import com.oracle.curd.dao.SaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    SaleMapper saleMapper;

    public List<Sale> getAllSale(){
        return saleMapper.selectByExample(null);
    }

    public List<Sale> getSaleByExample(String pname, String proid, String cusname, String cusid){
        SaleExample example = new SaleExample();
        SaleExample.Criteria criteria = example.createCriteria();

        if ((pname==null||pname.equals("")) && (proid==null || proid.equals("")) && (cusname==null || cusname.equals("")) && (cusid==null || cusid.equals(""))){
            return saleMapper.selectByExample(null);
        } else {
            if (pname!=null && !pname.equals("")){
                criteria.andPnameEqualTo(pname);
            }
            if (proid!=null && !proid.equals("")){
                criteria.andProidEqualTo(proid);
            }
            if (cusname!=null && !cusname.equals("")){
                criteria.andCusnameEqualTo(cusname);
            }
            if (cusid!=null && !cusid.equals("")){
                criteria.andCusidEqualTo(cusid);
            }
            return saleMapper.selectByExample(example);
        }
    }

    public void updateSale(
            String saleid, String pname, String proid,
            Integer num, Double price, String total,
            String cusname, String cusid, String marks, Date saledate
    ){
        Sale sale = new Sale();
        sale.setSaleid(saleid);
        sale.setPname(pname);
        sale.setProid(proid);
        sale.setNum(num);
        sale.setPrice(price);
        sale.setTotal(total);
        sale.setCusname(cusname);
        sale.setCusid(cusid);
        sale.setMarks(marks);
        sale.setSaledate(saledate);

        saleMapper.updateByPrimaryKey(sale);
    }

    public void addSale(String saleid, String pname, String proid,
                        Integer num, Double price, String total,
                        String cusname, String cusid, String marks){
        Sale sale = new Sale();
        sale.setSaleid(saleid);
        sale.setPname(pname);
        sale.setProid(proid);
        sale.setNum(num);
        sale.setPrice(price);
        sale.setTotal(total);
        sale.setCusname(cusname);
        sale.setCusid(cusid);
        sale.setMarks(marks);
        sale.setSaledate(new Date());

        saleMapper.insert(sale);
    }

    public void deleteSaleById(String saleid){
        saleMapper.deleteByPrimaryKey(saleid);
    }
}







