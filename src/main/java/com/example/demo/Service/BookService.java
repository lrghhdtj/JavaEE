package com.example.demo.Service;

import com.example.demo.Pojo.PageBean;
import com.example.demo.Utils.Result;
import org.springframework.stereotype.Service;


public interface BookService {
    Result getBooks();

    PageBean page(Integer page, Integer pageSize);

    Result search(String similarName);
}
