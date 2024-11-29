package com.example.demo.Mapper;

import com.example.demo.Pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper  {
    @Select("select * from User where username = #{username}")
    User getUser(String username);

    @Insert("insert into User (username,password,telephone,email) values (#{username},#{password},#{telephone},#{email})")
    void insertuser(String username, String password, String telephone, String email);

    @Update("update User set password = #{newpassword} where username = #{username}")
    void change_password(String username,String newpassword);

    @Select("select id from User where username = #{username}")
    Integer getUserid(String username);
}
