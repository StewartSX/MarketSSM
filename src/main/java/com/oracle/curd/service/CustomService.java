package com.oracle.curd.service;

import com.oracle.curd.bean.Custom;
import com.oracle.curd.bean.CustomExample;
import com.oracle.curd.dao.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomService {

    @Autowired
    CustomMapper customMapper;

    public List<Custom> getAllCus(){
        return customMapper.selectByExample(null);
    }

    public Custom getCusById(String cusid){
        return customMapper.selectByPrimaryKey(cusid);
    }

    public List<Custom> getCusByExample(String cusid, String cusname){
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();

        if ((cusid==null||cusid.equals("")) && (cusname==null || cusname.equals(""))){
            return customMapper.selectByExample(null);
        } else {
            if (cusid!=null && !cusid.equals("")){
                criteria.andCusidEqualTo(cusid);
            }
            if (cusname!=null && !cusname.equals("")){
                criteria.andCusnameEqualTo(cusname);
            }
            return customMapper.selectByExample(customExample);
        }

    }

    public void addCus(String cusid, String cusname, String tel, String person, String addresss, String email){
        Custom custom = new Custom();
        custom.setCusid(cusid);
        custom.setCusname(cusname);
        custom.setTel(tel);
        custom.setPerson(person);
        custom.setAddress(addresss);
        custom.setEmali(email);

        customMapper.insert(custom);
    }

    public void updateCus(String cusid, String cusname, String tel, String person, String addresss, String email){
        Custom custom = new Custom();
        custom.setCusid(cusid);
        custom.setCusname(cusname);
        custom.setTel(tel);
        custom.setPerson(person);
        custom.setAddress(addresss);
        custom.setEmali(email);

        customMapper.updateByPrimaryKey(custom);
    }

    public void deleteCusById(String cusid){
        customMapper.deleteByPrimaryKey(cusid);
    }
}
