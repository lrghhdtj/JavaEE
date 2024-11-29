package com.example.demo.Service;


import com.example.demo.Pojo.User;
import com.example.demo.Utils.Result;

public interface UserService {
    Result login(String username, String password);

    Result register(User user);

    Result change_password(String username, String oldpassword, String newpassword);
}
