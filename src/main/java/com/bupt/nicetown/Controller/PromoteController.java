package com.bupt.nicetown.Controller;

import com.bupt.nicetown.pojo.Promote;
import com.bupt.nicetown.pojo.Result;
import com.bupt.nicetown.pojo.User;
import com.bupt.nicetown.service.PromoteService;
import com.bupt.nicetown.service.UserService;
import com.bupt.nicetown.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/promote")
public class PromoteController {
    @Autowired
    private PromoteService promoteService;
    @Autowired
    private UserService userService;

    @PutMapping("/create")
    public Result create(@RequestHeader(name = "Authorization") String token, @RequestBody Promote promote) {

        //解析用户名，获取用户id，赋值给promote
        Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");
        User u = userService.findByName(username);
        int UserID = u.getUserID();
        promote.setPromotterID(UserID);

        //控制台输出
        System.out.println(promote);

        //增加一个逻辑，判断乡镇id是否存在。

        //创建宣传
        promoteService.create(promote);
        return Result.success();
    }

}
