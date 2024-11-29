package com.example.demo.Service;

import com.example.demo.Utils.Result;

import java.time.LocalDateTime;

public interface BorrowService {
    Result lend(String BookName, String username, int lasttime);
    
    Result yet(String BookName, String username, LocalDateTime initialtime);

    Result record(String username);
}
