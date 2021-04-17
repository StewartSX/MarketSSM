package com.oracle.curd.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.curd.bean.Staff;
import com.oracle.curd.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StaffController {

    @Autowired
    StaffService staffService;

    @RequestMapping(value = "/toGetallstaff")
    public ModelAndView toGetallstaff(){
        ModelAndView mav = new ModelAndView();

        PageHelper.startPage(1, 5);
        List<Staff> staffs = staffService.getAllStaff();
        PageInfo<Staff> pageInfo = new PageInfo<>(staffs, 5);

        mav.addObject("pageInfo", pageInfo);
        mav.setViewName("getAllstaff");
        return mav;
    }

    @RequestMapping(value = "/selectStaff")
    public ModelAndView selectStaff(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @RequestParam(value = "staffid", required = false) String staffid,
            @RequestParam(value = "staffname", required = false) String staffname
    ){
        ModelAndView mav = new ModelAndView();
        PageHelper.startPage(pn, 5);
        List<Staff> staffs = staffService.getStaffByExample(staffid, staffname);
        PageInfo<Staff> pageInfo = new PageInfo<>(staffs, 5);

        mav.setViewName("getAllstaff");
        mav.addObject("pageInfo", pageInfo);
        mav.addObject("staffid", staffid);
        mav.addObject("staffname", staffname);
        return mav;
    }

    @RequestMapping(value = "/toAddstaff")
    public String toAddstaff(){
        return "addStaff";
    }

    @RequestMapping(value = "/addStaff")
    public ModelAndView addStaff(
            @RequestParam(value = "staffid") String staffid,
            @RequestParam(value = "staffname") String staffname,
            @RequestParam(value = "card") String card,
            @RequestParam(value = "sex") String sex,
            @RequestParam(value = "tel") String tel,
            @RequestParam(value = "stafftype") String stafftype,
            @RequestParam(value = "pwd1") String pwd1,
            @RequestParam(value = "pwd2") String pwd2
    ){
        if (pwd1.equals(pwd2)){
            staffService.addStaff(staffid, staffname, card, sex, tel, stafftype, pwd1, pwd2);
            return new ModelAndView("redirect:/toGetallstaff");
        } else {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addStaff");
            mav.addObject("errorInfoAddStaff", "两次密码不一致！");
            return mav;
        }
    }

    @RequestMapping(value = "/toEditstaff")
    public ModelAndView toEditstaff(@RequestParam(value = "staffid") String staffid){
        ModelAndView mav = new ModelAndView();
        mav.addObject("staff", staffService.getStaffById(staffid));
        mav.setViewName("editStaff");
        return mav;
    }

    @RequestMapping(value = "/editStaff")
    public ModelAndView editStaff(
            @RequestParam(value = "staffid") String staffid,
            @RequestParam(value = "staffname") String staffname,
            @RequestParam(value = "card") String card,
            @RequestParam(value = "sex") String sex,
            @RequestParam(value = "tel") String tel,
            @RequestParam(value = "stafftype") String stafftype,
            @RequestParam(value = "pwd1") String pwd1,
            @RequestParam(value = "pwd2") String pwd2
    ){
        if (pwd1.equals(pwd2)){
            staffService.editStaff(staffid, staffname, card, sex, tel, stafftype, pwd1, pwd2);
            return new ModelAndView("redirect:/toGetallstaff");
        } else {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("editStaff");
            mav.addObject("errorInfoEditStaff", "两次密码不一致！");
            return mav;
        }
    }

    @RequestMapping(value = "/delStaff")
    public ModelAndView delStaff(@RequestParam(value = "staffid") String staffid){
        staffService.deleteStaffById(staffid);
        return new ModelAndView("redirect:/toGetallstaff");
    }
}
