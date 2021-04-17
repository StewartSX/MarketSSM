package com.oracle.curd.controller;

import com.oracle.curd.bean.Manager;
import com.oracle.curd.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @RequestMapping(value = "/adminLoginCheck")
    public String adminLoginCheck(@RequestParam(value = "managerid")String managerid, @RequestParam(value = "pwd") String pwd, HttpServletRequest request){
        if (! "".equals(managerid)){
            if (! "".equals(pwd)){
                Manager manager = managerService.login(managerid);
                if (manager != null){
                    if (manager.getPwd().equals(pwd)){
                        return "main";
                    } else {
                        request.setAttribute("errorInfoML", "密码错误！");
                        return "managerLogin";
                    }
                } else {
                    request.setAttribute("errorInfoML", "用户不存在！");
                    return "managerLogin";
                }
            } else {
                request.setAttribute("errorInfoML", "密码不能为空！");
                return "managerLogin";
            }
        } else {
            request.setAttribute("errorInfoML", "用户ID不能为空！");
            return "managerLogin";
        }

    }
}
