package com.yang.demo;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "com")
@NacosPropertySource(dataId = "demoId",groupId = "nacosdemo",autoRefreshed = true)
public class DemoApplication {
    @NacosInjected
    private NamingService namingService;
    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.application.name}")
    private String applicationName;
    //curl -X PUT 'http://127.0.0.1:8848/nacos/v1/ns/instance?serviceName=xxx&ip=127.0.0.1&port=8080'
    @PostConstruct
    public void registerInstance() throws NacosException, NacosException {
        namingService.registerInstance(applicationName,"127.0.0.1",serverPort);
//        if(CollectionUtils.isEmpty(namingService.getAllInstances(applicationName))){
//            namingService.registerInstance(applicationName,"127.0.0.1",serverPort);
//        }
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
//        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
//        System.out.println(getMaxArea(a));
//        System.out.println(getMaxArea(a));
//        System.out.println(getMaxArea(a));

    }




    public static int getMaxArea(int[] a) {
        int hg = a.length;//数组长度
        int left = 0;
        int right = hg - 1;
        //寻找最大面积
        int x = right - left + 1;//长方形的长度
        int y = Math.min(a[left], a[right]);
        int area = x * y;
        while (left != right) {
            if (a[right] >= a[left]) {//左边大于右边 每次要移动高度比较小的那个 才有可能让面积增大
                left = left + 1;
            } else {
                right = right - 1;
            }
            x = right - left;
            y = Math.min(a[left], a[right]);
            int temp = x * y;
            if (temp > area) {
                area = temp;
            }
        }
        return area;//故意多加的
        //哈哈
    }
}