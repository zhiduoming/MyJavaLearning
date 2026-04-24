package com.github.zhiduoming.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.zhiduoming.mapper.EmpExprMapper;
import com.github.zhiduoming.mapper.EmpMapper;
import com.github.zhiduoming.pojo.Emp;
import com.github.zhiduoming.pojo.EmpExpr;
import com.github.zhiduoming.pojo.EmpQueryParam;
import com.github.zhiduoming.pojo.PageResult;
import com.github.zhiduoming.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public PageResult<Emp> page(EmpQueryParam query) {
        //获取分页参数
        Integer page =query.getPage();
        Integer pageSize =query.getPageSize();

        //设置分页参数
        PageHelper.startPage(page,pageSize);

        //执行查询
        List<Emp> empList =  empMapper.list(query);

        //对结果进行封装
        PageInfo<Emp> pageInfo =new PageInfo<>(empList);

        return new PageResult<>(
                pageInfo.getTotal(),
                pageInfo.getList()
        );

    }

    @Override
    @Transactional
    public void save(Emp emp) {
        //给 emp 设置创建时间和修改时间
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        //保存员工基本信息
        empMapper.insert(emp);

        //保存员工经历信息
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            //遍历每段工作经历，为每个工作经历赋empId 的值
            exprList.forEach(expr -> expr.setEmpId(emp.getId()));

            empExprMapper.insertBatch(emp);
        }



    }
}
