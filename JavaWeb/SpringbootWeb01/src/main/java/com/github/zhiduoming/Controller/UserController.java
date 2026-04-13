package com.github.zhiduoming.Controller;


import com.github.zhiduoming.Service.Impl.UserServiceImpl;
import com.github.zhiduoming.Service.UserService;
import com.github.zhiduoming.pojoUser.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class UserController {

    private UserService userService = new UserServiceImpl();

    @RequestMapping("/list")
    public List<User> list() throws FileNotFoundException {

        //调用service，拿到数据
        List<User> userList = userService.list();

        return userList;

    }
}

