package com.example.demo.Controller;

import com.example.demo.Service.BookService;
import com.example.demo.Utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/books")
@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping
    public Result getBooks() {
        return bookService.getBooks();
    }
}
