package com.example.demo.Service.impl;

import com.example.demo.Mapper.BorrowMapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Pojo.Borrow;
import com.example.demo.Pojo.User;
import com.example.demo.Service.UserService;
import com.example.demo.Utils.Jwtutils;
import com.example.demo.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;


@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BorrowMapper borrowMapper;
    @Override
    public Result login(String username , String password) {
        //根据用户查询用户的信息
        User user = userMapper.getUser(username);
        if (user == null){
            return Result.error("用户不存在！");
        }
        //判断密码是否正确
        if (!user.getPassword().equals(password)){
            return Result.error("密码错误！");
        }
        //生成jwt令牌并返回
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id",user.getId());
        claims.put("username",user.getUsername());
        claims.put("password",user.getPassword());
        String jwt = Jwtutils.generateJwt(claims);
        if (user.getGovernor() == 1) {
            return Result.success(jwt,"governor");
        }else {
            LocalDateTime now = LocalDateTime.now();
            List<Borrow> outtime_list = borrowMapper.outtime(now);
            return Result.success(jwt,outtime_list);
        }
    }

    @Override
    public Result register(User user) {
        User u = userMapper.getUser(user.getUsername());
        if (u == null){
            userMapper.insertuser(user.getUsername(), user.getPassword(),user.getTelephone(),user.getEmail());
            return Result.success("注册成功！");
        }else {
            return Result.error("用户已存在！");
        }
    }

    @Override
    public Result change_password(String username, String oldpassword, String newpassword) {
        User user = userMapper.getUser(username);
        if (user == null){
            return Result.error("用户不存在！");
        }
        //判断密码是否正确
        else if (!user.getPassword().equals(oldpassword)){
            return Result.error("旧密码错误！");
        }
        else {
            userMapper.change_password(username,newpassword);
            return Result.success("修改密码成功！");
        }
    }
}
