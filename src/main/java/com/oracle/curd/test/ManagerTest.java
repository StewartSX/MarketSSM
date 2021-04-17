package com.oracle.curd.test;


import com.oracle.curd.bean.Manager;
import com.oracle.curd.dao.ManagerMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ManagerTest {
    @Autowired
    ManagerMapper managerMapper;
    @Autowired
    SqlSession sqlSession;

    @Test
    public void TestLogin(){
        Manager admin = managerMapper.selectByPrimaryKey("admin");
        System.out.println(admin);
    }
}
