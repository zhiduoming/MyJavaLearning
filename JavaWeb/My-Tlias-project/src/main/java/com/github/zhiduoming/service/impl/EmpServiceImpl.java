package com.github.zhiduoming.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.zhiduoming.mapper.EmpExprMapper;
import com.github.zhiduoming.mapper.EmpMapper;
import com.github.zhiduoming.pojo.*;
import com.github.zhiduoming.service.EmpService;
import com.github.zhiduoming.utils.JwtUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmpServiceImpl implements EmpService {
    private final EmpMapper empMapper;

    private final EmpExprMapper empExprMapper;

    public EmpServiceImpl(EmpMapper empMapper, EmpExprMapper empExprMapper) {
        this.empMapper = empMapper;
        this.empExprMapper = empExprMapper;
    }

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

    @Override
    @Transactional
    public void deleteByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }

        empExprMapper.deleteByEmpIds(ids);
        empMapper.deleteByIds(ids);
    }

    @Override
    public Emp getInfo(Integer id) {
        //获取员工的基本信息
        Emp emp= empMapper.getById(id);
        if (emp == null) {
            return null;
        }
        //获取员工的工作经历信息
        List<EmpExpr> empExprList =empExprMapper.getByEmpId(id);
        emp.setExprList(empExprList);
        return emp;
    }

    @Override
    @Transactional
    public void update(Emp emp) {
        //更新员工基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);

        //重建员工经历信息：先删除旧经历，再保存本次提交的新经历，支持经历删除、修改和新增
        empExprMapper.deleteByEmpId(emp.getId());

        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(emp);
        }
    }

    @Override
    public LoginInfo login(Emp emp) {
        Emp loginEmp = empMapper.getByUsernameAndPassword(emp);
        if (loginEmp == null) {
            return null;
        }
        //从数据库中查到的这个 loginEmp 中获得 id 和 username 封装到 Map 集合里，
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", loginEmp.getId());
        claims.put("username", loginEmp.getUsername());

        // 然后将其传递到生成 JWT 令牌的方法中作为有效载荷 payload 中的自定义信息
        String token = JwtUtils.generateToken(claims);
        return new LoginInfo(loginEmp.getId(), loginEmp.getUsername(), loginEmp.getName(), token);
    }
}
