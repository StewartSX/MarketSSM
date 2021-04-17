package com.oracle.curd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping(value = "/adminLogin")
    public String adminLogin(){
        return "managerLogin";
    }

    @RequestMapping(value = "/adminLoginOut")
    public String adminLoginOut(){
        return "managerLogin";
    }
}
