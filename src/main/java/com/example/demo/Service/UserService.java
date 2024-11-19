package com.example.demo.Service;


import com.example.demo.Utils.Result;

public interface UserService {
    Result login(String username, String password);

    Result register(String username, String password);

    Result change(String username, String oldpassword, String newpassword);
}
