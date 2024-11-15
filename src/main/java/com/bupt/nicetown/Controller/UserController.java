package com.bupt.nicetown.Controller;

import com.bupt.nicetown.pojo.Result;
import com.bupt.nicetown.pojo.User;
import com.bupt.nicetown.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    private Result result;

    @PostMapping("/register")
    public Result register(String username, String password) {
        //前端把一大堆参数返回给我，让我先检查一下你合不合规
        //看看用户名重复不重复
        User u = userService.findByName(username);

        if (u != null) {
            //占用的话报错
            return Result.error("用户名已存在，请重新输入");
        }else {
            //没占用就注册
            userService.register(username, password);
            return Result.success();
        }
    }

}
