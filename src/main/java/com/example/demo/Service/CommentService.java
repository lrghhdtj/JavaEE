package com.example.demo.Service;

import com.example.demo.Pojo.Comment;
import com.example.demo.Utils.Result;

public interface CommentService {
    Result getcomment(String bookname);

    Result addcomment(Comment comment);

    Result deletecomment(String username, String bookname);
}
