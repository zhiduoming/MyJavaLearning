package com.github.zhiduoming.controller;

import com.github.zhiduoming.pojo.Emp;
import com.github.zhiduoming.pojo.LoginInfo;
import com.github.zhiduoming.pojo.Result;
import com.github.zhiduoming.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    private final EmpService empService;

    public LoginController(EmpService empService) {
        this.empService = empService;
    }


    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录：{}",emp.getUsername());

        LoginInfo loginInfo =empService.login(emp);

        if(loginInfo==null){
            return Result.error("用户名或密码错误");
        }
        return Result.success(loginInfo);
    }
}
