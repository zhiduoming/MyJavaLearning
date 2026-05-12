package com.github.zhiduoming;

import com.github.zhiduoming.mapper.UserMapper;
import com.github.zhiduoming.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisDemo01ApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }
    @Test
    public void testDeleteById(){
        Integer i=userMapper.deleteById(4);
        System.out.println(i);
    }

    @Test
    public void testInsert(){
        User user =new User(null,"yangyang","123456","杨洋",28);
        userMapper.insert(user);
    }

    @Test
    public void testUpdate(){
        User user = new User(1 ,"zhouyu" ,"123456","周瑜",20);
        userMapper.update(user);
    }

    @Test
    public void testSelect(){
        User user = userMapper.findByUsernameAndPassword("zhouyu","123456");
        System.out.println(user);
    }


}
