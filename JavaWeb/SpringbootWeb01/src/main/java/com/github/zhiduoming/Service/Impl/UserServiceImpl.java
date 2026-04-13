package com.github.zhiduoming.Service.Impl;

import com.github.zhiduoming.Service.UserService;
import com.github.zhiduoming.dao.UserDao;
import com.github.zhiduoming.dao.impl.UserDaoImpl;
import com.github.zhiduoming.pojoUser.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> list() {

        List<String> lines = userDao.findAll();

        List<User> Userlist = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String Username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, Username, password, name, age, updateTime);
        }).toList();

        return Userlist;
    }
}
