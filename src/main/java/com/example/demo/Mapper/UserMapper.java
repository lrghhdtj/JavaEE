package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from web.user where username = #{username}")
    User getUser(String username);

    @Insert("insert into web.user(username,password) values (#{username},#{password})")
    void insertuser(String username, String password);

    @Update("update web.user set password = #{newpassword} where username = #{username}")
    void change(String username,String newpassword);

    @Select("select id from user where username = #{username}")
    Integer getUserid(String username);
}
