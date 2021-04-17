package com.oracle.curd.test;

import com.oracle.curd.bean.Ckin;
import com.oracle.curd.dao.CkinMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CkinTest {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    CkinMapper ckinMapper;
    @Test
    public void getAllTest(){
        List<Ckin> ckins = ckinMapper.selectByExample(null);
        for (Ckin ckin : ckins) {
            System.out.println(ckin);
        }
    }

    @Test
    public void updateCkinTest(){
        Ckin ckin = new Ckin();
        ckin.setInid("6");
        ckin.setProid("7");
        ckin.setPname("炸鸡");
        ckin.setNum(10);
        try {
            ckin.setIndate(sdf.parse("1982-01-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ckin.setMarks("82年的炸鸡");
        ckinMapper.updateByPrimaryKey(ckin);
    }
}
