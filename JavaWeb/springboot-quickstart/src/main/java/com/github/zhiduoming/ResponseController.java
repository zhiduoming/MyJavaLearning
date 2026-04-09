package com.github.zhiduoming;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {

    @RequestMapping("/response")
    public void response(HttpServletResponse  response) throws IOException {
        //1.设置响应状态码
        response.setStatus(200);
        //2.设置响应头
        response.setHeader("name", "zhangsan");
        //3.设置响应体
        response.getWriter().write("<h1>Hello Response</h1>");
    }

    @RequestMapping("/response2")
    public ResponseEntity<String> response2() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("name", "zhangsan")
                .body("<h1>Hello Response2</h1>");
    }
}
