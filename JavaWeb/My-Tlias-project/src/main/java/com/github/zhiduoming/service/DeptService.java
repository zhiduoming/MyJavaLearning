package com.github.zhiduoming.service;

import com.github.zhiduoming.pojo.Dept;

import java.util.List;

public interface DeptService {
    //查询所有的部门数据
    List<Dept> findAll();


    void deleteById(Integer id);

    void add(Dept dept);

    Dept findById(Integer id);

    void update(Dept dept);
}
