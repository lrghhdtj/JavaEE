package com.example.demo.Service;

import com.example.demo.Utils.Result;

public interface CollectService {
    Result findall(String username);

    Result add(String username, String bookname);

    Result delete(String username, String bookname);
}
