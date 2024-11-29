package com.example.demo.Controller;

import com.example.demo.Service.BorrowService;
import com.example.demo.Utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Slf4j
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;
//借书接口，lasttime为借书多长时间，给天数
    @GetMapping("/lend")
    public Result borrow(@RequestParam String BookName, @RequestParam String username,@RequestParam int lasttime ) {
        return borrowService.lend(BookName,username,lasttime);
    }
//还书,需要给书名BookName、用户名username、借阅时间initialtime
    @GetMapping("/yet")
    public Result yet(@RequestParam String BookName, @RequestParam String username,@RequestParam String initialtime ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return borrowService.yet(BookName,username, LocalDateTime.parse(initialtime, formatter));
    }

    //程序在借书籍，给username，返回列表类型为borrow选择展示
    @GetMapping("/record")
    public Result record( @RequestParam String username) {
        return borrowService.record(username);
    }

}
