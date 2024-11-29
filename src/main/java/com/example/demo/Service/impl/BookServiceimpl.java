package com.example.demo.Service.impl;

import com.example.demo.Mapper.BookMapper;
import com.example.demo.Pojo.Book;
import com.example.demo.Pojo.PageBean;
import com.example.demo.Service.BookService;
import com.example.demo.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceimpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public Result getBooks() {
        return null;
    }

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        Long count = bookMapper.count();
        Integer start = (page - 1) * pageSize;
        List<Book> empList = bookMapper.Page(start,pageSize);
        PageBean pageBean = new PageBean(count, empList);
        return pageBean;
    }

    @Override
    public Result search(String similarName) {
        List<Book> list = bookMapper.search("%"+similarName+"%");
        if(list.size()>0){
            return Result.success(list);
        }else {
            return Result.error("没有符合条件的查询结果！");
        }
    }
}
