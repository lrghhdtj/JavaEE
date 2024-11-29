package com.example.demo.Service.impl;

import com.example.demo.Mapper.BookMapper;
import com.example.demo.Mapper.CommentMapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Pojo.Comment;
import com.example.demo.Service.CommentService;
import com.example.demo.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CommnetServiceimpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookMapper bookMapper;
    @Override
    public Result getcomment(String bookname) {
        List<Comment> list = commentMapper.selectAll(bookname);
        if (list.size() > 0) {
            return Result.success(list);
        }else {
            return Result.error("没有评论！");
        }
    }

    @Override
    public Result addcomment(Comment comment) {
        Comment c = commentMapper.get(comment.getUsername(),comment.getBookname());
        if (c == null){
            int userid = userMapper.getUserid(comment.getUsername());
            int bookid = bookMapper.GetBookByName(comment.getBookname()).getId();
            Date createtime = new Date();
            commentMapper.addcomment(comment.getUsername(),comment.getBookname(),comment.getComment(),comment.getGoal(),new Timestamp(createtime.getTime()),bookid,userid);
            return Result.success("评论成功！");
        }else {
            return Result.error("已评论！");
        }
    }

    @Override
    public Result deletecomment(String username,String bookname) {
        Comment c = commentMapper.get(username,bookname);
        if (c != null){
            commentMapper.deletecomment(username,bookname);
            return Result.success("成功删除评论！");
        }else {
            return Result.error("未找到评论！");
        }
    }
}
