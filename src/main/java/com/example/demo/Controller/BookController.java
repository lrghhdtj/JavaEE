package com.example.demo.Controller;

import com.example.demo.Pojo.PageBean;
import com.example.demo.Service.BookService;
import com.example.demo.Utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/books")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;


    //分页查询
    //page为页号，pagesize为大小可传可不传
    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
       PageBean pageBean = bookService.page(page, pageSize);
        return Result.success(pageBean);
    }
    //模糊查询，没加分页
    @GetMapping("/search")
    public Result search(@RequestParam String similar_name)
    {
        return bookService.search(similar_name);
    }
}
