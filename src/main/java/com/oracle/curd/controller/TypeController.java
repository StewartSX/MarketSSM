package com.oracle.curd.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.curd.bean.Type;
import com.oracle.curd.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypeController {

    @Autowired
    TypeService typeService;

    @RequestMapping(value = "/toGetall")
    public String toGetAll(Model model){
        PageHelper.startPage(1, 5);
        List<Type> types = typeService.getAllType();
        PageInfo<Type> page = new PageInfo<>(types, 5);
        model.addAttribute("pageInfo", page);
        return "getAll";
    }

    @RequestMapping(value = "/selectType")
    public String selectTypeByExample(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @RequestParam(value = "protypeid", required = false) String protypeid,
            @RequestParam(value = "typename", required = false) String typename,
            Model model
    ){
        PageHelper.startPage(pn, 5);
        List<Type> types = typeService.getTypeByExample(protypeid, typename);
        PageInfo<Type> page = new PageInfo<>(types, 5);

        model.addAttribute("pageInfo", page);
        model.addAttribute("protypeid",protypeid);
        model.addAttribute("typename",typename);
        return "getAll";
    }

    @RequestMapping(value = "/addType")
    public String addType(
            @RequestParam(value = "protypeid") String protypeid,
            @RequestParam(value = "typename") String typename,
            Model model
    ){
        if ((protypeid==null||protypeid.equals("")) || (typename==null || typename.equals(""))) {
            model.addAttribute("errorInfoAddType", "带*项为必填项，不能为空！");
            return "getAll";
        } else {
            typeService.addType(protypeid, typename);
            return "getAll";
        }
    }

    @RequestMapping(value = "/toEdittype")
    public String toEdittype(
            @RequestParam(value = "protypeid") String protypeid,
            @RequestParam(value = "typename") String typename,
            Model model
    ){
        Type type = new Type();
        type.setProtypeid(protypeid);
        type.setTypename(typename);

        model.addAttribute("type", type);
        return "editType";
    }

    @RequestMapping(value = "/editType")
    public String editType(
            @RequestParam(value = "protypeid") String protypeid,
            @RequestParam(value = "typename") String typename,
            Model model
    ){
        if ((protypeid==null||protypeid.equals("")) || (typename==null || typename.equals(""))) {
            model.addAttribute("errorInfoEditType", "带*项为必填项，不能为空！");
            return "editType";
        } else {
            typeService.updateType(protypeid, typename);
            return "getAll";
        }
    }

    @RequestMapping(value = "/delType")
    public String delType(@RequestParam(value = "protypeid") String protypeid, Model model){
        typeService.removeType(protypeid);
        model.addAttribute("page", "type");
        return "temp";
    }


}
