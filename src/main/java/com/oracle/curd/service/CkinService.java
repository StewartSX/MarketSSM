package com.oracle.curd.service;

import com.oracle.curd.bean.Ckin;
import com.oracle.curd.bean.CkinExample;
import com.oracle.curd.dao.CkinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class CkinService {
    @Autowired
    CkinMapper ckinMapper;
    public List<Ckin> getAll(){
        CkinExample example = new CkinExample();
        example.setOrderByClause("inid asc");
        return ckinMapper.selectByExample(example);
    }

    public List<Ckin> getCkinsByExample(String inid, String pname, String proid, String indate) {
        CkinExample example = new CkinExample();
        CkinExample.Criteria criteria = example.createCriteria();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        example.setOrderByClause("inid asc");
        if ((inid==null||inid.equals("")) && (pname==null || pname.equals("")) && (proid==null || proid.equals("")) && (indate==null || indate.equals(""))){
            return ckinMapper.selectByExample(example);
        } else {
            if (inid!=null && !inid.equals("")){
                criteria.andInidEqualTo(inid);
            }
            if (pname!=null && !pname.equals("")){
                criteria.andPnameEqualTo(pname);
            }
            if (proid!=null && !proid.equals("")){
                criteria.andProidEqualTo(proid);
            }
            if (indate!=null && !indate.equals("")){
                try {
                    criteria.andIndateEqualTo(sdf.parse(indate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return ckinMapper.selectByExample(example);
        }
    }

    public void addCkin(Ckin ckin){
        ckinMapper.insert(ckin);
    }

    public void removeCkinByID(String inid){
        ckinMapper.deleteByPrimaryKey(inid);
    }

    public void updateCkinByID(Ckin ckin){
        ckinMapper.updateByPrimaryKey(ckin);
    }

}
