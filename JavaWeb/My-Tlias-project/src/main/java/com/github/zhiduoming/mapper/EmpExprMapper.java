package com.github.zhiduoming.mapper;

import com.github.zhiduoming.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpExprMapper {


    void insertBatch(Emp emp);
}
