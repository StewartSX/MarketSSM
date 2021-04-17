package com.oracle.curd.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.curd.bean.Ckin;
import com.oracle.curd.service.CkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CkinController {

    @Autowired
    CkinService ckinService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping(value = "/toGetAllCkin")
    public String toPage(Model model){
        PageHelper.startPage(1, 5);
        List<Ckin> ckins = ckinService.getAll();
        PageInfo<Ckin> page = new PageInfo<>(ckins, 5);
        model.addAttribute("pageInfo", page);
        return "getAllCkin";
    }

    //新增按钮跳转到新页面
    @RequestMapping(value = "/toAddCkin")
    public String toAddCkin(){
        return "addCkin";
    }

    //查询
    @RequestMapping(value = "/select")
    public String selectByExmple(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @RequestParam(value = "inid", required = false) String inid,
            @RequestParam(value = "pname", required = false) String pname,
            @RequestParam(value = "proid", required = false) String proid,
            @RequestParam(value = "indate", required = false) String indate,
            Model model
    ){
        PageHelper.startPage(pn, 5);
        List<Ckin> ckins = ckinService.getCkinsByExample(inid, pname, proid, indate);
        PageInfo<Ckin> page = new PageInfo<>(ckins, 5);

        model.addAttribute("pageInfo", page);
        model.addAttribute("pname",pname);
        model.addAttribute("inid",inid);
        model.addAttribute("proid",proid);
        model.addAttribute("indate",indate);
        return "getAllCkin";
    }
    //新增
    @RequestMapping(value = "/addCkin")
    public String addCkin(
            @RequestParam(value = "inid", required = false) String inid,
            @RequestParam(value = "proid", required = false) String proid,
            @RequestParam(value = "pname", required = false) String pname,
            @RequestParam(value = "num", required = false) Integer num,
            @RequestParam(value = "indate", required = false) String indate,
            @RequestParam(value = "marks", required = false) String marks,
            Model model
    ){
        if ((inid==null||inid.equals("")) || (pname==null || pname.equals("")) || (proid==null || proid.equals("")) || (indate==null || indate.equals("")) || (num==null)){
            model.addAttribute("errorInfoAdd", "带*项为必填项，不能为空！");
            return "addCkin";
        } else{
            Ckin ckin = new Ckin();
            ckin.setInid(inid);
            ckin.setProid(proid);
            ckin.setPname(pname);
            ckin.setNum(num);
            ckin.setMarks(marks);
            try {
                ckin.setIndate(sdf.parse(indate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ckinService.addCkin(ckin);
            return "getAllCkin";
        }
    }

    //删除
    @RequestMapping(value = "/delCkin")
    public String removeCkin(@RequestParam(value = "inid") String inid, Model model){
        ckinService.removeCkinByID(inid);
        model.addAttribute("page", "ckin");
        return "temp";
    }
    //修改按钮
    @RequestMapping(value = "/toEditCkin")
    public String toEditCkin(
             @RequestParam(value = "inid") String inid,
             @RequestParam(value = "proid") String proid,
             @RequestParam(value = "pname") String pname,
             @RequestParam(value = "num") Integer num,
             @RequestParam(value = "indate") Date indate,
             @RequestParam(value = "marks", required = false) String marks,
             Model model
    ){
        Ckin ckin = new Ckin();
        ckin.setInid(inid);
        ckin.setProid(proid);
        ckin.setPname(pname);
        ckin.setNum(num);
        ckin.setIndate(indate);
        ckin.setMarks(marks);
        model.addAttribute("ckin", ckin);
        return "editCkin";
    }

    //修改操作
    @RequestMapping(value = "editCkin")
    public String UpdateCkinById(
            @RequestParam(value = "inid") String inid,
            @RequestParam(value = "proid") String proid,
            @RequestParam(value = "pname") String pname,
            @RequestParam(value = "num") Integer num,
            @RequestParam(value = "indate") String indate,
            @RequestParam(value = "marks", required = false) String marks,
            Model model
    ){
        if ((pname==null || pname.equals("")) || (proid==null || proid.equals("")) || (indate==null || indate.equals("")) || (num==null || num==0)){
            model.addAttribute("errorInfoEdit", "带*项为必填项，不能为空或者为0 ！");
            return "editCkin";
        } else {
            Ckin ckin = new Ckin();
            ckin.setInid(inid);
            ckin.setProid(proid);
            ckin.setPname(pname);
            ckin.setNum(num);
            try {
                ckin.setIndate(sdf.parse(indate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ckin.setMarks(marks);

            ckinService.updateCkinByID(ckin);
            return "getAllCkin";
        }






    }
}
