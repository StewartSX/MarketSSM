package com.oracle.curd.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.curd.bean.Sale;
import com.oracle.curd.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class SaleController {

    @Autowired
    SaleService saleService;

    @RequestMapping(value = "/toGetallsale")
    public String toGetallsale(Model model){
        PageHelper.startPage(1, 5);
        List<Sale> sales = saleService.getAllSale();
        PageInfo<Sale> pageInfo = new PageInfo<>(sales, 5);

        model.addAttribute("pageInfo", pageInfo);
        return "getAllsale";
    }

    @RequestMapping(value = "/selectSale")
    public String selectSale(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @RequestParam(value = "pname", required = false) String pname,
            @RequestParam(value = "proid", required = false) String proid,
            @RequestParam(value = "cusname", required = false) String cusname,
            @RequestParam(value = "cusid", required = false) String cusid,
            Model model
    ){
        PageHelper.startPage(pn, 5);
        List<Sale> sales = saleService.getSaleByExample(pname, proid, cusname, cusid);
        PageInfo<Sale> pageInfo = new PageInfo<>(sales, 5);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("pname",pname);
        model.addAttribute("proid",proid);
        model.addAttribute("cusname",cusname);
        model.addAttribute("cusid",cusid);
        return "getAllsale";
    }

    @RequestMapping(value = "/toGetsale")
    public ModelAndView toGetsale(
            @RequestParam(value = "saleid", required = false) String saleid,
            @RequestParam(value = "pname", required = false) String pname,
            @RequestParam(value = "proid", required = false) String proid,
            @RequestParam(value = "num", required = false) Integer num,
            @RequestParam(value = "price", required = false) Double price,
            @RequestParam(value = "total", required = false) String total,
            @RequestParam(value = "cusname", required = false) String cusname,
            @RequestParam(value = "cusid", required = false) String cusid,
            @RequestParam(value = "marks", required = false) String marks,
            @RequestParam(value = "saledate")Date saledate
            ){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("getSale");
        modelAndView.addObject("saleid", saleid);
        modelAndView.addObject("pname", pname);
        modelAndView.addObject("proid", proid);
        modelAndView.addObject("num", num);
        modelAndView.addObject("price", price);
        modelAndView.addObject("total", total);
        modelAndView.addObject("cusname", cusname);
        modelAndView.addObject("cusid", cusid);
        modelAndView.addObject("marks", marks);
        modelAndView.addObject("saledate", saledate);
        return modelAndView;
    }

    @RequestMapping(value = "/updateSale")
    public ModelAndView getAllsale(
            @RequestParam(value = "saleid") String saleid,
            @RequestParam(value = "pname") String pname,
            @RequestParam(value = "proid") String proid,
            @RequestParam(value = "num") Integer num,
            @RequestParam(value = "price") Double price,
            @RequestParam(value = "total") String total,
            @RequestParam(value = "cusname") String cusname,
            @RequestParam(value = "cusid") String cusid,
            @RequestParam(value = "marks") String marks,
            @RequestParam(value = "saledate")Date saledate
    ){
        saleService.updateSale(saleid, pname, proid, num, price, total, cusname, cusid, marks, saledate);

        return new ModelAndView("redirect:/toGetallsale");
    }

    @RequestMapping(value = "/toAddsale")
    public String toAddsale(){
        return "addSale";
    }

    @RequestMapping(value = "/addSale")
    public ModelAndView addSale(
            @RequestParam(value = "saleid") String saleid,
            @RequestParam(value = "pname") String pname,
            @RequestParam(value = "proid") String proid,
            @RequestParam(value = "num") Integer num,
            @RequestParam(value = "price") Double price,
            @RequestParam(value = "total") String total,
            @RequestParam(value = "cusname") String cusname,
            @RequestParam(value = "cusid") String cusid,
            @RequestParam(value = "marks") String marks
    ){
        saleService.addSale(saleid, pname, proid, num, price, total, cusname, cusid, marks);
        return new ModelAndView("redirect:/toGetallsale");
    }

    @RequestMapping(value = "/delSale")
    public ModelAndView delSale(@RequestParam(value = "saleid") String saleid){
        saleService.deleteSaleById(saleid);
        return new ModelAndView("redirect:/toGetallsale");
    }
}
