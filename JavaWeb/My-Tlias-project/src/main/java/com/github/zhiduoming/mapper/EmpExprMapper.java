package com.github.zhiduoming.mapper;

import com.github.zhiduoming.pojo.Emp;
import com.github.zhiduoming.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpExprMapper {


    void insertBatch(Emp emp);

    void deleteByEmpIds(@Param("ids") List<Integer> ids);

    List<EmpExpr> getByEmpId(@Param("empId") Integer empId);

    void deleteByEmpId(@Param("empId") Integer empId);
}
