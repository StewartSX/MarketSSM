package com.oracle.curd.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.curd.bean.Custom;
import com.oracle.curd.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomController {

    @Autowired
    CustomService customService;

    @RequestMapping(value = "/toGetAllcus")
    public ModelAndView toGetAllcus(){
        ModelAndView mav = new ModelAndView();
        PageHelper.startPage(1, 5);
        List<Custom> customs = customService.getAllCus();
        PageInfo<Custom> pageInfo = new PageInfo<>(customs, 5);
        mav.setViewName("getAllcus");
        mav.addObject("pageInfo", pageInfo);
        return mav;
    }

    @RequestMapping(value = "/selectCus")
    public ModelAndView selectCusByExample(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @RequestParam(value = "cusid", required = false) String cusid,
            @RequestParam(value = "cusname", required = false) String cusname
    ){
        ModelAndView mav = new ModelAndView();
        PageHelper.startPage(pn, 5);
        List<Custom> customs = customService.getCusByExample(cusid, cusname);
        PageInfo<Custom> pageInfo = new PageInfo<>(customs, 5);
        mav.setViewName("getAllcus");
        mav.addObject("pageInfo", pageInfo);
        mav.addObject("cusid", cusid);
        mav.addObject("cusname", cusname);
        return mav;
    }

    @RequestMapping(value = "/toAddcus")
    public String toAddcus(){
        return "addCus";
    }

    @RequestMapping(value = "/addCus")
    public ModelAndView addCus(
            @RequestParam(value = "cusid") String cusid,
            @RequestParam(value = "cusname") String cusname,
            @RequestParam(value = "tel") String tel,
            @RequestParam(value = "person", required = false) String person,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "emali") String emali
    ){
        customService.addCus(cusid, cusname, tel, person, address, emali);
        return new ModelAndView("redirect:/toGetAllcus");
    }

    @RequestMapping(value = "/toEditcus")
    public ModelAndView toEditcus(@RequestParam(value = "cusid") String cusid){
        ModelAndView mav = new ModelAndView();
        mav.addObject("cus", customService.getCusById(cusid));
        mav.setViewName("editCus");
        return mav;
    }

    @RequestMapping(value = "/editCus")
    public ModelAndView editCus(
            @RequestParam(value = "cusid") String cusid,
            @RequestParam(value = "cusname") String cusname,
            @RequestParam(value = "tel") String tel,
            @RequestParam(value = "person", required = false) String person,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "emali") String emali
    ){
        ModelAndView mav = new ModelAndView();
        customService.updateCus(cusid, cusname, tel, person, address, emali);
        return new ModelAndView("redirect:/toGetAllcus");
    }

    @RequestMapping(value = "/delCus")
    public ModelAndView delCus(
            @RequestParam(value = "cusid") String cusid
    ){
        customService.deleteCusById(cusid);
        return new ModelAndView("redirect:/toGetAllcus");
    }

}
