package com.example.demo.Service.impl;


import com.example.demo.Mapper.BookMapper;
import com.example.demo.Mapper.CollectMapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Pojo.Book;
import com.example.demo.Pojo.Collect;
import com.example.demo.Service.CollectService;
import com.example.demo.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CollectServiceimpl implements CollectService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private CollectMapper collectMapper;
    @Override
    public Result findall(String username) {
        int userid = userMapper.getUserid(username);
        List<Integer> clist = collectMapper.getby(userid);
        List<Book> list = new ArrayList<>();
        if (clist.size() > 0) {
            for (int i = 0; i < clist.size(); i++) {
                list.add(bookMapper.GetBookById(clist.get(i)));
            }
            return Result.success(list);
        }else {
            return Result.error("没有收藏！");
        }
    }

    @Override
    public Result add(String username, String bookname) {
        int userid = userMapper.getUserid(username);
        int bookid = bookMapper.GetBookByName(bookname).getId();

        Collect collect =  collectMapper.get(userid,bookid);
        if (collect != null){
            return Result.error("已收藏！");
        }else {
            collectMapper.add(username,bookname,userid,bookid);
            return Result.success("加入成功！");
        }
    }

    @Override
    public Result delete(String username, String bookname) {
        int userid = userMapper.getUserid(username);
        int bookid = bookMapper.GetBookByName(bookname).getId();
        Collect collect =  collectMapper.get(userid,bookid);
        if (collect == null){
            return Result.error("收藏不存在！");
        }else {
            collectMapper.delete(userid,bookid);
            return Result.success("删除成功！");
        }
    }
}
