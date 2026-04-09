package com.github.zhiduoming;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        //1.获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式："+method);
        //2.获取请求URL地址
        String url = request.getRequestURL().toString();//http://localhost:8080/springboot-quickstart/request
        System.out.println("请求URL地址："+url);
        //3.获取请求URI
        String uri = request.getRequestURI();
        System.out.println("请求URI："+uri);
        //4.获取请求协议
        String protocol = request.getProtocol();
        System.out.println("请求协议："+protocol);
        //5.获取请求参数 ?name=zhangsan,age=23
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("请求参数：name="+name+",age="+age);

        //6.获取请求头
        String header = request.getHeader("Accept");
        System.out.println("请求头："+header);
        return "请求成功";
    }


}
