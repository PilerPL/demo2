package com.yang.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(getMaxArea(a));

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