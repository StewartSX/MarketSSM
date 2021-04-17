package com.oracle.curd.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.curd.bean.Product;
import com.oracle.curd.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping(value = "/toGetlist")
    public String toGetList(Model model){
        PageHelper.startPage(1, 5);
        List<Product> products = productService.getAll();
        PageInfo<Product> page = new PageInfo<>(products, 5);
        model.addAttribute("pageInfo", page);
        return "getList";
    }

    //查询
    @RequestMapping(value = "/selectProduct")
    public String selectByExample(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @RequestParam(value = "protype", required = false) String protype,
            @RequestParam(value = "proid", required = false) String proid,
            @RequestParam(value = "pname", required = false) String pname,
            @RequestParam(value = "supname", required = false) String supname,
            Model model
    ){
        PageHelper.startPage(pn, 5);
        List<Product> products = productService.getProductByExample(protype, proid, pname, supname);
        PageInfo<Product> page = new PageInfo<>(products, 5);

        model.addAttribute("pageInfo", page);
        model.addAttribute("protype",protype);
        model.addAttribute("proid",proid);
        model.addAttribute("pname",pname);
        model.addAttribute("supname",supname);
        return "getList";
    }

    //product新增按钮
    @RequestMapping(value = "/toAddpro")
    public String toAddpro(){
        return "addPro";
    }
    //product新增操作
    @RequestMapping(value = "/addPro")
    public String addPro(
            @RequestParam(value = "proid") String proid,
            @RequestParam(value = "pname") String pname,
            @RequestParam(value = "price") Double price,
            @RequestParam(value = "inprice") Double inprice,
            @RequestParam(value = "prodate") String prodate,
            @RequestParam(value = "reledate") String reledate,
            @RequestParam(value = "supname") String supname,
            @RequestParam(value = "protype") String protype,
            @RequestParam(value = "unit", required = false) String unit,
            @RequestParam(value = "marks", required = false) String marks,
            Model model
    ){
        if (
                (proid==null||proid.equals("")) ||
                (pname==null || pname.equals("")) ||
                (price==null) ||
                (inprice==null) ||
                (prodate==null || prodate.equals("")) ||
                (reledate==null || reledate.equals("")) ||
                (supname==null || supname.equals("")) ||
                (protype==null || protype.equals(""))
        ){
            model.addAttribute("errorInfoAddPro", "带*项为必填项，不能为空！");
            return "addPro";
        } else {
            Product product = new Product();
            product.setProid(proid);
            product.setPname(pname);
            product.setPrice(price);
            product.setInprice(inprice);
            try {
                product.setProdate(sdf.parse(prodate));
                product.setReledate(sdf.parse(reledate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            product.setSupname(supname);
            product.setProtype(protype);
            product.setUnit(unit);
            product.setMarks(marks);

            productService.addProduct(product);
            return "getList";
        }
    }
    //删除操作
    @RequestMapping(value = "/delProduct")
    public String removeProductById(@RequestParam(value = "proid") String proid, Model model){
        productService.removeProduct(proid);
        model.addAttribute("page", "product");
        return "temp";
    }
    //查看
    @RequestMapping(value = "/toGetpro")
    public String toGetPro(
            @RequestParam(value = "proid") String proid,
            @RequestParam(value = "pname") String pname,
            @RequestParam(value = "price") Double price,
            @RequestParam(value = "inprice") Double inprice,
            @RequestParam(value = "prodate") String prodate,
            @RequestParam(value = "reledate") String reledate,
            @RequestParam(value = "supname") String supname,
            @RequestParam(value = "protype") String protype,
            @RequestParam(value = "unit", required = false) String unit,
            @RequestParam(value = "marks", required = false) String marks,
            Model model
    ){
        Product product = new Product();
        product.setProid(proid);
        product.setPname(pname);
        product.setPrice(price);
        product.setInprice(inprice);
        try {
            product.setProdate(sdf.parse(prodate));
            product.setReledate(sdf.parse(reledate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        product.setSupname(supname);
        product.setProtype(protype);
        product.setUnit(unit);
        product.setMarks(marks);

        System.out.println(product);
        model.addAttribute("product", product);
        return "getPro";
    }

    //修改按钮
    @RequestMapping(value = "/toEditpro")
    public String toEditpro(
            @RequestParam(value = "proid") String proid,
            @RequestParam(value = "pname") String pname,
            @RequestParam(value = "price") Double price,
            @RequestParam(value = "inprice") Double inprice,
            @RequestParam(value = "prodate") String prodate,
            @RequestParam(value = "reledate") String reledate,
            @RequestParam(value = "supname") String supname,
            @RequestParam(value = "protype") String protype,
            @RequestParam(value = "unit", required = false) String unit,
            @RequestParam(value = "marks", required = false) String marks,
            Model model
    ){
        Product product = new Product();
        product.setProid(proid);
        product.setPname(pname);
        product.setPrice(price);
        product.setInprice(inprice);
        try {
            product.setProdate(sdf.parse(prodate));
            product.setReledate(sdf.parse(reledate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        product.setSupname(supname);
        product.setProtype(protype);
        product.setUnit(unit);
        product.setMarks(marks);

        model.addAttribute("product", product);
        return "editPro";
    }

    //修改操作
    @RequestMapping(value = "/editpro")
    public String editpro(
            @RequestParam(value = "proid") String proid,
            @RequestParam(value = "pname") String pname,
            @RequestParam(value = "price") Double price,
            @RequestParam(value = "inprice") Double inprice,
            @RequestParam(value = "prodate") String prodate,
            @RequestParam(value = "reledate") String reledate,
            @RequestParam(value = "supname") String supname,
            @RequestParam(value = "protype") String protype,
            @RequestParam(value = "unit", required = false) String unit,
            @RequestParam(value = "marks", required = false) String marks,
            Model model
    ){
        if (
                (proid==null||proid.equals("")) ||
                (pname==null || pname.equals("")) ||
                (price==null) ||
                (inprice==null) ||
                (prodate==null || prodate.equals("")) ||
                (reledate==null || reledate.equals("")) ||
                (supname==null || supname.equals("")) ||
                (protype==null || protype.equals(""))
        ) {
            model.addAttribute("errorInfoEditPro", "带*项为必填项，不能为空！");
            return "editPro";
        } else {
            Product product = new Product();
            product.setProid(proid);
            product.setPname(pname);
            product.setPrice(price);
            product.setInprice(inprice);
            try {
                product.setProdate(sdf.parse(prodate));
                product.setReledate(sdf.parse(reledate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            product.setSupname(supname);
            product.setProtype(protype);
            product.setUnit(unit);
            product.setMarks(marks);

            productService.updateProduct(product);
            return "getList";
        }
    }

}
