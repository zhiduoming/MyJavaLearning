package com.github.zhiduoming.mapper;

import com.github.zhiduoming.pojo.Emp;
import com.github.zhiduoming.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface EmpMapper {

    List<Emp> list(EmpQueryParam query);


    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("INSERT INTO emp (username, password, name, gender, " +
            "phone, job, salary, image, entry_date, dept_id, create_time, update_time) VALUES " +
            "(#{username},#{password},#{name},#{gender},#{phone},#{job},#{salary}," +
            "#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);
}
