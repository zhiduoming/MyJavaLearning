package com.github.zhiduoming.controller;

import com.github.zhiduoming.pojo.Emp;
import com.github.zhiduoming.pojo.EmpQueryParam;
import com.github.zhiduoming.pojo.PageResult;
import com.github.zhiduoming.pojo.Result;
import com.github.zhiduoming.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    private final EmpService empService;

    public EmpController(EmpService empService) {
        this.empService = empService;
    }

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

    //批量删除员工
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("批量删除员工：{}", ids);
        empService.deleteByIds(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据 id 查询回显员工信息：{}",id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    //根据 id 修改员工信息
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("根据 id 修改员工信息：{}", emp);
        empService.update(emp);
        return Result.success();
    }

}
