package com.oracle.curd.service;

import com.oracle.curd.bean.Manager;
import com.oracle.curd.dao.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    ManagerMapper managerMapper;
    public Manager login(String managerid){
        return managerMapper.selectByPrimaryKey(managerid);
    }
}
