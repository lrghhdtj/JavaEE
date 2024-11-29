package com.example.demo.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int id;
    private String username;
    private String bookname;//书名
    private String comment;//评论
    private int goal;//评分
    private Date createtime;//评论时间
    private int userid;
    private int bookid;
}
