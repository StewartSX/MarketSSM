package com.oracle.curd.service;

import com.oracle.curd.bean.Type;
import com.oracle.curd.bean.TypeExample;
import com.oracle.curd.dao.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    TypeMapper typeMapper;

    public List<Type> getAllType(){
        return typeMapper.selectByExample(null);
    }

    public List<Type> getTypeByExample(String protypeid, String typename){
        TypeExample example = new TypeExample();
        TypeExample.Criteria criteria = example.createCriteria();
        if ((protypeid==null||protypeid.equals("")) && (typename==null || typename.equals(""))){
            return typeMapper.selectByExample(null);
        } else {
            if (protypeid!=null && !protypeid.equals("")){
                criteria.andProtypeidEqualTo(protypeid);
            }
            if (typename!=null && !typename.equals("")){
                criteria.andTypenameEqualTo(typename);
            }
            return typeMapper.selectByExample(example);
        }
    }

    public void addType(String protypeid, String typename){
        Type type = new Type();
        type.setProtypeid(protypeid);
        type.setTypename(typename);
        typeMapper.insert(type);
    }

    public void updateType(String protypeid, String typename){
        Type type = new Type();
        type.setProtypeid(protypeid);
        type.setTypename(typename);
        typeMapper.updateByPrimaryKey(type);
    }

    public void removeType(String protypeid){
        typeMapper.deleteByPrimaryKey(protypeid);
    }

}
