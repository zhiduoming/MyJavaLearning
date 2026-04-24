package com.github.zhiduoming.service;

import com.github.zhiduoming.pojo.Emp;
import com.github.zhiduoming.pojo.EmpQueryParam;
import com.github.zhiduoming.pojo.PageResult;

import java.util.List;

public interface EmpService {

    PageResult<Emp> page(EmpQueryParam query);

    void save(Emp emp);
}
