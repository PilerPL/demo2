package com.yang.demo.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @NacosValue(value = "${username:null}", autoRefreshed = true)
    private String username;
    @NacosValue(value = "${age:null}", autoRefreshed = true)
    private int age;
    @NacosValue(value = "${sex:null}", autoRefreshed = true)
    private int sex;

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public String getUser() {
        return username+":"+age+":"+sex;
    }
}