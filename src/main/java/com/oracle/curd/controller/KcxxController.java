package com.oracle.curd.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.curd.bean.Kcxx;
import com.oracle.curd.bean.Product;
import com.oracle.curd.service.KcxxService;
import com.oracle.curd.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KcxxController {

    @Autowired
    KcxxService kcxxService;

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/toGetallkcxx")
    public String toGetallkcxx(Model model){
        PageHelper.startPage(1, 5);
        List<Kcxx> kcxxs = kcxxService.getAll();
        PageInfo<Kcxx> pageInfo = new PageInfo<>(kcxxs, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "getAllkcxx";
    }

    @RequestMapping(value = "/selectKcxx")
    public String selectKcxxByExample(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @RequestParam(value = "pname", required = false) String pname,
            @RequestParam(value = "proid", required = false) String proid,
            Model model
    ){
        PageHelper.startPage(pn, 5);
        List<Kcxx> kcxxs = kcxxService.getKcxxByExample(pname, proid);
        PageInfo<Kcxx> pageInfo = new PageInfo<>(kcxxs, 5);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("proid", proid);
        model.addAttribute("pname", pname);
        return "getAllkcxx";
    }

    @RequestMapping(value = "/toGetKcxx")
    public String toGetKcxx(
            @RequestParam(value = "proid", required = false) String proid,
            @RequestParam(value = "num", required = false) Integer num,
            Model model
    ){
        Product product = productService.getProductById(proid);
        model.addAttribute("product", product);
        model.addAttribute("num", num);
        return "getKcxx";
    }

    @RequestMapping(value = "/toEditkcxx")
    public String toEditkcxx(
            @RequestParam(value = "proid", required = false) String proid,
            @RequestParam(value = "pname", required = false) String pname,
            @RequestParam(value = "num", required = false) Integer num,
            @RequestParam(value = "marks", required = false) String marks,
            Model model
    ){
        Kcxx kcxx = new Kcxx();
        kcxx.setProid(proid);
        kcxx.setPname(pname);
        kcxx.setNum(num);
        kcxx.setMarks(marks);

        model.addAttribute("kcxx", kcxx);
        return "editKcxx";
    }

    @RequestMapping(value = "/editKcxx")
    public String editKcxx(
            @RequestParam(value = "proid", required = false) String proid,
            @RequestParam(value = "pname", required = false) String pname,
            @RequestParam(value = "num", required = false) Integer num,
            @RequestParam(value = "marks", required = false) String marks,
            Model model
    ){
        if (num==null){
            model.addAttribute("errorInfoEditKcxx", "带*项为必填项，不能为空！");
            return "editKcxx";
        } else {
            Kcxx kcxx = new Kcxx();
            kcxx.setProid(proid);
            kcxx.setPname(pname);
            kcxx.setNum(num);
            kcxx.setMarks(marks);

            kcxxService.updateKcxx(kcxx);
            return "getAllkcxx";
        }

    }
}
