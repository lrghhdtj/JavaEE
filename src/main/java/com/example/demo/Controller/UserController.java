package com.example.demo.Controller;

import com.example.demo.Pojo.User;
import com.example.demo.Service.UserService;
import com.example.demo.Utils.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/user")
//@Api(tags = "用户接口")
public class UserController {
    @Autowired
    private UserService userService;
    /*
    登录接口，message为jwt令牌
    如果是管理员data的数据为字符串类型governor
    如果是普通用户data会返回归还超时的书籍列表类型为borrow，选择展示
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        return userService.login(user.getUsername(), user.getPassword());
        }

        //注册接口，传用户名username，密码password，电话telephone，邮箱email，用户类型默认为普通用户不需要传
    @PostMapping("/register")
    public Result register(@RequestBody User user ){
        return userService.register(user);
    }
//改密码，传username、oldpassword、newpassword
    @PostMapping("/changepassword")
    public Result change_password(@RequestBody usertmp usertmp ){
            return userService.change_password(usertmp.getUsername(), usertmp.getOldpassword(), usertmp.getNewpassword());
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class usertmp{
        private String username;
        private String oldpassword;
        private String newpassword;
        private String newtel;
        private String newemail;

    }
}
