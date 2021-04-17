package com.oracle.curd.service;

import com.oracle.curd.bean.Kcxx;
import com.oracle.curd.bean.KcxxExample;
import com.oracle.curd.dao.KcxxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KcxxService {

    @Autowired
    KcxxMapper kcxxMapper;

    public List<Kcxx> getAll(){
        return kcxxMapper.selectByExample(null);
    }


    public List<Kcxx> getKcxxByExample(String pname, String proid){
        KcxxExample example = new KcxxExample();
        KcxxExample.Criteria criteria = example.createCriteria();
        if ((proid==null || proid.equals("")) && (pname==null || pname.equals(""))){
            return kcxxMapper.selectByExample(null);
        } else {
            if (proid!=null && !proid.equals("")){
                criteria.andProidEqualTo(proid);
            }
            if (pname!=null && !pname.equals("")){
                criteria.andPnameEqualTo(pname);
            }
            return kcxxMapper.selectByExample(example);
        }
    }

    public void updateKcxx(Kcxx kcxx){
        kcxxMapper.updateByPrimaryKey(kcxx);
    }
}
