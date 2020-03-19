//package com.yang.demo.controller;
//
//import com.alibaba.nacos.api.config.annotation.NacosValue;
//import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
////加载 dataId 为 example 的配置源，并开启自动更新
//@NacosPropertySource(dataId = "example",autoRefreshed = true)
//public class AppConfig {
//    @NacosValue(value = "${username:null}", autoRefreshed = true)
//    private String username;
//
//    public String getUsername() {
//        return username;
//    }
//    public void setUsername(String username) {
//        this.username = username;
//    }
//}