package com.example.demo.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collect {
    private int id;
    private String username;
    private String bookname;//书名
    private int userid;
    private int bookid;
}
