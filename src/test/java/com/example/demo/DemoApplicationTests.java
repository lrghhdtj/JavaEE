package com.example.demo;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.Pojo.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@MapperScan(basePackageClasses = UserMapper.class)
@SpringBootTest
class DemoApplicationTests {
@Autowired
    UserMapper userMapper;
    @Test
    void insert() {
        User user = new User();
        user.setId(1);
        user.setUsername("tom");
        user.setPassword("123456");
        user.setTelephone("18888888888");
        int result = userMapper.insert(user);
    }
    @Test
    void select() {}
    @Test
    void delete(){
        userMapper.deleteById(1);
    }
}
