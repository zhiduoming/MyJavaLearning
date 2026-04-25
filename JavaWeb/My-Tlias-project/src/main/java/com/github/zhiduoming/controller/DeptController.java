package com.github.zhiduoming.controller;

import com.github.zhiduoming.pojo.Dept;
import com.github.zhiduoming.pojo.Result;
import com.github.zhiduoming.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    private final DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping
    public Result list(){
        log.info("查询全部的部门数据");
        List<Dept> deptList= deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping
    public Result delete(/*参数名和形参名一样可以省略该注解@RequestParam("id")*/ Integer id){
        log.info("根据ID删除部门：{}", id);
        //调用service层
        deptService.deleteById(id);

        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("根据name来添加部门:{}", dept);
        //调用service层
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("{id}")
    public Result findById(@PathVariable Integer id){
        log.info("根据ID来查询部门信息：{}", id);
        //调用service层
        Dept dept =deptService.findById(id);
        return Result.success(dept);
    }


    @PutMapping
    public Result updateById(@RequestBody Dept dept){
        log.info("根据ID修改部门信息：{}", dept);
        //调用service层
        deptService.update(dept);
        return Result.success();
    }
}
