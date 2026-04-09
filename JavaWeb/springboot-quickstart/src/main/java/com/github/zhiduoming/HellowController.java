package com.github.zhiduoming;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//表示当前类是一个请求处理类
public class HellowController {
    @RequestMapping("/hello")
    public String hello(String name) {
        System.out.println("name:" + name);
        return "Hello" + name + "~";
    }
}
