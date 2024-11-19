package com.example.demo.Controller;

import com.example.demo.Pojo.User;
import com.example.demo.Service.UserService;
import com.example.demo.Utils.Result;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/user")
//@Api(tags = "用户接口")
public class UserController {
    @Autowired
    private UserService userService;

        @PostMapping("/login")
        public Result login(@RequestBody User user) {
            return userService.login(user.getUsername(), user.getPassword());
        }

    @PostMapping("/register")
    public Result register(@RequestBody User user ){
        System.out.println(user);
        return userService.register(user.getUsername(), user.getPassword());
    }

    @PostMapping("/change")
    public Result change(@RequestBody usertmp usertmp ){
            return userService.change(usertmp.getUsername(), usertmp.getOldpassword(), usertmp.getNewpassword());
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class usertmp{
        private String username;
        private String oldpassword;
        private String newpassword;
        private String oldtel;
        private String newtel;
        private String oldemail;
        private String newemail;

    }
}
