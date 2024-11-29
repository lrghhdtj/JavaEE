package com.example.demo.Service.impl;

import com.example.demo.Mapper.BookMapper;
import com.example.demo.Mapper.BorrowMapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Pojo.Borrow;
import com.example.demo.Pojo.User;
import com.example.demo.Service.BorrowService;
import com.example.demo.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;


@Service
public class BorrowServiceimpl implements BorrowService {
    @Autowired
    private BorrowMapper borrowMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookMapper bookMapper;
    @Override
    public Result lend(String BookName, String username, int lasttime) {
        int userid = userMapper.getUserid(username);
        int bookid = bookMapper.GetBookByName(BookName).getId();
        int stock = bookMapper.getStock(BookName);
        if (stock > 0) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime deadline = now.plusHours(lasttime * 24);
            borrowMapper.lend(bookid, userid, BookName, now, deadline);
            return Result.success("借阅成功！");
        }else {
            return Result.error("书籍存量不足！");
        }
    }

    @Override
    public Result yet(String BookName, String username, LocalDateTime initialtime) {
        int userid = userMapper.getUserid(username);
        int bookid = bookMapper.GetBookByName(BookName).getId();
        Borrow borrow = borrowMapper.get(bookid,userid,initialtime);
        if (borrow == null) {
            return Result.error("没有借阅记录！");
        }else {
            borrowMapper.yet(bookid,userid,initialtime);
            return Result.success("归还成功！");
        }
    }

    @Override
    public Result record(String username) {
        User user = userMapper.getUser(username);
        List<Borrow> list = borrowMapper.getByuser(user.getId());
        return Result.success(list);
    }
}
