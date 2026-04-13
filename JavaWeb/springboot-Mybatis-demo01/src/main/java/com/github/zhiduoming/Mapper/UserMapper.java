package com.github.zhiduoming.Mapper;

import com.github.zhiduoming.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询操作
     *
     */
    //@Select("select * from user")
    public List<User> findAll();

    /**
     * 根据ID来删除数据
     */
    @Delete("delete from user where id =#{id}")
    public Integer deleteById(Integer id);

    /**
     * 插入用户信息
     */
    @Insert("insert into user (username, password, name, age) values (#{username},#{password},#{name},#{age})")
    public void insert(User user);

    @Update("update user set username =#{username},password=#{password} ,name =#{name}, age =#{age} where id =#{id}")
    public void update(User user);

    /**
     * 根据用户名和密码查询信息
     *
     */
    @Select("select * from user where username =#{username} and password =#{password}")
    public User findByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
}
