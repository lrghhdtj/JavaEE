package com.example.demo.Controller;

import com.example.demo.Pojo.Collect;
import com.example.demo.Service.CollectService;
import com.example.demo.Utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;
    //查看用户的评论，传username，返回Book类型集合
    @GetMapping("/view")
    public Result view(@RequestParam String username) {
        return collectService.findall(username);

    }
    //添加评论传username，bookname
    @PostMapping("/add")
    public Result add(@RequestBody Collect collect) {
        return collectService.add(collect.getUsername(), collect.getBookname());
    }
    //删除评论传username，bookname
    @PostMapping("/delete")
    public Result delete(@RequestBody Collect collect) {
        return collectService.delete(collect.getUsername(), collect.getBookname());

    }
}
