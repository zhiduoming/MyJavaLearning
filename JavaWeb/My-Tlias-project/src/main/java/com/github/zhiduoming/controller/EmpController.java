package com.github.zhiduoming.controller;

import com.github.zhiduoming.pojo.Emp;
import com.github.zhiduoming.pojo.EmpQueryParam;
import com.github.zhiduoming.pojo.PageResult;
import com.github.zhiduoming.pojo.Result;
import com.github.zhiduoming.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result findAll(EmpQueryParam query){
        log.info("分页查询员工列表参数:{},{},{},{},{},{}",query.getName(),query.getGender(),
                query.getBegin(), query.getEnd(),query.getPage(),query.getPageSize());
        PageResult<Emp> pageResult =empService.page(query);
        return Result.success(pageResult);
    }

    //保存员工信息
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工：{}",emp );
        empService.save(emp);
        return Result.success();
    }

}
