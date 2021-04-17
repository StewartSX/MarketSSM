package com.oracle.curd.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.curd.bean.Supply;
import com.oracle.curd.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SupplyController {

    @Autowired
    SupplyService supplyService;

    @RequestMapping(value = "/toGetallsup")
    public ModelAndView toGetallsup(){
        ModelAndView mav = new ModelAndView();
        PageHelper.startPage(1, 5);
        List<Supply> supplies = supplyService.getAllSupply();
        PageInfo<Supply> pageInfo = new PageInfo<>(supplies, 5);
        mav.setViewName("getAllsup");
        mav.addObject("pageInfo", pageInfo);
        return mav;
    }

    @RequestMapping(value = "/selectSup")
    public ModelAndView selectSup(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @RequestParam(value = "supid", required = false) String supid,
            @RequestParam(value = "suppname", required = false) String suppname
    ){
        ModelAndView mav = new ModelAndView();
        PageHelper.startPage(pn, 5);
        List<Supply> supplies = supplyService.getSupplyByExample(supid, suppname);
        PageInfo<Supply> pageInfo = new PageInfo<>(supplies, 5);

        mav.addObject("supid", supid);
        mav.addObject("suppname", suppname);
        mav.addObject("pageInfo", pageInfo);
        mav.setViewName("getAllsup");
        return mav;
    }

    @RequestMapping(value = "/toAddsup")
    public String toAddsup(){
        return "addSup";
    }

    @RequestMapping(value = "/addSup")
    public ModelAndView addSup(
            @RequestParam(value = "supid") String supid,
            @RequestParam(value = "suppname") String suppname,
            @RequestParam(value = "tel") String tel,
            @RequestParam(value = "person", required = false) String person,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "emali") String emali
    ){
        supplyService.addSupply(supid, suppname, tel, person, address, emali);
        return new ModelAndView("redirect:/toGetallsup");
    }

    @RequestMapping(value = "/toEditsup")
    public ModelAndView toEditsup(@RequestParam(value = "supid") String supid){
        ModelAndView mav = new ModelAndView();
        mav.addObject("sup", supplyService.getSupplyById(supid));
        mav.setViewName("editSup");
        return mav;
    }

    @RequestMapping(value = "/editSup")
    public ModelAndView editSup(
            @RequestParam(value = "supid") String supid,
            @RequestParam(value = "suppname") String suppname,
            @RequestParam(value = "tel") String tel,
            @RequestParam(value = "person", required = false) String person,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "emali") String emali
    ){
        supplyService.updateSupply(supid, suppname, tel, person, address, emali);
        return new ModelAndView("redirect:/toGetallsup");
    }

    @RequestMapping(value = "/delSup")
    public ModelAndView delSup(@RequestParam(value = "supid") String supid){
        supplyService.deleteSupplyById(supid);
        return new ModelAndView("redirect:/toGetallsup");
    }
}
