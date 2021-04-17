package com.oracle.curd.test;

import com.github.pagehelper.PageInfo;
import com.oracle.curd.bean.Ckin;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-mvc.xml"})
public class MVCTest {
    //创建一个虚拟的MVC请求,获取处理的结果
    MockMvc mockMvc;
    //创建一个SpringMVC的IOC容器
    @Autowired
    WebApplicationContext context;

    //在测试方法前调用，创建请求对象
    @Before
    public void initMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void testPageCkin(){
        // 模拟get请求
        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/getAllCkin").param("pn", "2")).andReturn();

            // 请求成功后获取请求域中的数据
            MockHttpServletRequest request = result.getRequest();
            PageInfo page = (PageInfo) request.getAttribute("pageInfo");
            System.out.println("当前的页码:"+page.getPageNum());
            System.out.println("总页码:"+page.getPages());
            System.out.println("总记录数:"+page.getTotal());
            System.out.println("是否有前一页:"+page.isHasPreviousPage());
            System.out.println("是否存在下一页"+page.isHasNextPage());
            System.out.println("页码范围：");
            int[] nums = page.getNavigatepageNums();
            for(int num:nums){
                System.out.println(" "+num);
            }
            List<Ckin> ckins = page.getList();
            System.out.println("Employees:");
            for(Ckin ckin:ckins){
                System.out.println(ckin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
