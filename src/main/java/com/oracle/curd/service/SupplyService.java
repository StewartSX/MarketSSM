package com.oracle.curd.service;

import com.oracle.curd.bean.Supply;
import com.oracle.curd.bean.SupplyExample;
import com.oracle.curd.dao.SupplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyService {

    @Autowired
    SupplyMapper supplyMapper;

    public Supply getSupplyById(String supid){
        return supplyMapper.selectByPrimaryKey(supid);
    }

    public List<Supply> getAllSupply(){
        return supplyMapper.selectByExample(null);
    }

    public List<Supply> getSupplyByExample(String supid, String suppname){
        SupplyExample example = new SupplyExample();
        SupplyExample.Criteria criteria = example.createCriteria();

        if ((supid==null||supid.equals("")) && (suppname==null || suppname.equals(""))){
            return supplyMapper.selectByExample(null);
        } else {
            if (supid!=null && !supid.equals("")){
                criteria.andSupidEqualTo(supid);
            }
            if (suppname!=null && !suppname.equals("")){
                criteria.andSuppnameEqualTo(suppname);
            }
            return supplyMapper.selectByExample(example);
        }
    }

    public void addSupply(String supid, String suppname, String tel, String person, String addresss, String email){
        Supply supply = new Supply();
        supply.setSupid(supid);
        supply.setSuppname(suppname);
        supply.setTel(tel);
        supply.setPerson(person);
        supply.setAddress(addresss);
        supply.setEmali(email);

        supplyMapper.insert(supply);
    }

    public void updateSupply(String supid, String suppname, String tel, String person, String addresss, String email){
        Supply supply = new Supply();
        supply.setSupid(supid);
        supply.setSuppname(suppname);
        supply.setTel(tel);
        supply.setPerson(person);
        supply.setAddress(addresss);
        supply.setEmali(email);

        supplyMapper.updateByPrimaryKey(supply);
    }

    public void deleteSupplyById(String supid){
        supplyMapper.deleteByPrimaryKey(supid);
    }
}
