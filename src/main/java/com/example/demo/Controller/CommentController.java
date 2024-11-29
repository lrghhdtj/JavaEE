package com.example.demo.Controller;

import com.example.demo.Pojo.Comment;
import com.example.demo.Service.CommentService;
import com.example.demo.Utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    //获取某书籍评论，传bookname，返回Comment类型集合
    @GetMapping("/get")
    public Result getComment(@RequestParam String bookname) {
        Result result;
        try {
            result = commentService.getcomment(bookname);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(String.valueOf(e));
        }
        return result;
    }
    //添加评论，需要传username，bookname，评论common，评分goal
    @PostMapping("/add")
    public Result addComment(@RequestBody Comment comment) {
        System.out.println(comment.toString());
        return commentService.addcomment(comment);

    }
    //删除评论，普通用户可加可不加，或者给管理员开放
    @GetMapping("/delete")
    public Result deleteComment(@RequestParam String username,@RequestParam String bookname) {
        Result result;
        try {
            result = commentService.deletecomment(username,bookname);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(String.valueOf(e));
        }
        return result;
    }
}
